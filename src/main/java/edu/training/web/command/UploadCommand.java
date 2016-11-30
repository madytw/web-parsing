package edu.training.web.command;

import edu.training.web.manager.ConfigManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Roman on 25.11.2016.
 */
public class UploadCommand implements ActionCommand {
    private static final String PARAM_INDEX = "path.page.index";

    public String execute(HttpServletRequest request) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        File tempDir = (File)request.getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);

        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    processUploadedFile(item, request);
                }
            }
        } catch (Exception e) {

            return null;
        }
        return ConfigManager.getProperty(PARAM_INDEX);
    }

    private void processUploadedFile(FileItem item, HttpServletRequest request) throws Exception {
        File uploadetFile = null;
        String path = request.getServletContext().getRealPath("/data/" + item.getName());
        uploadetFile = new File(path);
        uploadetFile.createNewFile();
        item.write(uploadetFile);
    }
}

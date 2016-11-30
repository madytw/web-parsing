package edu.training.web.factory;

import edu.training.web.command.ActionCommand;
import edu.training.web.command.CommandEnum;
import edu.training.web.command.EmptyCommand;
import edu.training.web.command.UploadCommand;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Roman on 25.11.2016.
 */
public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String action = request.getParameter("command");
        if(isMultipart){
            return new UploadCommand();
        }
        if (action == null || action.isEmpty()) {
            return current;
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {

        }
        return current;
    }
}

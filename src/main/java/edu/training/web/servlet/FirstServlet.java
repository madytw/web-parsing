package edu.training.web.servlet;


import edu.training.parsing.entity.AbstractMedicine;
import edu.training.parsing.entity.Drug;
import edu.training.parsing.entity.Injection;
import edu.training.parsing.parser.AbstractMedicineBuilder;
import edu.training.parsing.parser.MedicineBuilderFactory;
import edu.training.web.command.ActionCommand;
import edu.training.web.factory.ActionFactory;
import edu.training.web.manager.ConfigManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Roman on 22.11.2016.
 */
@WebServlet("/parsing")
public class FirstServlet extends HttpServlet {
    public FirstServlet() {
        super();
    }

    public void init() throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        page = command.execute(request);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }
}
package edu.training.web.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Roman on 25.11.2016.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}

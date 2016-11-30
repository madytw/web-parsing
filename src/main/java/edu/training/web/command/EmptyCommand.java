package edu.training.web.command;

import edu.training.web.manager.ConfigManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Roman on 25.11.2016.
 */
public class EmptyCommand implements ActionCommand {
    private static final String PARAM_LANG = "lang";
    private static final String PARAM_LOCALE = "locale";
    private static final String DEFAULT_LOCALE = "ru_RU";
    private static final String PARAM_INDEX = "path.page.index";
    private static final String PARAM_PAGE = "page";
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if(session.getAttribute(PARAM_LANG) == null){
            session.setAttribute(PARAM_LANG, DEFAULT_LOCALE);
        }

        String lang = (String) session.getAttribute(PARAM_LANG);
        request.setAttribute(PARAM_LOCALE, lang);
        session.setAttribute(PARAM_PAGE, PARAM_INDEX);

        return ConfigManager.getProperty(PARAM_INDEX);
    }
}

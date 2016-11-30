package edu.training.web.command;

import edu.training.web.manager.ConfigManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Roman on 25.11.2016.
 */
public class LanguageCommand implements ActionCommand {
    private static final String PARAM_LANG = "lang";
    private static final String PARAM_LOCALE = "locale";
    private static final String DEFAULT_LOCALE = "ru_RU";
    private static final String PARAM_PAGE = "page";
    private static final String PARAM_INDEX = "path.page.index";
    public String execute(HttpServletRequest request) {
        String lang = request.getParameter(PARAM_LANG);
        HttpSession session = request.getSession(true);

        if(lang.isEmpty()){
            session.setAttribute(PARAM_LANG, DEFAULT_LOCALE);
            request.setAttribute(PARAM_LOCALE, DEFAULT_LOCALE);
        }else{
            session.setAttribute(PARAM_LANG, lang);
            request.setAttribute(PARAM_LOCALE, lang);
        }

        String currPage = (String) session.getAttribute(PARAM_PAGE);

        if(currPage == null){
            currPage = PARAM_INDEX;
        }
        return ConfigManager.getProperty(currPage);
    }
}

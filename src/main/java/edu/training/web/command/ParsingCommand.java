package edu.training.web.command;

import edu.training.parsing.entity.AbstractMedicine;
import edu.training.parsing.entity.Drug;
import edu.training.parsing.entity.Injection;
import edu.training.parsing.parser.AbstractMedicineBuilder;
import edu.training.parsing.parser.MedicineBuilderFactory;
import edu.training.web.manager.ConfigManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Roman on 25.11.2016.
 */
public class ParsingCommand implements ActionCommand {
    private static final String PARAM_PARSING_TYPE = "parsType";
    private static final String PARAM_DRUGS = "drugs";
    private static final String PARAM_INJECTIONS = "injections";
    private static final String PARAM_LOCALE = "locale";
    private static final String PARAM_LANG = "lang";
    private static final String PARAM_FILE_PATH = "/data/meds.xml";
    private static final String PARAM_RESULT = "path.page.result";
    private static final String PARAM_PAGE = "page";

    public String execute(HttpServletRequest request) {
        String type = request.getParameter("parsType");
        Set<Drug> drugs = new HashSet<Drug>();
        Set<Injection> injections = new HashSet<Injection>();
        for(AbstractMedicine med : getMedicines(type, request)){
            if(med instanceof Drug){
                drugs.add((Drug)med);
            }else{
                injections.add((Injection)med);
            }
        }

        HttpSession session = request.getSession(true);
        String locale = (String) session.getAttribute(PARAM_LANG);

        session.setAttribute(PARAM_PARSING_TYPE, type);
        session.setAttribute(PARAM_DRUGS, drugs);
        session.setAttribute(PARAM_INJECTIONS, injections);
        request.setAttribute(PARAM_LOCALE, locale);
        session.setAttribute(PARAM_PAGE, PARAM_RESULT);

        return ConfigManager.getProperty(PARAM_RESULT);
    }

    private Set<AbstractMedicine> getMedicines(String parsType, HttpServletRequest request){
        MedicineBuilderFactory factory = new MedicineBuilderFactory();
        String appPath = request.getServletContext().getRealPath("");
        AbstractMedicineBuilder builder = factory.createMedicineBuilder(parsType);
        builder.buildSetMedicines(appPath + PARAM_FILE_PATH);
        return builder.getMedicines();
    }
}

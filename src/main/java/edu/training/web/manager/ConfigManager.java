package edu.training.web.manager;

import java.util.ResourceBundle;

/**
 * Created by Roman on 25.11.2016.
 */
public class ConfigManager {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.config");
    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}

package org.javadom;

import io.quarkus.qute.TemplateExtension;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@TemplateExtension(namespace = "i18n")
public class I18nExtensions {
    public static String t(String key, String lang) {
        if (key == null) {
            return "";
        }
        Locale locale = (lang != null && lang.startsWith("es")) ? Locale.of("es") : Locale.ENGLISH;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
            return bundle.getString(key);
        } catch (MissingResourceException ex) {
            return key;
        }
    }
}

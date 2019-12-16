package by.ysenko.finaltask.view;

import javax.servlet.jsp.tagext.TagSupport;

public class LangTag extends TagSupport {

    public static String langValue(String attribute, String cookie) {
        String lang = null;
        if (attribute != null && attribute.length() > 0) {
            lang = attribute;
        } else {
            lang = cookie;
        }

        return lang;
    }
}

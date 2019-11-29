package by.ysenko.finaltask.view;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CopyWrightTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {

        String tag = "<hr/>Time : <b> " + "My first tag" + " </b><hr/>";

        try {
            JspWriter out = pageContext.getOut();
            out.write(tag);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}

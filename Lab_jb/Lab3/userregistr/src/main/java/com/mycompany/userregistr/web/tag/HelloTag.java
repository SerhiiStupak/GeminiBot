package com.mycompany.userregistr.web.tag;

import java.io.IOException;
import java.time.LocalTime;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class HelloTag extends TagSupport {

    private String name;

    @Override
    public int doStartTag() throws JspException {
        String prefix = "Good morning, ";
        if (LocalTime.now().isAfter(LocalTime.NOON)) {
            prefix = "Good afternoon, ";
        }
        try {
            if (name == null || name.length()==0) {
                pageContext.getOut().write(prefix + "anonymous");
            } else {
                pageContext.getOut().write(prefix + name);
            }
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;

    }

    @Override
    public void release() {
        super.release();
        this.name = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
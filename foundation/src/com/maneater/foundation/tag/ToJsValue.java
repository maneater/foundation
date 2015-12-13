package com.maneater.foundation.tag;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

public class ToJsValue extends TagSupport {
    public ToJsValue() {
        super();
    }

    @Override
    public int doAfterBody() throws JspException {
        return super.doAfterBody();
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }

    private String argName;
    private Object argObj;

    public String getArgName() {
        return argName;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public Object getArgObj() {
        return argObj;
    }

    public void setArgObj(Object argObj) {
        this.argObj = argObj;
    }

    @Override
    public int doStartTag() throws JspException {
        if (argName != null) {
            JspWriter out = this.pageContext.getOut();
            try {
                ObjectMapper mapper = new ObjectMapper();
                out.write("var " + this.argName + "=" + mapper.writeValueAsString(this.argObj));
            } catch (IOException e) {
                throw new JspException(e);
            }
        }
        return super.doStartTag();
    }


    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public Tag getParent() {
        return super.getParent();
    }

    @Override
    public Object getValue(String k) {
        return super.getValue(k);
    }

    @Override
    public Enumeration<String> getValues() {
        return super.getValues();
    }

    @Override
    public void release() {
        super.release();
    }

    @Override
    public void removeValue(String k) {
        super.removeValue(k);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        super.setPageContext(pageContext);
    }

    @Override
    public void setParent(Tag t) {
        super.setParent(t);
    }

    @Override
    public void setValue(String k, Object o) {
        super.setValue(k, o);
    }
}

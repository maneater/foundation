package com.maneater.foundation.tag;

import org.springframework.util.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class FilePathTag extends TagSupport {
    public FilePathTag() {
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

    private String path;
    private String basePath;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int doStartTag() throws JspException {
        if (!StringUtils.isEmpty(path)) {
            JspWriter out = this.pageContext.getOut();
            try {
                if (path.toUpperCase().startsWith("HTTP://") || StringUtils.isEmpty(basePath)) {
                    out.write(path);
                } else {
                    out.write(basePath + "/" + path);
                }
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

package com.maneater.foundation.filter;

import com.maneater.foundation.uitl.SysUtil;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
public class AdminFilter implements Filter {
    private final static Logger logger = Logger.getLogger(AdminFilter.class);
    private final static Set<String> urlSet = new HashSet<String>();

    static {
        urlSet.add("/view/admin/login.jsp");
        urlSet.add("/admin/adminLogin");
        urlSet.add("/admin/login");
    }

    public AdminFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rp = (HttpServletResponse) response;
        logger.info("AdminFilter-" + rq.getServletPath());
        String reqPath = rq.getServletPath();
        if (SysUtil.checkIsLogin(rq)) {
            chain.doFilter(request, response);
        } else {
            if (urlSet.contains(reqPath)) {
                chain.doFilter(request, response);
            } else {
                rp.sendRedirect(rq.getContextPath() + "/admin/login");
            }
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}

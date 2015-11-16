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
public class UserFilter implements Filter {
    private final static Logger logger = Logger.getLogger(UserFilter.class);
    private final static Set<String> urlSet = new HashSet<String>();

    static {
        urlSet.add("/view/login.jsp");
        urlSet.add("/user/login");
        urlSet.add("/user/doLogin");
        urlSet.add("/user/logout");
        urlSet.add("/user/register");
        urlSet.add("/user/register.jsp");
    }

    public UserFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rp = (HttpServletResponse) response;
        logger.info("UserFilter-" + rq.getServletPath());
        String reqPath = rq.getServletPath();
        if (SysUtil.checkUserLogin(rq)) {
            chain.doFilter(request, response);
        } else {
            if (urlSet.contains(reqPath)) {
                chain.doFilter(request, response);
            } else {
                rp.sendRedirect(rq.getContextPath() + "/user/login");
            }
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}

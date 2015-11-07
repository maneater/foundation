package com.maneater.foundation.uitl;


import com.maneater.foundation.Config;
import com.maneater.foundation.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SysUtil {
    public static boolean checkIsLogin(HttpServletRequest rq) {
        HttpSession session = rq.getSession(false);
        if (session != null) {
            return session.getAttribute(Config.SESSION_KEY_ADMIN) != null;
        }
        return false;
    }

    public static boolean login(HttpServletRequest req, Admin admin) {
        HttpSession session = req.getSession(true);
        session.setAttribute(Config.SESSION_KEY_ADMIN, admin);
        return true;
    }

}

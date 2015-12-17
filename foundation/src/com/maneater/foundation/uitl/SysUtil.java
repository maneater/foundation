package com.maneater.foundation.uitl;


import com.maneater.foundation.Config;
import com.maneater.foundation.entity.User;
import com.maneater.foundation.nosql.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SysUtil {
    public static boolean checkAdminLogin(HttpServletRequest rq) {
        HttpSession session = rq.getSession(false);
        if (session != null) {
            return session.getAttribute(Config.SESSION_KEY_ADMIN) != null;
        }
        return false;
    }

    public static boolean adminLogin(HttpServletRequest req, Admin admin) {
        HttpSession session = req.getSession(true);
        session.setAttribute(Config.SESSION_KEY_ADMIN, admin);
        return true;
    }

    public static void adminLogout(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute(Config.SESSION_KEY_ADMIN);
        }
    }

    public static boolean userLogin(User user, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        session.setAttribute(Config.SESSION_KEY_USER, user);
        return true;
    }

    public static boolean checkUserLogin(HttpServletRequest rq) {
        HttpSession session = rq.getSession(false);
        if (session != null) {
            return session.getAttribute(Config.SESSION_KEY_USER) != null;
        }
        return false;
    }


    public static void userLogout(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute(Config.SESSION_KEY_USER);
        }
    }

    public static String getLoginUserId(HttpServletRequest rq) {
        HttpSession session = rq.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute(Config.SESSION_KEY_USER);
            if (user != null) {
                return String.valueOf(user.getId());
            }
        }
        return "";
    }
}

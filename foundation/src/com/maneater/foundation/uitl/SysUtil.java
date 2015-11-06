package com.maneater.foundation.uitl;


import com.maneater.foundation.Config;

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

}

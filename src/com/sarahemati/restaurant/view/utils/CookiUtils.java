package com.sarahemati.restaurant.view.utils;

import javax.servlet.http.Cookie;

public class CookiUtils {
	public static void save(String name, String value, int age) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(age);
		JsfUtil.getResponse().addCookie(cookie);
	}

	public static String retrieve(String name) {
		Cookie[] cookies = JsfUtil.getRequest().getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie c : cookies) {
			if (name.equals(c.getName())) {
				return c.getValue();
			}
		}
		return null;
	}
}

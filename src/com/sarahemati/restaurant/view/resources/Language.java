package com.sarahemati.restaurant.view.resources;

import java.util.ResourceBundle;

import com.sarahemati.restaurant.view.utils.LanguageUtil;

public class Language {

	public static String getValue(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle(
				"com.sarahemati.restaurant.view.resources.language",
				LanguageUtil.getLocale());
		return bundle.getString(key);
	}
}

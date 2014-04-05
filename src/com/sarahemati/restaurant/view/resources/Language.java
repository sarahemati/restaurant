package com.sarahemati.restaurant.view.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sarahemati.restaurant.view.utils.LanguageUtil;

public class Language {
	private String getLocation() {
		return this.getClass().getClassLoader()
				.getResource("com/sarahemati/restaurant/view/resources")
				.getPath();
	}

	public List<String> getLanguages() {
		List<String> result = new ArrayList<String>();
		File[] files = new File(getLocation()).listFiles();
		for (File f : files) {
			String str = f.getName();
			if (str.endsWith(".properties")) {
				str = str.replaceAll(".properties", "");
				String[] ss = str.split("_");
				result.add(ss[ss.length - 1]);
			}
		}
		return result;
	}

	public static String getValue(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle(
				"com.sarahemati.restaurant.view.resources.language",
				LanguageUtil.getLocale());
		return bundle.getString(key);
	}
}

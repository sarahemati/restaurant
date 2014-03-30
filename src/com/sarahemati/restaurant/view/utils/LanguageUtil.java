package com.sarahemati.restaurant.view.utils;

import java.io.Serializable;
import java.util.Locale;

public class LanguageUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	public static Locale getLocale() {
		String lang = CookiUtils.retrieve("language");
		if (lang == null) {
			return JsfUtil.getRequest().getLocale();
		}else{
			return new Locale(lang);
		}
		
	}

	public static boolean isRtl() {
		String rtlLanguages = "ar,arc,bcc,bqi,ckb,dv,fa,glk,he,ku,mzn,pnb,ps,sd,ug,ur,yi";
		return rtlLanguages.indexOf(getLocale().getLanguage()) != -1;
	}
}

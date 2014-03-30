package com.sarahemati.restaurant.view.templates;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.sarahemati.restaurant.view.utils.LanguageUtil;


@Named
@SessionScoped
public class BaseTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	public Locale getLocale() {
		return LanguageUtil.getLocale();
	}

	public boolean isRTL() {
		return LanguageUtil.isRtl();
	}
}

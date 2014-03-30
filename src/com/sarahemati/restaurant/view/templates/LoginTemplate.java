package com.sarahemati.restaurant.view.templates;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.sarahemati.restaurant.view.utils.CookiUtils;


@Named
@RequestScoped
public class LoginTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	public String mnuLoginClick() {
		return "/pages/login.html?faces-redirect=true";
	}

	public String mnuSignupClick() {
		return "/pages/registration.html?faces-redirect=true";
	}

	public String mnuEnClick() {
		CookiUtils.save("language", "en", Integer.MAX_VALUE);
		String viewId = FacesContext.getCurrentInstance().getViewRoot()
				.getViewId();
		return viewId + "?faces-redirect=true";
	}

	public String mnuFaClick() {
		CookiUtils.save("language", "fa", Integer.MAX_VALUE);
		String viewId = FacesContext.getCurrentInstance().getViewRoot()
				.getViewId();
		return viewId + "?faces-redirect=true";
	}
}

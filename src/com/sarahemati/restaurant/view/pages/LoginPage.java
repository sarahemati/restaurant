package com.sarahemati.restaurant.view.pages;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sarahemati.restaurant.business.service.GeneralService;
import com.sarahemati.restaurant.view.resources.Language;
import com.sarahemati.restaurant.view.utils.JsfUtil;

@Named
@RequestScoped
public class LoginPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private GeneralService service;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String btnLoginClick() {
		String unam = Language.getValue("username");
		String pass = Language.getValue("password");
		if (unam.equals(getUsername()) && pass.equals(getPassword())) {
			return "/pages/protected/admin/mainAdmin.html?faces-redirect=true";
		} else {
			// is Customer?
		}
		JsfUtil.addErrorMessage(Language.getValue("error"),
				Language.getValue("login.msg.error"));
		return null;
	}
}

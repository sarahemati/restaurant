package com.sarahemati.restaurant.view.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsfUtil {
	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getExternalContext().getRequest();
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) getExternalContext().getResponse();
	}

	public static void addInfoMessage(String title, String msg) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, title, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addFatalMessage(String title, String msg) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_FATAL, title, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addWarningMessage(String title, String msg) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, title, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addErrorMessage(String title, String msg) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, title, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
}

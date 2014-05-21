package com.sarahemati.restaurant.view.pages;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.sarahemati.restaurant.business.service.GeneralService;
import com.sarahemati.restaurant.model.Customer;
import com.sarahemati.restaurant.model.Login;
import com.sarahemati.restaurant.model.UsernamePassword;

@Named
@SessionScoped
public class RegisterPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Login login;
	private String confrimPassword;
	@EJB
	private GeneralService service;

	public String getConfrimPassword() {
		return confrimPassword;
	}

	public void setConfrimPassword(String confrimPassword) {
		this.confrimPassword = confrimPassword;
	}

	public Login getLogin() {
		if(login==null){
			login=new Login();
		}
		if(login.getUsernamepassword()==null){
			login.setUsernamepassword(new UsernamePassword());
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Customer getCustomer() {
		if (customer == null) {
			customer = new Customer();
		}
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String btnSaveClick() {
		try {
			getLogin().setUser(getCustomer());
			service.save(getLogin());
			customer = null;
			login=null;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "ok", "ok"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
							"error"));
			e.printStackTrace();
		}
		return null;
	}

	public void addMessage(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}

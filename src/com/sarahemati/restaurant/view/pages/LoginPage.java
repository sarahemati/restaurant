package com.sarahemati.restaurant.view.pages;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sarahemati.restaurant.business.service.GeneralService;
import com.sarahemati.restaurant.model.Customer;

@Named
@RequestScoped
public class LoginPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private GeneralService service;

	public String btnTestClick() {
		Customer c = new Customer();
		c.setFirstname("Sara");
		c.setLastname("Hemati");
		c.setAddress("Karaj");
		c.setPhoneNo("123");
		try {
			service.save(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.sarahemati.restaurant.business.service;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sarahemati.restaurant.dao.GeneralDao;

@Stateless
public class GeneralService implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private GeneralDao dao;

	public <T> T save(T t) throws Exception {
		return dao.save(t);
	}
}

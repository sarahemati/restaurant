package com.sarahemati.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sarahemati.restaurant.model.abstracts.BaseEntity;

@Entity
@Table(name = "USERNAMES_PASSWORDS")
// @NamedQueries(@NamedQuery(name="",query=""))
public class UsernamePassword extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
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

}

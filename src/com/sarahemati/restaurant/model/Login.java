package com.sarahemati.restaurant.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sarahemati.restaurant.model.abstracts.BaseEntity;

@Entity
@Table(name = "LOGINS")
// @NamedQueries(@NamedQuery(name="",query=""))
public class Login extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UsernamePassword usernamepassword;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;

	public UsernamePassword getUsernamepassword() {
		return usernamepassword;
	}

	public void setUsernamepassword(UsernamePassword usernamepassword) {
		this.usernamepassword = usernamepassword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

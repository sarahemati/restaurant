package com.sarahemati.restaurant.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sarahemati.restaurant.model.abstracts.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"FIRSTNAME", "LASETNAME" }) })
// @NamedQueries(@NamedQuery(name="",query=""))
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASETNAME")
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}

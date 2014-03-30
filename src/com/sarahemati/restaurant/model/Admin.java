package com.sarahemati.restaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "ADMIN")
@Table(name = "ADMINS")
//@NamedQueries(@NamedQuery(name="",query=""))
public class Admin extends User {
	private static final long serialVersionUID = 1L;

}

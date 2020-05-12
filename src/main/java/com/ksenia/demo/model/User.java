package com.ksenia.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */

@Entity
@Table(name = "user")
@Data
public class User
{
	@Id
	private int id;
	private String name;
	private String surname;
	private String login;
	private String password;
	@Transient
	transient String confirmPassword;
	@OneToOne
	private Address address;
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}

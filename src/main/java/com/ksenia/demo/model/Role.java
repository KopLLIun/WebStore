package com.ksenia.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */

@Entity
@Table(name = "role")
@Data
public class Role
{
	@Id
	private int id;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
}

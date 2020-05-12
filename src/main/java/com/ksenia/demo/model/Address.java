package com.ksenia.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */
@Entity
@Table(name = "address")
@Data
public class Address
{
	@Id
	private int id;
	private String town;
	private String street;
	private int houseNumber;
	private int flatNumber;
}

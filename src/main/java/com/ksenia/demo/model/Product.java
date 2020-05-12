package com.ksenia.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */

@Entity
@Table(name = "product")
@Data
public class Product
{
	@Id
	private int id;
	private String name;
	private double price;
	private int amount;
	private String description;

}

package com.ksenia.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */

@Entity
@Table(name = "booking")
@Data
public class Booking
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "booking_date")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public String toString()
	{
		return "Booking{" +
			"id=" + id +
			", date=" + date +
			'}';
	}
}

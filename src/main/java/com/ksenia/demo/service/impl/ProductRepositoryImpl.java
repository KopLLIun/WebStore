package com.ksenia.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksenia.demo.model.Product;
import com.ksenia.demo.repository.ProductRepository;
import com.ksenia.demo.service.IProductService;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */

@Service
public class ProductRepositoryImpl implements IProductService
{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getGoodsById(Integer id)
	{
		return productRepository.getOne(id);
	}

	@Override
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	@Override
	public void addProduct(Product product)
	{
		productRepository.saveAndFlush(product);
	}

	@Override
	public Product editProduct(Product product)
	{
		return productRepository.saveAndFlush(product);
	}

	@Override
	public void deleteProduct(Integer id)
	{
		productRepository.deleteById(id);
	}
}

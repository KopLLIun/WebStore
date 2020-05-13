package com.ksenia.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ksenia.demo.model.ProductType;
import com.ksenia.demo.repository.ProductTypeRepository;
import com.ksenia.demo.service.IProductTypeService;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */
public class ProductTypeServiceImpl implements IProductTypeService
{
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public List<ProductType> getAllProductsType()
	{
		return productTypeRepository.findAll();
	}

	@Override
	public ProductType getProductTypeByID(Integer id)
	{
		return productTypeRepository.getOne(id);
	}

	@Override
	public void addProductType(ProductType productType)
	{
		productTypeRepository.saveAndFlush(productType);
	}

	@Override
	public ProductType editProduct(ProductType productType)
	{
		return productTypeRepository.saveAndFlush(productType);
	}

	@Override
	public void deleteProduct(Integer id)
	{
		productTypeRepository.deleteById(id);
	}
}

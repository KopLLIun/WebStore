package com.ksenia.demo.service;

import java.util.List;

import com.ksenia.demo.model.ProductType;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */
public interface IProductTypeService
{
	List<ProductType> getAllProductsType();
	ProductType getProductTypeByID(Integer id);
	void addProductType(ProductType productType);
	ProductType editProduct(ProductType productType);
	void deleteProduct(Integer id);
}

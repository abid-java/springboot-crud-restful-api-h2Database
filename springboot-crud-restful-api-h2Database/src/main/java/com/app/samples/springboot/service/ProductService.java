/*
 * 
 */
package com.app.samples.springboot.service;

import java.util.List;

import com.app.samples.springboot.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Creates the product.
	 *
	 * @param product the product
	 * @return the product
	 */
	public Product createProduct(Product product);
	
	/**
	 * Update product.
	 *
	 * @param product the product
	 * @param productId the product id
	 * @return the product
	 */
	public Product updateProduct(Product product,long productId);
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	public List<Product> getAllProducts();
	
	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 */
	public Product getProductById(long productId);
	
	/**
	 * Delete product.
	 *
	 * @param productId the product id
	 */
	public void deleteProduct(long productId);
}

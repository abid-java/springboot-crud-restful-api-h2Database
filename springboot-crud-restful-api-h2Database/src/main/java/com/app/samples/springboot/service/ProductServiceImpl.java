package com.app.samples.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.samples.springboot.entity.Product;
import com.app.samples.springboot.exception.ResourceNotFoundException;
import com.app.samples.springboot.repository.ProductRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductServiceImpl.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Creates the product.
	 *
	 * @param product the product
	 * @return the product
	 */
	@Override
	public Product createProduct(Product product) {
		Product savedProduct = null;
		if(product != null) {
			savedProduct = productRepository.save(product);
		}
		return savedProduct;
	}

	/**
	 * Update product.
	 *
	 * @param product the product
	 * @param productId the product id
	 * @return the product
	 */
	@Override
	public Product updateProduct(Product product, long productId) {
		Optional<Product> existingProduct = productRepository.findById(productId);
		Product updatedProduct = null;
		if(product != null) {
			if(existingProduct.isPresent()) {
				updatedProduct = existingProduct.get();
				updatedProduct.setId(product.getId());
				updatedProduct.setName(product.getName());
				updatedProduct.setDescription(product.getDescription());
			}else {
				throw new ResourceNotFoundException("Product Not Found with Id : " + product.getId());
			}
		}
		productRepository.save(updatedProduct);
		return updatedProduct;
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 */
	@Override
	public Product getProductById(long productId) {
		Optional<Product> product = productRepository.findById(productId);
		Product existingProduct = null;
		if(product.isPresent()) {
			existingProduct = product.get();
		}
		else {
			throw new ResourceNotFoundException("Product Not Found with Id : " + productId);
		}
		return existingProduct;
	}

	/**
	 * Delete product.
	 *
	 * @param productId the product id
	 */
	@Override
	public void deleteProduct(long productId) {
		Optional<Product> existingProduct = productRepository.findById(productId);
		Product productDb =  null;
		if(existingProduct.isPresent()) {
			productDb = existingProduct.get();
			productRepository.delete(productDb);
		}
		else {
			throw new ResourceNotFoundException("Product Not Found with Id : " + productId);
		}		
	}

}

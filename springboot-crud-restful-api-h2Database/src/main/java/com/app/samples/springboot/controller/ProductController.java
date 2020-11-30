package com.app.samples.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.samples.springboot.entity.Product;
import com.app.samples.springboot.service.ProductService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductController.
 */
@RestController
public class ProductController {
	
	/** The product service. */
	@Autowired
	private ProductService productService;
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		ResponseEntity<List<Product>> responseEntity = null;
		List<Product> products = productService.getAllProducts();
		responseEntity = ResponseEntity.ok().body(products);
		return responseEntity;
	}
	
	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) {
		ResponseEntity<Product> responseEntity = null;
		Product product = productService.getProductById(productId);
		responseEntity = ResponseEntity.ok().body(product);
		return responseEntity;
	}
	
	/**
	 * Creates the product.
	 *
	 * @param product the product
	 * @return the response entity
	 */
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		ResponseEntity<Product> responseEntity = null;
		Product createdProduct = productService.createProduct(product);
		responseEntity = ResponseEntity.ok().body(createdProduct);
		return responseEntity;
	}
	
	/**
	 * Update product.
	 *
	 * @param product the product
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable long id) {
		ResponseEntity<Product> responseEntity = null;
		product.setId(id);
		Product updatedProduct = productService.updateProduct(product,id);
		responseEntity = ResponseEntity.ok().body(updatedProduct);
		return responseEntity;
	}
	
	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id) {
		ResponseEntity<?> responseEntity = null;
		productService.deleteProduct(id);
		responseEntity = (ResponseEntity<?>)ResponseEntity.status(HttpStatus.OK);
		return responseEntity;
	}
	
	

}

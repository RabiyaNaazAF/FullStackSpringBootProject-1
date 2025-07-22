package com.jsp.product.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.jsp.product.entity.Product;
import com.jsp.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	public void add(Product product, ModelMap map) {
		repository.save(product);
		map.put("pass", "Product Added Success");
	}
 public void findRecords(ModelMap map){
	 map.put("products", repository.findAll());
 }
 
 public void delete(int id, ModelMap map) {
	 repository.deleteById(id);
	 map.put("pass", "product deleted success");
 }
 
 public void edit(int id, ModelMap map) {
	 Product product=repository.findById(id).get();
	 map.put( "product", product);
 }
 
 public void update(Product product, ModelMap map) {
	 repository.save(product);
	 map.put("pass", "product updated success");
 }
}
package com.jsp.product.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jsp.product.entity.Product;
import com.jsp.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/")
	public String loadMain() {
		return "main.html";
	}

	@GetMapping("/add")
	public String loadAdd() {
		return "add.html";
	}
	

	@PostMapping("/add")
	public String add(@ModelAttribute Product product, ModelMap map) {
		service.add(product, map);
		return "main.html";
	}
				
	@GetMapping("/view")
	public String view(ModelMap map) {
	service.findRecords(map);
	return "view";
	}
	
	@GetMapping("/delete/{id}")	
	public String delete(@PathVariable int id, ModelMap map) {
		service.delete(id, map);
		return view(map);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, ModelMap map) {
		service.edit(id, map);
		return "edit.html";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute Product product, ModelMap map) {
		service.update(product, map);
		return view(map) ;
	}
	
	
}
package com.inventory.product.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.product.model.Inventory;
import com.inventory.product.repository.InventoryDao;

@RestController
@Scope("session")
@EnableAutoConfiguration
@ComponentScan({"com.inventory.product"})
@PropertySource("classpath:banned-products.properties")
@EnableJpaRepositories("com.inventory.product.repository")
public class ControllerRest {
	
	@Autowired
	private InventoryDao inventorydao;

	@Autowired
	private Inventory newProduct;

	/*
	 * When id is 1, returns response code 302
	 * else
	 * returns response code 200
	 */
	@GetMapping(value = "/products/{id}")
	public Optional<Inventory> findProductByID(@PathVariable int id, HttpServletResponse response) {

		if(id==1)
		{ 
			response.setStatus(HttpServletResponse.SC_FOUND);
			return null;
		}
		else
			return inventorydao.findById(id);
	}
	
	/*
	 * Get the price of a given product. 
	 * Since this end-point is used to check price periodically, 
	 * cache the HTTP response for 30 minutes
	 * */
	@GetMapping(value = "/product/{name}")
	public double getPrice(@PathVariable String name, HttpServletResponse response) {

		Inventory i= inventorydao.findByName(name);
		response.setHeader("Cache-Control", "max-age=1800");
		return i.getPrice();

	}
	
	//to delete product using deletemapping
	@DeleteMapping(value = "/deletemapping/{id}")
	public String deleteProductById(@PathVariable int id) {

		inventorydao.deleteById(id);
		return "Deleted the product successfully";
	}
	
	/*
	 * Create an Auto configuration class MyConfiguration to return Inventory instance
	 * in order to add a new product on startup
	 */
	@PostMapping("/addnewproducts")  
	public String addnewProduct()   
	{  
		inventorydao.save(newProduct);
		return "Product given in configuration is added to inventory successfully";
	}  
}

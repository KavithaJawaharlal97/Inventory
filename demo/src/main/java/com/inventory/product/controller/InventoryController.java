package com.inventory.product.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.product.model.Inventory;
import com.inventory.product.repository.InventoryDao;

@Controller
@Scope("session")
@EnableAutoConfiguration
@ComponentScan({"com.inventory.product"})
@PropertySource("classpath:banned-products.properties")
@EnableJpaRepositories("com.inventory.product.repository")
public class InventoryController {

	@Autowired
	private InventoryDao inventorydao;
	
	@Autowired
	private Inventory newProduct;
	
	@Value("${banned.products}")
	String bannedProducts;

	@GetMapping(value = "/products") 
	String showAllProducts(Model m) {
		
		m.addAttribute("productss",inventorydao.findAll());
		
		return "ViewProducts";
		
	}

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

	@GetMapping(value = "/product/{name}")
	public double getPrice(@PathVariable String name, HttpServletResponse response) {

		Inventory i= inventorydao.findByName(name);
		response.setHeader("Cache-Control", "max-age=1800");
		return i.getPrice();

	}
	@DeleteMapping(value = "/deletemapping/{id}")
	public String deleteProductById(@PathVariable int id) {
		
		inventorydao.deleteById(id);
		
		return "Deleted the product successfully";
	}
	
	
	@GetMapping(value = "/deleteproduct")
	public String deleteProductById(Model m,@RequestParam("id") String id1) {
		int id = Integer.parseInt(id1);
		inventorydao.deleteById(id);
		
		String msg= "Deleted the product successfully";
		m.addAttribute("message",msg);
		return "ResultPage";
	}
	
	@PostMapping("/addproducts") 
	//@RequestMapping("/addproducts")
	public String addProduct(Model m,@RequestParam("name") String name,@RequestParam("price") String price1,@RequestParam("quantity") String quantity1)   
	{  
		Inventory inv = new Inventory();
		double price=Double.parseDouble(price1);
		int quantity = Integer.parseInt(quantity1);
		String msg ="";
		String[] bannedProductsList = bannedProducts.split(","); 
		for(String products:bannedProductsList)
		{
			if(name.equals(products))
			 {
				msg= "Banned Product cannot be added to inventory";
				m.addAttribute("message",msg);
				return "ResultPage";
			 }
		}
		inv.setName(name);
		inv.setPrice(price);
		inv.setQuantity(quantity);
		inventorydao.save(inv);
		
		msg= "Product added to inventory successfully";
		m.addAttribute("message",msg);
		return "ResultPage";
		
	}  
	
	@RequestMapping("/addDetails")  
	public String add()   
	{  
		return "AddDetails";
	}  

	@RequestMapping("/updateDetails")  
	public String update()   
	{  
		return "UpdateDetails";
	}  

	@RequestMapping("/deleteDetails")  
	public String delete()   
	{  
		return "DeleteDetails";
	}  
	@PostMapping("/addnewproducts")  
	public String addnewProduct()   
	{  
		inventorydao.save(newProduct);
		return "Product given in configuration is added to inventory successfully";
	}  
	
	@RequestMapping(value = "/updateproducts", method = RequestMethod.POST) 
	public String updateInventory(Model m,@RequestParam(value="id")String id1,@RequestParam(value="name") String name,@RequestParam(value="price") String price1,@RequestParam(value="quantity") String quantity1)   
	{  
		int id = Integer.parseInt(id1);
		double price=Double.parseDouble(price1);
		int quantity = Integer.parseInt(quantity1);
		String msg ="Product details updated successfully";
		Optional<Inventory> inv = inventorydao.findById(id);
        inv.get().setName(name);
        inv.get().setPrice(price);
        inv.get().setQuantity(quantity);
        inventorydao.save(inv.get());
        m.addAttribute("message",msg);
        return "ResultPage";
	}  


}
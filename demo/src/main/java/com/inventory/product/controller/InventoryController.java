package com.inventory.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@Value("${banned.products}")
	String bannedProducts;

	//To View Products 
	@GetMapping(value = "/products") 
	String showAllProducts(Model m) {

		m.addAttribute("productss",inventorydao.findAll());

		return "ViewProducts";

	}

	//to delete product using getmapping
	@GetMapping(value = "/deleteproduct")
	public String deleteProductById(Model m,@RequestParam("id") String id1) {
		int id = Integer.parseInt(id1);
		inventorydao.deleteById(id);

		String msg= "Deleted the product successfully";
		m.addAttribute("message",msg);
		return "ResultPage";
	}

	/*
	 * Maintaining a list of banned products in a property file banned-products.properties, 
	 * do not allow insertion if the product is blocked and raise appropriate error
	 * Inserting the products using post mapping
	 * */
	@PostMapping("/addproducts") 
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

	/*
	 * To access web pages
	 */
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

	//To Update the products based on id value
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
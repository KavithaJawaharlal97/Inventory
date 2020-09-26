package com.inventory.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.repository.InventoryDao;

@Service
public class InventoryService implements InventoryCRUDService{
	
	/*@Autowired
	private InventoryDao inventoryDao;
	
	public void updateuser(String name,double price, int quantity) {
		
		  inventoryDao.addproduct(name, price, quantity);
	}*/
}

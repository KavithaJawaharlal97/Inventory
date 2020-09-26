package com.inventory.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.product.model.Inventory;

@Repository
public interface InventoryDao extends JpaRepository<Inventory, Integer> {

	
	Inventory findByName(@Param("name") String name);
	
	String hql = "UPDATE Inventory as i set " +
	          "i.name = :name," +
	          "i.price = :price, " +
	          "i.quantity = :quantity " +
	          "where i.id = :id";
	
	@Modifying
	@Transactional
	@Query(value= "insert into Inventory(name, price,quantity) values (:name, :price,:quantity)",nativeQuery=true)
	void addproduct(@Param("name") String name,@Param("price") double price,@Param("quantity") int quantity);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value= hql)
	void updateInventory(@Param("id") int id,@Param("name") String name,@Param("price") Double price,@Param("quantity") Integer quantity);
	

}

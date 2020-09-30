package com.inventory.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.product.model.Inventory;

/*
 * Repository class for inventory entity
 */
@Repository
public interface InventoryDao extends JpaRepository<Inventory, Integer> {

	//Finding the entity by name
	Inventory findByName(@Param("name") String name);
}

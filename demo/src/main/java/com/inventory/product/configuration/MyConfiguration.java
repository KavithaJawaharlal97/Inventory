package com.inventory.product.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inventory.product.model.Inventory;

@Configuration
@ConditionalOnMissingClass
public class MyConfiguration {

	@Bean(value="newProduct")
	@ConditionalOnMissingBean
	public Inventory newProduct() {
		return new Inventory("Tablet",8000,1);
	}
}

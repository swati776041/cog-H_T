package com.java.demo;


import java.time.LocalDate;
import java.util.List;

public class Order {
	int id;
	String status;
	LocalDate orderDate;
	LocalDate deliveryDate;
	List<Item> items;
	Customer customer;

	public Order (int id,String status,LocalDate orderDate,LocalDate deliveryDate,List<Item> items,Customer customer) {
	
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.items =items;
		this.customer = customer;
	}
}

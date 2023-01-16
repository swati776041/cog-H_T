package com.main;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.java.demo.Customer;
import com.java.demo.Item;
import com.java.demo.Order;



@FunctionalInterface
interface GetDate{
	
	int doTask(int id,String status,LocalDate orderDate,LocalDate deliveryDate,List<Item> items,Customer customer);

}
	
public class MainClass2 {
	
	public static void main(String[] args)
	{
		Item i1 = new Item(134,"Moto24",15000,"Mobiles");
		Item i2 = new Item(157,"Spiderman",50,"Books");
		Item i3 = new Item(204,"Acer",70000,"Laptops");
		Item i4 = new Item(210,"iphone",45000,"Mobiles");
		Item i5 = new Item(215,"Shirt",1500,"Shirts");
		
		Customer c1 = new Customer(1,"Tom","Male","Bangalore");
		Customer c2 = new Customer(2,"Mike","Male","Delhi");
		Customer c3 = new Customer(3,"Miley","Female","Pune");
		Customer c4 = new Customer(4,"Kunal","Male","Delhi");
		Customer c5 = new Customer(5,"Sakshi","Female","Delhi");
		
		List<Item> items1 = new ArrayList<Item>();
		items1.add(i1);
		items1.add(i3);
		
		List<Item> items2 = new ArrayList<Item>();
		items2.add(i3);
		
		List<Item> items3 = new ArrayList<Item>();
		items3.add(i4);
		items3.add(i5);
		
		List<Item> items4 = new ArrayList<Item>();
		items4.add(i1);
		items4.add(i2);
		items4.add(i3);
		items4.add(i5);
		
		List<Item> items5 = new ArrayList<Item>();
		items5.add(i1);
		Order o1 = new Order(1,"delivered", LocalDate.of(2021, 11, 12),LocalDate.of(2021, 11, 14), items1, c1);
		Order o2 = new Order(2,"delivered", LocalDate.of(2022, 05, 19),LocalDate.of(2022, 5, 24), items2, c4);
		Order o3 = new Order(3,"delivered", LocalDate.of(2021, 07, 31),LocalDate.of(2021, 8, 04), items3, c2);
	    Order o4 = new Order (4,"pending", LocalDate.of(2022, 10, 29), LocalDate.of(1, 1, 1),items4, c3);
		Order o5 = new Order(5,"pending", LocalDate.of(2021, 10, 29),LocalDate.of(1, 1, 1), items5, c5);
		GetDate lt=(int id,String status,LocalDate orderDate,LocalDate deliveryDate,List<Item> items,Customer customer)->{
			{

			System.out.println(id  + " " + status + " " +  orderDate+ " " +  deliveryDate + " " + items + " " + customer );
		    }
		  return id;
			};	
				lt.doTask(1,"delivered", LocalDate.of(2021, 11, 12),LocalDate.of(2021, 11, 14), items1, c1);		
				lt.doTask(2,"delivered", LocalDate.of(2022, 05, 19),LocalDate.of(2022, 5, 24), items2, c4);
			lt.doTask(3,"delivered", LocalDate.of(2021, 07, 31),LocalDate.of(2021, 8, 04), items3, c2);
			lt.doTask(4,"pending", LocalDate.of(2022, 10, 29), LocalDate.of(1, 1, 1),items4, c3);
			lt.doTask(5,"pending", LocalDate.of(2021, 10, 29),LocalDate.of(1, 1, 1), items5, c5);
		}
//		List<customerOrders> ordersInRangeDated = customerOrders.steam().filter(c->{
//			try {
//				return c.getOderDte.after(LocalDate.Parse(2022, 01, 01))&&
//						c.getOderDte.after(LocalDate.parse(2022, 10, 31));	
//			}catch (ParseException e) {
//				e.printStackTrace();
//			}
//			
//		}).collect(Collectors.toList());
//		System.out.println(ordersInRangeDated);
//		System.out.println();
		
	
	}


package com.main;

@FunctionalInterface
interface ListMobiles{
	
	void doTask(int i, String name, double price, String category);


}
public class Mobiles{
	
	public static void main(String[] args)
	{
	
		ListMobiles lb=(int i, String name, double price, String category)->{
			if(category=="Mobiles")
			{
			System.out.println(i  + " " + name + " " +  price + " " +   category);
			}
			
		};
		lb.doTask(134,"Moto24",15000,"Mobiles");
		lb.doTask(157,"Spiderman",50,"Books");
		lb.doTask(204,"Acer",70000,"Laptops");
		lb.doTask(210,"iphone",45000,"Mobiles");
		lb.doTask(215,"Shirt",1500,"Shirts");
		
		ListMobiles lt=(int i, String name, double price, String category)->{
			if(category=="Laptops" )
			{
			double dis=5;
			double p=100-dis;
			price=(p*price)/100;
	
			System.out.println(i  + " " + name + " " +  price + " " +   category);
			}
		};
		
		lt.doTask(134,"Moto24",15000,"Mobiles");
		lt.doTask(157,"Spiderman",50,"Books");
		lt.doTask(204,"Acer",70000,"Laptops");
		lt.doTask(210,"iphone",45000,"Mobiles");
		lt.doTask(215,"Shirt",1500,"Shirts");
		
		ListMobiles nm=(int i, String name, double price, String category)->{
			if(category!="Mobiles") {
		
				System.out.println(i  + " " + name + " " +  price + " " +   category);
			}
			};
			nm.doTask(134,"Moto24",15000,"Mobiles");
			nm.doTask(157,"Spiderman",50,"Books");
			nm.doTask(204,"Acer",70000,"Laptops");
			nm.doTask(210,"iphone",45000,"Mobiles");
			nm.doTask(215,"Shirt",1500,"Shirts");
	
			
			ListMobiles s=(int i, String name, double price, String category)->{
				if(category== "Mobiles" && price >= 20000)
				{
					System.out.println(i  + " " + name + " " +  price + " " +   category);
				}
				};
				s.doTask(134,"Moto24",15000,"Mobiles");
					s.doTask(157,"Spiderman",50,"Books");		
					s.doTask(204,"Acer",70000,"Laptops");
					s.doTask(210,"iphone",45000,"Mobiles");
				s.doTask(215,"Shirt",1500,"Shirts");		
}
}


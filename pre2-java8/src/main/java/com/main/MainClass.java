package com.main;



@FunctionalInterface
interface GetVar{
	
	void doTask( int id,String name, String gender,String city);

}
	
public class MainClass {
	public static void main(String[] args)
	{
		
		
		GetVar lt=(int id,String name, String gender,String city)->{
		if(gender=="Female")
		{
			System.out.println(id  + " " + name + " " +  gender+ " " +   city);
		}
		
		};
		lt.doTask(3,"Miley","Female","Pune");
		lt.doTask(5,"Sakshi","Female","Delhi");
		lt.doTask(1,"Tom","Male","Bangalore");
		lt.doTask(2,"Mike","Male","Delhi");
		lt.doTask(4,"Kunal","Male","Delhi");
		
}

}

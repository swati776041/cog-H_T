package com.demo.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
@SpringBootApplication
public class MyApp implements CommandLineRunner{
	
	@Autowired
	Environment env;
	@Value("${myapp.test}")
	String test;
	@Value("${myapp.test.demo}")
	String demo;
	@Override
	public void run(String ...args) throws Exception {
		System.out.println("My app is running");
		System.out.println("Demo:" + env.getProperty("Demo"));
		System.out.println("Number_Of_Processor:" + env.getProperty("Number_Of_Processor"));
		System.out.println("OS:" + env.getProperty("OS"));
		System.out.println();
		System.out.println("property test:"+test);
		System.out.println("property->ENV demo:"+demo);
	}
	
public static void main(String[] args)
{
	SpringApplication.run(MyApp.class, args);
}
}

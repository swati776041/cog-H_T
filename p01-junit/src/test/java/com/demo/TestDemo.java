package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.demo.test.Calculator;

public class TestDemo {
	@Test
public void ShouldDivNumByNum()
{
Calculator cal= new Calculator();
double num1 = 8;
double num2 = 2;
double expectedResult = 4;
double actualResult = cal.div(num1, num2);
Assertions.assertEquals(expectedResult,actualResult);
}
	@Test
	public void ShouldNotDivNumByZero()
	{
	Calculator cal= new Calculator();
	double num1 = 8;
	double num2 = 0;
	
  Exception e=assertThrows(ArithmeticException.class,()-> cal.div(num1, num2));
	Assertions.assertEquals(e.getMessage(),"Divisor throw error");
	
	}
}

package com.demo.test;

public class Calculator {
	public double div(double num1, double num2)
	{
double res;
if(num2==0) {
	throw new ArithmeticException("Divisor throw error");
}
else
{
res=num1/num2;
}
return res;
	}

	

}


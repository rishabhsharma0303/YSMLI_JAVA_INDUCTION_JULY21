package com.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;
	
	@Before
	public void setUp() {
		calculator=new Calculator();
	}
	
	//hey junit this method must throws ex ie ArithmeticException
	//if it throws ArithmeticException it is consider success of test case
	@Test(expected = ArithmeticException.class)
	public void divide_two_number_with_exception() {
		int result=calculator.divide(15, 0);
		Assert.assertEquals(7, result);
	}
	
	@Test
	public void divide_two_number_with_sucess() {
		int result=calculator.divide(15, 2);
		Assert.assertEquals(7, result);
	}
	
	@Ignore
	@Test
	public void addTest() {
		int sum=calculator.add(3,5);
		Assert.assertEquals(8, sum);
	}
	
	@After
	public void tearDown() {
		calculator=null;
	}
}

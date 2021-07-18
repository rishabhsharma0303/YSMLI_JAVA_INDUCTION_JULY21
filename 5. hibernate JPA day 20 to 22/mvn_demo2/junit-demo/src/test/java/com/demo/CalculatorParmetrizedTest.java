package com.demo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * what is the need of paramertrized test case
 * what if u want to run same test for 100 of data, excel , csv
 */
@RunWith(Parameterized.class)
public class CalculatorParmetrizedTest {
	
	private int expectedResult;
	private int firstNumber;
	private int secondNumber;
	
	@Parameters
	public static Collection<Object[]> testData(){
		System.out.println("method with @Parameters is called... ");
		Object[][]data=new Object[][]{{4,2,2},{4,1,3},{40,10,30},{40,20,20},{49,29,20}};
		return Arrays.asList(data);
	}


	Calculator calculator;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup is called...");
		calculator=new Calculator();
	}
										//4 				2 						2
	public CalculatorParmetrizedTest(int expectedResult, int firstNumber, int secondNumber) {
		System.out.println("CalculatorParmetrizedTest is called....");
		this.expectedResult = expectedResult;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	
									//4 				2 						2
	@Test
	public void testAdd(){
		Assert.assertEquals(expectedResult, calculator.add(firstNumber, secondNumber));
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown is called...");
		calculator=null;
	}
	
}






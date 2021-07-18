package com.demo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class CalTest {

	private Cal cal;
	@Before
	public void setUp() throws Exception {
		cal=new Cal();
	}
	
	@Test
	public void testAdd() {
		int i=0;
		
		assertEquals(4, cal.add(2, 2));
		System.out.println("hello world cal running");
	}

	@After
	public void tearDown() throws Exception {
		cal=null;
	}

	

}

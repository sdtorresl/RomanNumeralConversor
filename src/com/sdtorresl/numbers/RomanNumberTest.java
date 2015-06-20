/**
 * 
 */
package com.sdtorresl.numbers;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Sergio Torres
 *
 */
public class RomanNumberTest {

	private RomanNumber myNumber;
	
	@Test
	public void test() throws Exception {
		myNumber = new RomanNumber();
		myNumber.setDecimalNumber(1550);
		assertEquals("MDL", myNumber.getRomanNumber());
		
		myNumber.setDecimalNumber(2458);
		assertEquals("MMCDLVIII", myNumber.getRomanNumber());
		
		myNumber.setRomanNumber("XXX");
		assertEquals(30, myNumber.getDecimalNumber());
		
		myNumber.setRomanNumber("L");
		assertEquals(50, myNumber.getDecimalNumber());
		
		myNumber.setRomanNumber("MMCDLVIII");
		assertEquals(2458, myNumber.getDecimalNumber());
		
		myNumber.setRomanNumber("MLVIII");
		assertEquals(1058, myNumber.getDecimalNumber());
		
		myNumber.setRomanNumber("MMLVIII");
		assertEquals(2058, myNumber.getDecimalNumber());
	}
	
	@Test 
	public void invalidNumbers() throws Exception {
		// Validate negative numbers
		boolean thrown = false;
		try {
			  myNumber.setDecimalNumber(-1550);
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);	
		
		// Avoid numbers greater than 4000
		thrown = false;
		try {
			  myNumber.setDecimalNumber(4001);
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

}

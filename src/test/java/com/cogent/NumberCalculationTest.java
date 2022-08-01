package com.cogent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class NumberCalculationTest {
	NumberCalculation nc;
	
	@BeforeEach
	void init() {
		nc = new NumberCalculation();
	}
	
	@Test
	void testAddition() {
		assertEquals(nc.add(10, 20), 30);
	}
	
	@Nested
	class AddTest{
		@Test
		void addPositive() {
			assertEquals(2, nc.add(1, 1));
		}
		@Test
		void addPositive_Negative() {
			assertEquals(0, nc.add(1, -1));
		}
		@Test
		void addNegative() {
			assertEquals(-2, nc.add(-1, -1));
		}
	}
	
	@Test
	void testMultiply() {
		assertAll(
				()->assertEquals(0, nc.multiply(1, 0)),
				()->assertEquals(7, nc.multiply(7, 1)),
				()->assertEquals(20, nc.multiply(5, 4))
				);
	}
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, ()->nc.divide(1, 0), "denominator should not be zero");
	}

}

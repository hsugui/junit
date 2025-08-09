package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BMICalculatorTest {

	@Test
	void shouldReturnTrueWhenDietRecommended() {
		// Given
		double weight = 89.0;
		double height = 1.72;
		
		// When
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		
		// Then
		assertTrue(recommended);
	}
	
	@Test
	void shouldReturnFalseWhenDietNotRecommended() {
		// Given
		double weight = 50.0;
		double height = 1.92;
		
		// When
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		
		// Then
		assertFalse(recommended);
	}

}

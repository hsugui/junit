package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {
	
//	@BeforeAll //setting up db connections or servers, etc. (operations that are expensive to run before every test)
//	static void beforeAll() {
//		System.out.println("Before all unit tests.");
//	}
//	
//	@AfterAll // close db connections, stop servers, etc.
//	static void afterAll() {
//		System.out.println("After all unit tests.");
//	}

	@ParameterizedTest
	@ValueSource(doubles = {89.0, 95.0, 110.0})
	void shouldReturnTrueWhenDietRecommended(Double coderWeight) {
		// Given
		double weight = coderWeight;
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
	
	@Test
	void shouldThrowArithmeticExceptionWhenHeightZero() {
		// Given
		double weight = 50.0;
		double height = 0.0;
		
		// When
		Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
		
		// Then
		assertThrows(ArithmeticException.class, executable);
	}
	
	@Test
	void shouldReturnCoderWithWorstBMIWhenCoderListNotEmpty() {
		// Given
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80, 60.0));
		coders.add(new Coder(1.82, 98.0));
		coders.add(new Coder(1.82, 64.7));
		
		// When
		Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
		
		// Then
		assertAll (
			() -> assertEquals(1.82, coderWorstBMI.getHeight()),
			() -> assertEquals(98.0, coderWorstBMI.getWeight())
		);
	}
	
	@Test
	void shouldReturnNullWorstBMICoderWhenCoderListIsEmpty() {
		// Given
		List<Coder> coders = new ArrayList<>();
		
		// When
		Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
		
		// Then
		assertNull(coderWorstBMI);
	}
	
	@Test
	void shouldReturnCorrectBMIScoreArrayWhenCoderListNotEmpty() {
		// Given
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80, 60.0));
		coders.add(new Coder(1.82, 98.0));
		coders.add(new Coder(1.82, 64.7));
		double[] expected = {18.52, 29.59, 19.53};
		
		// When
		double[] bmiScores = BMICalculator.getBMIScores(coders);
		
		// Then
		assertArrayEquals(expected, bmiScores); // we need this method for arrays because of memory address
	}

}

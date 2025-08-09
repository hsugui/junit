package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ActivityCalculatorTest {

	@Test
	void shouldReturnBadWhenAvgBelow20() {
		// Given
		int weeklyCardioMins = 40;
		int weeklyWorkouts = 1;
		
		// When
		String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkouts);
		
		// Then
		assertEquals("bad", actual);
	}
	
	@Test
	void shouldReturnAverageWhenAvgBetween20And40() {
		// Given
		int weeklyCardioMins = 40;
		int weeklyWorkouts = 3;
		
		// When
		String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkouts);
		
		// Then
		assertEquals("average", actual);
	}

	
	@Test
	void shouldReturnGoodWhenAvgAbove40() {
		// Given
		int weeklyCardioMins = 40;
		int weeklyWorkouts = 7;
		
		// When
		String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkouts);
		
		// Then
		assertEquals("good", actual);
	}

	@Test
	void shouldThrowExceptionWhenInputBelowZero() {
		// Given
		int weeklyCardioMins = -40;
		int weeklyWorkouts = 7;
		
		// When
		Executable executable = () -> ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkouts);
		
		// Then
		assertThrows(RuntimeException.class, executable);
	}
}

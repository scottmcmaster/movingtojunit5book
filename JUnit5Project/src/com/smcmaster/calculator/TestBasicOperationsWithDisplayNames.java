package com.smcmaster.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Tests basic operations of the calculator class")
public class TestBasicOperationsWithDisplayNames {
  private Calculator calc;
  
  @BeforeEach
  public void setUp() {
    calc = new DefaultCalculator();
  }
  
  @Nested
  @DisplayName("Addition tests")
  class AddTests {
    @Test
    @DisplayName("Tests adding positive numbers")
    public void testPositives() {
      assertEquals(16, calc.add(10, 6));
    }
    
    @Test
    @DisplayName("Tests adding negative numbers")
    public void testNegatives() {
      assertEquals(-16, calc.add(-10, -6));
    }    
  }
  
  @Nested
  @DisplayName("Subtraction tests")
  class SubtractTests {
    @Test
    @DisplayName("Tests subtracting positive numbers")
    public void testPositives() {
      assertEquals(4, calc.subtract(10, 6));
    }
    
    @Test
    @DisplayName("Tests subtracting negative numbers")
    public void testNegatives() {
      assertEquals(-4, calc.subtract(-10, -6));
    }    
  }
}

package com.smcmaster.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestBasicOperations {
  private Calculator calc;
  
  @BeforeEach
  public void setUp() {
    calc = new DefaultCalculator();
  }
  
  @Nested
  class AddTests {
    @Test
    public void testPositives() {
      assertEquals(16, calc.add(10, 6));
    }
    
    @Test
    public void testNegatives() {
      assertEquals(-16, calc.add(-10, -6));
    }    
  }
  
  @Nested
  class SubtractTests {
    @Test
    public void testPositives() {
      assertEquals(4, calc.subtract(10, 6));
    }
    
    @Test
    public void testNegatives() {
      assertEquals(-4, calc.subtract(-10, -6));
    }    
  }
}

package com.smcmaster.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RandomBinaryCalculationParameterResolver.class)
class TestRandomBinaryCalculations {

  private Calculator calc = new DefaultCalculator();
  
  @Test
  void testRandomBinaryCalculation(BinaryCalculation bc) {
    System.out.println("" + bc + ": " + calc.calculate(bc));
  }
}

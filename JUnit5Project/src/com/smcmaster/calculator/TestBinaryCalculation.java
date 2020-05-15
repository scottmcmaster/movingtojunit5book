package com.smcmaster.calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestBinaryCalculation {
  
  @Test
  public void testConstructionWithFields_Old() {
    BinaryCalculation calc = new BinaryCalculation("add", 10, 6);
    assertEquals(Operation.ADD, calc.getOperation());
    assertEquals(10, calc.getLeft(), 0.001);
    assertEquals(6, calc.getRight(), 0.001);
  }
  
  @Test
  public void testConstructionWithAssertAll() {
    BinaryCalculation calc = new BinaryCalculation("add", 10, 6);
    assertAll(
        () -> assertEquals(Operation.ADD, calc.getOperation()),
        () -> assertEquals(10, calc.getLeft(), 0.001),
        () -> assertEquals(6, calc.getRight(), 0.001));
  }
}

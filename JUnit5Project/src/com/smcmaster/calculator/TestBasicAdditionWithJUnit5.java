package com.smcmaster.calculator;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBasicAdditionWithJUnit5 {

  private Calculator cal;
  
  @BeforeEach
  public void setUp() {
    cal = new DefaultCalculator();
  }
  
  @Test
  public void testSimpleAddition() {
    assertEquals(10, cal.add(3, 7), 0.001);
  }
}

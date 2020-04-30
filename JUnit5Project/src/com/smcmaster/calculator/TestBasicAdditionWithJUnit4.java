package com.smcmaster.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBasicAdditionWithJUnit4 {

  private Calculator cal;
  
  @Before 
  public void setUp() {
    cal = new DefaultCalculator();
  }
  
  @Test
  public void testSimpleAddition() {
    assertEquals(10, cal.add(3, 7), 0.001);
  }
}

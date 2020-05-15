package com.smcmaster.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestBasicAddition {

  private Calculator cal;
  
  @Before 
  public void setUp() {
    cal = new DefaultCalculator();
  }
  
  @Test
  public void testSimpleAddition() {
    assertEquals(10, cal.add(3, 7), 0.001);
  }

  @Test
  public void testAddStrings() {
    assertEquals("adds strings", "10.0", cal.add("3", "7"));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testDivideByZero() {
    cal.divide(60, 0);
  }
  
  @Ignore
  @Test(timeout = 3000)
  public void testReallySlowAdd() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    }
    assertEquals(10, cal.add(3, 7), 0.001);
  }
}

package com.smcmaster.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.fail;
import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
  
  @Test
  public void testAddStrings() {
    assertEquals("10.0", cal.add("3", "7"), "adds strings");
  }
  
  @Test
  public void testDivideByZero() {
    assertThrows(IllegalArgumentException.class,
        () -> cal.divide(60, 0));
  }
  
  @Test
  public void testDivideByZeroMessage() {
    try {
      cal.divide(60, 0);
    } catch (IllegalArgumentException ex) {
      assertEquals("divide by zero", ex.getMessage());
      return;
    } catch (RuntimeException ex) {
    }
    fail("didn't catch expected exception");
  }
  
  @Disabled
  @Test
  public void testReallySlowAdd() {
    assertTimeout(Duration.ofSeconds(3), () -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
      }
      assertEquals(10, cal.add(3, 7));
    });
  }
}

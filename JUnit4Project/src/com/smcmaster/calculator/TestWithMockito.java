package com.smcmaster.calculator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestWithMockito {
  @Mock
  private Calculator calc;
  
  @Test
  public void testAdd() {
    when(calc.add(6, 4)).thenReturn(10.0);
    
    App app = new App(calc);
    double result = app.run(new String[] {"add", "6", "4"});
    assertEquals(10, result, 0.001);
  }
}

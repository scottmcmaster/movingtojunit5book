package com.smcmaster.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestWithMockitoParameterInjection {
  @Test
  public void testAdd(@Mock Calculator calc) {
    when(calc.add(6, 4)).thenReturn(10.0);
    
    App app = new App(calc);
    double result = app.run(new String[] {"add", "6", "4"});
    assertEquals(10, result, 0.001);
  }
}

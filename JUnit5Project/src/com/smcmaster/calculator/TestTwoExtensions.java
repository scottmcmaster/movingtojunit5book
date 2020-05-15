package com.smcmaster.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(RandomBinaryCalculationParameterResolver.class)
public class TestTwoExtensions {
  @Test
  public void testAdd(@Mock Calculator calc, BinaryCalculation bc) {    
    App app = new App(calc);
    app.run(new String[] {bc.getOperation().toString().toLowerCase(),
        "" + bc.getLeft(), "" + bc.getRight()});

    switch (bc.getOperation()) {
      case ADD:
        verify(calc).add(bc.getLeft(), bc.getRight());
        break;
        
      case SUB:
        verify(calc).subtract(bc.getLeft(), bc.getRight());        
        break;
        
      case MUL:
        verify(calc).multiply(bc.getLeft(), bc.getRight());
        break;
        
      case DIV:
        verify(calc).divide(bc.getLeft(), bc.getRight());
        break;
        
      default:
        fail("unknown operation");
    }
  }
}

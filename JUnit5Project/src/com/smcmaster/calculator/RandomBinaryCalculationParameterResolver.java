package com.smcmaster.calculator;

import java.util.Random;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * Returns a random binary calculation for a test method. 
 */
public class RandomBinaryCalculationParameterResolver implements ParameterResolver {
  private static final double RANGE = 10000;
  private static final Random rand = new Random();
  
  private double randDouble() {
    return -RANGE + RANGE * rand.nextDouble();
  }
  
  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    String operation;
    switch (rand.nextInt(3)) {
      case 0:
        operation = "add";
        break;
      case 1:
        operation = "sub";
        break;
      case 2:
        operation = "mul";
        break;
      default:
        operation = "div";
        break;
    }
    
    double right;
    do {
      right = randDouble();
    } while (operation.equals("div") && right == 0);
    return new BinaryCalculation(operation, randDouble(), right);
  }

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == BinaryCalculation.class;
  }
}

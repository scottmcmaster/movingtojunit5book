package com.smcmaster.calculator;

public class DefaultCalculator implements Calculator {

  @Override
  public double add(double x, double y) {
    return x + y;
  }

  @Override
  public double subtract(double x, double y) {
    return x - y;
  }

  @Override
  public double multiply(double x, double y) {
    return x * y;
  }

  @Override
  public double divide(double x, double y) {
    if (y == 0) {
      throw new IllegalArgumentException("divide by zero");
    }
    return x / y;
  }

  @Override
  public String add(String x, String y) {
    return "" + (Double.parseDouble(x) + Double.parseDouble(y));
  }

  @Override
  public double calculate(BinaryCalculation calculation) {
    
    double x = calculation.getLeft();
    double y = calculation.getRight();
    
    switch (calculation.getOperation()) {
      case ADD:
        return add(x, y);
        
      case SUB:
        return subtract(x, y);
        
      case MUL:
        return multiply(x, y);
        
      case DIV:
        return divide(x, y);
        
      default:
        throw new IllegalArgumentException("unknown operation");
    }
  }
}

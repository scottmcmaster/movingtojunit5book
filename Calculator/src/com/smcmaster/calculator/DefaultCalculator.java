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
  public double divide(int x, int y) {
    return x / y;
  }
}

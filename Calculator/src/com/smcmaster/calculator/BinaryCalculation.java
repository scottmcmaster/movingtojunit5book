package com.smcmaster.calculator;

public class BinaryCalculation {
  private Operation operation;
  private double left;
  private double right;

  public BinaryCalculation(String operation, double left, double right) {
    if (operation == null || operation.isBlank()) {
      throw new IllegalArgumentException("invalid operation");
    }
    this.operation = Operation.valueOf(operation.toUpperCase());
    this.left = left;
    this.right = right;
  }

  public BinaryCalculation(Operation operation, double left, double right) {
    this.operation = operation;
    this.left = left;
    this.right = right;
  }

  public Operation getOperation() {
    return operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public double getLeft() {
    return left;
  }

  public void setLeft(double left) {
    this.left = left;
  }

  public double getRight() {
    return right;
  }

  public void setRight(double right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "BinaryCalculation [operation=" + operation + ", left=" + left + ", right=" + right
        + "]";
  }
}

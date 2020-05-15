package com.smcmaster.calculator;

public class App {

  private Calculator calc;

  public App(Calculator calc) {
    this.calc = calc;
  }
  
  public double run(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException();
    }
    
    double x = Double.parseDouble(args[1]);
    double y = Double.parseDouble(args[2]);
    
    switch (args[0]) {
      case "add":
        return calc.add(x, y);
        
      case "sub":
        return calc.subtract(x, y);
        
      case "mul":
        return calc.multiply(x, y);
        
      case "div":
        return calc.divide(x, y);
        
      default:
        throw new IllegalArgumentException("unknown operation");
    }
  }
  
  /**
   * usage: (add|sub|mul|div) arg1 arg2
   */
  public static void main(String[] args) {
    System.out.println(new App(new DefaultCalculator()).run(args));
  }

}

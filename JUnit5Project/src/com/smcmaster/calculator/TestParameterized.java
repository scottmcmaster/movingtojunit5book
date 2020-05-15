package com.smcmaster.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class TestParameterized {

  private DefaultCalculator calc;

  @BeforeEach
  void setUp() {
    calc = new DefaultCalculator();
  }
  
  @ParameterizedTest
  @ValueSource(strings = {"add", "sub", "mul", "div"})
  void testAllOperations(String op) {
    BinaryCalculation bc = new BinaryCalculation(op, 20, 10);
    double result = calc.calculate(bc);
    System.out.println(bc + ": " + result);
  }
  
  @ParameterizedTest
  @EnumSource(Operation.class)
  void testAllEnumOperations(Operation op) {
    BinaryCalculation bc = new BinaryCalculation(op, 20, 10);
    double result = calc.calculate(bc);
    System.out.println(bc + ": " + result);
  }

  @ParameterizedTest
  @EmptySource
  @NullSource
  @ValueSource(strings = {"foo", "bar", "   "})
  void testInvalidArguments(String op) {
    assertThrows(IllegalArgumentException.class,
        () -> calc.calculate(new BinaryCalculation(op, 10, 20)));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {"foo", "bar", "   "})
  void testInvalidArgumentsShorter(String op) {
    assertThrows(IllegalArgumentException.class,
        () -> calc.calculate(new BinaryCalculation(op, 10, 20)));
  }
  
  @ParameterizedTest
  @CsvFileSource(resources = "/testcalculations.csv", numLinesToSkip = 1)
  void testMultipleCalculationsFromCSV(
      String left, String op, String right, String answer) {
    BinaryCalculation bc = new BinaryCalculation(Operation.valueOf(op),
        Double.parseDouble(left), Double.parseDouble(right));
    double result = calc.calculate(bc);
    assertEquals(Double.parseDouble(answer), result);
  }
  
  @ParameterizedTest
  @CsvFileSource(resources = "/testcalculations.csv", numLinesToSkip = 1)
  @CsvSource({"1,ADD,1,2", "1,SUB,1,0"})
  void testMultipleCalculationsFromCSVFileAndInline(
      String left, String op, String right, String answer) {
    BinaryCalculation bc = new BinaryCalculation(Operation.valueOf(op),
        Double.parseDouble(left), Double.parseDouble(right));
    double result = calc.calculate(bc);
    assertEquals(Double.parseDouble(answer), result);
  }
  
  @ParameterizedTest
  @MethodSource("provideCalcWithAnswers")
  void testMultipleCalculations(CalcWithAnswer calcWithAnswer) {
    double result = calc.calculate(calcWithAnswer.getCalc());
    assertEquals(calcWithAnswer.getAnswer(), result);
  }
  
  private static Stream<CalcWithAnswer> provideCalcWithAnswers() {
    return Stream.of(
        new CalcWithAnswer(new BinaryCalculation(Operation.ADD, 5, 6), 11),
        new CalcWithAnswer(new BinaryCalculation(Operation.SUB, 19, 6), 13),
        new CalcWithAnswer(new BinaryCalculation(Operation.MUL, 5, 6), 30),
        new CalcWithAnswer(new BinaryCalculation(Operation.DIV, 10, 5), 2)
    );
  }
  
  @ParameterizedTest
  @MethodSource("provideCalcArguments")
  void testMultipleCalculationsArguments(BinaryCalculation bc, double answer) {
    double result = calc.calculate(bc);
    assertEquals(answer, result);
  }
  
  private static Stream<Arguments> provideCalcArguments() {
    return Stream.of(
        Arguments.of(new BinaryCalculation(Operation.ADD, 5, 6), 11),
        Arguments.of(new BinaryCalculation(Operation.SUB, 19, 6), 13),
        Arguments.of(new BinaryCalculation(Operation.MUL, 5, 6), 30),
        Arguments.of(new BinaryCalculation(Operation.DIV, 10, 5), 2)
    );
  }
  
  private static class CalcWithAnswer {
    private final BinaryCalculation calc;
    private final double answer;

    public CalcWithAnswer(BinaryCalculation calc, double answer) {
      this.calc = calc;
      this.answer = answer;
    }

    public BinaryCalculation getCalc() {
      return calc;
    }

    public double getAnswer() {
      return answer;
    }
    
    @Override
    public String toString() {
      return "" + calc.getLeft() + " " + calc.getOperation() + " " + calc.getRight() + " = " + answer;
    }
  }
}

package org.rekdev.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvaluateReversePolishNotationTest {

  EvaluateReversePolishNotation evalRPN;

  @BeforeEach
  public void setup() {
    evalRPN = new EvaluateReversePolishNotation();
  }

  @Test
  public void testExample1() {
    final String[] tokens = {"2", "1", "+", "3", "*"};
    final int actual = evalRPN.evalRPN(tokens);
    assertEquals(9, actual);
  }

  @Test
  public void testExample2() {
    final String[] tokens = {"4", "13", "5", "/", "+"};
    final int actual = evalRPN.evalRPN(tokens);
    assertEquals(6, actual);
  }

  @Test
  public void testExample3() {
    final String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    final int actual = evalRPN.evalRPN(tokens);
    assertEquals(22, actual);
  }

  @Test
  public void testSimpleSubtraction() {
    final String[] tokens = {"13", "9", "-"};
    final int actual = evalRPN.evalRPN(tokens);
    assertEquals(4, actual);
  }

  @Test
  public void testSimpleDivision() {
    final String[] tokens = {"13", "6", "/"};
    final int actual = evalRPN.evalRPN(tokens);
    assertEquals(2, actual);
  }

  @Test
  public void testUnexpectedToken() {
    final String[] tokens = {"13", "6", "%"};
    final Throwable thrown = assertThrows(
        IllegalArgumentException.class,
        () -> evalRPN.evalRPN(tokens));
    assertEquals("Unexpected token: \"%\"", thrown.getMessage());
  }

  @Test
  public void testPopFromEmptyStack() {
    final String[] tokens = {"+"};
    final Throwable thrown = assertThrows(
        NoSuchElementException.class,
        () -> evalRPN.evalRPN(tokens));
  }
}

package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 20. Valid Parentheses (Easy)
 * https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidParenthesisTest {
  ValidParenthesis validParenthesis;

  @BeforeEach
  public void setup() {
    validParenthesis = new ValidParenthesis();
  }

  @Test
  public void testExample1() {
    assertThat(validParenthesis.isValid("()")).isTrue();
  }

  @Test
  public void testExample2() {
    assertThat(validParenthesis.isValid("()[]{}")).isTrue();
  }

  @Test
  public void testExample3() {
    assertThat(validParenthesis.isValid("(]")).isFalse();
  }

  @Test
  public void testExample4() {
    assertThat(validParenthesis.isValid("([])")).isTrue();
  }

  @Test
  public void testExample5() {
    assertThat(validParenthesis.isValid("([)]")).isFalse();
  }

  @Test
  public void testOnlyOpen() {
    assertThat(validParenthesis.isValid("[")).isFalse();
  }
}

package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RomanToIntegerTest {

  RomanToInteger romanToInteger;

  @BeforeEach
  void setUp() {
    romanToInteger = new RomanToInteger();
  }

  @Test
  public void testExample1() {
    int actual = romanToInteger.romanToInt("III");
    assertThat(actual).isEqualTo(3);
  }

  @Test
  public void testExample2() {
    int actual = romanToInteger.romanToInt("LVIII");
    assertThat(actual).isEqualTo(58);
  }

  @Test
  public void testExample3() {
    int actual = romanToInteger.romanToInt("MCMXCIV");
    assertThat(actual).isEqualTo(1994);
  }
}

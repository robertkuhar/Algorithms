package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IntegerToRomanTest {
  IntegerToRoman integerToRoman;

  @BeforeEach
  void setUp() {
    integerToRoman = new IntegerToRoman();
  }

  @Test
  public void testExample1() {
    String actual = integerToRoman.intToRoman(3749);
    assertThat(actual).isEqualTo("MMMDCCXLIX");
  }

  @Test
  public void testExample2() {
    String actual = integerToRoman.intToRoman(58);
    assertThat(actual).isEqualTo("LVIII");
  }

  @Test
  public void testExample3() {
    String actual = integerToRoman.intToRoman(1994);
    assertThat(actual).isEqualTo("MCMXCIV");
  }
}

package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidPalindromeTest {
  ValidPalindrome validPalindrome;

  @BeforeEach
  void setUp() {
    validPalindrome = new ValidPalindrome();
  }

  @Test
  public void testExample1() {
    assertThat(validPalindrome.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
  }

  @Test
  public void testExample2() {
    assertThat(validPalindrome.isPalindrome("race a car")).isFalse();
  }

  @Test
  public void testExample3() {
    assertThat(validPalindrome.isPalindrome(" ")).isTrue();
  }
}

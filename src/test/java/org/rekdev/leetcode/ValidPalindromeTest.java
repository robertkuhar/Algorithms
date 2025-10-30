package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 125. Valid Palindrome (Easy)
 * https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 */
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

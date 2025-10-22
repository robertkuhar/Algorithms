package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestSubstringWithoutRepeatsTest {
  LongestSubstringWithoutRepeats longestSubstringWithoutRepeats;

  @BeforeEach
  void setUp() throws Exception {
    longestSubstringWithoutRepeats = new LongestSubstringWithoutRepeats();

  }

  @Test
  public void testExample1() {
    String s = "abcabcbb";
    int actual = longestSubstringWithoutRepeats.lengthOfLongestSubstring(s);
    assertThat(actual).isEqualTo(3);
  }

  @Test
  public void testExample2() {
    String s = "bbbbb";
    int actual = longestSubstringWithoutRepeats.lengthOfLongestSubstring(s);
    assertThat(actual).isEqualTo(1);
  }

  @Test
  public void testExample3() {
    String s = "pwwkew";
    int actual = longestSubstringWithoutRepeats.lengthOfLongestSubstring(s);
    assertThat(actual).isEqualTo(3);
  }

  @Test
  public void testaaabbbccc() {
    String s = "aaabbbccc";
    int actual = longestSubstringWithoutRepeats.lengthOfLongestSubstring(s);
    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void testQuickOutNullOrEmptyString() {
    assertThat(longestSubstringWithoutRepeats.lengthOfLongestSubstring(null))
        .isEqualTo(0);
    assertThat(longestSubstringWithoutRepeats.lengthOfLongestSubstring(""))
        .isEqualTo(0);
  }
}

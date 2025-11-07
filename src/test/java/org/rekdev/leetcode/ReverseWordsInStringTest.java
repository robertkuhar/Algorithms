package org.rekdev.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 151. Reverse Words in a String (Medium)
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWordsInStringTest {

  ReverseWordsInString reverseWordsInString;

  @BeforeEach
  public void setUp() throws Exception {
    reverseWordsInString = new ReverseWordsInString();
  }

  @Test
  public void testExample1() {
    final String expected = "blue is sky the";
    final String actual = reverseWordsInString.reverseWords("the sky is blue");
    assertEquals(expected, actual);
  }

  @Test
  public void testExample2() {
    final String expected = "world hello";
    final String actual = reverseWordsInString.reverseWords("  hello world  ");
    assertEquals(expected, actual);
  }

  @Test
  public void testExample3() {
    final String expected = "example good a";
    final String actual = reverseWordsInString.reverseWords("a good    example");
    assertEquals(expected, actual);
  }
}

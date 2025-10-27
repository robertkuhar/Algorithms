package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 17. Letter Combinations of a Phone Number (Medium)
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LetterCombinationsOfAPhoneNumberTest {

  LetterCombinationsOfAPhoneNumber letterCombinations;

  @BeforeEach
  public void setUp() throws Exception {
    letterCombinations = new LetterCombinationsOfAPhoneNumber();
  }

  @Test
  public void testExample1() {
    List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    List<String> actual = letterCombinations.letterCombinations("23");
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
  }

  @Test
  public void testExample2() {
    List<String> expected = List.of("a", "b", "c");
    List<String> actual = letterCombinations.letterCombinations("2");
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
  }
}

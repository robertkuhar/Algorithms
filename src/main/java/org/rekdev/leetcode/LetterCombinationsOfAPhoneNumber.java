package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

  /**
   * 17. Letter Combinations of a Phone Number (Medium)
   * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
   * that the number could represent. Return the answer in any order.
   * </p>
   * <p>
   * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that
   * 1 does not map to any letters.
   * </p>
   * <img src="https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png" alt="phone keyboard"/>
   * <p>
   * Example 1:<br/>
   * Input: digits = "23"<br/>
   * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: digits = "2"<br/>
   * Output: ["a","b","c"]<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= digits.length <= 4<br/>
   * - digits[i] is a digit in the range ['2', '9'].<br/>
   * </p>
   *
   * @param digits
   * @return
   */
  public List<String> letterCombinations(String digits) {
    final Map<Character, String> charsByDigit = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    final List<String> letterCombinations = new ArrayList<>();
    backtrack(digits, 0, new StringBuilder(), charsByDigit, letterCombinations);
    return letterCombinations;
  }

  private void backtrack(
      final String digits,
      final int ix,
      final StringBuilder stringBuilder,
      final Map<Character, String> charsByDigit,
      final List<String> letterCombinations) {

    if (ix == digits.length()) {
      letterCombinations.add(stringBuilder.toString());
      return;
    }
    final char digitChar = digits.charAt(ix);
    final String letters = charsByDigit.get(digitChar);
    for (int i = 0; i < letters.length(); i++) {
      final char letter = letters.charAt(i);
      // This is 'the move'
      stringBuilder.append(letter);
      backtrack(digits, ix + 1, stringBuilder, charsByDigit, letterCombinations);
      // This is the actual backtrack; undo 'the move'
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
  }
}

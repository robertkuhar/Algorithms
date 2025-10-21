package org.rekdev.leetcode;

import java.util.Map;

public class RomanToInteger {

  /**
   * 13. Roman to Integer
   * https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150
   *
   * <p>
   * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
   * <pre>
   * Symbol       Value
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   * </pre>
   * </p>
   * <p>
   * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written
   * as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
   * </p>
   * <p>
   * Roman numerals are usually written largest to smallest from left to right. However, the numeral
   * for four is not IIII. Instead, the number four is written as IV. Because the one is before the
   * five we subtract it making four. The same principle applies to the number nine, which is
   * written as IX. There are six instances where subtraction is used:<br/>
   * - I can be placed before V (5) and X (10) to make 4 and 9. <br/>
   * - X can be placed before L (50) and C (100) to make 40 and 90. <br/>
   * - C can be placed before D (500) and M (1000) to make 400 and 900. <br/>
   * - Given a roman numeral, convert it to an integer. <br/>
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: s = "III"<br/>
   * Output: 3<br/>
   * Explanation: III = 3.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: s = "LVIII"<br/>
   * Output: 58<br/>
   * Explanation: L = 50, V= 5, III = 3.<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: s = "MCMXCIV"<br/>
   * Output: 1994<br/>
   * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= s.length <= 15<br/>
   * - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').<br/>
   * - It is guaranteed that s is a valid roman numeral in the range [1, 3999].<br/>
   * </p>
   *
   * @param s Input Roman Number
   * @return decimal integer value of Roman Number
   */
  public int romanToInt(String s) {
    Map<Character, Integer> intByRomanNumeral = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
    int sum = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      int currVal = intByRomanNumeral.get(s.charAt(i));
      int nextVal = intByRomanNumeral.get(s.charAt(i + 1));
      if (currVal < nextVal) {
        sum -= currVal;
      } else {
        sum += currVal;
      }
    }
    sum += intByRomanNumeral.get(s.charAt(s.length() - 1));
    return sum;
  }
}

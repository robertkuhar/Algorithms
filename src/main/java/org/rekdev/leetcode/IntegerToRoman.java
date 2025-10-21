package org.rekdev.leetcode;

import java.util.List;

public class IntegerToRoman {

  /**
   * 12. Integer to Roman
   * https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Seven different symbols represent Roman numerals with the following values:<br/>
   * <pre>
   * Symbol	Value
   * I	1
   * V	5
   * X	10
   * L	50
   * C	100
   * D	500
   * M	1000
   * </pre>
   * </p>
   * <p>
   * Roman numerals are formed by appending the conversions of decimal place values from highest to
   * lowest. Converting a decimal place value into a Roman numeral has the following rules:<br/>
   * - If the value does not start with 4 or 9, select the symbol of the maximal value that can be
   * subtracted from the input, append that symbol to the result, subtract its value, and convert
   * the remainder to a Roman numeral.<br/>
   * - If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted
   * from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than
   * 10 (X): IX.
   * -- Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD)
   * and 900 (CM).<br/>
   * - Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent
   * multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to
   * append a symbol 4 times use the subtractive form.<br/>
   * </p>
   * <p>
   * Given an integer, convert it to a Roman numeral.
   * </p>
   * Example 1:<br/>
   * Input: num = 3749<br/>
   * Output: "MMMDCCXLIX"<br/>
   * Explanation:<br/>
   * <pre>
   * 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)<br/>
   *  700 = DCC as 500 (D) + 100 (C) + 100 (C)<br/>
   *   40 = XL as 10 (X) less of 50 (L)<br/>
   *    9 = IX as 1 (I) less of 10 (X)<br/>
   * </pre>
   * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: num = 58<br/>
   * Output: "LVIII"<br/>
   * Explanation:<br/>
   * <pre>
   * 50 = L
   *  8 = VIII
   * </pre>
   * <p>
   * Example 3:<br/>
   * Input: num = 1994<br/>
   * Output: "MCMXCIV"<br/>
   * Explanation:<br/>
   * <pre>
   * 1000 = M
   *  900 = CM
   *   90 = XC
   *    4 = IV
   * </pre>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= num <= 3999<br/>
   * </p>
   *
   * @param num Decimal Integer Number
   * @return Roman Numeral string for input num
   */
  public String intToRoman(int num) {
    final StringBuilder sb = new StringBuilder();
    record IntToRomanMapping(int val, String romanNumeral) {

    }
    final List<IntToRomanMapping> romanMappings = List.of(
        new IntToRomanMapping(1000, "M"),
        new IntToRomanMapping(900, "CM"),
        new IntToRomanMapping(500, "D"),
        new IntToRomanMapping(400, "CD"),
        new IntToRomanMapping(100, "C"),
        new IntToRomanMapping(90, "XC"),
        new IntToRomanMapping(50, "L"),
        new IntToRomanMapping(40, "XL"),
        new IntToRomanMapping(10, "X"),
        new IntToRomanMapping(9, "IX"),
        new IntToRomanMapping(5, "V"),
        new IntToRomanMapping(4, "IV"),
        new IntToRomanMapping(1, "I")
    );
    for (IntToRomanMapping mapping : romanMappings) {
      int val = mapping.val;
      String romanNumeral = mapping.romanNumeral;
      while (num >= val) {
        sb.append(romanNumeral);
        num -= val;
      }
    }
    return sb.toString();
  }
}

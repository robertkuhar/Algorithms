package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

  /**
   * 6. Zigzag Conversion (Medium)
   * <p>
   * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
   * (you may want to display this pattern in a fixed font for better legibility)
   * </p>
   * <pre>
   * P   A   H   N
   * A P L S I I G
   * Y   I   R
   * </pre>
   * <p>
   * And then read line by line: "PAHNAPLSIIGYIR"
   * </p>
   * <p>
   * Write the code that will take a string and make this conversion given a number of rows: String
   * convert(String s, int numRows);
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: s = "PAYPALISHIRING", numRows = 3<br/>
   * Output: "PAHNAPLSIIGYIR"<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: s = "PAYPALISHIRING", numRows = 4<br/>
   * Output: "PINALSIGYAHRPI"<br/>
   * Explanation:<br/>
   * <pre>
   * P     I    N
   * A   L S  I G
   * Y A   H R
   * P     I
   * </pre>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: s = "A", numRows = 1<br/>
   * Output: "A"<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= s.length <= 1000<br/>
   * - s consists of English letters (lower-case and upper-case), ',' and '.'.<br/>
   * - 1 <= numRows <= 1000<br/>
   * </p>
   *
   * @param s
   * @param numRows
   * @return
   */
  public String convert(String s, int numRows) {
    if (numRows == 1 || numRows >= s.length()) {
      return s;
    }
    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuilder());
    }
    int curRow = 0;
    int direction = -1;
    for (char c : s.toCharArray()) {
      rows.get(curRow).append(c);
      if (curRow == 0 || curRow == numRows - 1) {
        direction *= -1;
      }
      curRow += direction;
    }
    StringBuilder sb = new StringBuilder();
    for (StringBuilder row : rows) {
      sb.append(row);
    }
    return sb.toString();
  }
}

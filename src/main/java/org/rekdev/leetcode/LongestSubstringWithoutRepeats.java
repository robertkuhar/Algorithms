package org.rekdev.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeats {

  /**
   * 3. Longest Substring Without Repeating Characters
   * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given a string s, find the length of the longest substring without duplicate characters.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: s = "abcabcbb"<br/>
   * Output: 3<br/>
   * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also
   * correct answers.
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: s = "bbbbb"<br/>
   * Output: 1<br/>
   * Explanation: The answer is "b", with the length of 1.
   * </p>
   * Example 3:<br/>
   * Input: s = "pwwkew"<br/>
   * Output: 3<br/>
   * Explanation: The answer is "wke", with the length of 3.<br/>
   * - Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
   * </p>
   * <p>
   * Constraints:<br/>
   * - 0 <= s.length <= 5 * 10^4<br/>
   * - s consists of English letters, digits, symbols and spaces.<br/>
   * </p>
   *
   * Insight: It is a sliding window and relies upon the Set to keep track of "this substring is all
   * unique characters".
   *
   * @param s input string
   * @return max length of substring with unique characters
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    Set<Character> uniqChars = new HashSet<>();
    int leftIx = 0;
    int rightIx = 0;
    int maxLen = 0;
    while (rightIx < s.length()) {
      char c = s.charAt(rightIx);
      while (uniqChars.contains(c)) {
        uniqChars.remove(s.charAt(leftIx));
        leftIx++;
      }
      uniqChars.add(c);
      maxLen = Math.max(maxLen, rightIx - leftIx + 1);
      rightIx++;
    }
    return maxLen;
  }
}

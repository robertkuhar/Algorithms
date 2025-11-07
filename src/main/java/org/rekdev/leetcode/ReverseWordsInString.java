package org.rekdev.leetcode;

public class ReverseWordsInString {

  /**
   * 151. Reverse Words in a String (Medium)
   * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an input string s, reverse the order of the words.
   * </p>
   * <p>
   * A word is defined as a sequence of non-space characters. The words in s will be separated by at
   * least one space.
   * </p>
   * <p>
   * Return a string of the words in reverse order concatenated by a single space.
   * </p>
   * <p>
   * Note that s may contain leading or trailing spaces or multiple spaces between two words. The
   * returned string should only have a single space separating the words. Do not include any extra spaces.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: s = "the sky is blue"<br/>
   * Output: "blue is sky the"<br/>
   * </p>
   * Example 2:<br/>
   * Input: s = "  hello world  "<br/>
   * Output: "world hello"<br/>
   * Explanation: Your reversed string should not contain leading or trailing spaces.<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: s = "a good   example"<br/>
   * Output: "example good a"<br/>
   * Explanation: You need to reduce multiple spaces between two words to a single space in the
   * reversed string.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= s.length <= 10^4
   * - s contains English letters (upper-case and lower-case), digits, and spaces ' '.<br/>
   * - There is at least one word in s.<br/>
   * </p>
   * <p>
   * Follow-up: If the string data type is mutable in your language, can you solve it in-place with
   * O(1) extra space?
   * </p>
   *
   * @param s input string to be reversed
   * @return words from s in reverse order
   */
  public String reverseWords(String s) {
    final String[] words = s.trim().split("\\s+");
    final StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      sb.append(words[i]).append(" ");
    }
    return sb.toString().trim();
  }
}

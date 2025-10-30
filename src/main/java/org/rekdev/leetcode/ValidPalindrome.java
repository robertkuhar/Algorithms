package org.rekdev.leetcode;

public class ValidPalindrome {

  /**
   * 125. Valid Palindrome (Easy)
   * https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
   * removing all non-alphanumeric characters, it reads the same forward and backward.
   * Alphanumeric characters include letters and numbers.
   * </p>
   * <p>
   * Given a string s, return true if it is a palindrome, or false otherwise.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: s = "A man, a plan, a canal: Panama"<br/>
   * Output: true<br/>
   * Explanation: "amanaplanacanalpanama" is a palindrome.<br/>
   * <p>
   * Example 2:<br/>
   * Input: s = "race a car"<br/>
   * Output: false<br/>
   * Explanation: "raceacar" is not a palindrome.<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: s = " "<br/>
   * Output: true<br/>
   * Explanation: s is an empty string "" after removing non-alphanumeric characters. Since an
   * empty string reads the same forward and backward, it is a palindrome.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= s.length <= 2 * 10^5<br/>
   * - s consists only of printable ASCII characters.<br/>
   * </p>
   *
   *
   * @param s input string
   * @return true if s is a palindrome; otherwise false
   */
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (!Character.isLetterOrDigit(s.charAt(left))) {
        left++;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(right))) {
        right--;
        continue;
      }
      char leftChar = s.charAt(left);
      char rightChar = s.charAt(right);
      if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}

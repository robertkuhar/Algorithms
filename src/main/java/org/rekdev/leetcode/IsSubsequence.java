package org.rekdev.leetcode;

public class IsSubsequence {

  /**
   * 392. Is Subsequence (Easy)
   * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
   * </p>
   * <p>
   * A subsequence of a string is a new string that is formed from the original string by deleting
   * some (can be none) of the characters without disturbing the relative positions of the remaining
   * characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
   * </p>
   * Example 1:<br/>
   * Input: s = "abc", t = "ahbgdc"<br/>
   * Output: true<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: s = "axc", t = "ahbgdc"<br/>
   * Output: false<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 0 <= s.length <= 100<br/>
   * - 0 <= t.length <= 10^4<br/>
   * - s and t consist only of lowercase English letters.<br/>
   * </p>
   * <p>
   * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9, and you
   * want to check one by one to see if t has its subsequence. In this scenario, how would you
   * change your code?
   * </p>
   *
   * Insight: For the follow-up, you make IsSubsequence "stateful" to capture the input string t.
   * On construction you build a Map<Character, List<Integer>> to capture all occurrences of each
   * char in t. When processing any individual s, you look up the sChar in the tMap. And then it is
   * a binary search for the smallest index that matches the target. The binary search is the
   * operative part. ClaudeAI wrote this
   * <pre>
   * class SubsequenceChecker {
   *     // Map: character → list of indices where it appears in t
   *     private Map<Character, List<Integer>> charIndices;
   *
   *     public SubsequenceChecker(String t) {
   *         // Pre-process t ONCE
   *         charIndices = new HashMap<>();
   *         for (int i = 0; i < t.length(); i++) {
   *             char c = t.charAt(i);
   *             charIndices.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
   *         }
   *     }
   *
   *     public boolean isSubsequence(String s) {
   *         int currentIndex = -1;  // Track position in t
   *
   *         for (char c : s.toCharArray()) {
   *             List<Integer> indices = charIndices.get(c);
   *
   *             // Character doesn't exist in t
   *             if (indices == null) {
   *                 return false;
   *             }
   *
   *             // Binary search for next occurrence after currentIndex
   *             int pos = binarySearch(indices, currentIndex);
   *             if (pos == -1) {
   *                 return false;  // No valid occurrence found
   *             }
   *
   *             currentIndex = pos;
   *         }
   *
   *         return true;
   *     }
   *
   *     // Find smallest index in list that's > target
   *     private int binarySearch(List<Integer> list, int target) {
   *         int left = 0, right = list.size() - 1;
   *         int result = -1;
   *
   *         while (left <= right) {
   *             int mid = left + (right - left) / 2;
   *             if (list.get(mid) > target) {
   *                 result = list.get(mid);
   *                 right = mid - 1;
   *             } else {
   *                 left = mid + 1;
   *             }
   *         }
   *
   *         return result;
   *     }
   * }
   * </pre>
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubsequence(String s, String t) {
    int sLen = s.length();
    if (sLen == 0) {
      return true;
    }
    int sIndex = 0;
    for (char tChar : t.toCharArray()) {
      char sChar = s.charAt(sIndex);
      if (sChar == tChar) {
        sIndex++;
        if(sIndex == sLen) {
          return true;
        }
      }
    }
    return false;
  }
}

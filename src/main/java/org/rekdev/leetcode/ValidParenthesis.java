package org.rekdev.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

  /**
   * 20. Valid Parentheses (Easy)
   * https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if
   * the input string is valid.
   * </p>
   * <p>
   * An input string is valid if:<br/>
   * - Open brackets must be closed by the same type of brackets.<br/>
   * - Open brackets must be closed in the correct order.<br/>
   * - Every close bracket has a corresponding open bracket of the same type.<br/>
   * <p>
   * Example 1:<br/>
   * Input: s = "()"<br/>
   * Output: true<br/>
   * </p>
   * Example 2:<br/>
   * Input: s = "()[]{}"<br/>
   * Output: true<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: s = "(]"<br/>
   * Output: false<br/>
   * </p>
   * <p>
   * Example 4:<br/>
   * Input: s = "([])"<br/>
   * Output: true<br/>
   * </p>
   * <p>
   * Example 5:<br/>
   * Input: s = "([)]"<br/>
   * Output: false<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * 1 <= s.length <= 10^4<br/>
   * s consists of parentheses only '()[]{}'.<br/>
   * </p>
   *
   * Insight: Gemini suggests HashMap rather than my slightly faster if gauntlet. I'm not buying the
   * 'more concise' argument, but if folks expect to see that, far be it from me to fight over the
   * little perf diff.
   *
   * @param s
   * @return
   */
  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (!stack.isEmpty()) {
          char c1 = stack.pop();
          if (c1 == '(' && c != ')') {
            return false;
          }
          if (c1 == '[' && c != ']') {
            return false;
          }
          if (c1 == '{' && c != '}') {
            return false;
          }
        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

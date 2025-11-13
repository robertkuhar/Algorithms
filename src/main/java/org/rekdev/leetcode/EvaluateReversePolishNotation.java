package org.rekdev.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {

  /**
   * 150. Evaluate Reverse Polish Notation (Medium)
   * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * You are given an array of strings tokens that represents an arithmetic expression in a Reverse 
   * Polish Notation (aka. Postfix).
   * </p>
   * <p>
   * Evaluate the expression. Return an integer that represents the value of the expression.
   * </p>
   * <p>
   * Note that:<br/>
   * - The valid operators are '+', '-', '*', and '/'.<br/>
   * - Each operand may be an integer or another expression.<br/>
   * - The division between two integers always truncates toward zero.<br/>
   * - There will not be any division by zero.<br/>
   * - The input represents a valid arithmetic expression in a reverse polish notation.<br/>
   * The answer and all the intermediate calculations can be represented in a 32-bit integer.<br/>
   * </p>
   * Example 1:<br/>
   * Input: tokens = [ "2", "1", "+", "3", "*" ]<br/>
   * Output: 9<br/>
   * Explanation: ((2 + 1) * 3) = 9<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: tokens = [ "4", "13", "5", "/", "+"]<br/>
   * Output: 6<br/>
   * Explanation: (4 + (13 / 5)) = 6<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: tokens = [ "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" ]<br/>
   * Output: 22<br/>
   * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5<br/>
   * = ((10 * (6 / (12 * -11))) + 17) + 5<br/>
   * = ((10 * (6 / -132)) + 17) + 5<br/>
   * = ((10 * 0) + 17) + 5<br/>
   * = (0 + 17) + 5<br/>
   * = 17 + 5<br/>
   * = 22<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= tokens.length <= 10^4
   * - tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].<br/>
   * </p>
   *
   * @param tokens
   * @return
   */
  public int evalRPN(String[] tokens) {
    final Deque<Integer> stack = new LinkedList<>();
    for (String token : tokens) {
      switch (token) {
        case "+": {
          final int y = stack.pop();
          final int x = stack.pop();
          stack.push(x + y);
          break;
        }
        case "-": {
          final int y = stack.pop();
          final int x = stack.pop();
          stack.push(x - y);
          break;
        }
        case "*": {
          final int y = stack.pop();
          final int x = stack.pop();
          stack.push(x * y);
          break;
        }
        case "/": {
          final int y = stack.pop();
          final int x = stack.pop();
          stack.push(x / y);
          break;
        }
        default:
          try {
            stack.push(Integer.parseInt(token));
          } catch (NumberFormatException e) {
            String errorMessage = String.format("Unexpected token: \"%s\"", token);
            throw new IllegalArgumentException(errorMessage, e);
          }
          break;
      }
    }
    return stack.pop();
  }
}

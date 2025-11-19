package org.rekdev.leetcode;

import org.rekdev.leetcode.LinkedListCycle.ListNode;

public class AddTwoNumbers {

  /**
   * 2. Add Two Numbers (Medium)
   * https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * You are given two non-empty linked lists representing two non-negative integers. The digits
   * are stored in reverse order, and each of their nodes contains a single digit.
   * Add the two numbers and return the sum as a linked list.
   * </p>
   * <p>
   * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   * </p>
   * Example 1:<br/>
   * Input: l1 = [2, 4, 3], l2 = [5, 6, 4]<br/>
   * Output: [7, 0, 8]<br/>
   * Explanation: 342 + 465 = 807.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: l1 = [0], l2 = [0]<br/>
   * Output: [0]<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: l1 = [9, 9, 9, 9, 9, 9, 9], l2 = [9, 9, 9, 9]<br/>
   * Output: [8, 9, 9, 9, 0, 0, 0, 1]<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - The number of nodes in each linked list is in the range [1, 100].<br/>
   * - 0 <= Node.val <= 9<br/>
   * - It is guaranteed that the list represents a number that does not have leading zeros.<br/>
   * </p>
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l1Current = l1;
    ListNode l2Current = l2;
    ListNode dummyHead = new ListNode(0);
    ListNode outputNode = dummyHead;
    int carry = 0;
    while (l1Current != null || l2Current != null || carry != 0) {
      int l1Digit = l1Current == null ? 0 : l1Current.val;
      int l2Digit = l2Current == null ? 0 : l2Current.val;
      int sum = l1Digit + l2Digit + carry;
      carry = sum / 10;
      int digit = sum % 10;
      outputNode.next = new ListNode(digit);
      outputNode = outputNode.next;
      if (l1Current != null) {
        l1Current = l1Current.next;
      }
      if (l2Current != null) {
        l2Current = l2Current.next;
      }
    }
    return dummyHead.next;
  }
}

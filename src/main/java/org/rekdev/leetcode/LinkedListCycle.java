package org.rekdev.leetcode;

public class LinkedListCycle {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    ListNode(int val) {
      this(val, null);
    }
  }

  /**
   * 141. Linked List Cycle
   * https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given head, the head of a linked list, determine if the linked list has a cycle in it.
   * </p>
   * <p>
   * There is a cycle in a linked list if there is some node in the list that can be reached
   * again by continuously following the next pointer. Internally, pos is used to denote the index
   * of the node that tail's next pointer is connected to. Note that pos is not passed as a
   * parameter.
   * </p>
   * <p>
   * Return true if there is a cycle in the linked list. Otherwise, return false.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: head = [3,2,0,-4], pos = 1<br/>
   * Output: true<br/>
   * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node
   * (0-indexed).
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: head = [1,2], pos = 0<br/>
   * Output: true<br/>
   * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: head = [1], pos = -1<br/>
   * Output: false<br/>
   * Explanation: There is no cycle in the linked list.
   * </p>
   * <p>
   * Constraints:<br/>
   * - The number of the nodes in the list is in the range [0, 10^4]<br/>
   * - -10^5 <= Node.val <= 10^5<br/>
   * - pos is -1 or a valid index in the linked-list.<br/>
   * </p>
   *
   * @param head head of the linked list
   * @return true if there is a cycle in the linked list; otherwise false.
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  /*
   * Commentary: The simplest implementation is to maintain some Set<ListNode> visited during the
   * traversal and return true if you find any ListNode in that Set. Gemini doesn't like this
   * because it is not space efficient. The classical solution is to move 2 pointers, a fast pointer
   * and a slow pointer. The slow pointer advances one node at a time, the fast pointer at two. If
   * they are ever equal before the fast pointer goes off the end, a cycle exists. I knew this from
   * years ago, but couldn't remember the details nor the name. Its called "Floyd's Cycle Finding".
   * Complexity wise it is O(N) time and O(1) space
   */
}

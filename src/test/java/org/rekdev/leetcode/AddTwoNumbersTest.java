package org.rekdev.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rekdev.leetcode.LinkedListCycle.ListNode;

/**
 * 2. Add Two Numbers (Medium)
 * https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class AddTwoNumbersTest {

  AddTwoNumbers addTwoNumbers;

  @BeforeEach
  public void setup() {
    addTwoNumbers = new AddTwoNumbers();
  }

  @Test
  public void testExample1() {
    final LinkedListCycle.ListNode l1n3 = new LinkedListCycle.ListNode(3);
    final LinkedListCycle.ListNode l1n2 = new LinkedListCycle.ListNode(4, l1n3);
    final LinkedListCycle.ListNode l1n1 = new LinkedListCycle.ListNode(2, l1n2);

    final LinkedListCycle.ListNode l2n3 = new LinkedListCycle.ListNode(4);
    final LinkedListCycle.ListNode l2n2 = new LinkedListCycle.ListNode(6, l2n3);
    final LinkedListCycle.ListNode l2n1 = new LinkedListCycle.ListNode(5, l2n2);

    final LinkedListCycle.ListNode expectedn3 = new LinkedListCycle.ListNode(8);
    final LinkedListCycle.ListNode expectedn2 = new LinkedListCycle.ListNode(0, expectedn3);
    final LinkedListCycle.ListNode expectedn1 = new LinkedListCycle.ListNode(7, expectedn2);

    LinkedListCycle.ListNode actual = addTwoNumbers.addTwoNumbers(l1n1, l2n1);

    ListNode expected = expectedn1;
    while (actual != null && expected != null) {
      assertEquals(expected.val, actual.val);
      expected = expected.next;
      actual = actual.next;
    }
    assertNull(actual);
    assertNull(expected);
  }

  @Test
  public void testExample2() {
    LinkedListCycle.ListNode expected = new LinkedListCycle.ListNode(0);
    LinkedListCycle.ListNode actual = addTwoNumbers.addTwoNumbers(
        new LinkedListCycle.ListNode(0),
        new LinkedListCycle.ListNode(0));
    assertEquals(expected.val, actual.val);
    assertNull(actual.next);
    assertNull(expected.next);
  }

  @Test
  public void testExample3() {
    final LinkedListCycle.ListNode l1n7 = new LinkedListCycle.ListNode(9);
    final LinkedListCycle.ListNode l1n6 = new LinkedListCycle.ListNode(9, l1n7);
    final LinkedListCycle.ListNode l1n5 = new LinkedListCycle.ListNode(9, l1n6);
    final LinkedListCycle.ListNode l1n4 = new LinkedListCycle.ListNode(9, l1n5);
    final LinkedListCycle.ListNode l1n3 = new LinkedListCycle.ListNode(9, l1n4);
    final LinkedListCycle.ListNode l1n2 = new LinkedListCycle.ListNode(9, l1n3);
    final LinkedListCycle.ListNode l1n1 = new LinkedListCycle.ListNode(9, l1n2);

    final LinkedListCycle.ListNode l2n4 = new LinkedListCycle.ListNode(9);
    final LinkedListCycle.ListNode l2n3 = new LinkedListCycle.ListNode(9, l2n4);
    final LinkedListCycle.ListNode l2n2 = new LinkedListCycle.ListNode(9, l2n3);
    final LinkedListCycle.ListNode l2n1 = new LinkedListCycle.ListNode(9, l2n2);

    final LinkedListCycle.ListNode expectedn8 = new LinkedListCycle.ListNode(1);
    final LinkedListCycle.ListNode expectedn7 = new LinkedListCycle.ListNode(0, expectedn8);
    final LinkedListCycle.ListNode expectedn6 = new LinkedListCycle.ListNode(0, expectedn7);
    final LinkedListCycle.ListNode expectedn5 = new LinkedListCycle.ListNode(0, expectedn6);
    final LinkedListCycle.ListNode expectedn4 = new LinkedListCycle.ListNode(9, expectedn5);
    final LinkedListCycle.ListNode expectedn3 = new LinkedListCycle.ListNode(9, expectedn4);
    final LinkedListCycle.ListNode expectedn2 = new LinkedListCycle.ListNode(9, expectedn3);
    final LinkedListCycle.ListNode expectedn1 = new LinkedListCycle.ListNode(8, expectedn2);

    LinkedListCycle.ListNode actual = addTwoNumbers.addTwoNumbers(l1n1, l2n1);
    ListNode expected = expectedn1;
    while (actual != null && expected != null) {
      assertEquals(expected.val, actual.val);
      expected = expected.next;
      actual = actual.next;
    }
    assertNull(actual);
    assertNull(expected);
  }
}

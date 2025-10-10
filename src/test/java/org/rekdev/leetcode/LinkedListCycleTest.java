package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListCycleTest {

  LinkedListCycle linkedListCycle;

  @BeforeEach
  public void setup() {
    linkedListCycle = new LinkedListCycle();
  }

  @Test
  public void testExample1() {
    final LinkedListCycle.ListNode node0 = new LinkedListCycle.ListNode(3);
    final LinkedListCycle.ListNode node1 = new LinkedListCycle.ListNode(2);
    final LinkedListCycle.ListNode node2 = new LinkedListCycle.ListNode(0);
    final LinkedListCycle.ListNode node3 = new LinkedListCycle.ListNode(-4);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node1;

    final boolean actual = linkedListCycle.hasCycle(node0);
    assertThat(actual).isTrue();
  }

  @Test
  public void testExample2() {
    final LinkedListCycle.ListNode node0 = new LinkedListCycle.ListNode(1);
    final LinkedListCycle.ListNode node1 = new LinkedListCycle.ListNode(2);
    node0.next = node1;
    node1.next = node0;

    final boolean actual = linkedListCycle.hasCycle(node0);
    assertThat(actual).isTrue();
  }

  @Test
  public void testExample3() {
    final LinkedListCycle.ListNode node0 = new LinkedListCycle.ListNode(1);
    final boolean actual = linkedListCycle.hasCycle(node0);
    assertThat(actual).isFalse();
  }

  @Test
  public void testQuickoutOnNull() {
    final boolean actual = linkedListCycle.hasCycle(null);
    assertThat(actual).isFalse();
  }

  @Test
  public void testFullTraversal() {
    final LinkedListCycle.ListNode node0 = new LinkedListCycle.ListNode(1);
    final LinkedListCycle.ListNode node1 = new LinkedListCycle.ListNode(2);
    final LinkedListCycle.ListNode node2 = new LinkedListCycle.ListNode(3);
    node0.next = node1;
    node1.next = node2;

    final boolean actual = linkedListCycle.hasCycle(node0);
    assertThat(actual).isFalse();
  }
}

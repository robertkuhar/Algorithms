package org.rekdev.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.rekdev.Queue;

public class QueueTests {

  @Test
  public void testOneInOneOut() {
    Queue<String> queue = new Queue<>();
    String s0 = "S0";

    assertTrue(queue.isEmpty());
    queue.enqueue(s0);
    assertFalse(queue.isEmpty());
    assertEquals(s0, queue.dequeue());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void testTwoInTwoOut() {
    Queue<String> queue = new Queue<>();
    String s0 = "S0";
    String s1 = "S1";

    assertTrue(queue.isEmpty());
    queue.enqueue(s0);
    queue.enqueue(s1);
    assertFalse(queue.isEmpty());
    String expect = s0;
    String actual = queue.dequeue();
    assertEquals(expect, actual);
    assertFalse(queue.isEmpty());
    expect = s1;
    actual = queue.dequeue();
    assertEquals(expect, actual);
    assertTrue(queue.isEmpty());
  }

  @Test
  public void testTwoInOneOutOneInTwoOut() {
    Queue<String> queue = new Queue<>();

    String s0 = "S0";
    String s1 = "S1";
    String s2 = "S2";

    assertTrue(queue.isEmpty());
    // Two in...
    queue.enqueue(s0);
    queue.enqueue(s1);

    // One out...
    String expect = s0;
    String actual = queue.dequeue();
    assertEquals(expect, actual);

    // One in...
    queue.enqueue(s2);

    // Two out...
    expect = s1;
    actual = queue.dequeue();
    assertEquals(expect, actual);

    expect = s2;
    actual = queue.dequeue();
    assertEquals(expect, actual);
    assertTrue(queue.isEmpty());
  }
}

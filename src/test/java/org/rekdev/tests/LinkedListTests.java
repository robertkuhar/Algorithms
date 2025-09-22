package org.rekdev.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.rekdev.lists.ListElement;

public class LinkedListTests {

  @Test
  public void testHasCycleNoCycle() {
    ListElement<String> root = new ListElement<>("A");
    root.setNext(new ListElement<>("B"));
    assertFalse(root.hasCycle(), "has no cycle");
  }

  @Test
  public void testHasCycleCycle() {
    ListElement<String> a = new ListElement<>("A");
    ListElement<String> b = new ListElement<>("B");
    ListElement<String> c = new ListElement<>("C");
    a.setNext(b);
    b.setNext(c);
    c.setNext(a);
    assertTrue(a.hasCycle(), "expected a has cycle");
    assertTrue(b.hasCycle(), "expected b.hasCycle()");
    assertTrue(c.hasCycle(), "expected c.hasCycle()");

    ListElement<String> d = new ListElement<>("D");
    c.setNext(d);
    assertFalse(a.hasCycle(), "expected !a.hasCycle()");
    d.setNext(b);
    assertTrue(a.hasCycle(), "expected a.hasCycle()");
    d.setNext(null);
    assertFalse(a.hasCycle(), "expected !a.hasCycle()");
  }

}

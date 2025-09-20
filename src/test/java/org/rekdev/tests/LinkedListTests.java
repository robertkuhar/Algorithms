package org.rekdev.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.rekdev.lists.ListElement;
import org.rekdev.lists.SinglyLinkedList;

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

  @Test
  public void testSinglyLinkedList() {
    SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();

    assertNull(linkedList.getFirst());
    assertNull(linkedList.getLast());

    String[] abc = {"A", "B", "C", "D"};
    for (String s : abc) {
      linkedList.add(s);
    }

    assertEquals(abc[0], linkedList.getFirst());
    assertEquals(abc[3], linkedList.getLast());
    for (int i = 0; i < abc.length; i++) {
      assertEquals(abc[i], linkedList.getAt(i));
    }
    int i = 0;
    for (Iterator<String> it = linkedList.iterator(); it.hasNext(); ) {
      assertEquals(abc[i], it.next());
      if (i % 2 == 0) {
        it.remove();
      }
      i++;
    }
    assertEquals(abc[1], linkedList.getFirst());
    assertEquals(abc[1], linkedList.getAt(0));
    assertEquals(abc[3], linkedList.getLast());
    assertEquals(abc[3], linkedList.getAt(1));

    linkedList.addFirst("A");
    assertEquals("A", linkedList.getFirst());
    assertEquals("B", linkedList.getAt(1));
    linkedList.insertAt(linkedList.findIndexOf("D"), "C");
    assertEquals("C", linkedList.getAt(2));
    assertEquals("D", linkedList.getAt(3));
    assertEquals("D", linkedList.getLast());
    linkedList.addLast("E");
    assertEquals("E", linkedList.getLast());

    String[] expected = {"A", "B", "C", "D", "E"};
    i = 0;
    for (String s : linkedList) {
      assertEquals(expected[i++], s);
    }
  }
}

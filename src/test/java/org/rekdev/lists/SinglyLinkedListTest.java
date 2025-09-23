package org.rekdev.lists;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

  private SinglyLinkedList<String> list;

  // This method runs before each test to ensure a clean state
  @BeforeEach
  void setUp() {
    list = new SinglyLinkedList<>();
  }

  @Test
  public void happyPathTest() {
    // an empty list has first and last null
    assertNull(list.getFirst());
    assertNull(list.getLast());

    list.add("one");
    assertEquals("one", list.getFirst());
    assertEquals("one", list.getLast());
    assertEquals("one", list.getAt(0));

    list.add("two");
    assertEquals("one", list.getFirst());
    assertEquals("two", list.getLast());
    assertEquals("one", list.getAt(0));
    assertEquals("two", list.getAt(1));

    list.addFirst("zero");
    assertEquals("zero", list.getFirst());
    assertEquals("two", list.getLast());
    assertEquals("zero", list.getAt(0));
    assertEquals("one", list.getAt(1));
    assertEquals("two", list.getAt(2));

    list.addLast("three");
    assertEquals("zero", list.getFirst());
    assertEquals("three", list.getLast());
    assertEquals("zero", list.getAt(0));
    assertEquals("one", list.getAt(1));
    assertEquals("two", list.getAt(2));
    assertEquals("three", list.getAt(3));

    assertTrue(list.remove("three"));
    assertEquals("zero", list.getFirst());
    assertEquals("two", list.getLast());
    assertFalse(list.remove("three"));

    final String removed = list.removeAt(0);
    assertEquals("zero", removed);
    assertEquals("one", list.getFirst());
    assertEquals("two", list.getLast());

    assertNull(list.find("zero"));
    assertEquals("one", list.find("one"));
    assertEquals("two", list.find("two"));
    assertNull(list.find("three"));
  }

  @Test
  public void emptyListTest() {
    assertNull(list.getFirst());
    assertNull(list.getLast());
    assertFalse(list.iterator().hasNext());
  }

  @Test
  public void getAt_indexOutOfBoundsThrows() {
    assertFalse(list.iterator().hasNext());
    final Exception thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
      list.getAt(0);
    });
    assertEquals("ix 0 is out of bounds", thrown.getMessage());
  }

  @Test
  public void getAt_illegalArgumentThrows() {
    final Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
      list.getAt(-1);
    });
    assertEquals("ix must be positive", thrown.getMessage());
  }

  @Test
  public void insertAt_IllegalArgumentThrows() {
    assertThatThrownBy(() -> list.insertAt(-1, "negative one"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("ix must be positive");
  }

  @Test
  public void insertAt_IndexOutOfBoundsThrows() {
    assertThatThrownBy(() -> list.insertAt(1, "one"))
        .isInstanceOf(IndexOutOfBoundsException.class);
  }

  @Test
  public void insertAtZeroIsLegig() {
    list.addFirst("one");
    list.insertAt(0, "zero");
    assertEquals("zero", list.getFirst());
    assertEquals("one", list.getLast());
  }

  @Test
  public void iteratorTest() {
    assertFalse(list.iterator().hasNext());

    final List<String> expected = List.of("one", "two", "three");
    expected.forEach(s -> list.add(s));

    final List<String> actual = new ArrayList<>();
    final Iterator<String> it1 = list.iterator();
    while (it1.hasNext()) {
      final String element = it1.next();
      actual.add(element);
    }
    assertEquals(expected, actual);
    assertFalse(it1.hasNext());

    final Iterator<String> it2 = list.iterator();
    while (it2.hasNext()) {
      it2.next();
      it2.remove();
    }
    assertNull(list.getFirst());
    assertNull(list.getLast());
    assertThrows(IllegalStateException.class, it2::remove);
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

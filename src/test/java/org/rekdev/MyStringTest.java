package org.rekdev;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MyStringTest {

  @Test
  public void testConstructorThrows() {
    final Exception e =
        assertThrows(IllegalArgumentException.class, () -> {
          new MyString(null);
        });
    assertEquals("chars cannot be null!", e.getMessage());
  }

  @Test
  public void testCharAt() {
    char[] c = new char[]{'0', '1', '2'};
    MyString ms = new MyString(c);
    assertEquals('0', ms.charAt(0));
    assertEquals('1', ms.charAt(1));
    assertEquals('2', ms.charAt(2));
    c[0] = 'a';
    c[1] = 'b';
    c[2] = 'c';
    assertEquals('0', ms.charAt(0));
    assertEquals('1', ms.charAt(1));
    assertEquals('2', ms.charAt(2));
  }

  @Test
  public void testEqualsContract() {
    MyString aaa0 = new MyString(new char[]{'a', 'a', 'a'});
    MyString aaa1 = new MyString(new char[]{'a', 'a', 'a'});
    assertEquals(aaa0, aaa1);
    int aaa0Hash = aaa0.hashCode();
    int aaa1Hash = aaa1.hashCode();
    assertEquals(aaa0Hash, aaa1Hash);

    assertEquals(aaa0, aaa1);
    MyString aab0 = new MyString(new char[]{'a', 'a', 'b'});
    assertNotEquals(aaa0, aab0);
    assertNotEquals(aaa0.hashCode(), aab0.hashCode());

    assertNotEquals(new MyString(new char[]{'a', 'a'}), aaa1);

    assertFalse(aaa1.equals(new Object()));
  }

  static class IndexOfTest {

    final char[] target;
    final int expectIx;

    IndexOfTest(char[] target, int expectedIx) {
      this.target = target;
      this.expectIx = expectedIx;
    }
  }

  @Test
  public void testIndexOf() {
    char[] c = new char[]{'a', 'a', 'b', 'a', 'a', 'c', 'a', 'b'};
    MyString ms = new MyString(c);

    IndexOfTest[] tests = {
        new IndexOfTest(new char[]{'z'}, -1),
        new IndexOfTest(new char[]{'a', 'a'}, 0),
        new IndexOfTest(new char[]{'a', 'b', 'a'}, 1),
        new IndexOfTest(new char[]{'a', 'a', 'c'}, 3),
        new IndexOfTest(new char[]{'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z'}, -1)
    };
    for (IndexOfTest test : tests) {
      int indexOf = ms.indexOf(test.target);
      assertEquals(test.expectIx, indexOf);
    }
  }

  @Test
  public void testIndexOfThrows() {
    final MyString ms = new MyString(new char[]{'a', 'b', 'c'});
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> ms.indexOf(null))
        .withMessage("target cannot be null or empty");

    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> ms.indexOf(new char[0]))
        .withMessage("target cannot be null or empty");
  }

}

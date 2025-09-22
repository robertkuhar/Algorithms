package org.rekdev.tests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseAnArrayTest {

  void reverseArrayInPlace(Object[] array) {
    if (array == null) {
      throw new IllegalArgumentException("array cannot be null!");
    }
    int i = 0;
    int j = array.length - 1;
    while (j > i) {
      Object tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
      i++;
      j--;
    }
  }


  @Test
  public void testReverseInPlace() {
    runTest(new Object[]{"One", "Two", "Three"}, new Object[]{"Three", "Two", "One"});
    runTest(new Object[]{"One", "Two"}, new Object[]{"Two", "One"});
    runTest(new Object[]{"One"}, new Object[]{"One"});
    runTest(new Object[0], new Object[0]);
  }

  @Test
  public void testThrows() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> reverseArrayInPlace(null))
        .withMessage("array cannot be null!");
  }

  private void runTest(Object[] actual, Object[] expected) {
    reverseArrayInPlace(actual);
    assertEquals(expected.length, actual.length);
    for (int ix = 0; ix < expected.length; ix++) {
      assertEquals(expected[ix], actual[ix], String.format("variance at ix=%d", ix));
    }
  }
}
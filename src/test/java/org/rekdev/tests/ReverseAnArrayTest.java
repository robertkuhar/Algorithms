package org.rekdev.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.rekdev.ArrayUtils;

public class ReverseAnArrayTest {

  @Test
  public void testReverseInPlace() {
    runTest(new Object[]{"One", "Two", "Three"}, new Object[]{"Three", "Two", "One"});
    runTest(new Object[]{"One", "Two"}, new Object[]{"Two", "One"});
    runTest(new Object[]{"One"}, new Object[]{"One"});
    runTest(new Object[0], new Object[0]);
  }

  private void runTest(Object[] actual, Object[] expected) {
    ArrayUtils.reverseArrayInPlace(actual);
    assertEquals(expected.length, actual.length);
    for (int ix = 0; ix < expected.length; ix++) {
      assertEquals(expected[ix], actual[ix], String.format("variance at ix=%d", ix));
    }
  }
}
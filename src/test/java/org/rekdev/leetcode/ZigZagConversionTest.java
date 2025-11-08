package org.rekdev.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZigZagConversionTest {

  ZigZagConversion zigZagConversion;

  @BeforeEach
  public void setup() {
    zigZagConversion = new ZigZagConversion();
  }

  @Test
  public void testExample1() {
    final String input = "PAYPALISHIRING";
    final String expected = "PAHNAPLSIIGYIR";
    final String actual = zigZagConversion.convert(input, 3);
    assertEquals(expected, actual);
  }

  @Test
  public void testExample2() {
    final String input = "PAYPALISHIRING";
    final String expected = "PINALSIGYAHRPI";
    final String actual = zigZagConversion.convert(input, 4);
    assertEquals(expected, actual);
  }

  @Test
  public void testExample3() {
    final String input = "A";
    final String expected = "A";
    final String actual = zigZagConversion.convert(input, 1);
    assertEquals(expected, actual);
  }

  @Test
  public void testEdgeCase() {
    assertEquals("ABC", zigZagConversion.convert("ABC", 10));
  }
}

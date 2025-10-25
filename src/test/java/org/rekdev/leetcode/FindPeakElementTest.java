package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindPeakElementTest {

  FindPeakElement findPeakElement;

  @BeforeEach
  public void setup() {
    findPeakElement = new FindPeakElement();
  }

  @Test
  public void testExample1() {
    int[] input = new int[]{1, 2, 3, 1};
    int actual = findPeakElement.findPeakElement(input);
    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void testExample2() {
    int[] input = new int[]{1, 2, 1, 3, 5, 6, 4};
    int actual = findPeakElement.findPeakElement(input);
    assertThat(actual).isEqualTo(5);
  }

  @Test
  public void testSingleElement() {
    int[] input = new int[]{1};
    int actual = findPeakElement.findPeakElement(input);
    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void testEmpty() {
    int[] input = new int[0];
    int actual = findPeakElement.findPeakElement(input);
    assertThat(actual).isEqualTo(-1);
  }

  @Test
  public void testMidWhenEvenNumberOfElements() {
    int[] input = new int[]{1, 2, 1, 3, 5, 6};
    int actual = findPeakElement.findPeakElement(input);
    assertThat(actual).isEqualTo(5);
  }
}

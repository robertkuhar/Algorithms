package org.rekdev.capacitycalc;

import java.util.Arrays;

/*
 * Summer 2014 interview question: You have an array where each element represents a height. If you
 * pour water over your array, how much water would be trapped by the depressions. Ex. [ 5, 1, 1, 5
 * ] is 8. [ 1, 2, 1, 2, 1 ] is 1.
 *
 * This implementation minimizes back tracking by only summing once a right
 * peak is found. The solution can be found with only one pass through the
 * input array
 *
 * @author joshcanfield
 */
public class CanfieldCapacityCalculator implements CapacityCalculator {

  @Override
  public int calc(int[] array) {
    return calculateWater(array);
  }

  // Lifted from https://code.stypi.com/jcanfield/test.java
  private int calculateWater(int[] h) {
    int left = 0;
    int right = 0;
    int waterSum = 0;

    System.out.println(Arrays.toString(h));
    // move left to a peak
    while (left < h.length - 1 && h[left] <= h[left + 1]) {
      ++left;
    }

    // while there are left peaks left
    while (left < h.length - 2) {

      // keep track of the sum of blocks between the left peak and
      // the right
      int sumToRight = 0;

      // remember the previous highest peak in case we don't find
      // a best match
      int lastHighestIndex = -1;
      int lastHighest = 0;
      int sumToLastHighest = 0;

      System.out.println("Left Peak at index " + left);
      right = left + 1;

      // find the right most peak that we can fill-to
      while (right < h.length && h[right] < h[left]) {
        if (h[right] > lastHighest) {
          lastHighest = h[right];
          lastHighestIndex = right;
          sumToLastHighest = sumToRight;
        }
        sumToRight += h[right];
        ++right;
      }

      // if we made it to the end without a good peak, use the
      // best peak
      if (right == h.length && lastHighestIndex > 0) {
        right = lastHighestIndex;
        sumToRight = sumToLastHighest;
      }
      System.out.println("Right Peak at index " + right);

      int covered = (right - left - 1);
      System.out.println("Covered: " + covered);

      int height = Math.min(h[right], h[left]);
      System.out.println("Height: " + height);
      System.out.println("SumToRight: " + sumToRight);

      int water = (height * covered) - sumToRight;
      System.out.println("Water: " + water);
      waterSum += water;

      left = right;
    }

    return waterSum;
  }
}
package org.rekdev.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.rekdev.CapacityCalculator;

/**
 * Summer 2014 interview question: You have an array where each element
 * represents a height. If you pour water over your array, how much water would
 * be trapped by the depressions. Ex. [ 5, 1, 1, 5 ] is 8. [ 1, 2, 1, 2, 1 ] is
 * 1.
 */
public class VolumeOfArrayTests {
  @Test
  public void testJoshC_onePassWonder() {
    /**
     * This implementation minimizes back tracking by only summing once a right
     * peak is found. The solution can be found with only one pass through the
     * input array
     * 
     * @author joshcanfield
     */
    CapacityCalculator joshC_OnePassWonder = new CapacityCalculator() {
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
        while (left < h.length - 1 && h[left] <= h[left + 1])
          ++left;

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
    };
    testSimple(joshC_OnePassWonder);
    testHarder(joshC_OnePassWonder);
    testHarderYet(joshC_OnePassWonder);
    testEdgeCases(joshC_OnePassWonder);
  }

  @Test
  public void testFindMaxesFromHere() {
    /**
     * This implementation considers each element and searches to the left and
     * the right for the boundaries then contributes its value to the total if
     * the boundaries are discovered. The number of times that this solution has
     * to go over each element is uncomfortable.
     * 
     * @author robertkuhar
     */
    CapacityCalculator findMaxesFromHere = new CapacityCalculator() {
      @Override
      public int calc(int[] array) {
        if (array == null) {
          throw new IllegalArgumentException("Expected not null array");
        }
        if (array.length <= 2) {
          return 0;
        }
        int totalCapacity = 0;
        int leftIx = -1;
        int rightIx = -1;
        for (int i = 0; i < array.length; i++) {
          // TODO: Can I reuse the previous value of leftIx?
          leftIx = findBoundIx(array, i, -1);
          // TODO: Can I reuse the previous value of rightIx?
          rightIx = findBoundIx(array, i, 1);
          if (leftIx >= 0 && rightIx >= 0) {
            int elemCapacity = Math.min(array[leftIx], array[rightIx]) - array[i];
            totalCapacity += elemCapacity;
          }
        }
        return totalCapacity;
      }

      /**
       * Walk the array in the specified direction searching for the maximum
       * height element. Return its index if you find it, -1 otherwise.
       * 
       * @param array
       * @param candidateIx
       * @param direction
       * @return index of maximum height element relative to candidateIx; -1 if
       *         not found.
       */
      private int findBoundIx(int[] array, int candidateIx, int direction) {
        int boundIx = -1;
        for (int i = candidateIx + direction; 0 <= i && i < array.length; i += direction) {
          if (boundIx == -1 && array[i] > array[candidateIx]) {
            boundIx = i;
          } else if (boundIx >= 0 && array[i] > array[boundIx]) {
            boundIx = i;
          }
        }
        return boundIx;
      }
    };
    testSimple(findMaxesFromHere);
    testHarder(findMaxesFromHere);
    testHarderYet(findMaxesFromHere);
    testEdgeCases(findMaxesFromHere);
  }

  void testIt(int expectedCapacity, int[] array, CapacityCalculator capacityCalculator) {
    int capcity = capacityCalculator.calc(array);
    assertEquals(expectedCapacity, capcity);
  }

  void testSimple(CapacityCalculator capacityCalculator) {
    int[] a = { 5, 1, 1, 5 };
    testIt(8, a, capacityCalculator);
  }

  void testHarder(CapacityCalculator capacityCalculator) {
    int[] b = { 1, 2, 6, 4, 5, 1, 2, 3, 6, 4 };
    testIt(15, b, capacityCalculator);
  }

  void testHarderYet(CapacityCalculator capacityCalculator) {
    int[] c = { 3, 2, 6, 4, 5, 1, 4, 3, 5, 4 };
    testIt(9, c, capacityCalculator);
  }

  void testEdgeCases(CapacityCalculator capacityCalculator) {
    int[][] testCases = { { 1, 1, 1 }, { 1, 2, 3 }, { 3, 2, 1 }, { 1, 2, 2, 1 }, { 1 }, {} };
    for (int i = 0; i < testCases.length; i++) {
      testIt(0, testCases[i], capacityCalculator);
    }
  }

}

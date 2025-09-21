package org.rekdev.capacitycalc;

public class GeminiCapacityCalculator implements CapacityCalculator {

  @Override
  public int calc(int[] array) {
    if (array == null || array.length < 3) {
      return 0; // Not enough walls to trap water
    }

    int left = 0;
    int right = array.length - 1;
    int trappedWater = 0;

    int maxLeft = 0;
    int maxRight = 0;

    while (left < right) {
      // Check which side is the limiting factor
      if (array[left] <= array[right]) {
        // The water level is limited by the left side
        if (array[left] > maxLeft) {
          maxLeft = array[left];
        } else {
          trappedWater += maxLeft - array[left];
        }
        left++;
      } else {
        // The water level is limited by the right side
        if (array[right] > maxRight) {
          maxRight = array[right];
        } else {
          trappedWater += maxRight - array[right];
        }
        right--;
      }
    }
    return trappedWater;
  }
}

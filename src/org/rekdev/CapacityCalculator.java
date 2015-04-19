package org.rekdev;

/**
 * A CapacityCalculator is calculates the volume of water trapped by the
 * depressions in the input array where each element of the array represents a
 * height value.
 * <p>
 * Examples:<br/>
 * calc([ 5, 1, 1, 5]) == 8<br/>
 * calc([ 1, 2, 1, 2, 1 ]) == 1<br/>
 * calc([ 1, 2, 3 ]) == 0<br/>
 * </p>
 */
public interface CapacityCalculator {
  int calc(int[] array);
}


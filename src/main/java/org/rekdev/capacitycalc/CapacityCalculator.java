package org.rekdev.capacitycalc;

/**
 * A CapacityCalculator calculates the volume of water trapped by the depressions in the input
 * array where each element of the array represents a height value.
 * <p>
 * Examples:<br/> calc([ 5, 1, 1, 5]) == 8<br/> calc([ 1, 2, 1, 2, 1 ]) == 1<br/> calc([ 1, 2, 3 ])
 * == 0<br/>
 * </p>
 *
 * Gemini says the Interview Question is like "
 */
public interface CapacityCalculator {

  /**
   * Each int value in the input array represents a height of a wall in container. The calc function
   * calculates the volume of water trapped within these depressions.
   *
   * @param array int array whose values are wall heights within a container.
   * @return the integer volume of the water trapped in the depressions of the input array.
   */
  int calc(int[] array);
}

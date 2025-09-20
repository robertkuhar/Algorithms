package org.rekdev.capacitycalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Summer 2014 interview question: You have an array where each element represents a height. If you
 * pour water over your array, how much water would be trapped by the depressions. Ex. [ 5, 1, 1, 5
 * ] is 8. [ 1, 2, 1, 2, 1 ] is 1.
 */
public class CapacityCalculatorTests {

  @Test
  public void testFindMaxesFromHere() {
    final CapacityCalculator findMaxesFromHere = new BobKCapacityCalculator();
    testSimple(findMaxesFromHere);
    testHarder(findMaxesFromHere);
    testHarderYet(findMaxesFromHere);
    testEdgeCases(findMaxesFromHere);
  }

  void testIt(int expectedCapacity, int[] array, CapacityCalculator capacityCalculator) {
    int capacity = capacityCalculator.calc(array);
    assertEquals(expectedCapacity, capacity);
  }

  void testSimple(CapacityCalculator capacityCalculator) {
    int[] a = {5, 1, 1, 5};
    testIt(8, a, capacityCalculator);
  }

  void testHarder(CapacityCalculator capacityCalculator) {
    int[] b = {1, 2, 6, 4, 5, 1, 2, 3, 6, 4};
    testIt(15, b, capacityCalculator);
  }

  void testHarderYet(CapacityCalculator capacityCalculator) {
    int[] c = {3, 2, 6, 4, 5, 1, 4, 3, 5, 4};
    testIt(9, c, capacityCalculator);
  }

  void testEdgeCases(CapacityCalculator capacityCalculator) {
    int[][] testCases = {{1, 1, 1}, {1, 2, 3}, {3, 2, 1}, {1, 2, 2, 1}, {1}, {}};
    for (int[] testCase : testCases) {
      testIt(0, testCase, capacityCalculator);
    }
  }

  @Test
  public void testJoshC_onePassWonder() {
    CapacityCalculator joshC_OnePassWonder = new JoshCCapacityCalculator();
    testSimple(joshC_OnePassWonder);
    testHarder(joshC_OnePassWonder);
    testHarderYet(joshC_OnePassWonder);
    testEdgeCases(joshC_OnePassWonder);
  }
}

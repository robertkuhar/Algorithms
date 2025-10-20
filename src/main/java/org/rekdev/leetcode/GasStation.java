package org.rekdev.leetcode;

public class GasStation {

  /**
   * 134. Gas Station (Med)
   * https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * There are n gas stations along a circular route, where the amount of gas at the ith station is
   * gas[i].
   * </p>
   * <p>
   * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith
   * station to its next (i + 1)th station. You begin the journey with an empty tank at one of the
   * gas stations.
   * </p>
   * <p>
   * Given two integer arrays gas and cost, return the starting gas station's index if you can
   * travel around the circuit once in the clockwise direction, otherwise return -1. If there exists
   * a solution, it is guaranteed to be unique.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]<br/>
   * Output: 3<br/>
   * Explanation:<br/>
   * 1. Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4<br/>
   * 2. Travel to station 4. Your tank = 4 - 1 + 5 = 8<br/>
   * 3. Travel to station 0. Your tank = 8 - 2 + 1 = 7<br/>
   * 4. Travel to station 1. Your tank = 7 - 3 + 2 = 6<br/>
   * 5. Travel to station 2. Your tank = 6 - 4 + 3 = 5<br/>
   * 6. Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.<br/>
   * Therefore, return 3 as the starting index.
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: gas = [2,3,4], cost = [3,4,3]<br/>
   * Output: -1<br/>
   * Explanation: You can't start at station 0 or 1, as there is not enough gas to travel to the
   * next station.<br/>
   * 1. Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4<br/>
   * 2. Travel to station 0. Your tank = 4 - 3 + 2 = 3<br/>
   * 3. Travel to station 1. Your tank = 3 - 3 + 3 = 3<br/>
   * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.<br/>
   * Therefore, you can't travel around the circuit once no matter where you start.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - n == gas.length == cost.length<br/>
   * - 1 <= n <= 10^5<br/>
   * - 0 <= gas[i], cost[i] <= 10^4<br/>
   * - The input is generated such that the answer is unique.<br/>
   * </p>
   *
   * @param gas gas available at the station
   * @param cost gas to travel to the next station
   * @return starting index of any station that you can travel the whole circuit from
   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int startIx = 0;
    int totalGas = 0;
    int currentGas = 0;
    int circuitLength = gas.length;
    for (int i = 0; i < circuitLength; i++) {
      int diff = gas[i] - cost[i];
      totalGas += diff;
      currentGas += diff;
      if (currentGas < 0) {
        startIx = i + 1;
        currentGas = 0;
      }
    }
    return totalGas >= 0 ? startIx : -1;
  }
}

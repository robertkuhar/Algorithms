package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 134. Gas Station (Med)
 * https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GasStationTest {

  GasStation gasStation;

  @BeforeEach
  public void setUp() throws Exception {
    gasStation = new GasStation();
  }

  @Test
  public void testExample1() {
    int[] gas = new int[]{1, 2, 3, 4, 5};
    int[] cost = new int[]{3, 4, 5, 1, 2};
    int actual = gasStation.canCompleteCircuit(gas, cost);
    assertThat(actual).isEqualTo(3);
  }

  @Test
  public void testExample2() {
    int[] gas = new int[]{2, 3, 4};
    int[] cost = new int[]{3, 4, 3};
    int actual = gasStation.canCompleteCircuit(gas, cost);
    assertThat(actual).isEqualTo(-1);
  }
}

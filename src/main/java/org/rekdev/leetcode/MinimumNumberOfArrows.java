package org.rekdev.leetcode;

import java.util.Arrays;

public class MinimumNumberOfArrows {

  /**
   * 425. Minimum Number of Arrows to Burst Balloons
   * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150
   *
   * <p>
   * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
   * </p>
   * <p>
   * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
   * </p>
   * <p>
   * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: points = [[10,16],[2,8],[1,6],[7,12]]<br/>
   * Output: 2<br/>
   * Explanation: The balloons can be burst by 2 arrows:<br/>
   * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].<br/>
   * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: points = [[1,2],[3,4],[5,6],[7,8]]<br/>
   * Output: 4<br/>
   * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: points = [[1,2],[2,3],[3,4],[4,5]]<br/>
   * Output: 2<br/>
   * Explanation: The balloons can be burst by 2 arrows:<br/>
   * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].<br/>
   * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].<br/>
   * </p>
   * Constraints:<br/>
   * - 1 <= points.length <= 10^5<br/>
   * - points[i].length == 2<br/>
   * - -2^31 <= xstart < xend <= 2^31 - 1<br/>
   * </p>
   *
   * @param points
   * @return
   */
  public int findMinArrowShots(int[][] points) {
    // This sort is O(N log N)
    Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
    int arrows = 1;
    long currentX = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > currentX) {
        arrows++;
        currentX = points[i][1];
      }
    }
    return arrows;
  }
}

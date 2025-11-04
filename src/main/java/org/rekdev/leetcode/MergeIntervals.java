package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

  /**
   * 56. Merge Intervals (Medium)
   * https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
   * intervals, and return an array of the non-overlapping intervals that cover all the intervals
   * in the input.
   * </p>
   * <p>
   * Example 1:<br/>
   * <pre>
   * Input: intervals = [
   *   [1,3],
   *   [2,6],
   *   [8,10],
   *   [15,18]
   * ]
   * Output: [
   *   [1,6],
   *   [8,10],
   *   [15,18]
   * ]
   * </pre>
   * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * <pre>
   * Input: intervals = [
   *   [1,4],
   *   [4,5]
   * ]
   * Output: [
   *   [1,5]
   * ]
   * </pre>
   * Explanation: Intervals [1,4] and [4,5] are considered overlapping.<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * <pre>
   * Input: intervals = [
   *   [4,7],
   *   [1,4]
   * ]
   * Output: [
   *   [1,7]
   * ]
   * </pre>
   * Explanation: Intervals [1,4] and [4,7] are considered overlapping.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= intervals.length <= 10^4<br/>
   * - intervals[i].length == 2<br/>
   * - 0 <= starti <= endi <= 10^4<br/>
   * </p>
   *
   * Insight: Sort the input so you can just keep checking if the new "start" is within the range
   * of the last one put into the output
   *
   * @param intervals
   * @return
   */
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    final List<int[]> merged = new ArrayList<>();
    for (int j = 0; j < intervals.length; j++) {
      int[] candidate = intervals[j];
      if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < candidate[0]) {
        merged.add(candidate);
      } else {
        merged.getLast()[1] = Math.max(merged.get(merged.size() - 1)[1], candidate[1]);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}

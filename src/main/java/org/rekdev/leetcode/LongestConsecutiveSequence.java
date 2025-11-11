package org.rekdev.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  /**
   * 128. Longest Consecutive Sequence (Medium)
   * https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an unsorted array of integers nums, return the length of the longest consecutive
   * elements sequence.
   * </p>
   * <p>
   * You must write an algorithm that runs in O(n) time.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [100,4,200,1,3,2]<br/>
   * Output: 4<br/>
   * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length
   * is 4.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [0,3,7,2,5,8,4,6,0,1]<br/>
   * Output: 9<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: nums = [1,0,1,2]<br/>
   * Output: 3<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 0 <= nums.length <= 10^5<br/>
   * - -10^9 <= nums[i] <= 10^9<br/>
   * </p>
   *
   * Insight: Populate a Set<Integer> of the input nums and then interrogate it for the max seq
   * @param nums
   * @return
   */
  public int longestConsecutive(int[] nums) {
    final Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int maxConsecutive = 0;
    for (int num : set) {
      if (!set.contains(num - 1)) {
        int consecutive = 1;
        int current = num;
        while (set.contains(current + 1)) {
          consecutive++;
          current++;
        }
        maxConsecutive = Math.max(maxConsecutive, consecutive);
      }
    }
    return maxConsecutive;
  }
}

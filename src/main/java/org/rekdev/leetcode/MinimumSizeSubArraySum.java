package org.rekdev.leetcode;

public class MinimumSizeSubArraySum {

  /**
   * 209. Minimum Size Subarray Sum
   * https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an array of positive integers nums and a positive integer target, return the minimal
   * length of a subarray whose sum is greater than or equal to target. If there is no such
   * subarray, return 0 instead.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: target = 7, nums = [2,3,1,2,4,3]<br/>
   * Output: 2<br/>
   * Explanation: The subarray [4,3] has the minimal length under the problem constraint.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: target = 4, nums = [1,4,4]<br/>
   * Output: 1<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: target = 11, nums = [1,1,1,1,1,1,1,1]<br/>
   * Output: 0<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= target <= 10^9
   * - 1 <= nums.length <= 10^5
   * - 1 <= nums[i] <= 10^4
   * </p>
   * <p>
   * Follow up: If you have figured out the O(n) solution, try coding another solution of which the
   * time complexity is O(n log(n)).
   * </p>
   *
   * @param target value we are trying to find combinations that are equal to or greater
   * @param nums array of positive integers
   * @return shortest length of a sub-array that sums up to greater than or equal target; 0 if none
   */
  public int minSubArrayLen(int target, int[] nums) {
    int minSubArrayLen =  Integer.MAX_VALUE;
    int lIndex = 0;
    int sum = 0;
    for (int rIndex = 0; rIndex < nums.length; rIndex++) {
      sum = sum + nums[rIndex];
      while (sum >= target) {
        int subArrayLen = rIndex - lIndex + 1;
        if (subArrayLen < minSubArrayLen) {
          minSubArrayLen = subArrayLen;
        }
        sum -= nums[lIndex];
        lIndex++;
      }
    }
    return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
  }
}

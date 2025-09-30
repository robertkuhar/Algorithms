package org.rekdev.leetcode;

public class JumpGame {

  /**
   * 55. Jump Game
   * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * You are given an integer array nums. You are initially positioned at the array's first index,
   * and each element in the array represents your maximum jump length at that position.
   * </p>
   * <p>
   * Return true if you can reach the last index, or false otherwise.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [2,3,1,1,4]<br/>
   * Output: true<br/>
   * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [3,2,1,0,4]<br/>
   * Output: false<br/>
   * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
   * which makes it impossible to reach the last index.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 10^4<br/>
   * - 0 <= nums[i] <= 10^5<br/>
   * </p>
   * @param nums - array of ints which is jump distance from current index
   * @return - true if you can jump to the end of the array; false otherwise
   */
  public boolean canJump(int[] nums) {
    if (nums.length <= 1) {
      return true;
    }
    int maxReach = 0;
    int lastIndex = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
      if (i > maxReach) {
        return false;
      }
      /*
       * Gemini explained it as "It tracks the maximum index you could have landed on from any
       * previous valid position up to index i−1". Gemini doesn't really like this forward approach
       * but this one does make sense to me, its just not maximum efficiency.
       */
      maxReach = Math.max(maxReach, i + nums[i]);
      if (maxReach >= lastIndex) {
        return true;
      }
    }
    return false;
  }
}

package org.rekdev.leetcode;

public class FindPeakElement {

  /**
   * 162. Find Peak Element
   * https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * A peak element is an element that is strictly greater than its neighbors.
   * </p>
   * <p>
   * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array
   * contains multiple peaks, return the index to any of the peaks.
   * </p>
   * <p>
   * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered
   * to be strictly greater than a neighbor that is outside the array.
   * </p>
   * <p>
   * You must write an algorithm that runs in O(log n) time.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [1,2,3,1]<br/>
   * Output: 2<br/>
   * Explanation: 3 is a peak element and your function should return the index number 2.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [1,2,1,3,5,6,4]<br/>
   * Output: 5<br/>
   * Explanation: Your function can return either index number 1 where the peak element is 2, or
   * index number 5 where the peak element is 6.</br>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 1000<br/>
   * - -2631 <= nums[i] <= 2^31 - 1<br/>
   * - nums[i] != nums[i + 1] for all valid i.<br/>
   * </p>
   *
   * Insight: The O(log n) thing dictates a binary search like traversal here.
   *
   * @param nums
   * @return
   */
  public int findPeakElement(int[] nums) {
    int leftIx = 0;
    int rightIx = nums.length - 1;
    while (leftIx <= rightIx) {
      int midIx = leftIx + (rightIx - leftIx) / 2;
      long leftVal = (midIx > 0) ? nums[midIx - 1] : Long.MIN_VALUE;
      long rightVal = (midIx < nums.length - 1) ? nums[midIx + 1] : Long.MIN_VALUE;
      if (nums[midIx] > leftVal && nums[midIx] > rightVal) {
        return midIx;
      } else if (nums[midIx] < rightVal) {
        leftIx = midIx + 1;
      } else {
        rightIx = midIx - 1;
      }
    }
    return -1;
  }
}

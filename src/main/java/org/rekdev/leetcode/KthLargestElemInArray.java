package org.rekdev.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElemInArray {

  /**
   * 215. Kth Largest Element in an Array (Medium)
   * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an integer array nums and an integer k, return the kth largest element in the array.
   * </p>
   * <p>
   * Note that it is the kth largest element in the sorted order, not the kth distinct element.
   * </p>
   * <p>
   * Can you solve it without sorting?
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [3,2,1,5,6,4], k = 2<br/>
   * Output: 5<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4<br/>
   * Output: 4<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * 1 <= k <= nums.length <= 10^5<br/>
   * -10^4 <= nums[i] <= 10^4<br/>
   * </p>
   *
   * @param nums
   * @param k
   * @return
   */
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
      throw new IllegalArgumentException(
          String.format(
              "nums: %s, k: %d are invalid inputs to findKthLargest",
              Arrays.toString(nums),
              k));
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
      minHeap.offer(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }
}

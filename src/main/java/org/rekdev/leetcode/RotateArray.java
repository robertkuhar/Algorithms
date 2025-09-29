package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArray {

  /**
   * 189. Rotate Array
   * https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [1,2,3,4,5,6,7], k = 3<br/>
   * Output: [5,6,7,1,2,3,4]<br/>
   * <br/>
   * Explanation:<br/>
   * - rotate 1 steps to the right: [7,1,2,3,4,5,6]<br/>
   * - rotate 2 steps to the right: [6,7,1,2,3,4,5]<br/>
   * - rotate 3 steps to the right: [5,6,7,1,2,3,4]<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [-1,-100,3,99], k = 2<br/>
   * Output: [3,99,-1,-100]<br/>
   * Explanation: <br/>
   * - rotate 1 steps to the right: [99,-1,-100,3]<br/>
   * - rotate 2 steps to the right: [3,99,-1,-100]<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 10^5<br/>
   * - -2^31 <= nums[i] <= 2^31 - 1<br/>
   * - 0 <= k <= 105<br/>
   * </p>
   * <p>
   * Follow up: Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.<br/>
   * <br/>
   * Could you do it in-place with O(1) extra space?<br/>
   * </p>
   *
   * @param nums array if ints to be rotated by k
   * @param k steps to rotate
   */
  public void rotate(int[] nums, int k) {
    List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    Collections.rotate(list, k);
    for(int i = 0; i < list.size(); i++) {
      nums[i] = list.get(i);
    }
  }
}

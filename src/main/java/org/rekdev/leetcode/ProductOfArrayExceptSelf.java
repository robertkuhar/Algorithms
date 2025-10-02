package org.rekdev.leetcode;

public class ProductOfArrayExceptSelf {

  /**
   * 238. Product of Array Except Self
   * https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150
   *
   * <p>
   * Given an integer array nums, return an array answer such that answer[i] is equal to the product
   * of all the elements of nums except nums[i].<br/>
   * <br/>
   * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.<br/>
   * <br/>
   * You must write an algorithm that runs in O(n) time and without using the division operation.<br/>
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [1,2,3,4]<br/>
   * Output: [24,12,8,6]<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [-1,1,0,-3,3]<br/>
   * Output: [0,0,9,0,0]<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 2 <= nums.length <= 10^5
   * - -30 <= nums[i] <= 30
   * - The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
   * </p>
   * <p>
   * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not
   * count as extra space for space complexity analysis.)
   * </p>
   *
   * @param nums input numbers
   * @return array with each element being the product of all other elements in the input array
   */
  public int[] productExceptSelf(int[] nums) {
    int[] answers = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      answers[i] = 1;
      for (int j = 0; j < nums.length; j++) {
        if (i != j) {
          answers[i] *= nums[j];
        }
      }
    }
    return answers;
  }
}

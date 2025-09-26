package org.rekdev.leetcode;

public class RemoveDuplicatesFromSortedArray {

  /**
   * 26. Remove Duplicates from Sorted Array
   * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
   * that each unique element appears only once. The relative order of the elements should be kept
   * the same. Then return the number of unique elements in nums.
   * </p>
   * <p>
   * Consider the number of unique elements of nums to be k, to get accepted, you need to do the
   * following things:<br/>
   * - Change the array nums such that the first k elements of nums contain the unique elements in the
   * order they were present in nums initially.<br/>
   * - The remaining elements of nums are not important as well as the size of nums.<br/>
   * - Return k.
   * </p>
   * <p>
   * Custom Judge:<br/>
   * The judge will test your solution with the following code:
   * <pre>
   * int[] nums = [...]; // Input array
   * int[] expectedNums = [...]; // The expected answer with correct length
   *
   * int k = removeDuplicates(nums); // Calls your implementation
   *
   * assert k == expectedNums.length;
   * for (int i = 0; i < k; i++) {
   *     assert nums[i] == expectedNums[i];
   * }
   * </pre>
   * If all assertions pass, then your solution will be accepted.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [1,1,2]<br/>
   * Output: 2, nums = [1,2,_]<br/>
   * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and
   * 2 respectively.
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [0,0,1,1,1,2,2,3,3,4]<br/>
   * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]<br/>
   * Explanation: Your function should return k = 5, with the first five elements of nums being 0,
   * 1, 2, 3, and 4 respectively. It does not matter what you leave beyond the returned k (hence
   * they are underscores).
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 3 * 10^4<br/>
   * - -100 <= nums[i] <= 100<br/>
   * - nums is sorted in non-decreasing order.<br/>
   * </p>
   */
  public int removeDuplicates(int[] nums) {
    int k = 0;
    int currentInt = -999;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != currentInt) {
        currentInt = nums[i];
        nums[k] = nums[i];
        k++;
      }
    }
    return k;
  }
}

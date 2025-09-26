package org.rekdev.leetcode;

public class RemoveDuplicatesFromSortedArrayII {

  /**
   * 80. Remove Duplicates from Sorted Array II
   * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
   * such that each unique element appears at most twice. The relative order of the elements should
   * be kept the same.
   * </p>
   * <p>
   * Since it is impossible to change the length of the array in some languages, you must instead
   * have the result be placed in the first part of the array nums. More formally, if there are k
   * elements after removing the duplicates, then the first k elements of nums should hold the final
   * result. It does not matter what you leave beyond the first k elements.
   * </p>
   * <p>
   * Return k after placing the final result in the first k slots of nums.
   * </p>
   * <p>
   * Do not allocate extra space for another array. You must do this by modifying the input array
   * in-place with O(1) extra memory.
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
   * Input: nums = [1,1,1,2,2,3]<br/>
   * Output: 5, nums = [1,1,2,2,3,_]<br/>
   * Explanation: Your function should return k = 5, with the first five elements of nums being 1,
   * 1, 2, 2 and 3 respectively. It does not matter what you leave beyond the returned k (hence
   * they are underscores).
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [0,0,1,1,1,1,2,3,3]<br/>
   * Output: 7, nums = [0,0,1,1,2,3,3,_,_]<br/>
   * Explanation: Your function should return k = 7, with the first seven elements of nums being 0,
   * 0, 1, 1, 2, 3 and 3 respectively. It does not matter what you leave beyond the returned k
   * (hence they are underscores).
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 3 * 10^4<br/>
   * - -10^4 <= nums[i] <= 10^4<br/>
   * - nums is sorted in non-decreasing order.<br/>
   * </p>
   */
  public int removeDuplicates(int[] nums) {
    int k = 0;
    int currentInt = -999;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != currentInt) {
        currentInt = nums[i];
        nums[k] = nums[i];
        k++;
        count = 0;
      } else {
        if (count == 0) {
          nums[k] = currentInt;
          k++;
          count++;
        }
      }
    }
    return k;
  }
}

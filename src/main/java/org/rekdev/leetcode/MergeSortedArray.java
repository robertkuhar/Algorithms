package org.rekdev.leetcode;

public class MergeSortedArray {

  /**
   * 88. Merged Sort Array<br/>
   * https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
   * integers m and n, representing the number of elements in nums1 and nums2 respectively.
   * <p>
   * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
   * <p>
   * The final sorted array should not be returned by the function, but instead be stored inside the
   * array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote
   * the elements that should be merged, and the last n elements are set to 0 and should be ignored.
   * nums2 has a length of n.
   * <p>
   * Example 1:
   * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   * Output: [1,2,2,3,5,6]
   * Explanation: The arrays we are merging are [1,2,3] and [2,5,6]. The result of the merge is
   * [1,2,2,3,5,6] with the underlined elements coming from nums1.
   * <p>
   * Example 2:
   * Input: nums1 = [1], m = 1, nums2 = [], n = 0
   * Output: [1]
   * Explanation: The arrays we are merging are [1] and []. The result of the merge is [1].
   * <p>
   * Example 3:
   * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
   * Output: [1]
   * Explanation: The arrays we are merging are [] and [1]. The result of the merge is [1]. Note
   * that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge
   * result can fit in nums1.
   * <p>
   * Constraints:
   * - nums1.length == m + n
   * - nums2.length == n
   * - 0 <= m, n <= 200
   * - 1 <= m + n <= 200
   * - -10^9 <= nums1[i],
   * - nums2[j] <= 10^9
   * <p>
   * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
   * </p>
   *
   * @param nums1 - sorted merge of nums1 and nums2
   * @param m - number of elements in nums1
   * @param nums2 - array to be merged into nums1
   * @param n - number of elements in nums2
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // Pointers for the arrays
    int nums1ReadPointer = m - 1;
    int nums2ReadPointer = n - 1;
    int nums1WritePointer = m + n - 1;

    // Loop while there are still elements to consider in nums2
    while (nums2ReadPointer >= 0) {
      if (nums1ReadPointer >= 0 && nums1[nums1ReadPointer] > nums2[nums2ReadPointer]) {
        nums1[nums1WritePointer] = nums1[nums1ReadPointer];
        nums1ReadPointer--;
      } else {
        nums1[nums1WritePointer] = nums2[nums2ReadPointer];
        nums2ReadPointer--;
      }
      nums1WritePointer--;
    }
  }
}

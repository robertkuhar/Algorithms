package org.rekdev.leetcode;

public class ConvertSortedArrayToBST {

  /**
   * 108. Convert Sorted Array to Binary Search Tree (Easy)
   * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an integer array nums where the elements are sorted in ascending order, convert it to a
   * height-balanced binary search tree.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [-10,-3,0,5,9]<br/>
   * Output: [0,-3,9,-10,null,5]<br/>
   * Explanation: [0,-10,5,null,-3,null,9] is also accepted:<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [1,3]<br/>
   * Output: [3,1]<br/>
   * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.<br/>
   * </p>
   * Constraints:<br/>
   * - 1 <= nums.length <= 10^4<br/>
   * - -10^4 <= nums[i] <= 10^4<br/>
   * - nums is sorted in a strictly increasing order.<br/>
   * </p>
   *
   * @param nums
   * @return
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    final TreeNode root = convert(nums, 0, nums.length - 1);
    return root;
  }

  private TreeNode convert(int[] nums, int leftIx, int rightIx) {
    if (leftIx > rightIx) {
      return null;
    }
    int midIx = leftIx + (rightIx - leftIx) / 2;
    TreeNode root = new TreeNode(nums[midIx]);
    root.left = convert(nums, 0, midIx - 1);
    root.right = convert(nums, midIx + 1, rightIx);
    return root;
  }
}

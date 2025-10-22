package org.rekdev.leetcode;

public class MinAbsDiffInBST {

  /**
   * 530. Minimum Absolute Difference in BST
   * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between
   * the values of any two different nodes in the tree.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: root = [4,2,6,1,3]<br/>
   * <pre>
   *     4
   *    / \
   *   2   6
   *  / \
   * 1   3
   * </pre>
   * Output: 1
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: root = [1,0,48,null,null,12,49]<br/>
   * <pre>
   *   1
   *  / \
   * 0   48
   *    /  \
   *   12   49
   * </pre>
   * Output: 1
   * </p>
   * <p>
   * Constraints:<br/>
   * - The number of nodes in the tree is in the range [2, 10^4].<br/>
   * - 0 <= Node.val <= 10^5<br/>
   * </p>
   * <p>
   * Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
   * </p>
   *
   * @param root
   * @return
   */
  public int minDiffInBST(TreeNode root) {
    traverse(root);
    return minDiff;
  }

  int minDiff = Integer.MAX_VALUE;
  Integer previousValue = null;

  void traverse(TreeNode node) {
    if (node == null) {
      return;
    }
    traverse(node.left);
    if (previousValue != null) {
      minDiff = Math.min(minDiff, Math.abs(node.val - previousValue));
    }
    previousValue = node.val;
    traverse(node.right);
  }
}

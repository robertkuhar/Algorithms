package org.rekdev.leetcode;

public class PathSum {

  /**
   * 112. Path Sum (Easy)
   * https://leetcode.com/problems/path-sum/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given the root of a binary tree and an integer targetSum, return true if the tree has a
   * root-to-leaf path such that adding up all the values along the path equals targetSum.
   * </p>
   * <p>
   * A leaf is a node with no children.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22<br/>
   * <pre>
   *        1
   *       / \
   *      4   8
   *     /   / \
   *    11  13  4
   *   / \       \
   *  7   2       1
   * </pre>
   * Output: true<br/>
   * Explanation: The root-to-leaf path with the target sum is shown.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: root = [1,2,3], targetSum = 5<br/>
   * <pre>
   *    1
   *   / \
   *  2   3
   * </pre>
   * Output: false<br/>
   * Explanation: There are two root-to-leaf paths in the tree:<br/>
   * - (1 --> 2): The sum is 3.<br/>
   * - (1 --> 3): The sum is 4.<br/>
   * There is no root-to-leaf path with sum = 5.<br/>
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: root = [], targetSum = 0<br/>
   * Output: false<br/>
   * Explanation: Since the tree is empty, there are no root-to-leaf paths.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - The number of nodes in the tree is in the range [0, 5000].<br/>
   * - -1000 <= Node.val <= 1000<br/>
   * - -1000 <= targetSum <= 1000<br/>
   * </p>
   *
   * @param root root of the tree
   * @param targetSum the target sum
   * @return true if the tree has a root-to-leaf path that sums up to targetSum; false otherwise
   */
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }
    return hasPathSum(root.left, targetSum - root.val) ||
        hasPathSum(root.right, targetSum - root.val);
  }
}

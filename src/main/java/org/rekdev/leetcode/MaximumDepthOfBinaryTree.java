package org.rekdev.leetcode;

public class MaximumDepthOfBinaryTree {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  /**
   * 104. MaximumDepthOfBinaryTree
   * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given the root of a binary tree, return its maximum depth.
   * </p>
   * <p>
   * A binary tree's maximum depth is the number of nodes along the longest path from the root node
   * down to the farthest leaf node.
   * </p>
   * <p>
   * Example 1:<br/>
   * <pre>
   *    3
   *   / \
   *  9   20
   *     / \
   *    15  7
   * </pre>
   * Input: root = [3,9,20,null,null,15,7]<br/>
   * Output: 3
   * </p>
   * <p>
   * Example 2:<br/>
   * <pre>
   *    1
   *     \
   *      2
   * </pre>
   * Input: root = [1,null,2]<br/>
   * Output: 2
   * </p>
   * <p>
   * Constraints:<br/>
   * - The number of nodes in the tree is in the range [0, 10^4].<br/>
   * - -100 <= Node.val <= 100<br/>
   * </p>
   *
   * @param root root node of the tree to be explored
   * @return max depth of the branches
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxLeft = maxDepth(root.left);
    int maxRight = maxDepth(root.right);
    return 1 + Math.max(maxLeft, maxRight);
  }
}

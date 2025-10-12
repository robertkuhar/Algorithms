package org.rekdev.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {

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
   * 199. Binary Tree Right Side View
   * https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given the root of a binary tree, imagine yourself standing on the right side of it, return the
   * values of the nodes you can see ordered from top to bottom.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: root = [1,2,3,null,5,null,4]<br/>
   * <pre>
   *    1
   *   / \
   *  2   3
   *   \   \
   *    5   4
   * </pre>
   * Output: [1,3,4]
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: root = [1,2,3,4,null,null,null,5]<br/>
   * <pre>
   *       1
   *      / \
   *     2   3
   *    /
   *   4
   *  /
   * 5
   * </pre>
   * Output: [1,3,4,5]
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: root = [1,null,3]<br/>
   * <pre>
   *  1
   *   \
   *    3
   * </pre>
   * Output: [1,3]
   * </p>
   * <p>
   * Example 4:<br/>
   * Input: root = []<br/>
   * Output: []
   * </p>
   * <p>
   * Constraints:<br/>
   * - The number of nodes in the tree is in the range [0, 100].<br/>
   * - -100 <= Node.val <= 100
   * </p>
   *
   * @param root root of the BinaryTree being traversed
   * @return value of each TreeNode visible from the right side
   */
  public List<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> rightSideView = new ArrayList<>();
    if (root != null) {
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          if (i == size - 1) {
            rightSideView.add(node.val);
          }
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }
      }
    }
    return rightSideView;
  }
}

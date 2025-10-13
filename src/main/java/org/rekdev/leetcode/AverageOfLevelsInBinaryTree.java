package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {

  /**
   * 637. Average of Levels in Binary Tree
   * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given the root of a binary tree, return the average value of the nodes on each level in the
   * form of an array. Answers within 10-5 of the actual answer will be accepted.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: root = [3,9,20,null,null,15,7]<br/>
   * <pre>
   *     3
   *    / \
   *   9   20
   *      / \
   *     15  7
   * </pre>
   * Output: [3.00000,14.50000,11.00000]<br/>
   * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is
   * 11. Hence return [3, 14.5, 11].
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: root = [3,9,20,15,7]
   * <pre>
   *     3
   *    / \
   *   9   20
   *  / \
   * 15  7
   * </pre>
   * Output: [3.00000,14.50000,11.00000]
   * </p>
   * <p>
   * Constraints:<br/>
   * - The number of nodes in the tree is in the range [1, 10^4].<br/>
   * - -2^31 <= Node.val <= 2^31 - 1
   * </p>
   *
   * @param root root of the BinaryTree being traversed
   * @return The Average of the node values per level
   */
  public List<Double> averageOfLevels(TreeNode root) {
    ArrayList<Double> averageOfLevels = new ArrayList<>();
    if (root != null) {
      Deque<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          sum += node.val;
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }
        averageOfLevels.add(sum / size);
      }
    }
    return averageOfLevels;
  }
}

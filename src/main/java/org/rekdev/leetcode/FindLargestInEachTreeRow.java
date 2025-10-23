package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindLargestInEachTreeRow {

  /**
   * 515. Find Largest Value in Each Tree Row
   * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
   * <p>
   * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: root = [1,3,2,5,3,null,9]<br/>
   * <pre>
   *     1
   *    / \
   *   3   2
   *  / \   \
   * 5   3   9
   * </pre>
   * Output: [1,3,9]<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: root = [1,2,3]<br/>
   * <pre>
   *   1
   *  / \
   * 3   2
   * </pre>
   * Output: [1,3]<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - The number of nodes in the tree will be in the range [0, 10^4].<br/>
   * - -2^31 <= Node.val <= 2^31 - 1<br/>
   * </p>
   *
   * Insight: BFS is what you use to move "level by level".
   * @see org.rekdev.leetcode.AverageOfLevelsInBinaryTree
   *
   * @param root root of the BinaryTree being traversed
   * @return List of the largest value at each level
   */
  public List<Integer> largestValues(TreeNode root) {
    ArrayList<Integer> largestValues = new ArrayList<>();
    if (root != null) {
      Deque<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        int maxValueForLevel = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          maxValueForLevel = Math.max(maxValueForLevel, node.val);
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }
        largestValues.add(maxValueForLevel);
      }
    }
    return largestValues;
  }
}

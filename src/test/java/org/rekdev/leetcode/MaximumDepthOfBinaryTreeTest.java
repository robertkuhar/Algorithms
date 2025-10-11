package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rekdev.leetcode.MaximumDepthOfBinaryTree.TreeNode;

/**
 * 104. MaximumDepthOfBinaryTree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaximumDepthOfBinaryTreeTest {

  MaximumDepthOfBinaryTree maximumDepthOfBinaryTree;

  @BeforeEach
  public void setup() {
    maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
  }

  @Test
  public void testExample1() {
    TreeNode nineLeftOfThree = new TreeNode(9);
    TreeNode fifteenLeftOfTwenty = new TreeNode(15);
    TreeNode sevenRightOfTwenty = new TreeNode(7);
    TreeNode twentyRightOfThree = new TreeNode(20, fifteenLeftOfTwenty, sevenRightOfTwenty);
    TreeNode root = new TreeNode(3, nineLeftOfThree, twentyRightOfThree);
    int maxDepth = maximumDepthOfBinaryTree.maxDepth(root);
    assertThat(maxDepth).isEqualTo(3);
  }

  @Test
  public void testExample2() {
    TreeNode twoRightOfOne = new TreeNode(2);
    TreeNode root = new TreeNode(1, null, twoRightOfOne);
    int maxDepth = maximumDepthOfBinaryTree.maxDepth(root);
    assertThat(maxDepth).isEqualTo(2);
  }

  @Test
  public void testNullRoot() {
    int maxDepth = maximumDepthOfBinaryTree.maxDepth(null);
    assertThat(maxDepth).isEqualTo(0);
  }

  @Test
  public void testTreeNode() {
    TreeNode treeNode = new TreeNode();
    int maxDepth = maximumDepthOfBinaryTree.maxDepth(treeNode);
    assertThat(maxDepth).isEqualTo(1);
  }
}

package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rekdev.leetcode.BinaryTreeRightSideView.TreeNode;

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-interview-150
 */
public class BinaryTreeRightSideViewTest {

  BinaryTreeRightSideView binaryTreeRightSideView;
  TreeNode five = null;
  TreeNode four = null;
  TreeNode three = null;
  TreeNode two = null;
  TreeNode one = null;

  @BeforeEach
  public void setup() {
    binaryTreeRightSideView = new BinaryTreeRightSideView();
    one = new TreeNode(1);
    two = new TreeNode(2);
    three = new TreeNode(3);
    four = new TreeNode(4);
    five = new TreeNode(5);
  }

  @Test
  public void testExample1() {
    one.left = two;
    one.right = three;
    two.right = five;
    three.right = four;
    List<Integer> expected = new ArrayList<>(List.of(1, 3, 4));
    List<Integer> actual = binaryTreeRightSideView.rightSideView(one);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    one.left = two;
    one.right = three;
    two.left = four;
    four.left = five;
    List<Integer> expected = new ArrayList<>(List.of(1, 3, 4, 5));
    List<Integer> actual = binaryTreeRightSideView.rightSideView(one);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample3() {
    one.left = two;
    one.right = three;
    List<Integer> expected = new ArrayList<>(List.of(1, 3));
    List<Integer> actual = binaryTreeRightSideView.rightSideView(one);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testNull() {
    List<Integer> expected = new ArrayList<>();
    List<Integer> actual = binaryTreeRightSideView.rightSideView(null);
    assertThat(actual).isEqualTo(expected);
  }
}

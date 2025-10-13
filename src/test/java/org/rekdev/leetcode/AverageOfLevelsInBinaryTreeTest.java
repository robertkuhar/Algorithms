package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 637. Average of Levels in Binary Tree
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class AverageOfLevelsInBinaryTreeTest {

  AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree;
  TreeNode three = null;
  TreeNode nine = null;
  TreeNode twenty = null;
  TreeNode fifteen = null;
  TreeNode seven = null;

  @BeforeEach
  public void setup() {
    averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();
    three = new TreeNode(3);
    nine = new TreeNode(9);
    twenty = new TreeNode(20);
    fifteen = new TreeNode(15);
    seven = new TreeNode(7);
  }

  @Test
  public void testExample1() {
    three.left = nine;
    three.right = twenty;
    twenty.left = fifteen;
    twenty.right = seven;
    List<Double> expected = new ArrayList<>(List.of(3.0, 14.5, 11.0));

    List<Double> actual = averageOfLevelsInBinaryTree.averageOfLevels(three);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    three.left = nine;
    three.right = twenty;
    nine.left = fifteen;
    nine.right = seven;

    List<Double> expected = new ArrayList<>(List.of(3.0, 14.5, 11.0));

    List<Double> actual = averageOfLevelsInBinaryTree.averageOfLevels(three);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testNull() {
    List<Double> expected = new ArrayList<>();
    List<Double> actual = averageOfLevelsInBinaryTree.averageOfLevels(null);
    assertThat(actual).isEqualTo(expected);
  }
}

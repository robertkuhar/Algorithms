package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 112. Path Sum (Easy)
 * https://leetcode.com/problems/path-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class PathSumTest {

  PathSum pathSum;

  @BeforeEach
  public void setUp() throws Exception {
    pathSum = new PathSum();
  }

  @Test
  public void testExample1() {

    TreeNode seven  = new TreeNode(7);
    TreeNode two = new TreeNode(2);
    TreeNode anotherOne = new TreeNode(1);
    TreeNode eleven = new TreeNode(11, seven, two);
    TreeNode thirteen = new TreeNode(13);
    TreeNode anotherFour = new TreeNode(4, anotherOne, null);
    TreeNode four = new TreeNode(4, eleven, null);
    TreeNode eight = new TreeNode(8, thirteen, anotherFour);
    TreeNode root = new TreeNode(1, four, eight);

    final boolean actual = pathSum.hasPathSum(root, 22);
    assertThat(actual).isTrue();
  }

  @Test
  public void testExample2() {
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    TreeNode root = new TreeNode(1, two, three);

    final boolean actual = pathSum.hasPathSum(root, 5);
    assertThat(actual).isFalse();
  }

  @Test
  public void testExample3() {
    final boolean actual = pathSum.hasPathSum(null, 0);
    assertThat(actual).isFalse();
  }
}

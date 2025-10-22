package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinAbsDiffInBSTTest {

  MinAbsDiffInBST minAbsDiffInBST;

  @BeforeEach
  public void setUp() throws Exception {
    minAbsDiffInBST = new MinAbsDiffInBST();
  }

  @Test
  public void testExample1() {
    TreeNode one = new TreeNode(1);
    TreeNode three = new TreeNode(3);
    TreeNode two = new TreeNode(2, one, three);
    TreeNode six = new TreeNode(6);
    TreeNode four = new TreeNode(4, two, six);
    int actual = minAbsDiffInBST.minDiffInBST(four);
    assertThat(actual).isEqualTo(1);
  }

  @Test
  public void testExample2() {
    TreeNode zero = new TreeNode(0);
    TreeNode twelve = new TreeNode(12);
    TreeNode fortyNine = new TreeNode(49);
    TreeNode fortyEight = new TreeNode(48, twelve, fortyNine);
    TreeNode one = new TreeNode(1, zero, fortyEight);
    int actual = minAbsDiffInBST.minDiffInBST(one);
    assertThat(actual).isEqualTo(1);
  }
}

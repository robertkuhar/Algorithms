package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConvertSortedArrayToBSTTest {

  ConvertSortedArrayToBST convertSortedArrayToBST;

  @BeforeEach
  void setUp() {
    convertSortedArrayToBST = new ConvertSortedArrayToBST();
  }

  @Test
  void testExample1() {
    int[] input = new int[]{-10, -3, 0, 5, 9};
    TreeNode root = convertSortedArrayToBST.sortedArrayToBST(input);
    assertThat(root.val).isEqualTo(0);
    assertThat(root.left.val).isEqualTo(-10);
    assertThat(root.right.val).isEqualTo(5);
    assertThat(root.left.right.val).isEqualTo(-3);
    assertThat(root.right.right.val).isEqualTo(9);
  }

  @Test
  void testExample2() {
    int[] input = new int[]{1, 3};
    TreeNode root = convertSortedArrayToBST.sortedArrayToBST(input);
    assertThat(root.val).isEqualTo(1);
    assertThat(root.left).isNull();
    assertThat(root.right.val).isEqualTo(3);
  }

  @Test
  void testQuickOuts() {
    assertThat(convertSortedArrayToBST.sortedArrayToBST(new int[] {})).isNull();
    assertThat(convertSortedArrayToBST.sortedArrayToBST(null)).isNull();
  }
}

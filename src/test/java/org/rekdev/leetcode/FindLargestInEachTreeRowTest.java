package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 515. Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 */
public class FindLargestInEachTreeRowTest {

  FindLargestInEachTreeRow findLargestInEachTreeRow;
  TreeNode one = null;
  TreeNode two = null;
  TreeNode three = null;
  TreeNode alsoThree = null;
  TreeNode five = null;
  TreeNode nine = null;

  @BeforeEach
  public void setup() {
    findLargestInEachTreeRow = new FindLargestInEachTreeRow();
    one = new TreeNode(1);
    two = new TreeNode(2);
    three = new TreeNode(3);
    alsoThree = new TreeNode(3);
    five = new TreeNode(5);
    nine = new TreeNode(9);
  }

  @Test
  public void testExample1() {
    one.left = three;
    one.right = two;
    three.left = five;
    three.right = alsoThree;
    two.right = nine;
    final List<Integer> expected = List.of(1, 3, 9);
    final List<Integer> actual = findLargestInEachTreeRow.largestValues(one);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    one.left = three;
    one.right = two;
    final List<Integer> expected = List.of(1, 3);
    final List<Integer> actual = findLargestInEachTreeRow.largestValues(one);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testQuickout() {
    final List<Integer> actual = findLargestInEachTreeRow.largestValues(null);
    assertThat(actual).isEmpty();
  }
}

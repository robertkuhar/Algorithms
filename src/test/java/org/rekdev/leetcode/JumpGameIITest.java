package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JumpGameIITest {

  JumpGameII jumpGameII;

  @BeforeEach
  public void setup() {
    jumpGameII = new JumpGameII();
  }

  @Test
  public void testExample1() {
    final int[] nums = {2, 3, 1, 1, 4};
    final int actual = jumpGameII.jump(nums);
    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void testExample2() {
    final int[] nums = {2, 3, 0, 1, 4};
    final int actual = jumpGameII.jump(nums);
    assertThat(actual).isEqualTo(2);
  }
}

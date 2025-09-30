package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class JumpGameTest {

  JumpGame jumpGame;

  @BeforeEach
  public void setup() {
    jumpGame = new JumpGame();
  }

  @Test
  public void testExample1() {
    final int[] nums = {2, 3, 1, 1, 4};
    final boolean actual = jumpGame.canJump(nums);
    assertThat(actual).isTrue();
  }

  @Test
  public void testExample2() {
    final int[] nums = {3, 2, 1, 0, 4};
    final boolean actual = jumpGame.canJump(nums);
    assertThat(actual).isFalse();
  }

  @Test
  public void testNumsZero() {
    final int[] nums = {0};
    final boolean actual = jumpGame.canJump(nums);
    assertThat(actual).isTrue();
  }

  @Test
  public void testNumsOne() {
    final int[] nums = {1};
    final boolean actual = jumpGame.canJump(nums);
    assertThat(actual).isTrue();
  }
}

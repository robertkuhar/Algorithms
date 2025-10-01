package org.rekdev.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomizedSetTest {

  RandomizedSet randomizedSet;

  @BeforeEach
  public void setUp() {
    randomizedSet = new RandomizedSet();
  }

  @Test
  public void testExample1() {
    assertThat(randomizedSet.insert(1)).isTrue();
    assertThat(randomizedSet.remove(2)).isFalse();
    assertThat(randomizedSet.insert(2)).isTrue();
    assertThat(randomizedSet.getRandom()).isIn(1, 2);
    assertThat(randomizedSet.remove(1)).isTrue();
    assertThat(randomizedSet.insert(2)).isFalse();
    assertThat(randomizedSet.getRandom()).isEqualTo(2);
  }
}

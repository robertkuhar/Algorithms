package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordLadderTest {

  WordLadder wordLadder;

  @BeforeEach
  void setUp() {
    wordLadder = new WordLadder();
  }

  @Test
  void testExample1() {
    final int actual = wordLadder.ladderLength(
        "hit",
        "cog",
        List.of("hot", "dot", "dog", "lot", "log", "cog")
    );
    assertThat(actual).isEqualTo(5);
  }

  @Test
  void testExample2() {
    final int actual = wordLadder.ladderLength(
        "hit",
        "cog",
        List.of("hot", "dot", "dog", "lot", "log")
    );
    assertThat(actual).isEqualTo(0);
  }
}

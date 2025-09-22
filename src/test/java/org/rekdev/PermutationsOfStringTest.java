package org.rekdev;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PermutationsOfStringTest {

  @Test
  void testEmptyString() {
    assertThat(PermutationsOfString.permutation("", "")).containsExactly("");
  }

  @Test
  void testSingleCharacterString() {
    assertThat(PermutationsOfString.permutation("", "a")).containsExactly("a");
  }

  @Test
  void testTwoCharacterString() {
    assertThat(PermutationsOfString.permutation("", "ab"))
        .hasSize(2)
        .containsExactlyInAnyOrder("ab", "ba");
  }

  @Test
  void testThreeCharacterString() {
    List<String> expectedPermutations = List.of(
        "abc", "acb", "bac", "bca", "cab", "cba"
    );
    assertThat(PermutationsOfString.permutation("", "abc"))
        .hasSize(6)
        .containsExactlyInAnyOrderElementsOf(expectedPermutations);
  }

  @Test
  void testStringWithDuplicateCharacters() {
    // This test will pass, but it highlights a limitation of the current algorithm
    // as it produces duplicate permutations.
    List<String> permutations = PermutationsOfString.permutation("", "aba");
    assertThat(permutations)
        .hasSize(6)
        .containsExactlyInAnyOrder("aba", "aab", "baa", "aba", "aab", "baa");
  }

  @Test
  void testNullStringThrowsException() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> PermutationsOfString.permutation("", null));
  }

  @Test
  void testNullPrefixThrowsException() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> PermutationsOfString.permutation(null, "abc"));
  }
}
package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GroupAnagramsTest {

  GroupAnagrams groupAnagrams;

  @BeforeEach
  public void setUp() throws Exception {
    groupAnagrams = new GroupAnagrams();
  }

  @Test
  public void testExample1() {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> expected = List.of(
        List.of("bat"),
        List.of("nat", "tan"),
        List.of("ate", "eat", "tea")
    );

    List<List<String>> actual = groupAnagrams.groupAnagrams(strs);

    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringCollectionOrder()
        .isEqualTo(expected);
  }

  @Test
  public void testExample2() {
    String[] strs = {""};
    List<List<String>> expected = List.of(List.of(""));

    List<List<String>> actual = groupAnagrams.groupAnagrams(strs);

    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringCollectionOrder()
        .isEqualTo(expected);
  }

  @Test
  public void testExample3() {
    String[] strs = {"a"};
    List<List<String>> expected = List.of(List.of("a"));

    List<List<String>> actual = groupAnagrams.groupAnagrams(strs);

    assertThat(actual)
        .usingRecursiveComparison()
        .ignoringCollectionOrder()
        .isEqualTo(expected);

  }
}

package org.rekdev.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Summer 2014 Phonescreen question: "Write a function that takes 2 Strings as input and reports
 * whether they are anagrams of each other."
 *
 * @author robertkuhar
 *
 */
public class TestIsAnagram {

  public boolean isAnagram(String s1, String s2) {
    if (s1 == s2) {
      return true;
    }
    if (s1 != null && s1.equals(s2)) {
      return true;
    }
    if (s1 != null && s2 != null && s1.length() != s2.length()) {
      return false;
    }
    Map<Character, Integer> s1Counts = makeCharDistributionMap(s1);
    Map<Character, Integer> s2Counts = makeCharDistributionMap(s2);
    return s1Counts.equals(s2Counts);
  }

  private Map<Character, Integer> makeCharDistributionMap(String s) {
    Map<Character, Integer> counts = new HashMap<>();
    if (s != null) {
      for (char c : s.toCharArray()) {
        // Guava MultiSet would turn this into one line...
        counts.merge(c, 1, Integer::sum);
      }
    }
    return counts;
  }

  @Test
  public void happyPath() {
    assertTrue(isAnagram("abc", "abc"));
    assertTrue(isAnagram("abc", "cba"));
    assertFalse(isAnagram("abc", "xyz"));
    assertTrue(isAnagram("aabbcc", "abccab"));
    assertFalse(isAnagram("abc", "abccab"));
  }

  @Test
  public void edgeCases() {
    assertTrue(isAnagram(null, null));
    assertTrue(isAnagram("", ""));
    assertFalse(isAnagram("a", null));
    assertFalse(isAnagram(null, "a"));
  }
}

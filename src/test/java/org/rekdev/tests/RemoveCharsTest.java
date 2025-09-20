package org.rekdev.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.*;
import org.junit.jupiter.api.Test;

public class RemoveCharsTest {

  @Test
  public void test_removeCharsRegEx() {
    String candidate = "Battle of the Vowels:  Hawaii vs. Grozny";
    String expected = "Bttl f th Vwls:  Hw vs. Grzny";
    assertEquals(expected, removeCharsRegEx(candidate, "aeiou"));

    assertEquals(candidate, removeCharsRegEx(candidate, ""));
    assertEquals(candidate, removeCharsRegEx(candidate, null));

    assertEquals("", removeCharsRegEx("", "aeiou"));
    assertNull(removeCharsRegEx(null, "aeiou"));
  }

  String removeCharsRegEx(String str, String remove) {
    if (remove == null || str == null || remove.isEmpty() || str.isEmpty()) {
      return str;
    }
    String result = str.replaceAll("[" + remove + "]", "");
    return result;
  }

  @Test
  public void test_removeCharsOldSchool() {
    String candidate = "Battle of the Vowels:  Hawaii vs. Grozny";
    String expected = "Bttl f th Vwls:  Hw vs. Grzny";
    assertEquals(expected, removeCharsOldSchool(candidate, "aeiou"));

    assertEquals(candidate, removeCharsOldSchool(candidate, ""));
    assertEquals(candidate, removeCharsOldSchool(candidate, null));

    assertEquals("", removeCharsOldSchool("", "aeiou"));
    assertNull(removeCharsOldSchool(null, "aeiou"));
  }

  String removeCharsOldSchool(String str, String remove) {
    if (remove == null || str == null || remove.isEmpty() || str.isEmpty()) {
      return str;
    }
    StringBuilder sb = new StringBuilder();
    Set<Character> removeMap = new HashSet<>();
    for (char c : remove.toCharArray()) {
      removeMap.add(c);
    }
    for (char c : str.toCharArray()) {
      if (!removeMap.contains(c)) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}

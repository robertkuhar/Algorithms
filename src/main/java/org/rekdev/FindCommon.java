package org.rekdev;

import java.util.*;

/*
 * PROBLEM: Write a function f(a, b) which takes two character string arguments and returns a string
 * containing only the characters found in both strings in the order of a. Write a version which is order
 * N-squared and one which is order N.
 *
 * Reference:  http://j2eecode.blogspot.com/2010/01/google-find-string.html
 */
public class FindCommon {

  public static String fOrderN_Squared(String a, String b) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      for (int j = 0; j < b.length(); j++) {
        if (b.charAt(j) == c && result.toString().indexOf(c) < 0) {
          result.append(c);
        }
      }
    }
    return result.toString();
  }

  public static String fOrderN(String a, String b) {
    StringBuilder result = new StringBuilder();
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, 0);
      }
    }
    for (int i = 0; i < b.length(); i++) {
      char c = b.charAt(i);
      if (map.containsKey(c)) {
        Integer count = map.get(c);
        count++;
        map.put(c, count);
      }
    }
    for (char c : map.keySet()) {
      if (map.get(c) > 0) {
        result.append(c);
      }
    }
    return result.toString();
  }
}

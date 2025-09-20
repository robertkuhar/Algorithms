package org.rekdev;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {

  public static void main(String args[]) {
    System.out.println(permutation("", args[0]));
  }

  static private List<String> permutation(String prefix, String s) {
    checkNotNull(s);
    checkNotNull(prefix);
    List<String> permutations = new ArrayList<String>();
    int n = s.length();
    if (n == 0) {
      /*
       * When there are no letters left, the prefix is a permutation of
       * the original s
       */
      permutations.add(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        /*
         * Pick one character off the front, add it to the prefix, and
         * recursively call permutation with the s without the character
         * at the current position.
         */
        permutations.addAll(
            permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n)));
      }
    }
    return permutations;
  }

  static private void checkNotNull(String s) {
    if (s == null) {
      throw new IllegalArgumentException();
    }
  }
}

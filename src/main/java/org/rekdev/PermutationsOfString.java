package org.rekdev;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {

  /**
   * Generates all permutations of a string.
   *
   * @param prefix The current string being built, initially empty.
   * @param s      The remaining characters to permute.
   * @return A list containing all permutations.
   */
  static public List<String> permutation(String prefix, String s) {
    System.out.printf("permutation( \"%s\", \"%s\" )\n", prefix, s);
    checkNotNull(s);
    checkNotNull(prefix);
    List<String> permutations = new ArrayList<>();
    int n = s.length();
    // Base Case: If the remaining string is empty, the prefix is a completed permutation.
    if (n == 0) {
      permutations.add(prefix);
    } else {
      // Iterate through each character of the input s...
      for (int i = 0; i < n; i++) {
        permutations.addAll(
            /*
             * add the selected character to the prefix and recurse on the remaining characters,
             * excluding the one just selected.
             */
            permutation(
                prefix + s.charAt(i),
                s.substring(0, i) + s.substring(i + 1, n)));
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

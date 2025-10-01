package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HIndex {

  /**
   * 274. H-Index
   * https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
   *
   * <p>
   * Given an array of integers citations where citations[i] is the number of citations a researcher
   * received for their ith paper, return the researcher's h-index.
   * </p>
   * <p>
   * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum
   * value of h such that the given researcher has published at least h papers that have each been
   * cited at least h times.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: citations = [3,0,6,1,5]<br/>
   * Output: 3<br/>
   * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
   * received 3, 0, 6, 1, 5 citations respectively.<br/>
   * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no
   * more than 3 citations each, their h-index is 3.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: citations = [1,3,1]<br/>
   * Output: 1<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - n == citations.length<br/>
   * - 1 <= n <= 5000<br/>
   * - 0 <= citations[i] <= 1000<br/>
   * </p>
   *
   * @param citations - number of citations for a researcher's i'th paper
   * @return max value of h such that a researcher has published h papers that have been cited h
   * times.
   */
  public int hIndex(int[] citations) {
    int maxHIndex = citations.length;
    Arrays.sort(citations);
    for (int i = 0; i < citations.length; i++) {
      int h = maxHIndex - i;
      if (citations[i] >= h) {
        return h;
      }
    }
    return 0;
  }
}

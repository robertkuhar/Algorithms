package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSum {

  /**
   * 373. Find K Pairs with Smallest Sums (Medium)
   * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an
   * integer k.
   * </p>
   * <p>
   * Define a pair (u, v) which consists of one element from the first array and one element from
   * the second array.
   * </p>
   * <p>
   * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3<br/>
   * Output: [[1,2],[1,4],[1,6]]<br/>
   * Explanation: The first 3 pairs are returned from the sequence:<br/>
   * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2<br/>
   * Output: [[1,1],[1,1]]<br/>
   * Explanation: The first 2 pairs are returned from the sequence:<br/>
   * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= nums1.length, nums2.length <= 10^5<br/>
   * - -10^9 <= nums1[i], nums2[i] <= 10^9<br/>
   * - nums1 and nums2 both are sorted in non-decreasing order.<br/>
   * - 1 <= k <= 10^4<br/>
   * - k <= nums1.length * nums2.length
   * </p>
   *
   * @param nums1
   * @param nums2
   * @param k
   * @return
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    class Pair {

      final int nums1Ix;
      final int nums2Ix;

      Pair(int nums1Ix, int nums2Ix)  {
        this.nums1Ix = nums1Ix;
        this.nums2Ix = nums2Ix;
      }
    }

    final List<List<Integer>> results = new ArrayList<>();
    final PriorityQueue<Pair> minHeap = new PriorityQueue<>( (a,b) -> {
      long sumA = (long) nums1[a.nums1Ix] + nums2[a.nums2Ix];
      long sumB = (long) nums1[b.nums1Ix] + nums2[b.nums2Ix];
      return Long.compare(sumA, sumB);
    } );
    // Init the minHeap
    for (int i = 0; i < nums1.length && i < k; i++) {
      minHeap.offer(new Pair(i, 0));
    }
    while (!minHeap.isEmpty() && k > 0) {
      Pair p = minHeap.poll();
      int i = p.nums1Ix;
      int j = p.nums2Ix;
      results.add(List.of(nums1[i], nums2[j]));
      k--;
      // Greedy expansion: Check if we can move to the next element in nums2
      if (j + 1 < nums2.length) {
        minHeap.offer(new Pair(i, j + 1));
      }
    }
    return results;
  }
}
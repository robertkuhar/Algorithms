package org.rekdev.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

  /**
   * 169. Majority Element<br/>
   * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * Given an array nums of size n, return the majority element.<br/>
   * The majority element is the element that appears more than n/2 times. You may assume that the
   * majority element always exists in the array.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: nums = [3,2,3]<br/>
   * Output: 3<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: nums = [2,2,1,1,1,2,2]<br/>
   * Output: 2<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * n == nums.length<br/>
   * 1 <= n <= 5 * 10^4<br/>
   * -10^9 <= nums[i] <= 10^9<br/>
   * </p>
   * <p>
   * Follow-up: Could you solve the problem in linear time and in O(1) space?
   * </p>
   *
   * @param nums input array
   * @return majority element in input array
   */
  public int majorityElement(int[] nums) {
    int majorityElement = 0;
    int count = 0;
    for (int num : nums) {
      if (count == 0) {
        majorityElement = num;
      }
      if (num == majorityElement) {
        count++;
      } else {
        count--;
      }
    }
    return majorityElement;
  }

  public int majorityElementViaMap(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    Map.Entry<Integer, Integer> maxEntry =
        Collections.max(map.entrySet(), Map.Entry.comparingByValue());
    return maxEntry.getKey();
  }
}

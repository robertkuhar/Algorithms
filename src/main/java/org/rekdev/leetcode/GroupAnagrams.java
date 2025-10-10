package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any
 * order.
 * </p>
 * <p>
 * Example 1:<br/>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]<br/>
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]<br/>
 * Explanation:<br/>
 * - There is no string in strs that can be rearranged to form "bat".<br/>
 * - The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.<br/>
 * - The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.<br/>
 * </p>
 * <p>
 * Example 2:<br/>
 * Input: strs = [""]<br/>
 * Output: [[""]]<br/>
 * </p>
 * <p>
 * Example 3:<br/>
 * Input: strs = ["a"]<br/>
 * Output: [["a"]]<br/>
 * </p>
 * <p>
 * Constraints:<br/>
 * - 1 <= strs.length <= 10^4<br/>
 * - 0 <= strs[i].length <= 100<br/>
 * - strs[i] consists of lowercase English letters.<br/>
 * </p>
 */
public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>(List.of(str)));
      } else {
        List<String> list = map.get(key);
        list.add(str);
      }
    }
    return new ArrayList<>(map.values());
  }
}

package org.rekdev.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * <p>
 * Implement the RandomizedSet class:<br/>
 * <br/>
 * - RandomizedSet() Initializes the RandomizedSet object.<br/>
 * - bool insert(int val) Inserts an item val into the set if not present. Returns true if the item
 * was not present, false otherwise.<br/>
 * - bool remove(int val) Removes an item val from the set if present. Returns true if the item was
 * present, false otherwise.<br/>
 * - int getRandom() Returns a random element from the current set of elements (it's guaranteed that
 * at least one element exists when this method is called). Each element must have the same
 * probability of being returned.<br/>
 * - You must implement the functions of the class such that each function works in average O(1)
 * time complexity.<br/>
 * </p>
 * <p>
 * Example 1:<br/>
 * Input: ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert",
 * "getRandom"]<br/>
 * [[], [1], [2], [2], [], [1], [2], []]<br/>
 * Output: [null, true, false, true, 2, true, false, 2]<br/>
 * <br/>
 * Explanation:<br/>
 * <pre>
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * </pre>
 * </p>
 * <p>
 * Constraints:<br/>
 * - -2^31 <= val <= 2^31 - 1
 * - At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
 * - There will be at least one element in the data structure when getRandom is called.
 * </p>
 */
public class RandomizedSet {

  private final List<Integer> list = new ArrayList<>();
  private final Map<Integer, Integer> map = new HashMap<>();
  private final Random random = new Random();

  public RandomizedSet() {
  }

  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }
    map.put(val, list.size());
    list.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }
    /*
     * This moves the last element in the list into the position occupied by the element we are
     * removing which will allow us to grab a random entry from the list.
     */
    int indexToRemove = map.get(val);
    int lastElement = list.getLast();
    list.set(indexToRemove, lastElement);
    map.put(lastElement, indexToRemove);
    list.removeLast();
    map.remove(val);
    return true;
  }

  public int getRandom() {
    int randomIndex = random.nextInt(list.size());
    return list.get(randomIndex);
  }
}

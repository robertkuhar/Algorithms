package org.rekdev.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache (Medium)
 * https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * </p>
 * <p>
 * Implement the LRUCache class:<br/>
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.<br/>
 * - int get(int key) Return the value of the key if the key exists, otherwise return -1.<br/>
 * - void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the
 * key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 * evict the least recently used key.<br/>
 * - The functions get and put must each run in O(1) average time complexity.<br/>
 * </p>
 * <p>
 * Example 1:<br/>
 * <pre>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * </pre>
 * </p>
 * <p>
 * Constraints:<br/>
 * - 1 <= capacity <= 3000<br/>
 * - 0 <= key <= 10^4<br/>
 * - 0 <= value <= 10^5<br/>
 * - At most 2 * 105 calls will be made to get and put.<br/>
 * </p>
 *
 * Insight: A Doubly linked list allows you to keep track of LRU by pushing stuff out when the
 * capacity is reached or breached. Claude helped.
 */
public class LRUCache {

  class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final Node head;
  private final Node tail;
  private final int capacity;
  private Map<Integer, Node> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    /*
     These are 'Sentinel values'. They will never be in the cache but they make the double linked
     list operations null-safe and easy to reason about
     */
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    Node node = cache.get(key);
    remove(node);
    addToFront(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      node.value = value;
      remove(node);
      addToFront(node);
    } else {
      if (cache.size() >= capacity) {
        Node lru = tail.prev; // LRU is always at tail.prev
        remove(lru);
        cache.remove(lru.key);
      }
      Node newNode = new Node(key, value);
      cache.put(key, newNode);
      addToFront(newNode);
    }
  }

  /**
   * Removes the Node from its current position in the double linked list patching up the node's
   * neighbors.
   * @param node Target Node
   */
  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  /**
   * Puts Node right after head, making it "the most recently used".
   * Structure: head <-> node <-> [old first] <-> ... <-> tail
   * @param node Target node
   */
  private void addToFront(Node node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }
}

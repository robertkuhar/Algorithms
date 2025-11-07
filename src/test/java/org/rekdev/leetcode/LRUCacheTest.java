package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 146. LRU Cache (Medium)
 * https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LRUCacheTest {

  @Test
  public void testExample1() {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertThat(cache.get(1)).isEqualTo(1);
    cache.put(3, 3);
    assertThat(cache.get(2)).isEqualTo(-1);
    cache.put(4, 4);
    assertThat(cache.get(1)).isEqualTo(-1);
    assertThat(cache.get(3)).isEqualTo(3);
    assertThat(cache.get(4)).isEqualTo(4);
  }

  @Test
  public void testUpdates() {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertThat(cache.get(1)).isEqualTo(1);
    assertThat(cache.get(2)).isEqualTo(2);
    cache.put(2, 22);
    assertThat(cache.get(2)).isEqualTo(22);
    assertThat(cache.get(1)).isEqualTo(1);
    cache.put(1, 11);
    assertThat(cache.get(1)).isEqualTo(11);
    assertThat(cache.get(2)).isEqualTo(22);
  }
}

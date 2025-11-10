package org.rekdev.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsSubsequenceTest {

  IsSubsequence isSubsequence;

  @BeforeEach
  public void setup() {
    isSubsequence = new IsSubsequence();
  }

  @Test
  public void testExample1() {
    final boolean actual = isSubsequence.isSubsequence("abc", "ahbgdc");
    assertTrue(actual);
  }

  @Test
  public void testExample2() {
    final boolean actual = isSubsequence.isSubsequence("axc", "ahbgdc");
    assertFalse(actual);
  }

  @Test
  public void testQuickout() {
    assertTrue(isSubsequence.isSubsequence("", "ahbgdc"));
  }
} 

package org.rekdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FindCommonTests {

  static class TestData {

    String a;
    String b;
    String expected;

    public TestData(String a, String b, String expected) {
      this.a = a;
      this.b = b;
      this.expected = expected;
    }
  }

  TestData[] testData = {new TestData("abc", "abc", "abc"),
      new TestData("abc", "cab", "abc"), new TestData("abc", "123", ""),
      new TestData("abc", "ac", "ac"), new TestData("abc", "bc", "bc"),
      new TestData("abc", "ab", "ab"), new TestData("abc", "a23", "a"),
      new TestData("aabbcc", "aabbcc", "abc"),
      new TestData("abba", "abc", "ab")};

  @Test
  public void test_fOrderN_Squared() {
    for (TestData test : testData) {
      assertEquals(test.expected, FindCommon.fOrderN_Squared(test.a, test.b));
    }
  }

  @Test
  public void test_fOrderN() {
    for (TestData test : testData) {
      assertEquals(test.expected, FindCommon.fOrderN(test.a, test.b));
    }
  }
}

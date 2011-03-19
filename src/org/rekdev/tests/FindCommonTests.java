package org.rekdev.tests;

import junit.framework.*;

import org.rekdev.*;

public class FindCommonTests extends TestCase {
    class TestData {
        String a;
        String b;
        String expected;

        public TestData(String a, String b, String expected) {
            this.a = a;
            this.b = b;
            this.expected = expected;
        }
    }

    TestData[] testData = { new TestData("abc", "abc", "abc"),
            new TestData("abc", "cab", "abc"), new TestData("abc", "123", ""),
            new TestData("abc", "ac", "ac"), new TestData("abc", "bc", "bc"),
            new TestData("abc", "ab", "ab"), new TestData("abc", "a23", "a"),
            new TestData("aabbcc", "aabbcc", "abc"),
            new TestData("abba", "abc", "ab") };

    public void test_fOrderN_Squared() {
        for (TestData test : testData) {
            assertEquals(test.expected,
                    FindCommon.fOrderN_Squared(test.a, test.b));
        }
    }

    public void test_fOrderN() {
        for (TestData test : testData) {
            assertEquals(test.expected, FindCommon.fOrderN(test.a, test.b));
        }
    }
}

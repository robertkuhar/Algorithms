package org.rekdev.tests;

import org.rekdev.ArrayUtils;

import junit.framework.TestCase;

public class ReverseAnArrayTest extends TestCase {
    public void testReverseInPlace() {
        runTest( new Object[] { "One", "Two", "Three" }, new Object[] { "Three", "Two", "One" } );
        runTest( new Object[] { "One", "Two" }, new Object[] { "Two", "One" } );
        runTest( new Object[] { "One" }, new Object[] { "One" } );
        runTest( new Object[0], new Object[0] );
    }

    private void runTest(Object[] actual, Object[] expected) {
        ArrayUtils.reverseArrayInPlace( actual );
        assertEquals( expected.length, actual.length );
        for( int ix = 0; ix < expected.length; ix++ ) {
            assertEquals( "variance at ix=" + ix, expected[ix], actual[ix] );
        }
    }
}
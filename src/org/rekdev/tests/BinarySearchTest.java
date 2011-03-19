package org.rekdev.tests;

import junit.framework.*;

public class BinarySearchTest extends TestCase {
    public void testBinarySearch() {
        int[] oneThroughTen = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for ( int i = 0; i < oneThroughTen.length; i++ ) {
            int foundIx = binarySearch( oneThroughTen[ i ], oneThroughTen );
            assertEquals( i, foundIx );
        }
        assertEquals( -1, binarySearch( 11, oneThroughTen ) );
    }

    int binarySearch( int target, int[] intArray ) {
        if ( intArray == null ) {
            throw new IllegalArgumentException( "intArray cannot be null" );
        }
        return doBinarySearch( target, 0, intArray.length - 1, intArray );
    }

    private int doBinarySearch( int target, int startIx, int endIx, int[] intArray ) {
        if ( startIx == endIx ) {
            return ( intArray[ startIx ] == target ) ? startIx : -1;
        }
        int midPointIx = ( ( endIx - startIx ) / 2 ) + startIx;
        if ( intArray[ midPointIx ] == target ) {
            return midPointIx;
        } else if ( intArray[ midPointIx ] > target ) {
            return doBinarySearch( target, startIx, midPointIx - 1, intArray );
        } else {
            return doBinarySearch( target, midPointIx + 1, endIx, intArray );
        }
    }
}

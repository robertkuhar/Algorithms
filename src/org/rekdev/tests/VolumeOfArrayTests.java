package org.rekdev.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Summer 2014 interview question: You have an array where each element
 * represents a height. If you pour water over your array, how much water would
 * be trapped by the depressions. Ex. [ 5, 1, 1, 5 ] is 8. [ 1, 2, 1, 2, 1 ] is
 * 1.
 * 
 */
public class VolumeOfArrayTests {
    public int calcCapacity( int[] array ) {
        if ( array == null ) {
            throw new IllegalArgumentException( "Expected not null array" );
        }
        if ( array.length <= 2 ) {
            return 0;
        }
        int totalCapacity = 0;
        for ( int i = 0; i < array.length; i++ ) {
            int leftIx = findBoundIx( array, i, -1 );
            int rightIx = findBoundIx( array, i, 1 );
            if ( leftIx >= 0 && rightIx >= 0 ) {
                int elemCapacity = Math.min( array[leftIx], array[rightIx] ) - array[i];
                totalCapacity += elemCapacity;
            }
        }
        return totalCapacity;
    }

    /**
     * Walk the array in the specified direction searching for the maximum
     * height element. Return its index if you find it, -1 otherwise.
     * 
     * @param array
     * @param candidateIx
     * @param direction
     * @return index of maximum height element relative to candidateIx; -1 if
     *         not found.
     */
    public int findBoundIx( int[] array, int candidateIx, int direction ) {
        int boundIx = -1;
        for ( int i = candidateIx + direction; 0 <= i && i < array.length; i += direction ) {
            if ( boundIx == -1 && array[i] > array[candidateIx] ) {
                boundIx = i;
            } else if ( boundIx >= 0 && array[i] > array[boundIx] ) {
                boundIx = i;
            }
        }
        return boundIx;
    }

    @Test
    public void testOne() {
        int[] a = { 5, 1, 1, 5 };
        int capcity = calcCapacity( a );
        assertEquals( 8, capcity );
    }

    @Test
    public void testTwo() {
        int[] b = { 1, 2, 6, 4, 5, 1, 2, 3, 6, 4 };
        int capcity = calcCapacity( b );
        assertEquals( 15, capcity );
    }

    @Test
    public void testThree() {
        int[] c = { 1, 2, 6, 4, 5, 1, 7, 3, 6, 4 };
        int capcity = calcCapacity( c );
        assertEquals( 11, capcity );
    }

}

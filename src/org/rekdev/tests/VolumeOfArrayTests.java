package org.rekdev.tests;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Summer 2014 interview question: You have an array where each element
 * represents a height. If you pour water over your array, how much water would
 * be trapped by the depressions. Ex. [ 5, 1, 1, 5 ] is 8. [ 1, 2, 1, 2, 1 ] is
 * 1.
 * 
 */
public class VolumeOfArrayTests {
    interface CapacityCalculator {
        int calc( int[] array );
    }

    @Test
    public void testFindMaxesFromHere() {
        /**
         * This implementation considers each element and searches to the left
         * and the right for the boundaries then contributes its value to the
         * total if the boundaries are discovered. The number of times that this
         * solution has to go over each element is uncomfortable.
         */
        CapacityCalculator findMaxesFromHere = new CapacityCalculator() {
            @Override
            public int calc( int[] array ) {
                if ( array == null ) {
                    throw new IllegalArgumentException( "Expected not null array" );
                }
                if ( array.length <= 2 ) {
                    return 0;
                }
                int totalCapacity = 0;
                int leftIx = -1;
                int rightIx = -1;
                for ( int i = 0; i < array.length; i++ ) {
                    // TODO: Can I cache the previous value of leftIx?
                    leftIx = findBoundIx( array, i, -1 );
                    // TODO: Can I cache the previous value of rightIx?
                    rightIx = findBoundIx( array, i, 1 );
                    if ( leftIx >= 0 && rightIx >= 0 ) {
                        int elemCapacity = Math.min( array[leftIx], array[rightIx] ) - array[i];
                        totalCapacity += elemCapacity;
                    }
                }
                return totalCapacity;
            }

            /**
             * Walk the array in the specified direction searching for the
             * maximum height element. Return its index if you find it, -1
             * otherwise.
             * 
             * @param array
             * @param candidateIx
             * @param direction
             * @return index of maximum height element relative to candidateIx;
             *         -1 if not found.
             */
            private int findBoundIx( int[] array, int candidateIx, int direction ) {
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
        };
        testSimple( findMaxesFromHere );
        testHarder( findMaxesFromHere );
        testHarderYet( findMaxesFromHere );
        testEdgeCases( findMaxesFromHere );
    }

    void testIt( int expectedCapacity, int[] array, CapacityCalculator capacityCalculator ) {
        int capcity = capacityCalculator.calc( array );
        assertEquals( expectedCapacity, capcity );
    }

    void testSimple( CapacityCalculator capacityCalculator ) {
        int[] a = { 5, 1, 1, 5 };
        testIt( 8, a, capacityCalculator );
    }

    public void testHarder( CapacityCalculator capacityCalculator ) {
        int[] b = { 1, 2, 6, 4, 5, 1, 2, 3, 6, 4 };
        testIt( 15, b, capacityCalculator );
    }

    private void testHarderYet( CapacityCalculator capacityCalculator ) {
        int[] c = { 3, 2, 6, 4, 5, 1, 4, 3, 5, 4 };
        testIt( 9, c, capacityCalculator );
    }

    public void testEdgeCases( CapacityCalculator capacityCalculator ) {
        int[][] testCases = { { 1, 1, 1 }, { 1, 2, 3 }, { 3, 2, 1 }, { 1, 2, 2, 1 }, { 1 }, {} };
        for ( int i = 0; i < testCases.length; i++ ) {
            int[] testCase = testCases[i];
            int capacity = capacityCalculator.calc( testCase );
            assertEquals( 0, capacity );
        }
    }

}

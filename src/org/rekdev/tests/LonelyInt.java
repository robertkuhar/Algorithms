package org.rekdev.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LonelyInt {
    interface LonelyIntFinder {
        int lonelyInt( int[] array );
    }

    class HashSetImpl implements LonelyIntFinder {
        @Override
        public int lonelyInt( int[] array ) {
            Set<Integer> candidates = new HashSet<Integer>();
            for ( int i : array ) {
                if ( candidates.contains( i ) ) {
                    candidates.remove( i );
                } else {
                    candidates.add( i );
                }
            }
            if ( candidates.size() != 1 ) {
                throw new IllegalStateException( "input array did not match specification" );
            }
            return candidates.iterator()
                    .next()
                    .intValue();
        }

    }

    class XORImpl implements LonelyIntFinder {
        @Override
        public int lonelyInt( int[] array ) {
            int xor = 0;
            for ( int i = 0; i < array.length; i++ ) {
                xor ^= array[i];
            }
            return xor;
        }
    }

    @Test
    public void testHashSetImpl() {
        int[] array = { 1, 2, 3, 4, 3, 2, 1 };
        int lonelyInt = new HashSetImpl().lonelyInt( array );
        assertEquals( 4, lonelyInt );
    }

    @Test
    public void testXORImpl() {
        int[] array = { 1, 2, 3, 4, 3, 2, 1 };
        int lonelyInt = new XORImpl().lonelyInt( array );
        assertEquals( 4, lonelyInt );
    }

}

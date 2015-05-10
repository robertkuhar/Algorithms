package org.rekdev;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HackerRank {
    // org.rekdev.tests.LonelyInt has a better XOR based algorithm
    public static int lonelyInt( int[] array ) {
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

    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String[] splits = s.split( " " );
        int[] array = new int[n];
        int i = 0;
        for ( String split : splits ) {
            if ( i < array.length ) {
                array[i++] = Integer.valueOf( split );
            } else {
                throw new IllegalArgumentException( String.format( "Expected only %d integers", n ) );
            }
        }
        System.out.println( lonelyInt( array ) );
    }
}

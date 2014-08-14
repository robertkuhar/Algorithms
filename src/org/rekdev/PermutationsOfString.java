package org.rekdev;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {
    public static void main( String args[] ) {
        System.out.println( permutation( "", args[0] ) );
    }

    static private List<String> permutation( String prefix, String s ) {
        List<String> permutations = new ArrayList<String>();
        int n = s.length();
        if ( n == 0 ) {
            /*
             * When there are no letters left, the prefix is a permutation of
             * the original s
             */
            permutations.add( prefix );
        } else {
            for ( int i = 0; i < n; i++ ) {
                /*
                 * We're picking one character off the front and adding it to
                 * the prefix and recursively calling permutation with the s
                 * without the character at the current position.
                 */
                permutations.addAll( permutation( prefix + s.charAt( i ), s.substring( 0, i ) + s.substring( i + 1, n ) ) );
            }
        }
        return permutations;
    }
}

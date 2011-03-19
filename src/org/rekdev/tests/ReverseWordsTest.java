package org.rekdev.tests;

import junit.framework.*;

public class ReverseWordsTest extends TestCase {
    public void test_reverseWordsRegex() {
        String candidate = "Do or do not, there is no try.";
        String expected = "try. no is there not, do or Do";

        assertEquals( null, reverseWordsRegex( null ) );
        assertEquals( "", reverseWordsRegex( "" ) );

        assertEquals( expected, reverseWordsRegex( candidate ) );
        assertEquals( "one", reverseWordsRegex( "one" ) );
    }

    String reverseWordsRegex( String str ) {
        if ( str == null || "".equals( str ) ) {
            return str;
        }
        String[] splits = str.split( " " );
        StringBuilder sb = new StringBuilder();
        int i = splits.length - 1;
        while ( i >= 0 ) {
            sb.append( splits[ i ] );
            i--;
            if ( i >= 0 ) {
                sb.append( " " );
            }
        }
        return sb.toString();
    }
}

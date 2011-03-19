package org.rekdev.tests;

import java.util.*;

import junit.framework.TestCase;

public class RemoveCharsTest extends TestCase {
    public void test_removeCharsRegEx() {
        String candidate = "Battle of the Vowels:  Hawaii vs. Grozny";
        String expected = "Bttl f th Vwls:  Hw vs. Grzny";
        assertEquals( expected, removeCharsRegEx( candidate, "aeiou" ) );

        assertEquals( candidate, removeCharsRegEx( candidate, "" ) );
        assertEquals( candidate, removeCharsRegEx( candidate, null ) );

        assertEquals( "", removeCharsRegEx( "", "aeiou" ) );
        assertEquals( null, removeCharsRegEx( null, "aeiou" ) );
    }

    String removeCharsRegEx( String str, String remove ) {
        if ( remove == null || str == null || "".equals( remove ) || "".equals( str ) ) {
            return str;
        }
        String result = str.replaceAll( "[" + remove + "]", "" );
        return result;
    }

    public void test_removeCharsOldSchool() {
        String candidate = "Battle of the Vowels:  Hawaii vs. Grozny";
        String expected = "Bttl f th Vwls:  Hw vs. Grzny";
        assertEquals( expected, removeCharsOldSchool( candidate, "aeiou" ) );

        assertEquals( candidate, removeCharsOldSchool( candidate, "" ) );
        assertEquals( candidate, removeCharsOldSchool( candidate, null ) );

        assertEquals( "", removeCharsOldSchool( "", "aeiou" ) );
        assertEquals( null, removeCharsOldSchool( null, "aeiou" ) );
    }

    String removeCharsOldSchool( String str, String remove ) {
        if ( remove == null || str == null || "".equals( remove ) || "".equals( str ) ) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Set<Character> removeMap = new HashSet<Character>();
        for ( char c : remove.toCharArray() ) {
            removeMap.add( c );
        }
        for ( char c : str.toCharArray() ) {
            if ( !removeMap.contains( c ) ) {
                sb.append( c );
            }
        }
        return sb.toString();
    }
}

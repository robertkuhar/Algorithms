package org.rekdev.tests;

import junit.framework.TestCase;

public class StringToIntTest extends TestCase {
    public void test_integerToString() {
        assertEquals( "1", intToString( 1 ) );
        assertEquals( "10", intToString( 10 ) );
        assertEquals( "7890", intToString( 7890 ) );
        assertEquals( "-10", intToString( -10 ) );
        assertEquals( "-125690", intToString( -125690 ) );
    }

    String intToString( int i ) {
        String result = "";
        boolean isNegative = ( i < 0 );
        i = Math.abs( i );
        while ( i != 0 ) {
            int digit = i % 10;
            i = i / 10;
            result = ( "" + digit ) + result;
        }
        if ( isNegative ) {
            result = "-" + result;
        }
        return result;
    }

    public void test_stringToInteger() {
        assertEquals( 1, stringToInt_RtoL( "1" ) );
        assertEquals( 10, stringToInt_RtoL( "10" ) );
        assertEquals( 7890, stringToInt_RtoL( "7890" ) );
        assertEquals( -10, stringToInt_RtoL( "-10" ) );
        assertEquals( -125690, stringToInt_RtoL( "-125690" ) );

        assertEquals( 1, stringToInt_LtoR( "1" ) );
        assertEquals( 10, stringToInt_LtoR( "10" ) );
        assertEquals( 7890, stringToInt_LtoR( "7890" ) );
        assertEquals( -10, stringToInt_LtoR( "-10" ) );
        assertEquals( -125690, stringToInt_LtoR( "-125690" ) );
    }

    int stringToInt_RtoL( String str ) {
        if ( str == null || "".equals( str ) ) {
            throw new IllegalArgumentException( "s cannot be null or empty" );
        }
        int result = 0;
        int powerOfTen = 1;
        char[] chars = str.toCharArray();
        int ix = chars.length - 1;
        while ( ix >= 0 ) {
            if ( ix == 0 && ( chars[ix] == '-' ) ) {
                result = -result;
            } else {
                result += ( ( chars[ix] - '0' ) * powerOfTen );
                powerOfTen *= 10;
            }
            ix--;
        }
        return result;
    }

    int stringToInt_LtoR( String str ) {
        if ( str == null || "".equals( str ) ) {
            throw new IllegalArgumentException( "s cannot be null or empty" );
        }
        int result = 0;
        char[] chars = str.toCharArray();
        int signMultiplier = 1;
        for ( int ix = 0; ix < chars.length; ix++ ) {
            if ( ix == 0 && ( chars[ix] == '-' ) ) {
                signMultiplier = -1;
            } else {
                result *= 10;
                result += ( chars[ix] - '0' );
            }
        }
        return result * signMultiplier;
    }

}
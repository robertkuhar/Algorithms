package org.rekdev.tests;

import org.rekdev.MyString;

import junit.framework.TestCase;

public class MyStringTest extends TestCase {

    /*
     * Test method for 'org.rekdev.MyString.charAt(int)'
     */
    public void testCharAt() {
        char[] c = new char[] { '0', '1', '2' };
        MyString ms = new MyString( c );
        assertEquals( '0', ms.charAt( 0 ) );
        assertEquals( '1', ms.charAt( 1 ) );
        assertEquals( '2', ms.charAt( 2 ) );
        c[0] = 'a';
        c[1] = 'b';
        c[2] = 'c';
        assertEquals( '0', ms.charAt( 0 ) );
        assertEquals( '1', ms.charAt( 1 ) );
        assertEquals( '2', ms.charAt( 2 ) );
    }

    /*
     * Test method for 'org.rekdev.MyString.equals(Object)'
     */
    public void testEqualsContract() {
        MyString aaa0 = new MyString( new char[] { 'a', 'a', 'a' } );
        MyString aaa1 = new MyString( new char[] { 'a', 'a', 'a' } );
        assertEquals( aaa0, aaa1 );
        int aaa0Hash = aaa0.hashCode();
        int aaa1Hash = aaa1.hashCode();
        assertEquals( aaa0Hash, aaa1Hash );

        assertEquals( aaa0, aaa1 );
        MyString aab0 = new MyString( new char[] { 'a', 'a', 'b' } );
        assertFalse( aaa0.equals( aab0 ) );
        int aab0Hash = aab0.hashCode();
        assertFalse( aaa0Hash == aab0Hash );
    }

    /*
     * Test method for 'org.rekdev.MyString.indexOf(char[])'
     */
    public void testIndexOf() {
        char[] c = new char[] { 'a', 'a', 'b', 'a', 'a', 'c', 'a', 'b' };
        MyString ms = new MyString( c );

        char[] t1 = new char[] { 'a', 'a' };
        int indexOfT1 = ms.indexOf( t1 );
        assertEquals( 0, indexOfT1 );

        char[] t2 = new char[] { 'a', 'b', 'a' };
        int indexOfT2 = ms.indexOf( t2 );
        assertEquals( 1, indexOfT2 );

    }

}

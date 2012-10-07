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

    class IndexOfTest {
        final char[] target;
        final int expectIx;

        IndexOfTest( char[] target, int expectedIx ) {
            this.target = target;
            this.expectIx = expectedIx;
        }
    }

    /*
     * Test method for 'org.rekdev.MyString.indexOf(char[])'
     */
    public void testIndexOf() {
        char[] c = new char[] { 'a', 'a', 'b', 'a', 'a', 'c', 'a', 'b' };
        MyString ms = new MyString( c );

        IndexOfTest[] tests = {
                new IndexOfTest( new char[] { 'z' }, -1 ),
                new IndexOfTest( new char[] { 'a', 'a' }, 0 ),
                new IndexOfTest( new char[] { 'a', 'b', 'a' }, 1 ),
                new IndexOfTest( new char[] { 'a', 'a', 'c' }, 3 ) };
        for ( IndexOfTest test : tests ) {
            int indexOf = ms.indexOf( test.target );
            assertEquals( test.expectIx, indexOf );
        }
    }

}

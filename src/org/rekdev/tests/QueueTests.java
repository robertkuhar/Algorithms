package org.rekdev.tests;

import org.rekdev.Queue;

import junit.framework.TestCase;

public class QueueTests extends TestCase {
    public void testOneInOneOut() {
        Queue<String> queue = new Queue<String>();
        String s0 = "S0";

        assertTrue( "expected queue.isEmpty()", queue.isEmpty() );
        queue.enqueue( s0 );
        assertFalse( "expected queue.isEmpty() == false", queue.isEmpty() );
        String expect = s0;
        String actual = queue.dequeue();
        assertEquals( expect, actual );
        assertTrue( "expected queue.isEmpty()", queue.isEmpty() );
    }

    public void testTwoInTwoOut() {
        Queue<String> queue = new Queue<String>();
        String s0 = "S0";
        String s1 = "S1";

        assertTrue( "expected queue.isEmpty()", queue.isEmpty() );
        queue.enqueue( s0 );
        queue.enqueue( s1 );
        assertFalse( "expected queue.isEmpty() == false", queue.isEmpty() );
        String expect = s0;
        String actual = queue.dequeue();
        assertEquals( expect, actual );
        assertFalse( "expected queue.isEmpty() == false", queue.isEmpty() );
        expect = s1;
        actual = queue.dequeue();
        assertEquals( expect, actual );
        assertTrue( "expected queue.isEmpty()", queue.isEmpty() );
    }

    public void testTwoInOneOutOneInTwoOut() {
        Queue<String> queue = new Queue<String>();

        String s0 = "S0";
        String s1 = "S1";
        String s2 = "S2";

        assertTrue( "expected queue.isEmpty()", queue.isEmpty() );
        // Two in...
        queue.enqueue( s0 );
        queue.enqueue( s1 );

        // One out...
        String expect = s0;
        String actual = queue.dequeue();
        assertEquals( expect, actual );

        // One in...
        queue.enqueue( s2 );

        // Two out...
        expect = s1;
        actual = queue.dequeue();
        assertEquals( expect, actual );

        expect = s2;
        actual = queue.dequeue();
        assertEquals( expect, actual );
        assertTrue( "expected queue.isEmpty()", queue.isEmpty() );
    }

}

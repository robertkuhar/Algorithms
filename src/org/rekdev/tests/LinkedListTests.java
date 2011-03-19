package org.rekdev.tests;

import java.util.Iterator;

import org.rekdev.lists.ListElement;
import org.rekdev.lists.SinglyLinkedList;

import junit.framework.TestCase;

public class LinkedListTests extends TestCase {
    public void testHasCycleNoCycle() {
        ListElement<String> root = new ListElement<String>( "A" );
        root.setNext( new ListElement<String>( "B" ) );
        assertTrue( "no cycle", root.hasCycle() == false );
    }

    public void testHasCycleCycle() {
        ListElement<String> a = new ListElement<String>( "A" );
        ListElement<String> b = new ListElement<String>( "B" );
        ListElement<String> c = new ListElement<String>( "C" );
        a.setNext( b );
        b.setNext( c );
        c.setNext( a );
        assertTrue( "expected a.hasCycle()", a.hasCycle() );
        assertTrue( "expected b.hasCycle()", b.hasCycle() );
        assertTrue( "expected c.hasCycle()", c.hasCycle() );

        ListElement<String> d = new ListElement<String>( "D" );
        c.setNext( d );
        assertFalse( "expected !a.hasCycle()", a.hasCycle() );
        d.setNext( b );
        assertTrue( "expected a.hasCycle()", a.hasCycle() );
        d.setNext( null );
        assertFalse( "expected !a.hasCycle()", a.hasCycle() );
    }

    public void testSinglyLinkedList() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();

        assertNull( "getFirst should be null", linkedList.getFirst() );
        assertNull( "getLast should be null", linkedList.getLast() );

        String[] abc = { "A", "B", "C", "D" };
        for ( String s : abc ) {
            linkedList.add( s );
        }

        assertEquals( abc[ 0 ], linkedList.getFirst() );
        assertEquals( abc[ 3 ], linkedList.getLast() );
        for ( int i = 0; i < abc.length; i++ ) {
            assertEquals( abc[ i ], linkedList.getAt( i ) );
        }
        int i = 0;
        for ( Iterator<String> it = linkedList.iterator(); it.hasNext(); ) {
            assertEquals( abc[ i ], it.next() );
            if ( i % 2 == 0 ) {
                it.remove();
            }
            i++;
        }
        assertEquals( abc[ 1 ], linkedList.getFirst() );
        assertEquals( abc[ 1 ], linkedList.getAt( 0 ) );
        assertEquals( abc[ 3 ], linkedList.getLast() );
        assertEquals( abc[ 3 ], linkedList.getAt( 1 ) );

        linkedList.addFirst( "A" );
        assertEquals( "A", linkedList.getFirst() );
        assertEquals( "B", linkedList.getAt( 1 ) );
        linkedList.insertAt( linkedList.findIndexOf( "D" ), "C" );
        assertEquals( "C", linkedList.getAt( 2 ) );
        assertEquals( "D", linkedList.getAt( 3 ) );
        assertEquals( "D", linkedList.getLast() );
        linkedList.addLast( "E" );
        assertEquals( "E", linkedList.getLast() );

        String[] expected = { "A", "B", "C", "D", "E" };
        i = 0;
        for ( String s : linkedList ) {
            assertEquals( expected[ i++ ], s );
        }

    }
}

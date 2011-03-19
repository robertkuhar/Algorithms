package org.rekdev.lists;

import java.util.Iterator;


public class SinglyLinkedList<T> implements Iterable<T> {
    private ListElement<T> head = null;
    private ListElement<T> tail = null;

    public SinglyLinkedList() {
    }

    public T getFirst() {
        return ( head != null ) ? head.getPayload() : null;
    }

    public T getLast() {
        return ( tail != null ) ? tail.getPayload() : null;
    }

    public T getAt( int ix ) {
        ListElement<T> elemAtIx = getElementAt( ix );
        return ( elemAtIx != null ) ? elemAtIx.getPayload() : null;
    }

    private ListElement<T> getElementAt( int ix ) {
        if ( ix < 0 ) {
            throw new IllegalArgumentException( "ix must be postive" );
        }
        int i = 0;
        ListElement<T> elemAtIx = head;
        while ( elemAtIx != null ) {
            if ( i == ix ) {
                return elemAtIx;
            }
            i++;
            elemAtIx = elemAtIx.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public void addFirst( T obj ) {
        ListElement<T> e = new ListElement<T>( obj );
        if ( head == null ) {
            head = tail = e;
        } else {
            e.setNext( head );
            head = e;
        }
    }

    public void add( T obj ) {
        if ( head == null ) {
            addFirst( obj );
        } else {
            ListElement<T> e = new ListElement<T>( obj );
            tail.setNext( e );
            tail = e;
        }
    }

    public void addLast( T obj ) {
        add( obj );
    }

    public void insertAt( int ix, T obj ) {
        if ( ix < 0 ) {
            throw new IllegalArgumentException( "ix must be postive" );
        }
        int i = 0;
        ListElement<T> elemAtIx = head;
        ListElement<T> elemAtIxMinusOne = null;
        while ( elemAtIx != null && i < ix ) {
            i++;
            elemAtIxMinusOne = elemAtIx;
            elemAtIx = elemAtIx.getNext();
        }
        if ( elemAtIx == null || i != ix ) {
            throw new IndexOutOfBoundsException();
        }
        ListElement<T> candidate = new ListElement<T>( obj, elemAtIx );
        if ( elemAtIxMinusOne != null ) {
            elemAtIxMinusOne.setNext( candidate );
        } else {
            head = candidate;
        }
    }

    public T removeAt( int ix ) {
        ListElement<T> elementAt = getElementAt( ix );
        if ( elementAt == head && elementAt == tail ) {
            head = null;
            tail = null;
        } else if ( elementAt == head ) {
            head = elementAt.getNext();
        } else if ( elementAt == tail ) {
            ListElement<T> elementPrev = getElementAt( ix - 1 );
            tail = elementPrev;
            elementPrev.setNext( null );
        } else {
            ListElement<T> elementPrev = getElementAt( ix - 1 );
            elementPrev.setNext( elementAt.getNext() );
        }
        return ( elementAt != null ) ? elementAt.getPayload() : null;
    }

    public boolean remove( T obj ) {
        int ix = findIndexOf( obj );
        if ( ix >= 0 ) {
            removeAt( ix );
            return true;
        }
        return false;
    }

    public int findIndexOf( T obj ) {
        int i = 0;
        for ( T t : this ) {
            if ( t != null && t.equals( obj ) ) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public T find( T obj ) {
        int ix = findIndexOf( obj );
        return ( ix >= 0 ) ? getAt( ix ) : null;
    }

    @Override
    public Iterator<T> iterator() {
        return new SinglyLinkedListIterator<T>( this );
    }

    public static class SinglyLinkedListIterator<T> implements Iterator<T> {
        private final SinglyLinkedList<T> singlyLinkedList;
        private ListElement<T> next;
        private int currIx;

        public SinglyLinkedListIterator( SinglyLinkedList<T> singlyLinkedList ) {
            this.singlyLinkedList = singlyLinkedList;
            next = this.singlyLinkedList.head;
            currIx = -1;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T t = next.getPayload();
            next = next.getNext();
            currIx++;
            return t;
        }

        @Override
        public void remove() {
            if ( currIx >= 0 ) {
                singlyLinkedList.removeAt( currIx );
                currIx--;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}

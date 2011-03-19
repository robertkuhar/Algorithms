package org.rekdev.lists;

public class ListElement<T> {
    private T payload = null;
    private ListElement<T> next = null;

    public ListElement( T payload, ListElement<T> next ) {
        this.payload = payload;
        this.next = next;
    }

    public ListElement( T payload ) {
        this( payload, null );
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload( T payload ) {
        this.payload = payload;
    }

    public ListElement<T> getNext() {
        return next;
    }

    public void setNext( ListElement<T> next ) {
        this.next = next;
    }

    /**
     * Analyzes the linked list returning true if a cycle is detected.
     * 
     * @return true if list traversal results in a cycle; false otherwise
     */
    public boolean hasCycle() {
        boolean hasCycle = false;
        ListElement<T> slow = this;
        ListElement<T> fast = this;
        int i = 0;
        while ( !hasCycle && fast != null ) {
            i++;
            fast = fast.next;
            if ( i % 2 == 0 ) {
                slow = slow.next;
            }
            hasCycle = ( slow == fast );
        }
        return hasCycle;
    }

}

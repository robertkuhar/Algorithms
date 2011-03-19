package org.rekdev;

import java.util.Stack;

/**
 * Using only a Stack this class implements a Queue. Interview question from
 * Redfin.
 * 
 * @author robertkuhar
 * 
 * @param <T>
 */
public class Queue< T > {
    Stack< T> stackIn = new Stack< T>();
    Stack< T> stackOut = new Stack< T>();

    public void enqueue( T o ) {
        this.stackIn.push( o );
    }

    public T dequeue() {
        if ( this.stackOut.isEmpty() ) {
            // Reverse the stackIn into the stackOut...
            while ( this.stackIn.isEmpty() == false ) {
                this.stackOut.push( this.stackIn.pop() );
            }
        }
        T o = this.stackOut.pop();
        return o;
    }

    public boolean isEmpty() {
        boolean empty = ( this.stackIn.isEmpty() && this.stackOut.isEmpty() );
        return empty;
    }
}

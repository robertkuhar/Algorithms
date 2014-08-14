package org.rekdev.tests;

import org.rekdev.graph.GraphNode;

import junit.framework.TestCase;

public class GraphNodeSearchTests extends TestCase {
    private static final GraphNode<String> A = new GraphNode<String>( "A" );
    private static final GraphNode<String> B = new GraphNode<String>( "B" );
    private static final GraphNode<String> C = new GraphNode<String>( "C" );
    private static final GraphNode<String> D = new GraphNode<String>( "D" );
    private static final GraphNode<String> E = new GraphNode<String>( "E" );
    private static final GraphNode<String> F = new GraphNode<String>( "F" );
    private static final GraphNode<String> G = new GraphNode<String>( "G" );

    static {
        A.addChild( B );
        A.addChild( C );
        A.addChild( E );

        B.addChild( D );
        B.addChild( F );

        C.addChild( G );

        E.addChild( F );
    }

    public void testNonRecursiveDepthFirstSearch() {
        GraphNode<String> found = A.dfsNonRecursive( G.getValue() );
        assertNotNull( found );
        assertEquals( G, found );
        found = A.dfsNonRecursive( "Bob" );
        assertNull( found );

    }

    public void testRecursiveDepthFirstSearch() {
        GraphNode<String> found = A.dfsRecursive( G.getValue() );
        assertNotNull( found );
        assertEquals( G, found );
        found = A.dfsRecursive( "Bob" );
        assertNull( found );
    }

    public void testNonRecursiveBredthFirstSearch() {
        GraphNode<String> found = A.bfsNonRecursive( G.getValue() );
        assertNotNull( found );
        assertEquals( G, found );
        found = A.bfsNonRecursive( "Bob" );
        assertNull( found );
    }
}

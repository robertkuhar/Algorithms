package org.rekdev.tests;

import org.rekdev.trees.TreeNode;

import junit.framework.TestCase;

public class TreeNodeSearchTests extends TestCase {
    private static final TreeNode<String> A = new TreeNode<String>( "A" );
    private static final TreeNode<String> B = new TreeNode<String>( "B" );
    private static final TreeNode<String> C = new TreeNode<String>( "C" );
    private static final TreeNode<String> D = new TreeNode<String>( "D" );
    private static final TreeNode<String> E = new TreeNode<String>( "E" );
    private static final TreeNode<String> F = new TreeNode<String>( "F" );
    private static final TreeNode<String> G = new TreeNode<String>( "G" );

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
        TreeNode<String> found = A.dfsNonRecursive( G.getValue() );
        assertNotNull( found );
        assertEquals( G, found );
        found = A.dfsNonRecursive( "Bob" );
        assertNull( found );

    }

    public void testRecursiveDepthFirstSearch() {
        TreeNode<String> found = A.dfsRecursive( G.getValue() );
        assertNotNull( found );
        assertEquals( G, found );
        found = A.dfsRecursive( "Bob" );
        assertNull( found );
    }

    public void testNonRecursiveBredthFirstSearch() {
        TreeNode<String> found = A.bfsNonRecursive( G.getValue() );
        assertNotNull( found );
        assertEquals( G, found );
        found = A.bfsNonRecursive( "Bob" );
        assertNull( found );
    }
}

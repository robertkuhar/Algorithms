package org.rekdev.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphNode<T> {
    private final T value;
    private List<GraphNode<T>> children;

    public GraphNode( T value, List<GraphNode<T>> children ) {
        this.value = value;
        this.children = new ArrayList<GraphNode<T>>();
        for ( GraphNode<T> child : children ) {
            this.children.add( child );
        }
    }

    public GraphNode( T value ) {
        this( value, new ArrayList<GraphNode<T>>() );
    }

    public List<GraphNode<T>> getChildren() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    public void addChild( GraphNode<T> child ) {
        this.children.add( child );
    }

    public void removeChild( GraphNode<T> child ) {
        this.children.remove( child );
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String[] s = this.getClass()
                .getName()
                .split( "\\." );
        sb.append( s[s.length - 1] );
        sb.append( "(" );
        sb.append( this.getValue() );
        sb.append( ", " );
        sb.append( this.children );
        sb.append( ")" );
        return sb.toString();
    }

    /**
     * This method performs a NonRecursive Depth First Search for a Node equal
     * to target.
     * 
     * @param target
     * @return TreeNode<T> matching target; null if not found.
     */
    public GraphNode<T> dfsNonRecursive( T target ) {
        Stack<GraphNode<T>> stack = new Stack<GraphNode<T>>();
        Map<GraphNode<T>, GraphNode<T>> visited = new HashMap<GraphNode<T>, GraphNode<T>>();
        stack.push( this );
        while ( !stack.empty() ) {
            GraphNode<T> candidate = (GraphNode<T>) stack.pop();
            if ( target.equals( candidate.getValue() ) ) {
                return candidate;
            }
            visited.put( candidate, candidate );
            for ( GraphNode<T> child : candidate.getChildren() ) {
                if ( visited.get( child ) == null ) {
                    stack.push( child );
                }
            }
        }
        return null;
    }

    public GraphNode<T> dfsRecursive( T target ) {
        return dfsRecursive( target, this, new HashSet<GraphNode<T>>() );
    }

    /**
     * This method performs a Recursive Depth First Search for a Node equal to
     * target.
     * 
     * @param target node
     * @param current node
     * @param visited visited nodes
     * @return TreeNode<T> matching target; null if not found.
     */
    private GraphNode<T> dfsRecursive( T target, GraphNode<T> node, Set<GraphNode<T>> visited ) {
        visited.add( node );
        if ( target.equals( node.getValue() ) ) {
            return node;
        }
        for ( GraphNode<T> child : node.getChildren() ) {
            if ( !visited.contains( child ) ) {
                GraphNode<T> targetNode = dfsRecursive( target, child, visited );
                if ( targetNode != null ) {
                    return targetNode;
                }
            }
        }
        return null;
    }

    /**
     * This method performs a NonRecursive Breadth First Search for a Node equal
     * to target.
     * 
     * @param target
     * @return TreeNode<T> matching target; null if not found.
     */
    public GraphNode<T> bfsNonRecursive( T target ) {
        List<GraphNode<T>> queue = new ArrayList<GraphNode<T>>();
        Map<GraphNode<T>, GraphNode<T>> visited = new HashMap<GraphNode<T>, GraphNode<T>>();
        queue.add( this );
        while ( !queue.isEmpty() ) {
            GraphNode<T> candidate = (GraphNode<T>) queue.remove( 0 );
            if ( target.equals( candidate.getValue() ) ) {
                return candidate;
            }
            visited.put( candidate, candidate );
            for ( GraphNode<T> child : candidate.getChildren() ) {
                if ( visited.get( child ) == null ) {
                    queue.add( child );
                }
            }
        }
        return null;
    }

}

package org.rekdev.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TreeNode<T> {
    private final T value;
    private List<TreeNode<T>> children;

    public TreeNode( T value, List<TreeNode<T>> children ) {
        this.value = value;
        this.children = new ArrayList<TreeNode<T>>();
        for ( TreeNode<T> child : children ) {
            this.children.add( child );
        }
    }

    public TreeNode( T value ) {
        this( value, new ArrayList<TreeNode<T>>() );
    }

    public List<TreeNode<T>> getChildren() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    public void addChild( TreeNode<T> child ) {
        this.children.add( child );
    }

    public void removeChild( TreeNode<T> child ) {
        this.children.remove( child );
    }

    public boolean equals( Object o ) {
        if ( o instanceof TreeNode<?> == false ) {
            return false;
        }
        TreeNode<?> that = (TreeNode<?>) o;
        if ( this.getValue().equals( that.getValue() ) == false ) {
            return false;
        }
        if ( this.getChildren().equals( that.getChildren() ) == false ) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.value.hashCode();
        hashCode += this.children.hashCode();
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String[] s = this.getClass().getName().split( "\\." );
        sb.append( s[ s.length - 1 ] );
        sb.append( "(" );
        sb.append( this.getValue() );
        sb.append( ", " );
        sb.append( this.children );
        sb.append( ")" );
        return sb.toString();
    }

    /**
     * This method performs a NonRecursive Depth First Search for a Node equal to target.
     * 
     * @param target
     * @return TreeNode<T> matching target; null if not found.
     */
    public TreeNode<T> dfsNonRecursive( T target ) {
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        Map<TreeNode<T>, TreeNode<T>> visited = new HashMap<TreeNode<T>, TreeNode<T>>();
        stack.push( this );
        while ( !stack.empty() ) {
            TreeNode<T> candidate = (TreeNode<T>) stack.pop();
            if ( target.equals( candidate.getValue() ) ) {
                return candidate;
            }
            visited.put( candidate, candidate );
            for ( TreeNode<T> child : candidate.getChildren() ) {
                if ( visited.get( child ) == null ) {
                    stack.push( child );
                }
            }
        }
        return null;
    }

    /**
     * This method performs a Recursive Depth First Search for a Node equal to target.
     * 
     * @param target
     * @return TreeNode<T> matching target; null if not found.
     */
    public TreeNode<T> dfsRecursive( T target ) {
        return dfsRecursive( target, this, new HashMap<TreeNode<T>, TreeNode<T>>() );
    }

    /**
     * This method performs a Recursive Depth First Search for a Node equal to target.
     * 
     * @param target
     * @param visited
     * @return TreeNode<T> matching target; null if not found.
     */
    private TreeNode<T> dfsRecursive( T target, TreeNode<T> node, Map<TreeNode<T>, TreeNode<T>> visited ) {
        visited.put( node, node );
        if ( target.equals( node.getValue() ) ) {
            return node;
        }
        for ( TreeNode<T> child : node.getChildren() ) {
            if ( visited.get( child ) == null ) {
                TreeNode<T> targetNode = dfsRecursive( target, child, visited );
                if ( targetNode != null ) {
                    return targetNode;
                }
            }
        }
        return null;
    }

    /**
     * This method performs a NonRecursive Bredth First Search for a Node equal to target.
     * 
     * @param target
     * @param node
     * @return TreeNode<T> matching target; null if not found.
     */
    public TreeNode<T> bfsNonRecursive( T target ) {
        List<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
        Map<TreeNode<T>, TreeNode<T>> visited = new HashMap<TreeNode<T>, TreeNode<T>>();
        queue.add( this );
        while ( !queue.isEmpty() ) {
            TreeNode<T> candidate = (TreeNode<T>) queue.remove( 0 );
            if ( target.equals( candidate.getValue() ) ) {
                return candidate;
            }
            visited.put( candidate, candidate );
            for ( TreeNode<T> child : candidate.getChildren() ) {
                if ( visited.get( child ) == null ) {
                    queue.add( child );
                }
            }
        }
        return null;
    }

}

package org.rekdev.trees;

public class BinarySearchTree<T extends Comparable<T>> {

  private BinaryTreeNode<T> root;

  public BinarySearchTree(T rootValue) {
    if (rootValue != null) {
      root = new BinaryTreeNode<>(rootValue);
    }
  }

  // Helper interface, now moved outside the node class
  public static interface Operation<T extends Comparable<T>> {

    void execute(BinaryTreeNode<T> t);
  }

  /**
   * Inserts a new value into the Binary Search Tree.
   *
   * @param newValue The value to insert.
   */
  public void insert(T newValue) {
    if (root == null) {
      root = new BinaryTreeNode<>(newValue);
    } else {
      insertRecursive(root, newValue);
    }
  }

  private BinaryTreeNode<T> insertRecursive(BinaryTreeNode<T> current, T newValue) {
    if (current == null) {
      return new BinaryTreeNode<>(newValue);
    }

    if (newValue.compareTo(current.getValue()) < 0) {
      current.setLeft(insertRecursive(current.getLeft(), newValue));
    } else if (newValue.compareTo(current.getValue()) > 0) {
      current.setRight(insertRecursive(current.getRight(), newValue));
    }
    return current; // Value already exists, return current node
  }

  public void preorderTraversal(Operation<T> operation) {
    preorderTraversalRecursive(root, operation);
  }

  private void preorderTraversalRecursive(BinaryTreeNode<T> node, Operation<T> operation) {
    if (node != null) {
      operation.execute(node);
      preorderTraversalRecursive(node.getLeft(), operation);
      preorderTraversalRecursive(node.getRight(), operation);
    }
  }

  public void inorderTraversal(Operation<T> operation) {
    inorderTraversalRecursive(root, operation);
  }

  private void inorderTraversalRecursive(BinaryTreeNode<T> node, Operation<T> operation) {
    if (node.getLeft() != null) {
      inorderTraversalRecursive(node.getLeft(), operation);
    }
    operation.execute(node);
    if (node.getRight() != null) {
      inorderTraversalRecursive(node.getRight(), operation);
    }
  }

  public void postorderTraversal(Operation<T> operation) {
    postorderTraversalRecursive(root, operation);
  }

  private void postorderTraversalRecursive(BinaryTreeNode<T> node, Operation<T> operation) {
    if (node.getLeft() != null) {
      postorderTraversalRecursive(node.getLeft(), operation);
    }
    if (node.getRight() != null) {
      postorderTraversalRecursive(node.getRight(), operation);
    }
    operation.execute(node);
  }

  public BinaryTreeNode<T> findNode(T t) {
    return findNodeRecursive(root, t);
  }

  // Note: This findNode logic is for a Binary SEARCH Tree, not a generic Binary Tree
  private BinaryTreeNode<T> findNodeRecursive(BinaryTreeNode<T> node, T t) {
    if (node == null) {
      return null;
    }
    if (node.getValue().equals(t)) {
      return node;
    } else if (node.getValue().compareTo(t) < 0) {
      return findNodeRecursive(node.getRight(), t);
    } else {
      return findNodeRecursive(node.getLeft(), t);
    }
  }
}
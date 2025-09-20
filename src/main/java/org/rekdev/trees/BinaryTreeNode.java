package org.rekdev.trees;

import java.util.Stack;

public class BinaryTreeNode<T extends Comparable<T>> {

  private T value;
  private BinaryTreeNode<T> left = null;
  private BinaryTreeNode<T> right = null;

  public BinaryTreeNode(T value) {
    setValue(value);
  }

  private void setValue(T value) {
    if (value == null) {
      throw new IllegalArgumentException("value cannot be null!");
    }
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  protected void setLeft(BinaryTreeNode<T> left) {
    this.left = left;
  }

  public BinaryTreeNode<T> getLeft() {
    return left;
  }

  protected void setRight(BinaryTreeNode<T> right) {
    this.right = right;
  }

  public BinaryTreeNode<T> getRight() {
    return right;
  }

  public BinaryTreeNode<T> findNode(T t) {
    if (value.equals(t)) {
      return this;
    } else if (value.compareTo(t) < 0 && right != null) {
      return right.findNode(t);
    } else if (left != null) {
      return left.findNode(t);
    }
    return null;
  }

  public static interface Operation {

    void execute(BinaryTreeNode<?> t);
  }

  public void preorderTraversalRecursive(Operation operation) {
    operation.execute(this);
    if (left != null) {
      left.preorderTraversalRecursive(operation);
    }
    if (right != null) {
      right.preorderTraversalRecursive(operation);
    }
  }

  public void preorderTraversalIterative(Operation operation) {
    Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
    stack.push(this);
    for (BinaryTreeNode<T> btNode = stack.pop(); btNode != null; btNode = stack.pop()) {
      operation.execute(btNode);
      if (btNode.right != null) {
        stack.push(btNode.right);
      }
      if (btNode.left != null) {
        stack.push(btNode.left);
      }
    }
  }

  public void inorderTraversalRecursive(Operation operation) {
    if (left != null) {
      left.inorderTraversalRecursive(operation);
    }
    operation.execute(this);
    if (right != null) {
      right.inorderTraversalRecursive(operation);
    }
  }

  public void postorderTraversalRecursive(Operation operation) {
    if (left != null) {
      left.postorderTraversalRecursive(operation);
    }
    if (right != null) {
      right.postorderTraversalRecursive(operation);
    }
    operation.execute(this);
  }

}

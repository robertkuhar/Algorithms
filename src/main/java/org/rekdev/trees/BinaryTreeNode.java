package org.rekdev.trees;

import lombok.Data;
import lombok.NonNull;

@Data
public class BinaryTreeNode<T extends Comparable<T>> {

  @NonNull
  private final T value;
  private BinaryTreeNode<T> left = null;
  private BinaryTreeNode<T> right = null;
}

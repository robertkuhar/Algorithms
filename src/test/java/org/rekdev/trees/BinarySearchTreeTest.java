package org.rekdev.trees;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

  // Helper class to collect node values during traversal
  static class StringCollector implements BinarySearchTree.Operation<String> {
    private final StringBuilder builder = new StringBuilder();

    @Override
    public void execute(BinaryTreeNode<String> node) {
      builder.append(node.getValue());
    }

    public String getResult() {
      return builder.toString();
    }
  }

  // Helper class to collect nodes during traversal
  static class NodeCollector<T extends Comparable<T>> implements BinarySearchTree.Operation<T> {
    private final List<BinaryTreeNode<T>> nodes = new ArrayList<>();

    @Override
    public void execute(BinaryTreeNode<T> node) {
      nodes.add(node);
    }

    public List<BinaryTreeNode<T>> getNodes() {
      return nodes;
    }
  }

  private BinarySearchTree<Integer> createTestTree() {
    // Creates this tree for testing:
    //       5
    //      / \
    //     3   7
    //    / \ / \
    //   2  4 6  8

    BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);
    tree.insert(3);
    tree.insert(7);
    tree.insert(2);
    tree.insert(4);
    tree.insert(6);
    tree.insert(8);
    return tree;
  }

  // --- Tests for findNode method ---
  @Test
  void findNode_returnsNodeWhenValueExists() {
    BinarySearchTree<Integer> tree = createTestTree();
    assertThat(tree.findNode(4)).isNotNull();
    assertThat(tree.findNode(4).getValue()).isEqualTo(4);
  }

  @Test
  void findNode_returnsRootWhenValueExists() {
    BinarySearchTree<Integer> tree = createTestTree();
    assertThat(tree.findNode(5)).isNotNull();
    assertThat(tree.findNode(5).getValue()).isEqualTo(5);
  }

  @Test
  void findNode_returnsNullWhenValueDoesNotExist() {
    BinarySearchTree<Integer> tree = createTestTree();
    assertThat(tree.findNode(1)).isNull();
  }

  @Test
  void findNode_returnsNullWhenTreeIsEmpty() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTree<>(null);
    assertThat(emptyTree.findNode(100)).isNull();
  }

  // --- Tests for insert method ---
  @Test
  void insert_addsNodeToTree() {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>(10);
    tree.insert(5);
    tree.insert(15);

    assertThat(tree.findNode(5)).isNotNull();
    assertThat(tree.findNode(15)).isNotNull();
    assertThat(tree.findNode(20)).isNull();
  }

  // --- Tests for Traversal methods ---
  @Test
  void inorderTraversal_visitsNodesInSortedOrder() {
    BinarySearchTree<Integer> tree = createTestTree();
    List<Integer> values = new ArrayList<>();
    tree.inorderTraversal(node -> values.add(node.getValue()));

    assertThat(values).containsExactly(2, 3, 4, 5, 6, 7, 8);
  }

  @Test
  void preorderTraversal_visitsNodesInCorrectOrder() {
    BinarySearchTree<Integer> tree = createTestTree();
    List<Integer> values = new ArrayList<>();
    tree.preorderTraversal(node -> values.add(node.getValue()));

    assertThat(values).containsExactly(5, 3, 2, 4, 7, 6, 8);
  }

  @Test
  void postorderTraversal_visitsNodesInCorrectOrder() {
    BinarySearchTree<Integer> tree = createTestTree();
    List<Integer> values = new ArrayList<>();
    tree.postorderTraversal(node -> values.add(node.getValue()));

    assertThat(values).containsExactly(2, 4, 3, 6, 8, 7, 5);
  }

  @Test
  void canUseStringOperationOnStringTree() {
    BinarySearchTree<String> tree = new BinarySearchTree<>("M");
    tree.insert("E");
    tree.insert("T");
    tree.insert("A");
    tree.insert("H");

    StringCollector collector = new StringCollector();
    tree.preorderTraversal(collector);

    assertThat(collector.getResult()).isEqualTo("MEAHT");
  }
}
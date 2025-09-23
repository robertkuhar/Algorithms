package org.rekdev.graph;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GraphNodeTest {

  // Helper method to build a common graph for testing traversals
  // This graph contains a cycle to ensure the visited set works correctly.
  //      A
  //     / \
  //    B -- C
  //   / \
  //  D - E
  private GraphNode<String> buildSampleGraph() {
    GraphNode<String> a = new GraphNode<>("A");
    GraphNode<String> b = new GraphNode<>("B");
    GraphNode<String> c = new GraphNode<>("C");
    GraphNode<String> d = new GraphNode<>("D");
    GraphNode<String> e = new GraphNode<>("E");

    a.addChild(b);
    a.addChild(c);

    b.addChild(d);
    b.addChild(e);
    b.addChild(c); // Creates a cycle

    c.addChild(b); // Creates a cycle
    d.addChild(e); // Creates a cycle

    return a;
  }

  // --- Tests for basic functionality ---
  @Test
  void graphNode_initializesWithValueAndChildren() {
    GraphNode<String> a = new GraphNode<>("A");
    GraphNode<String> b = new GraphNode<>("B");
    GraphNode<String> c = new GraphNode<>("C");
    a.addChild(b);
    a.addChild(c);

    assertThat(a.getValue()).isEqualTo("A");
    assertThat(a.getChildren()).containsExactly(b, c);
  }

  @Test
  void addChild_addsChildToNode() {
    GraphNode<String> parent = new GraphNode<>("Parent");
    GraphNode<String> child = new GraphNode<>("Child");
    parent.addChild(child);

    assertThat(parent.getChildren()).hasSize(1);
    assertThat(parent.getChildren().getFirst()).isEqualTo(child);
  }

  @Test
  void removeChild_removesChildFromNode() {
    GraphNode<String> parent = new GraphNode<>("Parent");
    GraphNode<String> child = new GraphNode<>("Child");
    parent.addChild(child);
    parent.removeChild(child);

    assertThat(parent.getChildren()).isEmpty();
  }

  @Test
  void toString_returnsCorrectStringRepresentation() {
    GraphNode<String> node = new GraphNode<>("Node", new ArrayList<>());
    assertThat(node.toString()).isEqualTo("GraphNode(Node, [])");
  }

  // --- Tests for DFS Traversal ---
  @Test
  void dfsNonRecursive_findsExistingNode() {
    GraphNode<String> graph = buildSampleGraph();
    GraphNode<String> foundNode = graph.dfsNonRecursive("E");

    assertThat(foundNode).isNotNull();
    assertThat(foundNode.getValue()).isEqualTo("E");
  }

  @Test
  void dfsNonRecursive_returnsNullForNonExistentNode() {
    GraphNode<String> graph = buildSampleGraph();
    GraphNode<String> foundNode = graph.dfsNonRecursive("Z");

    assertThat(foundNode).isNull();
  }

  @Test
  void dfsRecursive_findsExistingNode() {
    GraphNode<String> graph = buildSampleGraph();
    GraphNode<String> foundNode = graph.dfsRecursive("E");

    assertThat(foundNode).isNotNull();
    assertThat(foundNode.getValue()).isEqualTo("E");
  }

  @Test
  void dfsRecursive_returnsNullForNonExistentNode() {
    GraphNode<String> graph = buildSampleGraph();
    GraphNode<String> foundNode = graph.dfsRecursive("Z");

    assertThat(foundNode).isNull();
  }

  // --- Tests for BFS Traversal ---
  @Test
  void bfsNonRecursive_findsExistingNode() {
    GraphNode<String> graph = buildSampleGraph();
    GraphNode<String> foundNode = graph.bfsNonRecursive("D");

    assertThat(foundNode).isNotNull();
    assertThat(foundNode.getValue()).isEqualTo("D");
  }

  @Test
  void bfsNonRecursive_returnsNullForNonExistentNode() {
    GraphNode<String> graph = buildSampleGraph();
    GraphNode<String> foundNode = graph.bfsNonRecursive("X");

    assertThat(foundNode).isNull();
  }

  @Test
  void searchOnEmptyGraph_returnsNull() {
    GraphNode<String> graph = new GraphNode<>("Root");
    assertThat(graph.dfsNonRecursive("A")).isNull();
    assertThat(graph.dfsRecursive("B")).isNull();
    assertThat(graph.bfsNonRecursive("C")).isNull();
  }

  @Test
  void searchOnRootNode_returnsRoot() {
    GraphNode<String> root = new GraphNode<>("Root");
    assertThat(root.dfsNonRecursive("Root")).isEqualTo(root);
    assertThat(root.dfsRecursive("Root")).isEqualTo(root);
    assertThat(root.bfsNonRecursive("Root")).isEqualTo(root);
  }
}
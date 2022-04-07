package class00_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    public int value;
    public List<Node> nexts;

    public Node(int value) {
        this.value = value;
        this.nexts = new ArrayList<>();
    }

    public static Node generateNode(){
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node.nexts.addAll(Arrays.asList(node1, node2, node3));

        node1.nexts.add(node);

        node2.nexts.add(node4);

        node3.nexts.add(node5);
        return node;
    }
}

package class00_20220404;

import class00_20220402.BinaryTree;
import class00_20220402.Node;
import class13.Code03_lowestAncestor;

import java.util.HashMap;
import java.util.HashSet;

public class BinaryTree_CommonParent {
    public static class Info{
        public boolean existedA;
        public boolean existedB;
        public Node target;

        public Info(boolean existedA, boolean existedB, Node t) {
            this.existedA = existedA;
            this.existedB = existedB;
            this.target = t;
        }
    }

    public static Node get(Node head, Node a, Node b){
        if(a == null || b == null){
            return null;
        }
        return process(head, a, b).target;
    }

    public static Info process(Node x, Node a, Node b){
        if(x == null){
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);

        boolean existedA = false;
        boolean existedB = false;
        Node target = null;
        if(leftInfo.target != null){
            target = leftInfo.target;
        }
        if(rightInfo.target != null){
            target = rightInfo.target;
        }

        if(leftInfo.existedA || rightInfo.existedA || x == a) existedA = true;
        if(leftInfo.existedB || rightInfo.existedB || x == b) existedB = true;
        if(existedA && existedB && leftInfo.target == null && rightInfo.target == null) target = x;


        return new Info(existedA, existedB, target);
    }

    public static Node lowestAncestor1(Node head, Node o1, Node o2) {
        if (head == null) {
            return null;
        }
        // key的父节点是value
        HashMap<Node, Node> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);
        HashSet<Node> o1Set = new HashSet<>();
        Node cur = o1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    public static void fillParentMap(Node head, HashMap<Node, Node> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }

    public static class NodeInfo{
        public Node head;
        public Node a;
        public Node b;

        public NodeInfo(Node head, Node a, Node b) {
            this.head = head;
            this.a = a;
            this.b = b;
        }
    }

    public static NodeInfo generateRandomNode(int maxLayer, int maxValue){
        NodeInfo nodeInfo = new NodeInfo(null, null, null);
        generateRandomNode(1, maxLayer, maxValue, nodeInfo);
        if(nodeInfo.a == null){
            nodeInfo.a = nodeInfo.head;
        }
        if(nodeInfo.b == null){
            nodeInfo.b = nodeInfo.head;
        }
        return nodeInfo;
    }

    public static Node generateRandomNode(int level, int maxLayer, int maxValue, NodeInfo nodeInfo){
        if(level > maxLayer || Math.random() > 0.5){
            return null;
        }

        Node head = new Node((int)(maxValue * Math.random()));
        if(Math.random() < 0.5 && nodeInfo.a == null){
            nodeInfo.a = head;
        }
        if(Math.random() < 0.5 && nodeInfo.b == null){
            nodeInfo.b = head;
        }
        head.left = generateRandomNode(level + 1, maxLayer, maxValue, nodeInfo);
        head.right = generateRandomNode(level + 1, maxLayer, maxValue, nodeInfo);
        nodeInfo.head = head;
        return head;
    }

    public static void main(String[] args) {
        int times = 100000;
        while(times -- > 0){
            NodeInfo nodeInfo = generateRandomNode(6, 100);
            Node myNode = get(nodeInfo.head, nodeInfo.a, nodeInfo.b);
            Node yourNode = lowestAncestor1(nodeInfo.head, nodeInfo.a, nodeInfo.b);

            if(nodeInfo.a != null && nodeInfo.b != null && myNode.value != nodeInfo.a.value && myNode.value != nodeInfo.b.value) {
                System.out.println((nodeInfo.a == null ? null : nodeInfo.a.value) + "  " + (nodeInfo.b == null ? null : nodeInfo.b.value));
                System.out.println((myNode == null ? myNode : myNode.value) + "  " + (yourNode == null ? yourNode : yourNode.value));
                System.out.println("------------------");
            }
            if(myNode != yourNode){
                System.out.println("Oops !");
                System.out.println(nodeInfo.a.value + "  " + nodeInfo.b.value);
                System.out.println((myNode==null? myNode : myNode.value) + "  " + (yourNode == null ? yourNode : yourNode.value));
                BinaryTree.printTree(nodeInfo.head);
                return;
            }
        }
        System.out.println("Success !!");
    }
}

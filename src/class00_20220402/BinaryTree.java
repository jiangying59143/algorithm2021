package class00_20220402;

import java.util.LinkedList;

public class BinaryTree {
    public static void print(Node head){
        if(head == null){
            return;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(head);
        while(!list.isEmpty()){
            Node node = list.poll();
            System.out.print(node.value + " ");
            if(node.left != null) list.add(node.left);
            if(node.right != null) list.add(node.right);
        }
    }

    public static void generateRandomTree(int level, int maxValue){
        Node head = new Node((int)(maxValue*Math.random()));

    }
}

package class00_20220402;

import java.util.*;

public class BinaryTree {
    public static void print(Node head){
        if(head == null){
            return;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(head);
        Node curEndNode = head;
        Node nextEndNode = null;
        int layer = 0;
        Map<Integer, String> printList = new LinkedHashMap<>();
        while(!list.isEmpty()){
            Node node = list.poll();
            String value = String.valueOf(node.value);
            if(value.length() == 1) value = value + " ";
            printList.put(layer, printList.containsKey(layer) ? printList.get(layer) + " " + value :"" + value);
            if(node.left != null) {
                list.add(node.left);
                nextEndNode = node.left;
            }
            if(node.right != null){
                list.add(node.right);
                nextEndNode = node.right;
            }
            if(curEndNode == node){
                layer ++;
                curEndNode = nextEndNode;
            }
        }

        for (Map.Entry<Integer, String> integerStringEntry : printList.entrySet()) {
            for (int i = 0; i < Math.pow(2, printList.size()-integerStringEntry.getKey()-1)+1; i++) {
                System.out.print("  ");
            }
            System.out.println(integerStringEntry.getValue());
        }
    }


    public static Node generateRandomNode(int level, int maxValue){
        Node head = new Node((int)(maxValue*Math.random()));
        if(level == 0) return head;
        head.left = generateRandomNode(level-1, maxValue);
        head.right = generateRandomNode(level-1, maxValue);
        return head;
    }

    public static void main(String[] args) {
//        PrintBT.printTree(generateRandomNode(5, 100));
        print(generateRandomNode(3, 100));
    }
}

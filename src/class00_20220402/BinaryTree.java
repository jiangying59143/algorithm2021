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
            for (int i = 0; i < printList.get(printList.size()-1).length()/2 - integerStringEntry.getValue().length() /2; i++) {
                System.out.print(" ");
            }
            System.out.println(integerStringEntry.getValue());
        }
    }

    public static void printTree(Node head){
        PrintBT.printTree(head);
    }


    public static Node generateRandomNode(int maxLayer, int maxValue){
        return generateRandomNode(1, maxLayer, maxValue);
    }

    public static Node generateRandomNode(int level, int maxLayer, int maxValue){
        if(level > maxLayer || Math.random() > 0.5){
            return null;
        }

        Node head = new Node((int)(maxValue * Math.random()));
        head.left = generateRandomNode(level + 1, maxLayer, maxValue);
        head.right = generateRandomNode(level + 1, maxLayer, maxValue);
        return head;
    }

    public static void main(String[] args) {
        printTree(generateRandomNode(5, 100));
//        print(generateRandomNode(3, 100));
    }
}

package class00_20220402;

import java.util.ArrayList;

public class BinaryTree_isSearch {
    public static class Info{
        public boolean isBST;
        public int max;
        public int min;
        public Info(boolean isB, int max, int min){
            this.isBST = isB;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isBST(Node head){
        if(head == null){
            return false;
        }
        return process(head).isBST;
    }

    public Info process(Node node){
        if(node == null){
            return null;
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int min = node.value, max = node.value;
        boolean isBST = false;
        if(leftInfo != null){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            isBST = leftInfo.isBST && leftInfo.min < node.value;
        }
        if(rightInfo != null){
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            isBST = rightInfo.isBST && rightInfo.max > node.value;
        }

        return new Info(isBST, min, max);
    }

    public static boolean isBST1(Node head) {
        if (head == null) {
            return true;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static void main(String[] args) {
        int times = 10000;
        while(times-- > 0){
            Node head = BinaryTree.generateRandomNode(5, 100);
            BinaryTree_isSearch binaryTree_isSearch = new BinaryTree_isSearch();
            if(binaryTree_isSearch.isBST(head) != isBST1(head)){
                System.out.println("Oops!");
                BinaryTree.printTree(head);
                return;
            }
        }
        System.out.println("success !");
    }
}

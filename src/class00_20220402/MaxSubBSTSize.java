package class00_20220402;

import class12.Code05_MaxSubBSTSize;

import java.util.ArrayList;

public class MaxSubBSTSize {
    public static class Info{
        public int maxSubBSTSize;
        public boolean isBST;
        public int max;
        public int min;

        public Info(int nodeSize, boolean isBST, Integer max, Integer min) {
            this.maxSubBSTSize = nodeSize;
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static int getSize(Node head){
        if(head == null){
            return 0;
        }
        return process(head).maxSubBSTSize;
    }

    public static Info process(Node node){
        if(node == null){
            return null;
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int min = node.value;
        int max = node.value;
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;

        if(leftInfo != null){
            min = Math.min(leftInfo.min, min);
            max = Math.max(leftInfo.max, max);
            leftMax = Math.max(leftInfo.max, leftMax);
        }
        if(rightInfo != null){
            min = Math.min(rightInfo.min, min);
            max = Math.max(rightInfo.max, max);
            rightMin = Math.min(rightMin, rightInfo.min);
        }

        boolean leftIsBST = leftInfo == null ? true : leftInfo.isBST;
        boolean rightIsBST = rightInfo == null ? true : rightInfo.isBST;

        int leftMaxSubBSTSize = leftInfo == null ? 0 : leftInfo.maxSubBSTSize;
        int rightMaxSubBSTSize = rightInfo == null ? 0 : rightInfo.maxSubBSTSize;
        int maxSubBSTSize = leftIsBST && rightIsBST && leftMax < node.value && node.value < rightMin  ? leftMaxSubBSTSize+rightMaxSubBSTSize+1 :  0;

        boolean isBST = leftIsBST && rightIsBST && leftMax < node.value && node.value < rightMin   ? true : false;

        return new Info(Math.max(Math.max(leftMaxSubBSTSize, rightMaxSubBSTSize), maxSubBSTSize),isBST, max, min);
    }

    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static int maxSubBSTSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
    }

    private static Node generateMyNode(){
        Node head = new Node(45);
        head.left = new Node(10);
        head.left.left = new Node(25);
        head.left.right = new Node(3);
        head.left.left.right = new Node(79);
        return head;
    }

    public static void main(String[] args) {
        int times = 10000;
        while(times -- > 0){
            Node head = BinaryTree.generateRandomNode(8, 100);
            int compareSize = maxSubBSTSize1(head);
            int mySize = getSize(head);
            if(compareSize != mySize){
                System.out.println("Oops!");
                System.out.println(compareSize);
                System.out.println(mySize);
                BinaryTree.printTree(head);
                return;
            }
        }
        System.out.println("Success !!");
    }
}

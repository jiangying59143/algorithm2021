package class00_20220402;

import class12.Code04_IsFull;

public class IsFull {
    public static class Info{
        public int height;
        public int nodeSize;

        public Info(int h, int n){
            height=h;
            nodeSize=n;
        }
    }

    public static boolean isFull(Node head){
        if(head == null){
            return true;
        }
        Info info = process(head);
        return (1<<info.height)-1 == info.nodeSize;
    }

    public static Info process(Node node){
        if(node == null){
            return new Info(0, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodeSize = leftInfo.nodeSize + rightInfo.nodeSize + 1;
        return new Info(height, nodeSize);
    }

    public static class Info2 {
        public boolean isFull;
        public int height;

        public Info2(boolean f, int h) {
            isFull = f;
            height = h;
        }
    }

    public static Info2 process2(Node h) {
        if (h == null) {
            return new Info2(true, 0);
        }
        Info2 leftInfo = process2(h.left);
        Info2 rightInfo = process2(h.right);
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info2(isFull, height);
    }

    public static boolean isFull2(Node head) {
        if (head == null) {
            return true;
        }
        return process2(head).isFull;
    }

    public static void main(String[] args) {
        int times = 10000;
        while(times -- > 0){
            Node head = BinaryTree.generateRandomNode(5, 100);
            if(IsFull.isFull(head) != IsFull.isFull2(head)){
                System.out.println("Oops!");
                BinaryTree.printTree(head);
                return;
            }
        }
        System.out.println("success !");
    }
}

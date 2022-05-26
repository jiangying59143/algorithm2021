package class00_review;

import java.util.LinkedList;

public class BinaryTreeTraversal {
    static class BinaryTreeNode {
        public int val;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }
    public static BinaryTreeNode getSample(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        return root;
    }

    // 递归序推导出来
    public static void recursionOrder(BinaryTreeNode node, int order){
        if(node == null){
            return;
        }
        if(0 == order){
            System.out.print(node.val + " ");
        }
        recursionOrder(node.left, order);
        if(1 == order){
            System.out.print(node.val + " ");
        }
        recursionOrder(node.right, order);
        if(2 == order){
            System.out.print(node.val + " ");
        }
    }

    public static void preOrder(BinaryTreeNode node){
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        stack.push(node);
        while(!stack.isEmpty()){
            BinaryTreeNode n = stack.pop();
            System.out.print(n.val + " ");
            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
        }
    }

    public static void inOrder(BinaryTreeNode node){
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        stack.push(node);
        while(!stack.isEmpty()){
            BinaryTreeNode n = stack.pop();
            System.out.print(n.val + " ");
            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode treeNode = getSample();
        System.out.println("------preOrder--------");
        recursionOrder(treeNode, 0);
        System.out.println();
        System.out.println("------inOrder--------");
        recursionOrder(treeNode, 1);
        System.out.println();
        System.out.println("------posOrder--------");
        recursionOrder(treeNode, 2);
        System.out.println();

        System.out.println("------preOrder stack--------");
        preOrder(treeNode);
        System.out.println();
    }

}

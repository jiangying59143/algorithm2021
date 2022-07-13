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

    public static BinaryTreeNode generateTree(int n){
        if(n <= 0){
            return null;
        }
        BinaryTreeNode[] nodes = new BinaryTreeNode[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new BinaryTreeNode(i+1);
        }

        int index = 0;
        while(index < n){
            if(2*index + 1 < n) nodes[index].left = nodes[2*index + 1];
            if(2*index + 2 < n) nodes[index].right = nodes[2*index + 2];
            index ++;
        }
        return nodes[0];
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
        if(node == null){
            return;
        }
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || node != null){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    // 先序遍历压栈，后出栈
    public static void posOrder(BinaryTreeNode node){
        LinkedList<BinaryTreeNode> preStack = new LinkedList<>();
        LinkedList<BinaryTreeNode> posStack = new LinkedList<>();
        preStack.push(node);
        BinaryTreeNode cur;
        while(!preStack.isEmpty()){
            cur = preStack.pop();
            posStack.push(cur);
            if(cur.left != null){
                preStack.push(cur.left);
            }
            if(cur.right != null){
                preStack.push(cur.right);
            }
        }

        while(!posStack.isEmpty()){
            System.out.print(posStack.pop().val + " ");
        }
    }

    public static void posOrder2(BinaryTreeNode head){
        LinkedList<BinaryTreeNode> posStack = new LinkedList<>();
        BinaryTreeNode prePopNode = head;
        posStack.push(prePopNode);
        while(!posStack.isEmpty()){
            BinaryTreeNode cur = posStack.peek();
            if(cur.left != null && cur.left != prePopNode && cur.right != prePopNode){
                posStack.push(cur.left);
            }else if(cur.right != null && cur.right != prePopNode){
                posStack.push(cur.right);
            }else{
                System.out.print(posStack.pop().val + " ");
                prePopNode = cur;
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

        System.out.println("------inOrder stack--------");
        inOrder(treeNode);
        System.out.println();

        System.out.println("------posOrder stack--------");
        posOrder(treeNode);
        System.out.println();

        System.out.println("------posOrder stack2--------");
        posOrder2(treeNode);
        System.out.println();
    }

}

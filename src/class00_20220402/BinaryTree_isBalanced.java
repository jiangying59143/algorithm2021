package class00_20220402;

public class BinaryTree_isBalanced {
    public static class TreeInfo{
        public boolean isBalanced;
        public int height;

        public TreeInfo(boolean isB, int h){
            isBalanced = isB;
            height = h;
        }
    }

    public boolean isBalanced(Node head){
        return process(head).isBalanced;
    }

    public TreeInfo process(Node node){
        if(node == null){
            return new TreeInfo(true, 0);
        }
        TreeInfo leftTreeInfo = process(node.left);
        TreeInfo rightTreeInfo = process(node.right);

        int height = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
        boolean isBalanced = leftTreeInfo.isBalanced && rightTreeInfo.isBalanced && Math.abs(leftTreeInfo.height-rightTreeInfo.height) <= 1;

        return new TreeInfo(isBalanced, height);
    }

    public static void main(String[] args) {
        BinaryTree_isBalanced binaryTree_isBalanced = new BinaryTree_isBalanced();
        Node treeHead = BinaryTree.generateRandomNode(3, 100);
        System.out.println(binaryTree_isBalanced.isBalanced(treeHead));
        System.out.println(binaryTree_isBalanced.isBalanced(null));
        PrintBT.printTree(treeHead);
    }
}

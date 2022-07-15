package class00_review;

import java.util.LinkedList;

public class BinaryMaxWidth {
    public static void levalTraversal(BinaryTreeTraversal.BinaryTreeNode node){
        if(node == null){
            return;
        }
        LinkedList<BinaryTreeTraversal.BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static int maxWidth(BinaryTreeTraversal.BinaryTreeNode node){
        if(node == null){
            return 0;
        }
        LinkedList<BinaryTreeTraversal.BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        int width = 1;
        int levelWidthCur = 0;
        BinaryTreeTraversal.BinaryTreeNode lastLevelNode = node;
        BinaryTreeTraversal.BinaryTreeNode cur = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                cur = node.left;
                levelWidthCur++;
            }
            if(node.right != null){
                queue.add(node.right);
                cur = node.right;
                levelWidthCur ++ ;
            }
            if(lastLevelNode == node){
                width = Math.max(width, levelWidthCur);
                lastLevelNode = cur;
                levelWidthCur = 0;
            }
        }
        return width;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal.BinaryTreeNode head = BinaryTreeTraversal.generateTree((int)Math.pow(2, 4)-5);
        levalTraversal(head);

        System.out.println(maxWidth(head));
    }
}

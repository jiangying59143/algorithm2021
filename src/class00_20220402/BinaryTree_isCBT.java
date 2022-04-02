package class00_20220402;

import java.util.LinkedList;

/**
 * 1. 层序遍历
 * 2. 只有右子树的不是完全二叉树
 */
public class BinaryTree_isCBT {
    public boolean isCBT(Node head){
        if(head == null){
            return false;
        }
        return layerTraversal(head);
    }

    public boolean layerTraversal(Node head){

        LinkedList<Node> queue = new LinkedList<>();

        queue.offer(head);

        boolean isLeaf = false;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(isLeaf && (node.left != null || node.right != null)
                    || node.left == null && node.right != null){
                return false;
            }
            if(node.left != null)queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            if(node.left == null && node.right == null){
                isLeaf = true;
            }
        }
        return true;
    }
}

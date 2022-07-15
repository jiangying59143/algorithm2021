package class00_20220402;

import java.util.LinkedList;

/**
 * 1. 层序遍历
 * 2. 只有右子树的不是完全二叉树
 */
public class BinaryTree_isCBT {
    public boolean isCBT1(Node head){
        if(head == null){
            return false;
        }
        return layerTraversal1(head);
    }

    public boolean layerTraversal1(Node head){

        LinkedList<Node> queue = new LinkedList<>();

        queue.offer(head);

        boolean isLeaf = false;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            /**
             * **o*****|***o*******
             * o***o***|**o**o*****
             *o**o*****|o*o*o*o****
             */
            if(isLeaf && (node.left != null || node.right != null)
//                    node.right != null 应该涵盖了下面的条件
//                    || node.left == null && node.right != null
                    ){
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

    public boolean isCBT2(Node head){
        if(head == null){
            return false;
        }
        return layerTraversal2(head);
    }

    public boolean layerTraversal2(Node head){

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

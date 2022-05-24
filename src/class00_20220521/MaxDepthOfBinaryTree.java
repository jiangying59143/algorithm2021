package class00_20220521;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepthOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getTreeHeight(root.left)-getTreeHeight(root.right)) == 1;
    }

    public int getTreeHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = 1+ getTreeHeight(node.left);
        int rightHeight = 1 + getTreeHeight(node.right);
        return Math.max(leftHeight, rightHeight);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while(2*i+1 < nums.length){
            TreeNode cur = queue.poll();
            cur.left = new TreeNode(nums[2*i+1]);
            queue.add(cur.left);
            if(2*i+2 < nums.length){
                cur.right = new TreeNode(nums[2*i+2]);
                queue.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        if(root.left != null) {
            leftDepth = 1 + minDepth(root.left);
        }
        int rightDepth = Integer.MAX_VALUE;
        if(root.right != null) {
            rightDepth = 1 + minDepth(root.right);
        }
        return Math.min(leftDepth, rightDepth);
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int ans = 0;
            while(!queue.isEmpty()){
                TreeNode tn = queue.poll();
                if(queue.isEmpty()){
                    ans++;
                    if(tn != null) {
                        queue.add(tn.left);
                        queue.add(tn.right);
                    }
                }
            }
            return ans;
        }
    }

    public static int hammingWeight(int n) {
        int ans = 0;
        for(; n != 0; n>>>=1){
            if((n & 1) == 1){
                ans++;
            }
        }
        return ans;
    }

    public static int hammingWeight1(int n) {
        int ans = 0;
        for(; n != 0; n>>>=1){
            if((n & 1) == 1){
                ans++;
            }
        }
        return ans;
    }

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 1; i <= 32; i++, n>>=1) {
            if((n & 1) == 1){
                int base = 1;
                for (int j = 1; j <= 32-i; j++) {
                    base <<= 1;
                }
                ans = ans | base;
            }
        }
        return ans;
    }

    public static int reverseBits1(int n) {
        int ans = 0;
        for (int i = 31; i >=0 && n !=0; i--, n>>=1) {
            if((n & 1) == 1){
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int n = Integer.parseInt("00110011001100110011001100110011",2);
//        System.out.println(n);
//        System.out.println(Integer.toBinaryString(reverseBits2(n)));
        System.out.println(titleToNumber("AAA"));
    }

    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public static int reverseBits2(int n) {
        System.out.println();
        n = n >>> 1 & M1 | (n & M1) << 1;
        System.out.println(Integer.toBinaryString(n));
        n = n >>> 2 & M2 | (n & M2) << 2;
        System.out.println(Integer.toBinaryString(n));
        n = n >>> 4 & M4 | (n & M4) << 4;
        System.out.println(Integer.toBinaryString(n));
        n = n >>> 8 & M8 | (n & M8) << 8;
        System.out.println(Integer.toBinaryString(n));
        return n >>> 16 | n << 16;
    }

    public static int titleToNumber(String columnTitle) {
        if(columnTitle == null || columnTitle.length() == 0 ){
            return -1;
        }
        char[] chars = columnTitle.toCharArray();
        int ans = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            ans += (chars[i]-'A'+1) *Math.pow(26, chars.length-1-i);
        }
        return ans;
    }

}

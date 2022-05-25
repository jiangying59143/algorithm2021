package class00MyStudy;
import java.util.Arrays;
import java.util.PriorityQueue;

public class A_Test {

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[j]<arr[minIndex] ? j : minIndex;
            }
            if(i == minIndex) continue;
            swap(arr, i, minIndex);
        }
    }

    public static void BubbleSort(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        testTrieTree();
//        System.out.println(RadixSort.maxBits(1100));
//        System.out.println(RadixSort.getDigit(10, 2));

        // heap head test
//        System.out.println(1/2);
//        System.out.println(-1/2);
//        System.out.println(-2/2);
//        System.out.println(-3/2);

//        HeapSort.MyComparator myComparator = new HeapSort.MyComparator();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(myComparator);
//        int arr[] = new int[]{1053158911, 581749897, -1142222509, -1159249366, -1180721091};
//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(1053158911 - -1180721091);

//        int arr[] = new int[]{5, 4, -4, -5,-8};
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println( Integer.MIN_VALUE < arr[i] && Integer.MAX_VALUE > arr[i]);
//            priorityQueue.add(arr[i]);
//        }
//        int size = priorityQueue.size();
//        while(size -- > 0){
//            System.out.println(priorityQueue.poll());
//        }

        System.out.println(climbStairs1(45));
        System.out.println(climbStairs2(45));
    }

    public static int climbStairs1(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int base1 = 1;
        int base2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = base1 + base2;
            base1 = base2;
            base2 = sum;
        }
        return sum;
    }

    public static int climbStairs2(int n) {
        if(n <= 2) return n;
        int[][] matrix = new int[][]{{1,1},{1,0}};

        int[][] resMatrix = new int[][]{{1,0},{0,1}};
        int power = n - 2;
        for (;power !=0; power >>= 1) {
            if((power & 1) == 1){
                resMatrix = multiMatrix(matrix, resMatrix);
            }
            matrix = multiMatrix(matrix, matrix);
        }
        return 2*resMatrix[0][0] + 1* resMatrix[1][0];
    }

    public static int[][] multiMatrix(int[][] matrix, int[][] matrix2){
        int a = matrix[0][0] * matrix2[0][0] + matrix[0][1] * matrix2[1][0];
        int b = matrix[0][0] * matrix2[0][1] + matrix[0][1] * matrix2[1][1];
        int c = matrix[1][0] * matrix2[0][0] + matrix[1][1] * matrix2[1][0];
        int d = matrix[1][0] * matrix2[0][1] + matrix[1][1] * matrix2[1][1];
        matrix2[0][0] = a;
        matrix2[0][1] = b;
        matrix2[1][0] = c;
        matrix2[1][1] = d;
        return matrix2;
    }

    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void testTrieTree(){
        String[] strings = new String[]{"500V", "kqQ6r", "5n", "1", "341GH1fD1cq", "5s6SPTB", "Jy4xuAZ1oPqZ", "989", "gwzfm35720A7m", "ASg9zcQ", "O1Jt3Jgu4Ks84",
                "9Fx6h79", "KP6rG9my2cdG7", "2g", "nwk99T68", "1", "GXL", "T4J", "82qCqRkmiN4", "1OPGP", "K", "8aRsAa259Z3PuH9sgX9", "LNId7xv", "745zJ3IQ2KO",
                "1TfB", "5090541F4SeK", "46X639BrJCR44z14", "hz1g", "I74AK8cBjzlo1", "07LS3SXhh", "87uWVPI5ONE6zmS", "D4UTv6S3POdZlSP706lzc", "Blgi0R", "XFL1t803S",
                "F57IGqr84Og5y1", "y265mG2CP", "0lF96tgX0l", "X00pH", "RTO5c4h", "Bw8TjxHl", "B9e5s", "cBG", "07YU1qnU7", "277pNOIMp23D", "l9", "O", "DLq8fHD8wk", "C7V2b3l2", "hz9Zbtq8P", "oZ800J1M2Wf6Twm8VegW9", "7348os6"};
        TrieTree trieTree = new TrieTree();        
        TrieTree.Right right = new TrieTree.Right();        
        Arrays.stream(strings).forEach(right::insert);        
        Arrays.stream(strings).filter(s->s.startsWith("1")).forEach(System.out::println);        
        right.map.entrySet().stream().filter(s->s.getKey().startsWith("1")).forEach(System.out::println);    
    }

    public static long sumMoney(int n){
        int week = n/7;
        int left = n%7;
        long weekMoneySum = (4*week + (week-1)*week/2)*7;
        long leftMoneySum = (week+1 + week+1+left-1)* left/2;
        return weekMoneySum + leftMoneySum;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null){
                return false;
            }
            ListNode pre = head.next;
            ListNode aft = head;

            while(pre != null){
                if(pre == aft){
                    return true;
                }
                pre = pre.next;
                aft = aft.next;
                if(pre == aft){
                    return true;
                }
                pre = pre.next;
            }

            return false;
        }
    }

    public static int climbStairs(int n) {
        return process(45);
    }

    public static int process(int n){
        if(n < 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return process(n-1) + process(n-2);
    }

    public class TreeNode {
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





    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.val == targetSum){
            return true;
        }

        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum- root.val);
    }



}
package class00_review;

import java.util.LinkedList;

public class PaperFolder {
    public static void fold(int index, int n, boolean flag){
        if(index == n){
            return;
        }

        fold(index+1, n, true);
        System.out.println((flag ? "凹 " : "凸") + " " + (index + 1));
        fold(index + 1, n, false);
    }

    public static void foldUnRecursion(int n){
        if(n <= 0){
            return;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        int level = n;
        int nodeCount = (int)Math.pow(2, level)-1;

    }



    public static void main(String[] args) {
        fold(0, 4, true);
    }
}

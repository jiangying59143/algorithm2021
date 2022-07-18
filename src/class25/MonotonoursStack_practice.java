package class25;

import java.util.Arrays;
import java.util.LinkedList;

public class MonotonoursStack_practice {
    public static int[][] monotonoursStack(int[] arr){
        int[][] res = new int[arr.length][2];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int resIndex = stack.pop();
                res[resIndex][0] = stack.isEmpty() ? -1 : stack.peek();
                res[resIndex][1] = i;
            }
            //如果相等怎么办 todo
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int resIndex = stack.pop();
            res[resIndex][0] = stack.isEmpty() ? -1 : stack.peek();
            res[resIndex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,0,1};
        int[][] res = monotonoursStack(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}

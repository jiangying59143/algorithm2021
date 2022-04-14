package class00MyStudy;

import java.util.Arrays;

public class RadixSort {

    public static void sort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        sort(arr, maxBits(arr));
    }

    public static int maxBits(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return maxBits(max);
    }

    public static int maxBits(int value){
        int res = 0;
        //important
        while(value != 0){
            res++;
            value /= 10;
        }
        return res;
    }

    public static void sort(int[] arr, int bitSize){
        int R=arr.length-1, radix = 10;
        int[] bucket = new int[radix];
        int[] help = new int[arr.length];
        for (int d = 1; d <= bitSize; d++) {
            for (int i = 0; i < arr.length; i++) {
                bucket[getDigit(arr[i], d)]++;
            }

            int sum = 0;
            for (int i = 1; i < radix; i++) {
                bucket[i] += bucket[i-1];
            }

            //important
            for (int r = R; r >= 0; r--) {
                help[bucket[getDigit(arr[r], d)]-- -1] = arr[r];
            }

            for (int i = 0; i < help.length; i++) {
                arr[i] = help[i];
            }

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = 0;
            }
        }

    }

    public static int getDigit(int x, int d){
        return x / (int)Math.pow(10, d-1) % 10;
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] generateRandomIntArr(int maxLen){
        int[] arr = new int[(int)(maxLen*Math.random() + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * Integer.MAX_VALUE);
        }
        return arr;
    }

    public static boolean getResult(int[] arr, int[] arr1){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != arr1[i]){
                System.out.println("Oops!!!");
                System.out.println(Arrays.toString(arr));
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int times = 10000;
        while (times -- > 0) {
            int[] arr = generateRandomIntArr(1000);
            int[] arr1 = Arrays.copyOf(arr, arr.length);

            sort(arr);
            comparator(arr1);
            if(!getResult(arr, arr1)) return;
        }
        System.out.println("Success!!!");

    }
}

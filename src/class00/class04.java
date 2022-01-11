package class00;

import class01.Code01_SelectionSort;

public class class04 {
    public void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length-1);
    }

    public void process(int[] arr, int L, int R){
        if(L <= R){
            return;
        }
        int mid = L + ((R-L)>>1);
        process(arr, L, mid);
        process(arr,mid+1, R);

        merge(arr, L, mid, R);
    }

    public void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R-L+1];
        int li = L, ri = mid+1, hi=0;
        while(li <= mid && ri <= R){
            help[hi++] = arr[li] < arr[ri] ? arr[li++] : arr[ri++];
        }

        while(li <= mid){
            help[hi++] = arr[li++];
        }

        while(ri <= R){
            help[hi++] = arr[ri++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Code01_SelectionSort.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Code01_SelectionSort.copyArray(arr1);
            new class04().mergeSort(arr1);
            Code01_SelectionSort.comparator(arr2);
            if (!Code01_SelectionSort.isEqual(arr1, arr2)) {
                succeed = false;
                Code01_SelectionSort.printArray(arr1);
                Code01_SelectionSort.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }


}

package class00_20220404;

public class SortMemory {
    public static void MergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int[] mergeArr = new int[arr.length];
        process(arr, 0, arr.length-1, mergeArr);
    }

    public static void process(int[] arr, int start, int end, int[] mergeArr){
        if(start >= end){
            return;
        }
        int mid = start + ((end-start)>>1);
        process(arr, start, mid, mergeArr);
        process(arr, mid+1, end, mergeArr);
        merge(arr, start, mid, end, mergeArr);
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] mergeArr){

    }
}

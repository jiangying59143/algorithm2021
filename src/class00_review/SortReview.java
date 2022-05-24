package class00_review;

import java.util.Arrays;

public class SortReview {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int[] tempArr = new int[arr.length];
        process(arr, 0, arr.length-1, tempArr);
    }

    public static void process(int[] arr, int start, int end, int[] tmpArr){
        if(start == end){
            return;
        }
        int mid = start + ((end-start)>>1);
        process(arr, start, mid, tmpArr);
        process(arr, mid + 1, end, tmpArr);
        merge(arr, start, mid, end, tmpArr);
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] tmpArr){
        int leftIndex = start;
        int rightIndex = mid + 1;
        int copyIndex = start;

        while(leftIndex <= mid && rightIndex <= end){
            tmpArr[copyIndex++] = arr[leftIndex] > arr[rightIndex] ? arr[rightIndex++] : arr[leftIndex++];
        }

        while(leftIndex <= mid){
            tmpArr[copyIndex++] = arr[leftIndex++];
        }

        while(rightIndex <= end){
            tmpArr[copyIndex++] = arr[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = tmpArr[i];
        }
    }

    public static void quickSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        processQuick(arr, 0, arr.length-1);
    }

    public static void processQuick(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int k = start + (int)((end-start) * Math.random()+1);
        int[] equalArea = getEqual(arr, start, k, end);
        processQuick(arr, start, equalArea[0]-1);
        processQuick(arr, equalArea[1] + 1, end);

    }

    public static int[] getEqual(int arr[], int start, int k, int end){
        int elem = arr[k];
        swap(arr, k, end);
        int index = start;
        int leftIndex = start-1;
        int rightIndex = end;
        while(index < rightIndex){
            if(arr[index] == elem){
                index ++;
            }else if(arr[index] < elem){
                swap(arr, ++leftIndex, index++);
            }else{
                swap(arr, --rightIndex, index);
            }
        }
        swap(arr, rightIndex, end);
        return new int[]{leftIndex+1,rightIndex};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,9,8,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{4,3,2,1,9,8,6};
        quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}

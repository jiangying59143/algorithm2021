package class00_review;

import java.util.Arrays;

public class SortReview {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class BubbleSort{
        public static void sort(int[] arr){
            if(arr == null || arr.length < 2){
                return;
            }
            for (int i = arr.length-1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if(arr[j] > arr[j+1]){
                        swap(arr, j, j+1);
                    }
                }
            }
        }
    }

    static class SelectionSort{
        public static void sort(int[] arr){
            if(arr == null || arr.length < 2){
                return;
            }
            for (int i = 0; i < arr.length-1; i++) {
                int minIndex = i;
                for (int j = i+1; j < arr.length; j++) {
                    minIndex = arr[j]<arr[minIndex] ? j : minIndex;
                }
                if(minIndex != i){
                    swap(arr, minIndex, i);
                }
            }
        }
    }

    static class InsertSort{
        public static void sort(int[] arr){
            if(arr == null || arr.length < 2){
                return;
            }

            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0 && arr[j-1] > arr[j]; j--) {
                    swap(arr, j-1, j);
                }
            }
        }
    }

    static class MergeSort{
        public static void sort(int[] arr){
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
    }

    static class QuickSort{
        public static void sort(int[] arr){
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
    }

    static class HeapSort{
        public static void sort(int[] arr){
            if(arr == null || arr.length < 2){
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                heapInsert(arr, i);
            }
            swap(arr, 0, arr.length-1);
            for (int i = arr.length - 1; i > 0; i--) {
                heapify(arr, 0, i);
                if(i>1){
                    swap(arr, 0, i-1);
                }
            }
        }

        public static void heapInsert(int[] arr, int i){
            while(i > 0){
                int headIndex = (i-1)/2;
                if(arr[i] <= arr[headIndex]){
                    break;
                }
                swap(arr, i, headIndex);
                i = headIndex;
            }
        }
        
        public static void heapify(int[] arr, int i, int heapSize){
            int leftIndex = 2*i+1;
            while(leftIndex < heapSize){
                int maxIndex = leftIndex+1 == heapSize || arr[leftIndex] > arr[leftIndex+1] ? leftIndex : leftIndex+1;
                if(arr[i] >= arr[maxIndex]){
                    break;
                }
                swap(arr, i, maxIndex);
                leftIndex = 2*maxIndex + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr0 = new int[]{4,3,2,1,9,8,6};
        BubbleSort.sort(arr0);
        System.out.println(Arrays.toString(arr0));

        int[] arr01 = new int[]{4,3,2,1,9,8,6};
        SelectionSort.sort(arr01);
        System.out.println(Arrays.toString(arr01));

        int[] arr02 = new int[]{4,3,2,1,9,8,6};
        InsertSort.sort(arr02);
        System.out.println(Arrays.toString(arr02));

        int[] arr = new int[]{4,3,2,1,9,8,6};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{4,3,2,1,9,8,6};
        QuickSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[]{4,3,2,1,9,8,6};
        HeapSort.sort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}

package class01;

public class Practice {
    public static void BubblSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            if(i != minIndex)swap(arr, i, minIndex);
        }
    }

    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0 && arr[j-1] > arr[j]; j--) {
                swap(arr, j-1, j);
            }
        }
    }


    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        int[] helpArr = new int[arr.length];
        processMergeSort(arr, 0, arr.length-1, helpArr);
        for (int i = 0; i < helpArr.length; i++) {
            arr[i] = helpArr[i];
        }
    }

    public static void processMergeSort(int[] arr, int L, int R, int[] helpArr){
        if(L <= R) return;
        int mid = L + ((R-L)>>1);
        processMergeSort(arr, L, mid, helpArr);
        processMergeSort(arr, mid+1, R, helpArr);
        merge(arr, L, mid, R, helpArr);
    }

    private static void merge(int[] arr, int L, int mid, int R, int[] helpArr) {
        int i = L;
        int j = mid+1;
        int helpIndex = L;
        while(i <= mid && j <= R){
            helpArr[helpIndex++] = arr[i] <= arr[j] ?  arr[i++] : arr[j++];
        }
        while(i<=mid){
            helpArr[helpIndex++] = arr[i++];
        }
        while(j <= R){
            helpArr[helpIndex++] = arr[j++];
        }
    }


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

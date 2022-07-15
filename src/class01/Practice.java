package class01;

public class Practice {
    public static void bubblSort(int[] arr){
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
    }

    public static void processMergeSort(int[] arr, int L, int R, int[] helpArr){
        if(L >= R) return;
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
        for (int k = L; k <=R; k++) {
            arr[k] = helpArr[k];
        }

    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
//     O(N*logN)
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }

//       O(N)
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        partition(arr, 0, arr.length-1);
    }

    public static void partition(int[] arr, int L, int R){
        if(L >= R) return;
        int pivot = L + (int)(Math.random()*(R-L+1));
        int[] equalArea = getEqualArea(arr, L, pivot, R);
        partition(arr, L, equalArea[0]-1);
        partition(arr, equalArea[1]+1, R);
    }

    public static int[] getEqualArea(int[] arr, int L, int p, int R){
        swap(arr, p, R);
        int index = L;
        int less = L-1;
        int more = R;
        while(index < more){
            if(arr[index] == arr[R]){
                index++;
            }else if(arr[index] < arr[R]){
                swap(arr, ++less, index++);
            }else{
                swap(arr, --more, index);
            }
        }
        swap(arr, more, R);
        return new int[]{less+1, more};
    }

    public static void heapInsert(int[] arr, int i){
        /**
         * (i-1)/2不能改成(i-1)>>1
         * (0-1)/2=0 BUT (0-1)>>1 = -1
          */
        while(arr[i] > arr[(i-1)/2]){
            swap(arr, i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    public static void heapify(int[] arr, int i, int heapSize){
        int left = 2*i+1;
        while(left < heapSize){
            int childMax = left+1 >= heapSize || arr[left] > arr[left+1] ? left : left+1;
            if(arr[i] >= arr[childMax]){
                return;
            }
            swap(arr, i, childMax);
            i = childMax;
            left = 2*i+1;
        }
    }


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int[] arr4 = copyArray(arr1);
            int[] arr5 = copyArray(arr1);
            int[] arr6 = copyArray(arr1);
            bubblSort(arr1);
            selectSort(arr2);
            insertSort(arr3);
            mergeSort(arr4);
            heapSort(arr5);
            quickSort(arr6);
            if (!isEqual(arr1, arr2) || !isEqual(arr2, arr3) || !isEqual(arr3, arr4) || !isEqual(arr4, arr5) || !isEqual(arr5, arr6)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                printArray(arr4);
                printArray(arr5);
                printArray(arr6);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

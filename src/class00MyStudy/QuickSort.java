package class00MyStudy;

import java.util.Arrays;

// 算法是思维的扩散和收敛过程， 重视过程。
public class QuickSort {
    public void sort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length -1);
    }

    public void process(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int randIndex = L + (int)(Math.random() * (R-L+1));
        swap(arr, randIndex, R);
        int[] equalArea = netherlandFlag(arr, L, R);
        process(arr, L, equalArea[0]-1);
        process(arr, equalArea[1]+1, R);
    }

    public int[] netherlandFlag(int[] arr, int L, int R){
        if(L > R){
            return new int[]{-1,-1};
        }
        if(L == R){
            return new int[]{L, R};
        }

        int less = L-1;
        int more = R;
        int index = L;
        while(index < more){
            if(arr[index] == arr[R]){
                index ++;
            }else if(arr[index] < arr[R]){
                swap(arr, index ++, ++less);
            }else {
//                swap(arr, index ++ , --more);
                swap(arr, index , --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less+1, more};
    }

    public void swap(int[] arr, int i, int j){
        if(i != j){
            arr[i] = arr[i]^arr[j];
            arr[j] = arr[i]^arr[j];
            arr[i] = arr[i]^arr[j];
        }
    }

    public void comparator(int arr[]){
        Arrays.sort(arr);
    }

    public static int[] generateRandomArr(int maxLen){
        int[] arr = new int[(int)(maxLen*Math.random()) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Integer.MAX_VALUE * Math.random()) + (int)(Integer.MIN_VALUE * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int times = 10000;
        QuickSort quickSort = new QuickSort();
        while (times -- > 0){
            int[] arr = generateRandomArr(50);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            quickSort.sort(arr);
            quickSort.comparator(arr2);

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != arr2[i]){
                    System.out.println("oops!");
                    System.out.println(Arrays.toString(arr));
                    return;
                }
            }
        }
        System.out.println("succeed!");
    }
}

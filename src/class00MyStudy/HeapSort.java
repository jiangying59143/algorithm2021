package class00MyStudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {
    public static class MyMaxHeap{
        public int[] heap;
        public final int size;
        public int limit;

        public MyMaxHeap(int size){
            this.size = size;
            heap = new int[size];
            limit=0;
        }

        public boolean isFull(){return size == limit;}

        public boolean isEmpty(){ return limit == 0;}

        public void push(int value){
            if(limit == size){
                throw new RuntimeException("exceed the limit:" + size);
            }
            heap[limit] = value;
            heapInsert(limit++);
        }

        public void heapInsert(int pos){
            while(heap[pos] > heap[(pos-1)/2]){
                swap(pos, (pos-1)/2);
                pos = (pos-1)/2;
            }
        }

        public int pop(){
            if(limit == 0){
                throw new RuntimeException("it has been empty");
            }
            int res = heap[0];
            swap(0, --limit);
            heapify(0);
            return res;
        }

        public void heapify(int pos){
            while(2*pos+1 < limit){
                int maxChildIndex = 2*pos+2 >= limit|| heap[2*pos+1] > heap[2*pos+2] ? 2*pos+1 : 2*pos+2;
                if(heap[pos] >= heap[maxChildIndex]){
                    return;
                }
                swap(pos, maxChildIndex);
                pos = maxChildIndex;
            }
        }

        public void swap(int pos1, int pos2){
            heap[pos1] = heap[pos1]^heap[pos2];
            heap[pos2] = heap[pos1]^heap[pos2];
            heap[pos1] = heap[pos1]^heap[pos2];
        }

    }

    public static class MyMaxHeapSort{

        public void sort(int[] arr){
            for (int i = 0; i < arr.length; i++) {
                heapInsert(arr, i);
            }

            int heapSize = arr.length;

//            swap(arr, 0,--heapSize );
//            while(heapSize > 0){
//                heapify(arr, 0, heapSize);
//                swap(arr, 0,--heapSize );
//            }
            while(heapSize > 0){
                swap(arr, 0,--heapSize );
                heapify(arr, 0, heapSize);
            }

        }

        public void comparatorSort(int[] arr){
            Arrays.sort(arr);
        }


        public void heapInsert(int[] arr, int pos){
            while(arr[pos] > arr[(pos-1)/2]){
                swap(arr, pos, (pos-1)/2);
                pos = (pos-1)/2;
            }
        }

        public void heapify(int[] arr, int pos, int limit){
            while(2*pos+1 < limit){
                int maxChildIndex = 2*pos+2 >= limit|| arr[2*pos+1] > arr[2*pos+2] ? 2*pos+1 : 2*pos+2;
                if(arr[pos] >= arr[maxChildIndex]){
                    return;
                }
                swap(arr, pos, maxChildIndex);
                pos = maxChildIndex;
            }
        }

        public void swap(int[] arr, int pos1, int pos2){
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;

            // it will cause Integer exceed the bundle
//            arr[pos1] = arr[pos1]^arr[pos2];
//            arr[pos2] = arr[pos1]^arr[pos2];
//            arr[pos1] = arr[pos1]^arr[pos2];
        }

    }

    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
//            it would cause exceed to the Integer bound.
//            return o2-o1;
            return  o2 > o1 ? 1 : (o2 < o1 ? -1 : 0);
        }
    }

    public static int[] generateRandomArr(int maxLen){
        int[] arr = new int[(int)(maxLen*Math.random())+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Integer.MAX_VALUE * Math.random() + Integer.MIN_VALUE*Math.random());
        }
        return arr;
    }


    public static void testHeap() {
        int times = 100000;
        while(times-- > 0) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComparator());
            int[] arr = generateRandomArr(1000);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            MyMaxHeap myMaxHeap = new MyMaxHeap(arr.length);
            for (int i = 0; i < arr.length; i++) {
                priorityQueue.add(arr[i]);
            }

            for (int i = 0; i < arr2.length; i++) {
                myMaxHeap.push(arr2[i]);
            }

            if(!myMaxHeap.isFull()){
                System.out.println("oops full wrong !! ");
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr2));
            }


            int size = arr.length;
            while (size -- > 0){
                int priPop = priorityQueue.poll();
                int myPop = myMaxHeap.pop();
                if(priPop != myPop){
                    System.out.println("oops pop wrong !! :" + priPop + " " + myPop);
                    System.out.println(size + "  " + myMaxHeap.limit);
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(myMaxHeap.heap));
                    return;
                }
            }

            if(!myMaxHeap.isEmpty()){
                System.out.println("oops empty wrong !! ");
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr2));
            }
        }
        System.out.println("Succeed!!");
    }

    public static void testHeapSort() {
        int times = 100000;
        while(times-- > 0) {
            MyMaxHeapSort myMaxHeapSort = new MyMaxHeapSort();
            int[] arr = generateRandomArr(1000);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            myMaxHeapSort.sort(arr);
            myMaxHeapSort.comparatorSort(arr2);

            int index = arr.length;
            while(index-- > 0){
                if(arr[index] != arr2[index]){
                    System.out.println("Oops!!");
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(arr2));
                    return;
                }
            }
        }
        System.out.println("Succeed!!");
    }

    public static void main(String[] args) {
//        testHeap();
        testHeapSort();
    }
}

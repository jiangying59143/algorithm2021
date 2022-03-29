package class00MyStudy;

public class HeapSort {
    public class MyMaxHeap{
        public int[] heap;
        public final int size;
        public int index;

        public MyMaxHeap(int size){
            this.size = size;
            heap = new int[size];
            index=0;
        }

        public void push(int value){
            if(index == size){
                throw new RuntimeException("exceed the limit:" + size);
            }
            heap[index] = value;
            heapInsert(index++);
        }

        public void heapInsert(int pos){
            while(heap[pos] > heap[(pos-1)/2]){
                swap(pos, (pos-1)/2);
                pos = (pos-1)/2;
            }
        }

        public void swap(int pos1, int pos2){
            heap[pos1] = heap[pos1]^heap[pos2];
            heap[pos2] = heap[pos1]^heap[pos2];
            heap[pos1] = heap[pos1]^heap[pos2];
        }
    }
}

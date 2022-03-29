package class00MyStudy;
import java.util.Arrays;
import java.util.PriorityQueue;

public class A_Test {    
    public static void main(String[] args) {
//        testTrieTree();
//        System.out.println(RadixSort.maxBits(1100));
//        System.out.println(RadixSort.getDigit(10, 2));

        // heap head test
//        System.out.println(1/2);
//        System.out.println(-1/2);
//        System.out.println(-2/2);
//        System.out.println(-3/2);

        HeapSort.MyComparator myComparator = new HeapSort.MyComparator();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(myComparator);
        int arr[] = new int[]{1053158911, 581749897, -1142222509, -1159249366, -1180721091};

        System.out.println(Integer.MAX_VALUE);
        System.out.println(1053158911 - -1180721091);

//        int arr[] = new int[]{5, 4, -4, -5,-8};
        for (int i = 0; i < arr.length; i++) {
            System.out.println( Integer.MIN_VALUE < arr[i] && Integer.MAX_VALUE > arr[i]);
            priorityQueue.add(arr[i]);
        }
        int size = priorityQueue.size();
        while(size -- > 0){
            System.out.println(priorityQueue.poll());
        }
    }
    public static void testTrieTree(){
        String[] strings = new String[]{"500V", "kqQ6r", "5n", "1", "341GH1fD1cq", "5s6SPTB", "Jy4xuAZ1oPqZ", "989", "gwzfm35720A7m", "ASg9zcQ", "O1Jt3Jgu4Ks84",
                "9Fx6h79", "KP6rG9my2cdG7", "2g", "nwk99T68", "1", "GXL", "T4J", "82qCqRkmiN4", "1OPGP", "K", "8aRsAa259Z3PuH9sgX9", "LNId7xv", "745zJ3IQ2KO",
                "1TfB", "5090541F4SeK", "46X639BrJCR44z14", "hz1g", "I74AK8cBjzlo1", "07LS3SXhh", "87uWVPI5ONE6zmS", "D4UTv6S3POdZlSP706lzc", "Blgi0R", "XFL1t803S",
                "F57IGqr84Og5y1", "y265mG2CP", "0lF96tgX0l", "X00pH", "RTO5c4h", "Bw8TjxHl", "B9e5s", "cBG", "07YU1qnU7", "277pNOIMp23D", "l9", "O", "DLq8fHD8wk", "C7V2b3l2", "hz9Zbtq8P", "oZ800J1M2Wf6Twm8VegW9", "7348os6"};
        TrieTree trieTree = new TrieTree();        
        TrieTree.Right right = new TrieTree.Right();        
        Arrays.stream(strings).forEach(right::insert);        
        Arrays.stream(strings).filter(s->s.startsWith("1")).forEach(System.out::println);        
        right.map.entrySet().stream().filter(s->s.getKey().startsWith("1")).forEach(System.out::println);    
    }
}
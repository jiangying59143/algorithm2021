package class00MyStudy;

import java.util.Arrays;

public class A_Test {
    public static void main(String[] args) {
        String[] strings = new String[]{"500V",
                "kqQ6r",
                "5n",
                "1",
                "341GH1fD1cq",
                "5s6SPTB",
                "Jy4xuAZ1oPqZ",
                "989",
                "gwzfm35720A7m",
                "ASg9zcQ",
                "O1Jt3Jgu4Ks84",
                "9Fx6h79",
                "KP6rG9my2cdG7",
                "2g",
                "nwk99T68",
                "1",
                "GXL",
                "T4J",
                "82qCqRkmiN4",
                "1OPGP",
                "K",
                "8aRsAa259Z3PuH9sgX9",
                "LNId7xv",
                "745zJ3IQ2KO",
                "1TfB",
                "5090541F4SeK",
                "46X639BrJCR44z14",
                "hz1g",
                "I74AK8cBjzlo1",
                "07LS3SXhh",
                "87uWVPI5ONE6zmS",
                "D4UTv6S3POdZlSP706lzc",
                "Blgi0R",
                "XFL1t803S",
                "F57IGqr84Og5y1",
                "y265mG2CP",
                "0lF96tgX0l",
                "X00pH",
                "RTO5c4h",
                "Bw8TjxHl",
                "B9e5s",
                "cBG",
                "07YU1qnU7",
                "277pNOIMp23D",
                "l9",
                "O",
                "DLq8fHD8wk",
                "C7V2b3l2",
                "hz9Zbtq8P",
                "oZ800J1M2Wf6Twm8VegW9",
                "7348os6"};

        TrieTree trieTree = new TrieTree();
        TrieTree.Right right = new TrieTree.Right();
        Arrays.stream(strings).forEach(right::insert);
        Arrays.stream(strings).filter(s->s.startsWith("1")).forEach(System.out::println);
        right.map.entrySet().stream().filter(s->s.getKey().startsWith("1")).forEach(System.out::println);
    }
}

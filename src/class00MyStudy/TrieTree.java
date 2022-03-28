package class00MyStudy;

import java.util.*;

public class TrieTree {
    class TrieNode{
        public int pass, end;
        public Map<Integer, TrieNode> nextMap;
        public TrieNode(){
            pass=0;
            end=0;
            nextMap = new HashMap<>();
        }
    }

    TrieNode root;

    public TrieTree(){
        root = new TrieNode();
    }

    public void insert(String word){
        if(word == null){
            return;
        }
        TrieNode trieNode = root;
        trieNode.pass++;
        char[] chars = word.toCharArray();
        for (int aChar : chars) {
            if(!trieNode.nextMap.containsKey(aChar)){
                trieNode.nextMap.put(aChar, new TrieNode());
            }
            trieNode = trieNode.nextMap.get(aChar);
            trieNode.pass++;
        }
        trieNode.end++;
    }

    public int search(String word){
        if(word == null){
            return 0;
        }
        TrieNode trieNode = root;
        char[] chars = word.toCharArray();
        for (int aChar : chars) {
            if(!trieNode.nextMap.containsKey(aChar)){
                return 0;
            }
            trieNode = trieNode.nextMap.get(aChar);
        }
        return trieNode.end;
    }

    public void delete(String word){
        if(search(word) == 0){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode trieNode = root;
        trieNode.pass--;
        for (int aChar : chars) {
            if(--trieNode.nextMap.get(aChar).pass == 0){
                trieNode.nextMap.remove(aChar);
                return;
            }
            trieNode = trieNode.nextMap.get(aChar);
        }
        trieNode.end--;
    }

    public int prefixNumber(String word){
        if(word == null){
            return 0;
        }
        TrieNode trieNode = root;
        char[] chars = word.toCharArray();
        for (int aChar : chars) {
            if(!trieNode.nextMap.containsKey(aChar)){
                return 0;
            }
            trieNode = trieNode.nextMap.get(aChar);
        }
        return trieNode.pass;
    }

    public static class Right{
        private final Map<String, Integer> map = new HashMap<>();

        public void insert(String word){
            map.put(word, map.containsKey(word) ? map.get(word)+1 : 1);
        }

        public int search(String word){
            return map.containsKey(word) ? map.get(word) : 0;
        }

        public void delete(String word){
            if(map.containsKey(word) && map.get(word) > 1){
                map.put(word, map.get(word)-1);
            } else map.remove(word);
        }

        public int prefixNumber(String word){
            int count=0;
            for (String s : map.keySet()) {
                if(s.startsWith(word)) count++;
            }
            return count;
        }
    }

    public static String generateRandomStr(int maxStrLen){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < new Random().nextInt(maxStrLen)+1; i++) {
            sb.append(ASCII.generateRandomNumberAndLetter());
        }
        return sb.toString();
    }

    public static List<String> generateStringArr(int maxArrLen, int maxStrLen){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(maxArrLen)+1; i++) {
            list.add(generateRandomStr(maxStrLen));
        }
        return list;
    }

    public static void main(String[] args) {
        int times = 100000;
        int arrLen = 1000;
        int strLen = 50;
        Random r = new Random();
        for (int i = 0; i < times; i++) {

            TrieTree trieTree = new TrieTree();
            Right right = new Right();
            List<String> list = generateStringArr(arrLen, strLen);
            for (String s : list) {
                trieTree.insert(s);
                right.insert(s);
            }

            for (String s : list) {
                double d = Math.random();
                if(d<0.5) {
                    trieTree.delete(s);
                    right.delete(s);
                }

                if(d<0.75){
                    int pass = trieTree.prefixNumber(s);
                    int passr = right.prefixNumber(s);
                    if(pass != passr){
                        System.out.println("Oops!!!!! pass value is not right :" + s + " " + pass + " " + passr);
                    }

                    int end = trieTree.search(s);
                    int endr = right.search(s);
                    if(end != endr){
                        System.out.println("Oops!!!!! end value is not right :" + s + " " + end + " " + endr);
                    }

                    if(pass != passr || end != endr){
                        System.out.println(Arrays.toString(list.toArray()));
                        return;
                    }
                }
            }
        }
        System.out.println("Success!");
    }
}

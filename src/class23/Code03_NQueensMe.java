package class23;

import java.util.*;

/**
 *
 N皇后问题是指在N*N的棋盘上要摆N个皇后，
 要求任何两个皇后不同行、不同列， 也不在同一条斜线上
 给定一个整数n，返回n皇后的摆法有多少种。n=1，返回1
 n=2或3，2皇后和3皇后问题无论怎么摆都不行，返回0
 n=8，返回92
 */
public class Code03_NQueensMe {
    public static int totalNQueens(int n){
        List<int[][]> ans = new ArrayList<>();
        int count = process(n, 0,  new HashMap<>(), ans);
        for (int[][] an : ans) {
            for (int[] a : an) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println("------------------");
        }

        return count;
    }


    public static int process(int n, int layer, Map<Integer, Integer> map, List<int[][]> ans){
        if(layer == n){
            if(map.size() == n){
                int[][] an = new int[n][n];
                for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                    an[integerIntegerEntry.getKey()][integerIntegerEntry.getValue()] = 1;
                }
                ans.add(an);
                map.clear();
                return 1;
            }else{
                return 0;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> layerIndex : map.entrySet()) {
            set.add(layerIndex.getValue());
            if(layerIndex.getValue()-(layer-layerIndex.getKey()) >= 0) {
                set.add(layerIndex.getValue() - (layer - layerIndex.getKey()));
            }
            if(layerIndex.getValue()+(layer-layerIndex.getKey()) < n ) {
                set.add(layerIndex.getValue() + (layer - layerIndex.getKey()));
            }
        }
        if(set.size() == n){
            map.clear();
            return 0;
        }
        int ways = 0;
        for (int i = 0; i < n; i++) {
            if(set.contains(i)){
                continue;
            }
            map.put(layer, i);
            ways +=process(n, layer+1,  map, ans);
        }
        return ways;
    }

    public static int process2(int n, int layer, Map<Integer, Integer> map, List<int[][]> ans){
        if(layer == n){
            if(map.size() == n){
                int[][] an = new int[n][n];
                for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                    an[integerIntegerEntry.getKey()][integerIntegerEntry.getValue()] = 1;
                }
                ans.add(an);
                map.clear();
                return 1;
            }else{
                return 0;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> layerIndex : map.entrySet()) {
            set.add(layerIndex.getValue());
            if(layerIndex.getValue()-(layer-layerIndex.getKey()) >= 0) {
                set.add(layerIndex.getValue() - (layer - layerIndex.getKey()));
            }
            if(layerIndex.getValue()+(layer-layerIndex.getKey()) < n ) {
                set.add(layerIndex.getValue() + (layer - layerIndex.getKey()));
            }
        }
        if(set.size() == n){
            map.clear();
            return 0;
        }
        int ways = 0;
        for (int i = 0; i < n; i++) {
            if(set.contains(i)){
                continue;
            }
            map.put(layer, i);
            ways +=process2(n, layer+1,  map, ans);
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}

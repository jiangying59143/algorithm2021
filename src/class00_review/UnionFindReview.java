package class00_review;

import java.util.LinkedList;

public class UnionFindReview {
    static class UnionFind {
        int[] gridArr;
        int rowSize;
        int columnSize;
        public int count;
        int[] rank;
        public UnionFind(int rowSize, int columnSize, int count){
            this.count=count;
            this.rowSize = rowSize;
            this.columnSize = columnSize;
            gridArr = new int[rowSize*columnSize];
            rank = new int[rowSize*columnSize];
            for (int i = 0; i < gridArr.length; i++) {
                gridArr[i] = i;
                rank[i] = 1;
            }
        }

        public int findParent(int i){
            LinkedList<Integer> stack = new LinkedList<>();
            while(gridArr[i] != i){
                stack.push(i);
                i = gridArr[i];
            }
            while(!stack.isEmpty()){
                gridArr[stack.pop()] = i;
            }
            return i;
        }

        public void union(int ir, int ic, int jr, int jc){
            int a = findParent(getIndex(ir, ic));
            int b = findParent(getIndex(jr, jc));
            if(a == b) return;
            if(rank[a] >= rank[b]){
                gridArr[b] = a;
                rank[a] += rank[b];
            }else{
                gridArr[a] = b;
                rank[b] += rank[a];
            }
            count--;
        }

        public int getIndex(int row, int column){
            return row*columnSize + column;
        }

    }

    public static void main(String[] args) {
        char[][] grid = new char[4][];
        grid[0] = new char[]{'1','1','0','0','0'};
        grid[1] = new char[]{'1','1','0','0','0'};
        grid[2] = new char[]{'0','0','1','0','0'};
        grid[3] = new char[]{'0','0','0','1','1'};

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                }
            }
        }
        UnionFind unionFind = new UnionFind(grid.length, grid[0].length, count);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i>0 && grid[i][j] == '1' && grid[i-1][j] == '1'){
                    unionFind.union(i-1, j, i, j);
                }
                if(j>0 && grid[i][j-1] == '1' && grid[i][j] == '1'){
                    unionFind.union(i, j-1, i, j);
                }
            }
        }

        System.out.println(unionFind.count);

    }
}

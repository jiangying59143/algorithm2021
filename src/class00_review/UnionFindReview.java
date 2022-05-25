package class00_review;

import java.util.LinkedList;

public class UnionFindReview {
    static class UnionFind {
        int[] gridArr;
        int rowSize;
        int columnSize;
        public UnionFind(int rowSize, int columnSize){
            this.rowSize = rowSize;
            this.columnSize = columnSize;
            gridArr = new int[rowSize*columnSize];
            for (int i = 0; i < gridArr.length; i++) {
                gridArr[i] = i;
            }
        }

        public int findParent(int i){
            int parent = gridArr[i];
            if(i != parent){
                parent = findParent(parent);
                LinkedList<Integer> stack = new LinkedList<>();
                stack.push(i);
                while(!stack.isEmpty()){
                    gridArr[stack.pop()] = parent;
                }
            }
            return parent;
        }

        public void union(int ir, int ic, int jr, int jc){
            int a = findParent(getIndex(ir, ic));
            int b = findParent(getIndex(jr, jc));
            if(a != b) {
                gridArr[a] = b;
            }
        }

        public int getNumber(){
            int count=0;
            for (int i = 0; i < gridArr.length; i++) {
                if(gridArr[i] == i && gridArr[i] != -1){
                    count++;
                }
            }
            return count;
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
        UnionFind unionFind = new UnionFind(grid.length, grid[0].length);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if(grid[i][j] == '0'){
                    unionFind.gridArr[unionFind.getIndex(i, j)] = -1;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if(grid[i][j-1] == '1' && grid[i][j] == '1'){
                    unionFind.union(i, j-1, i, j);
                }else if(i>0 && grid[i][j] == '1' && grid[i-1][j] == '1'){
                    unionFind.union(i-1, j, i, j);
                }
            }
        }

        System.out.println(unionFind.getNumber());

    }
}

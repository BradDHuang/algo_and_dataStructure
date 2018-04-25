package com.company;

// lc 433.

import java.util.LinkedList;
import java.util.Queue;

// public class Main {

//     private static int m;
//     private static int n;
//     public static int numIslands(boolean[][] grid) {

//         if (grid == null) return 0;
//         m = grid.length;
//         if (m == 0) return 0;
//         if (grid[0] == null) return 0;
//         n = grid[0].length;
//         if (n == 0) return 0;
//         int count = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j]) {
//                     // dfs(grid, i, j);
                    
//                     bfs(grid, i, j);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
//     // private static void dfs (boolean[][] grid, int i, int j) {
//     //     if (i < 0 || j < 0 || i >= m || j >= n || !grid[i][j]) return;
//     //     grid[i][j] = false;
//     //     dfs(grid, i, j + 1);
//     //     dfs(grid, i, j - 1);
//     //     dfs(grid, i + 1, j);
//     //     dfs(grid, i - 1, j);
//     // }

//     private static void bfs (boolean[][] grid, int i, int j) {
//         Queue<Integer> queue = new LinkedList<>();
//         int position = i * n + j;
//         queue.offer(position);
//         while (!queue.isEmpty()) {
//             position = queue.poll();
//             int x = position / n;
//             int y = position % n;
//             if (x > 0 && grid[x - 1][y]) {
//                 queue.offer((x - 1) * n + y);
//                 grid[x - 1][y] = false;
//             }
//             if (x < m - 1 && grid[x + 1][y]) {
//                 queue.offer((x + 1) * n + y);
//                 grid[x + 1][y] = false;
//             }
//             if (y > 0 && grid[x][y - 1]) {
//                 queue.offer(x * n + y - 1);
//                 grid[x][y - 1] = false;
//             }
//             if (y < n - 1 && grid[x][y + 1]) {
//                 queue.offer((x) * n + y + 1);
//                 grid[x][y + 1] = false;
//             }
//         }
//     }

class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    markByBFS(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void markByBFS(boolean[][] grid, int x, int y) {

        int[] deltaX = {0, 1, -1, 0};
        int[] deltaY = {1, 0, 0, -1};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        grid[x][y] = false;
        while (!queue.isEmpty()) {
            Coordinate co = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(co.x + deltaX[i], co.y + deltaY[i]);
                if (!inBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }
    }

    private static boolean inBound(Coordinate co, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return co.x >= 0 && co.x < n && co.y >= 0 && co.y < m;
    }

    public static void main(String[] args) {

        boolean[][] grid = new boolean[][]{
                {true, true, false, false, false},
                {false, false, true, false, false},
                {false, false, false, true, true}};
        System.out.println(numIslands(grid));
        
        System.out.println(numIslands(null));
        boolean[][] grid1 = {};
        System.out.println(numIslands(grid1));
        boolean[][] grid2 = {null};
        System.out.println(numIslands(grid2));
        System.out.println(grid2.length);
        boolean[][] grid3 = {{}};
        System.out.println(numIslands(grid3));

    }

}
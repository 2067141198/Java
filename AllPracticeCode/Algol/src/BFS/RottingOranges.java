package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 本题可以先找到所有的腐烂橘子，入队，用第一批带出新一批腐烂的橘子
 * 每以匹橘子都会在一分钟之内腐烂,所以此题可以转化为求BFS执行的大循环的次数
 * 这里的step的更新需要有一个标记，只有新的腐烂的橘子加入，step才能自加
 * 最后BFS执行完之后，说明所有可以被腐烂的都完成了，再去遍历grid,如何还有
 * 值为1的，说明没有办法完全腐烂，返回-1,如果没有，则返回step
 */
public class RottingOranges {
    private static int[][] nextP = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }
        int resTime = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + nextP[j][0];
                    int ny = p.y + nextP[j][1];
                    if (nx >= row || ny >= col || nx < 0 || ny < 0)
                        continue;
                    if (grid[nx][ny] == 1) {
                        flag = true;
                        grid[nx][ny] = 2;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
            if (flag)
                resTime++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return resTime;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

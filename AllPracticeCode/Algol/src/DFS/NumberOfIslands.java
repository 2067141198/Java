package DFS;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 输入示例：
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出：1
 */
public class NumberOfIslands {
    private int[][] penth = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void DPS(char[][] grid, int row, int col, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + penth[i][0];
            int ny = y + penth[i][1];
            if (nx >= row || ny >= col || nx < 0 || ny < 0)
                continue;
            if (grid[nx][ny] == '1')
                DPS(grid, row, col, nx, ny);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    DPS(grid, row, col, i, j);
                    count++;
                }

            }
        }
        return count;
    }
}

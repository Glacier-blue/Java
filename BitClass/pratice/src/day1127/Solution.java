package day1127;

import java.util.ArrayList;
import java.util.List;

/**
 * 力扣：二维网格迁移
 * 代码解答错误，对小数据可以正确解答，对一个大数据具有逻辑错误
 * 最后一次修正：20211128 20：11
 */
class Solution {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        int row = 0;
        int i = (m * n - k) / n;
        int j = (m * n - k) % n;
        int a = 0;
        int b = 0;
        while (true) {
            boolean is = true;
            List<Integer> tmp = new ArrayList<Integer>();
            while (i < m) {
                while (j < n && row < n) {
                    tmp.add(grid[i][j]);
                    j++;
                    row++;
                }
                if (j == n) {
                    j = 0;
                    i++;
                }
                if (row == n) {
                    row = 0;
                    list.add(tmp);
                    is = false;
                    break;
                }
            }
            if (is == false) {
                continue;
            }
            while (a <= (m * n - k) / n) {
                while (b < n && row < n) {
                    if (a * m + b == m * n - k) {
                        is = false;
                        break;
                    }
                    tmp.add(grid[a][b]);
                    b++;
                    row++;
                }
                if (b == n) {
                    b = 0;
                    a++;
                }
                if (row == n) {
                    row = 0;
                    list.add(tmp);
                    break;
                }
                if (is == false) break;
            }
            if (a==(m * n - k) / n||is == false) break;
        }
        return list;
    }

}
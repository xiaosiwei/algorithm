package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/game-of-life/
 * O(n) space
 */
public class GameOfLife {
    public class Solution {
        public void gameOfLife(int[][] board) {
            for (int i = 0;i < board.length;i++) {
                for (int j = 0;j < board[i].length;j++) {
                    board[i][j] = getNewValue(board, i, j);
                }
            }

            for (int i = 0;i < board.length;i++) {
                for (int j = 0;j < board[i].length;j++) {
                    board[i][j] = getResultValue(board, i, j);
                }
            }
        }

        private int getResultValue(int[][] board, int i, int j) {
            if (board[i][j] < 2) return board[i][j];
            return board[i][j] - 2;
        }

        private int getOldValue(int[][] board, int i, int j) {
            if (board[i][j] < 2) return board[i][j];
            if (board[i][j] == 2) return 1;
            return 0;
        }

        private int getNewValue(int[][] board, int i, int j) {
            int cnt = findCnt(board,i,j);
            switch (cnt) {
                case 2:
                    return board[i][j];
                case 3:
                    if (board[i][j] == 0) {
                        return 3;
                    } else{
                        return 1;
                    }
                default:
                    if (board[i][j] == 0) {
                        return 0;
                    } else {
                        return 2;
                    }
            }
        }

        private int findCnt(int[][] board, int x, int y) {
            int result = 0;
            for (int i = -1;i <= 1;i++) {
                for (int j = -1;j <= 1;j++) {
                    if (i == 0 && j == 0) continue;

                    int tmpx = x + i;
                    int tmpy = y + j;
                    if (tmpx < 0 || tmpx >= board.length) continue;
                    if (tmpy < 0 || tmpy >= board[x].length) continue;

                    result += getOldValue(board, tmpx, tmpy);
                }
            }

            return result;
        }

    }
}

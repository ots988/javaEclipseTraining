package dataStructAndAlgorithm;

import java.util.LinkedList;

public class LCS {

    /**
     * 获得最大公共子序列长度
     * @param a
     * @param b
     * @return
     */
    public int getLCSLength(String a, String b) {
        /**
         * row行，line列
         */
        int line = a.length();
        int row = b.length();
        /**
         * A为列 B为行
         */
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        //第一行第一列全为0，不涉及字符对比
        int[][] dp = new int[line + 1][row + 1];
        //第一行，第一列全设为0
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int m = 1; m < line + 1; m++) {
            for (int n = 1; n < row + 1; n++) {
                if (A[m - 1] == B[n - 1]) {
                    // 动态规划公式一
                    dp[m][n] = dp[m - 1][n - 1] + 1;
                } else {
                    // 动态规划公式二
                    dp[m][n] = Math.max(dp[m - 1][n], dp[m][n - 1]);
                }
            }
        }
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        //打印最长子序列
        printLCS(line - 1, row - 1, A, B, dp);
        return dp[line - 1][row - 1];
    }

    /**
     *
     * @param i 列长
     * @param j 行长
     * @param A 其中一个字符串对应的字符数组
     * @param dp 矩阵
     */
    public void printLCS(int i, int j, char[] s1, char[] s2, int[][] dp) {
        LinkedList<Object> stack = new LinkedList<>();
        while ((i >= 0) && (j >= 0)) {
            if (s1[i] == s2[j]) {
                // 字符串从后开始遍历，如若相等，则存入栈中
                stack.push(s1[i]);
                i--;
                j--;
            } else {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.getLCSLength("aabafs", "bafh"));
    }

}
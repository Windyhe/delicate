package org.example.myleetcode;

/**
 * 回文子串个数
 */
public class L647 {

    static class Solution {
        public int countSubstrings(String s) {
            int ret = 0;
            boolean[][] temp = new boolean[s.length()][s.length()];
            for (int j = 0; j < s.length(); j++) {
                for (int i = j; i >= 0; i--) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 2 || temp[i + 1][j - 1]) {
                            temp[i][j] = true;
                            ret++;
                        } else {
                            temp[i][j] = false;
                        }
                    } else {
                        temp[i][j] = false;
                    }
                }
            }
            return ret;
        }
    }
}

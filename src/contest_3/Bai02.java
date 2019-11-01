/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest_3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author daoan
 */
public class Bai02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1, s2;
        s1 = in.next();
        s2 = in.next();
        int f[][] = new int [1001][1001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                f[i][j] = 0;
            }
        }
        int d1 = s1.length();
        int d2 = s2.length();
        for (int i = 1; i <= d1; i++) {
            for (int j = 1; j <= d2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        System.out.println(f[d1][d2]);
    }
}

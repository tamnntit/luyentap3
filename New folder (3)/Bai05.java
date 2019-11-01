/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest_3;

import java.util.Scanner;

/**
 *
 * @author daoan
 */
public class Bai05 {

    public static long DU = 1000000007;
    public static long a[][] = new long[1010][1010];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            System.out.println(ToHop(k, n));
        }
    }

    public static long ToHop(int k, int n) {
        if (k == 0 || k == n) {
            return 1;
        }
        for (int i = 0; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                if (i == 0 || i == j) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = (a[i][j - 1] + a[i - 1][j - 1]) % DU;
                }
            }
        }
        return a[k][n];
    }

}

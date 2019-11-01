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
public class Bai09 {

    public static int a[][] = new int[1111][1111];
    public static int f[][] = new int[1111][1111];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            f[1][1] = a[1][1];
            for (int i = 2; i <= n; i++) {
                f[i][1] = f[i - 1][1] + a[i][1];
            }
            for (int j = 2; j <= m; j++) {
                f[1][j] = f[1][j - 1] + a[1][j];
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    f[i][j] = Math.min(f[i - 1][j - 1] + a[i][j], f[i - 1][j] + a[i][j]);
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + a[i][j]);
                }
            }
            System.out.println(f[n][m]);
        }
    }
}

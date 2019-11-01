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
public class Bai07 {
    public static long DU = 1000000007;
    public static long f[] = new long[100001];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            for (int i = 2; i < 100001; i++) {
                f[i] = 0;
            }
            f[0] = 1;
            f[1] = 1;
            for (int i = 2; i <= k; i++) {
                for (int j = 0; j <= i - 1; j++) {
                    f[i] += f[j];
                    f[i] = f[i] % DU;
                }
            }

            for (int i = k + 1; i <= n; i++) {
                for (int j = i - k; j <= i - 1; j++) {
                    f[i] += f[j];
                    f[i] = f[i] % DU;
                }
            }
            System.out.println(f[n]);
        }
    }
}

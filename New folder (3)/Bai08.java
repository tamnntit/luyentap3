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
public class Bai08 {
    public static long MOD = 1000000007;
    public static long a[][] = new long[105][50005];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            if (k > n * 9) {
                System.out.println("0");
            } else if (n == 1 && k == 0) {
                System.out.println("1");
            } else {
                for (int i = 0; i < 105; i++) {
                    for (int j = 0; j < 50005; j++) {
                        a[i][j] = -1;
                    }
                }
                long res = 0;
                for (int i = 1; i <= 9; i++) {
                    if (k - i >= 0) {
                        res += Process(n - 1, k - i);
                    }
                }
                System.out.println((res % MOD));
            }
        }
    }

    public static long Process(int n, int k) {
        if (n == 0) {
            if(k ==0) return 1;
            return 0;
        }
        if (a[n][k] != -1) {
            return a[n][k];
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            if (k - i >= 0) {
                sum += Process(n - 1, k - i);
                sum %= MOD;
            }
        }

        a[n][k] = sum;
        return sum;
    }
}

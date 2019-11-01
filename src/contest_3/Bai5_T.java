/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luyentap3;

import java.util.Scanner;

/**
 *
 * @author nntam
 */
public class Bai5 {
    static long mod = (long)1e9+7;
    static int n, k;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            n  = in.nextInt();
            k = in.nextInt();
            long x[][] = new long[1001][1001];
            for(int i = 0; i<=n;i++) {
                x[i][0] = 1;
                x[i][i] = 1;
            }
            
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j < i; j++) {
                    x[i][j] = (x[i-1][j] + x[i-1][j-1])%mod;
                }
            }
            System.out.println(x[n][k]);
        }
    }
}

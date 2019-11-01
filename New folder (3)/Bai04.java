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
public class Bai04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, s;
        n = in.nextInt();
        s = in.nextInt();
        long f[][] = new long[n+1][1001];
        int a[] = new int [n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.fill(f[a[1]], 0);
        f[a[1]][s] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                if((j-a[i] == 0) || (f[i-1][j] == 1) ||(j-a[i] >= 0 && f[i-1][j-a[i]] == 1)){
                    f[i][j] = 1;
                }
                else{
                    f[i][j] = 0;
                }
            }
        }
        if(f[n][s] == 1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}

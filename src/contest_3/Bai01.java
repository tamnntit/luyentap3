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
public class Bai01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int c, n;
        c = in.nextInt();
        n = in.nextInt();
        int a[] = new int [n+1];
        int f[][] = new int[n+1][c+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.fill(f[0], 0);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                f[i][j] = f[i-1][j];
                if(j >= a[i] && (f[i][j] < f[i-1][j-a[i]]+a[i])){
                    f[i][j] = f[i-1][j-a[i]] + a[i];
                }
            }
        }
        System.out.println(f[n][c]);
    }
    
}

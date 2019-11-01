/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luyentap3;

import java.util.Scanner;

/**
 * Xau con chung dai nhat
 * @author nntam
 */
public class Bai2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x, y;
        x = in.nextLine();
        y = in.nextLine();
        int n = x.length(), m = x.length();
        int c[][] = new int[n+1][m+1];
        for(int i = 0; i < n; i++) c[i][0] = 0;
        for(int i = 0; i < m; i++) c[0][i] = 0;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) c[i][j] = c[i-1][j-1]+1;
                else c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
            }
        }
        System.out.println(c[n][m]);
        
    }
    
}

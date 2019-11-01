/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luyentap3;

import java.util.Scanner;

/**
 * xem phim
 * @author nntam
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int c, n, a[];
        c = in.nextInt(); n = in.nextInt();
        a = new int[n+1];
        for(int i = 1; i<= n; i++) {
          a[i] = in.nextInt();  
        }
        
        int x[][] = new int[n+1][c+1];
        for(int i = 0; i<= n; i++) x[i][c] = 0;
        for(int i = 0; i<= c; i++) x[1][i] = 0;
        
        for(int i = 1; i <= n; i++ ) {
            for(int j = 0; j <= c; j++) {
                x[i][j] = x[i-1][j];
                if(j >= a[i] && x[i][j] < x[i-1][j-a[i]]+a[i]) {
                    x[i][j] = x[i-1][j-a[i]]+a[i];
                }
            }
        }
        System.out.println(x[n][c]);
                
        
    }
    
}

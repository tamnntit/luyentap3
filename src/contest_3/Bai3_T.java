/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luyentap3;

import java.util.Scanner;

/**
 * Day con tang dai nhat
 * @author nntam
 */
public class Bai3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, a[];
        n = in.nextInt();
        a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        
        int x[] = new int[n+1];
        int max = 0;
        for(int i = 0; i <= n; i++) x[i] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(a[i] > a[j]) {
                    x[i] = Math.max(x[i], x[j] + 1);
                    
                }
            }
            if(x[i] > max) max = x[i];
        }
        System.out.println(max);
    }
    
}

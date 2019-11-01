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
public class Bai10 {

    public static Scanner in = new Scanner(System.in);
    public static int a[][] = new int[1001][1001];
    public static int n, m;

    public static void main(String[] args) {
        init();
        solve();
    }

    public static void init() {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            Arrays.fill(a[i], 0);
        }
        for (int i = 1; i <= m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x][y] = 1;
            a[y][x] = 1;
        }
    }

    public static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println("");
        }
    }

}

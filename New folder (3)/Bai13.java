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
public class Bai13 {
    public static Scanner in = new Scanner(System.in);
    public static int a[][] = new int[1001][1001];
    public static int n, m;

    public static void main(String[] args) {
        init();
        solve();
    }

    public static void init() {
        n = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= n; i++) {
            Arrays.fill(a[i], 0);
        }
        for (int i = 1; i <= n; i++) {
            String s = in.nextLine();
            String res[] = s.split(" ");
            m = res.length;
            for (int j = 0; j < m; j++) {
                int x = i;
                int y = Integer.parseInt(res[j]);
                a[x][y] = 1;
                a[y][x] = 1;
            }
        }
    }

    public static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest_3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author daoan
 */
public class Bai21 {

    public static Scanner in = new Scanner(System.in);
    public static boolean cx[] = new boolean[1001];
    public static int a[][] = new int[1001][1001];
    public static int truoc[] = new int[1001];
    public static int count, m, n, start, finish;

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            init();
            Bfs(start);
            if (cx[finish]) {
                System.out.println("-1");
            } else {
                solve();
            }
        }
    }

    public static void solve() {
        int res = 1;
        int u = finish;
        while (truoc[u] != start) {
            u = truoc[u];
            res++;
        }
        System.out.println(res);
    }

    public static void init() {
        n = in.nextInt();
        m = in.nextInt();
        start = in.nextInt();
        finish = in.nextInt();
        for (int i = 1; i <= n; i++) {
            cx[i] = true;
            Arrays.fill(a[i], 0);
            Arrays.fill(truoc, 0);
        }
        for (int i = 1; i <= m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x][y] = 1;
            a[y][x] = 1;
        }
    }

    public static void Bfs(int u) {
        Queue<Integer> qu = new LinkedList();
        qu.add(u);
        cx[u] = false;
        while (!qu.isEmpty()) {
            int v = qu.peek();
            //System.out.print(v + " ");
            qu.poll();
            for (int i = 1; i <= n; i++) {
                if (cx[i] && a[v][i] == 1) {
                    qu.add(i);
                    cx[i] = false;
                    truoc[i] = v;
                }
            }
        }
    }
}

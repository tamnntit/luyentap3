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
public class Bai23 {
    public static Scanner in = new Scanner(System.in);
    public static boolean cx[] = new boolean[1001];
    public static int a[][] = new int[1001][1001];
    //public static int truoc[] = new int[1001];
    public static int m, n, start;

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            init();
            Bfs(start);
        }
    }

    public static void init() {
        n = in.nextInt();
        m = in.nextInt();
        start = in.nextInt();
        for (int i = 1; i <= n; i++) {
            cx[i] = true;
            Arrays.fill(a[i], 0);
            //Arrays.fill(truoc, 0);
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
        String res[] = new String[n];
        int sc = 0;
        qu.add(u);
        cx[u] = false;
        while (!qu.isEmpty()) {
            int s = qu.peek();
            qu.poll();
            for (int t = 1; t <= n; t++) {
                if (cx[t] && a[s][t] == 1) {
                    res[sc] = Integer.toString(s) + " " + Integer.toString(t);
                    sc++;
                    qu.add(t);
                    cx[t] = false;
                }
            }
        }
        if(sc < n-1){
            System.out.println("-1");
        }
        else{
            for (int i = 0; i < sc; i++) {
                System.out.println(res[i]);
            }
        }
    }
}

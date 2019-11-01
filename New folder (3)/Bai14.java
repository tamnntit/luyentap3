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
 * @author nntam
 */
public class Bai14 {
    public static Scanner in = new Scanner(System.in);
    public static boolean cx[] = new boolean[1001];
    public static int a[][] = new int[1001][1001];
    public static int b[][] = new int[1001][1001];
    public static int m, n, q;

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            init();
            solve();
        }
    }

    public static void init() {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            cx[i] = true;
            Arrays.fill(a[i], 0);
            Arrays.fill(b[i], 0);
        }
        for (int i = 1; i <= m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x][y] = 1;
            a[y][x] = 1;
            b[x][y] = 1;
            b[y][x] = 1;
        }
    }

    public static void Bfs(int u) {
        Queue<Integer> qu = new LinkedList();
        int bfs[] = new int[n+1];
        int id = 0;
        qu.add(u);
        cx[u] = false;
        while(!qu.isEmpty()){
            int v = qu.peek();
            bfs[id++] = v;
            qu.poll();
            for (int i = 1; i <= n; i++) {
                if(cx[i] && a[v][i] == 1){
                    qu.add(i);
                    cx[i] = false;
                }
            }
        }
        for (int i = 0; i < id-1; i++) {
            int x = bfs[i];
            for (int j = i+1; j < id; j++) {
                int y = bfs[j];
                b[x][y] = 1;
                b[y][x] = 1;
            }
        }
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            if(cx[i]){
                Bfs(i);
            }
        }
        q = in.nextInt();
        for (int i = 1; i <= q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if(b[x][y] == 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}

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
public class Bai15 {
    public static Scanner in = new Scanner(System.in);
    public static boolean cx[] = new boolean[1001];
    public static int a[][] = new int[1001][1001];
    public static int n;

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            init();
            solve();
        }
    }

    public static void init() {
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            cx[i] = true;
            Arrays.fill(a[i], 0);
        }
        for (int i = 1; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x][y] = 1;
            a[y][x] = 1;
        }
    }
    
    public static void solve(){
        Bfs(1);
        for (int i = 1; i <= n; i++) {
            if(cx[i]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void Bfs(int u) {
        Queue<Integer> qu = new LinkedList();
        qu.add(u);
        cx[u] = false;
        while(!qu.isEmpty()){
            int v = qu.peek();
            qu.poll();
            for (int i = 1; i <= n; i++) {
                if(cx[i] && a[v][i] == 1){
                    qu.add(i);
                    cx[i] = false;
                }
            }
        }
    }
}

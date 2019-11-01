/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest_3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author daoan
 */
public class Bai22 {
    public static Scanner in = new Scanner(System.in);
    public static boolean cx[] = new boolean[1001];
    public static int a[][] = new int[1001][1001];
    public static int truoc[] = new int[1001];
    public static int r = 0, m, n, start, finish;

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            r=0;
            init();
            Dfs(start);
            if (cx[finish]) {
                System.out.println("-1");
            } else {
                System.out.println(r);
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

    public static void Dfs(int u) {
        Stack st = new Stack();
        st.push(u);
        //System.out.print(u + " ");
        cx[u] = false;
        while(!st.isEmpty()){
            int v = (int) st.peek();
            st.pop();
            for (int i = 1; i <= n; i++) {
                if(cx[i] && a[v][i] == 1){
                    cx[i] = false;
                    //System.out.print(i + " ");
                    st.push(v);
                    st.push(i);
                    truoc[i] = v;
                    r++;
                    if(i == finish) return;
                    break;
                }
            }
        }
    }
}

package test3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Bai24 {
    static LinkedList<Edge> edges;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-->0) {
            int n = sc.nextInt(), m = sc.nextInt(), u = sc.nextInt();
            LinkedList<Integer>[] adj = new LinkedList[n+1];
            edges = new LinkedList<>();
            for (int i = 0; i < n+1; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt(), b= sc.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }
            boolean[] chuaxet = new boolean[n+1];
            Arrays.fill(chuaxet, true);
            dfs(chuaxet, u, adj);
//            System.out.println(edges);
            if (edges.size() != n -1) System.out.println(-1);
            else {
                for (Edge edge : edges) {
                    System.out.println(edge.u+" "+edge.v);
                }
            }
        }
    }

    static void dfs(boolean[] chuaxet, int u, LinkedList<Integer>[] ke) {
        chuaxet[u] = false;
        for (Integer v : ke[u]) {
            if (chuaxet[v]) {
                chuaxet[v] = false;
                edges.add(new Edge(u, v));
                dfs(chuaxet, v, ke);
            }
        }
    }

    private static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    '}';
        }
    }
}

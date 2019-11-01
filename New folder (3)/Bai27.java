package luyentap3;

import java.util.HashMap;
import java.util.Scanner;

public class Bai27 {
    public static void main(String[] args) {// DUONG DI NGAN NHAT
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] mat = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt(), c = scanner.nextInt();
            mat[u][v] = c;
            mat[v][u] = c;
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        int q = scanner.nextInt();
        while (q-- > 0) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            if (map.containsKey(x)) {
                System.out.println(map.get(x)[y]);
            } else d(mat, x, y, n + 1, map);
        }
    }
    private static void d(int[][] graph, int src, int dst, int n, HashMap<Integer, int[]> map) {
        int[] dist = new int[n];
        boolean[] spt = new boolean[n];
        for (int i = 1; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }
        dist[src] = 0;
        for (int i = 1; i < n; i++) {
            int u = minDist(dist, spt);
            spt[u] = true;
            for (int j = 1; j < n; j++) {
                if (!spt[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j])
                    dist[j] = dist[u] + graph[u][j];
            }
        }
        map.put(src, dist);
        System.out.println(dist[dst]);
    }
    private static int minDist(int[] dist, boolean[] spt) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v < dist.length; v++)
            if (!spt[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest_3;

import java.util.Scanner;

/**
 *
 * @author daoan
 */
public class Bai16 {
    public static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int qx[] = new int[250001];
    public static int qy[] = new int[250001];
    public static int a[][] = new int[1001][1001];
    public static int count, m, n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (a[i][j] == 1) {
                        count++;
                        a[i][j] = 0;
                        Bfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void Bfs(int u, int v) {
        int x, y, xx, yy;
        int first = 1;
        int last = 1;
        qx[first] = u;
        qy[first] = v;
        while (first >= 1) {
            x = qx[first];
            y = qy[first];
            int k1 = first;
            for (int k = 0; k < 8; k++) {
                xx = x + dx[k];
                yy = y + dy[k];
                if (xx > 0 && yy > 0 && xx <= n && yy <= m) {
                    if (a[xx][yy] == 1) {
                        a[xx][yy] = 0;
                        first++;
                        qx[first] = xx;
                        qy[first] = yy;
                    }
                }
            }
            if (k1 == first) {
                first--;
            }
        }
    }

}

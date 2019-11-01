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
public class Bai03 {

    public static void main(String[] args) {
        int n, res;
        int a[] = new int[100010], h[] = new int[100010];
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        h[1] = 1;
        res = 1;
        for (int i = 2; i <= n; i++) {
            if (a[i] < a[h[1]]) {
                h[1] = i;
            } else if (a[i] > a[h[res]]) {
                res++;
                h[res] = i;
            } else {
                int l = 1, r = res;
                while (l < r) {
                    int mid = (l + r + 1) / 2;
                    if (a[i] > a[h[mid]]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                int mid = l;
                if (a[i] > a[h[mid]] && a[i] < a[h[mid + 1]]) {
                    h[mid + 1] = i;
                }
            }
        }
        System.out.println(res);
    }
}

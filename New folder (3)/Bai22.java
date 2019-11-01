package luyentap3;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Bai22 {
    static LinkedList<Integer> dsKe[];
    static boolean chuaXet[];
    static int t, n, m, u, v, truoc[];
    public static void main(String[] args) {// duong di dfs
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            u = sc.nextInt();
            v = sc.nextInt();
            dsKe = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                dsKe[i] = new LinkedList<>();
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                dsKe[a].add(b);
                dsKe[b].add(a);
            }
            DFS(u);
            System.out.println(result());
        }
    }
    public static void DFS(int u){
        chuaXet = new boolean[n+1];
        truoc = new int[n+1];
        for(int i = 1; i <=n; i++){
            chuaXet[i] = true;
            truoc[i] =0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(u);
        while(!stack.isEmpty()){
            u = stack.pop();
            if(chuaXet[u]){
                chuaXet[u] = false;
            }
            for(int i : dsKe[u]){
                if(chuaXet[i]){
                    truoc[i] = u;
                    stack.push(u);
                    stack.push(i);
                    break;
                }
            }
        }
    }
    public static int result(){
        int count = 1;
        if(truoc[v] == 0)
            return -1;
        while(truoc[v] != u){
            count++;
            v = truoc[v];
        }
        return count;
    }
}

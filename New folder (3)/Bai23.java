package luyentap3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai23 {
    static LinkedList<Integer> dsKe[];
    static boolean chuaXet[];
    static int t,n,m,u;
    static ArrayList<Canh> dsCanh;
    public static class Canh{// cay khung cua do thi theo thuat toan bfs
        public int dau;
        public int cuoi;
        public Canh(int dau, int cuoi) {
            this.dau = dau;
            this.cuoi = cuoi;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            m = sc.nextInt();
            u = sc.nextInt();
            dsKe = new LinkedList[n+1];
            for(int i = 1; i<=n;i++)
                dsKe[i] = new LinkedList<>();
            for(int i = 0 ; i < m ;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                dsKe[a].add(b);
                dsKe[b].add(a);
            }
            BFS(u);
            result();
        }
    }
    public static void BFS(int u){
        chuaXet = new boolean[n+1];
        dsCanh = new ArrayList<>();
        for(int i = 1; i<= n;i++)
            chuaXet[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        chuaXet[u] = false;
        while(!queue.isEmpty()){
            u = queue.poll();
            for(int i : dsKe[u]){
                if(chuaXet[i]){
                    chuaXet[i] = false;
                    queue.add(i);
                    dsCanh.add(new Canh(u,i));
                }
            }
        }
    }
    public static void result(){
        boolean isTree = true;
        for(int i = 1; i<=n; i++){
            if(chuaXet[i])
                isTree = false;
        }
        if(!isTree)
            System.out.println("-1");
        else{
            for(int i = 0; i < dsCanh.size();i++){
                System.out.println(dsCanh.get(i).dau + " " +dsCanh.get(i).cuoi);
            }
        }
    }
}

package BFS;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TaskA {

    static ArrayList<Integer> d;
    static ArrayList<Integer>[] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        g = new ArrayList[n+1];
        for(int i=0; i<n+1; i++)
            g[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (sc.nextInt()==1){
                    g[i].add(j);
                    g[j].add(i);
                }

        int a = sc.nextInt();
        int b = sc.nextInt();

        d = new ArrayList<>(n+1);
        for (int i=0;i<=n;i++)
            d.add(-1);

        bfs(a);

        System.out.println(d.get(b));
    }

    static void bfs(int a){
        d.set(a,0);

        Queue<Integer> q = new PriorityQueue<>();
        q.add(a);

        while(!q.isEmpty()){
            int u = q.peek();
            q.poll();

            for(int v : g[u])
                if(d.get(v)==-1){
                    d.set(v,d.get(u)+1);
                    q.add(v);
                }
        }
    }
}
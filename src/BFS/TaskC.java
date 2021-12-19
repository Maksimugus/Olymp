package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    static ArrayList<Integer> d;
    static ArrayList<Integer>[] g;
    static int[] pr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        pr = new int[n+1];

        g = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++)
            g[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++){
            int k = sc.nextInt();
            int p = sc.nextInt();
            g[k].add(p);
        }

        int s = sc.nextInt();
        int t = sc.nextInt();

        d = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            d.add(-1);

        bfs(s);

        System.out.println(d.get(t));
        if(d.get(t)!=-1){
            ArrayDeque<Integer> way = new ArrayDeque<>();
            for(int i = t; i!=-1; i = pr[i])
                way.addFirst(i);
            for (int w : way)
                System.out.print(w + " ");
        }
    }

    static void bfs(int start) {
        d.set(start,0);
        pr[start] = -1;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.peek();
            q.poll();

            for (int v : g[u])
                if (d.get(v) == -1) {
                    d.set(v, d.get(u) + 1);
                    q.add(v);
                    pr[v] = u;
                }
        }
    }
}

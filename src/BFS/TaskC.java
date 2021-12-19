package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    static ArrayList<Integer> d;
    static ArrayList<Integer>[] g;
    static int[] pr;
    static ArrayDeque<Integer> way;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        pr = new int[n+1];
        way  = new ArrayDeque<>();

        g = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++)
            g[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++){
            int k = sc.nextInt();
            int p = sc.nextInt();
            g[k].add(p);
            g[p].add(k);
        }

        int s = sc.nextInt();
        int t = sc.nextInt();

        d = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            d.add(-1);

        bfs(s,t);

        System.out.println(d.get(t));
        if(d.get(t)!=-1){
            for (int w : way)
                System.out.print(w + " ");
        }else
            System.out.println("-1");
    }

    static void bfs(int start, int end) {
        d.set(start,0);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.peek();
            q.poll();

            for (int v : g[u]) {
                if (d.get(v) == -1) {
                    d.set(v, d.get(u) + 1);
                    q.add(v);
                    pr[v] = u;
                }
            }
        }

        for(int i = end; i!=start; i = pr[i])
            way.addFirst(i);
        way.addFirst(start);
    }
}

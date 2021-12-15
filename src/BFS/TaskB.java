package BFS;

import java.util.*;

public class TaskB {

    static ArrayList<Integer> d;
    static ArrayList<Integer>[] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        g = new ArrayList[n+1];
        for(int i=0; i<n+1; i++)
            g[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (sc.nextInt()==1){
                    g[i].add(j);
                }

        d = new ArrayList<>(n+1);
        for (int i=0;i<=n;i++)
            d.add(-1);

        bfs(x);

        for(int i = 1; i<=n; i++)
            System.out.print(d.get(i) + " ");
    }

    static void bfs(int start){
        d.set(start,0);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);

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

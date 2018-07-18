chapter1.5-Case study, Union-Find
=================================

二次的时间太慢了!!!

```java
/**
 * Quick-find   
 */
class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }

    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; ++i)
        {
            if (id[i] == pid)
            {
                id[i] = qid;
            }
        }
    }
}
```

```java
/**
 * Quick-union
 */
class QuickUnionUF {
    private int[] a;

    public QuickUnionUF(int N) {
        a = new int[N];
        for (int i = 0; i != a.length; ++i)
        {
            a[i] = i;
        }
    }

    private int root(int i) {
        while (i != a[i])
        {
            i = a[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        a[root(p)] = root(q);
    }
}

/**
 * Depth of node x is at most lg N
 * nodeSize(x) <= nodeSize(y): size = element number of the node
 * 0: node 1 a->a
 * 1: node 2 a->b
 * 2: node 4 a->b->c d->c
 * ...
 */
```

```java
/**
 * path compression
 */
class ModifyQuickUnionUF {
    private int[] a;
    private int[] size;

    public ModifyQuickUnionUF(int N) {
        a = new int[N];
        for (int i = 0; i != a.length; ++i)
        {
            a[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != a[i])
        {
            /**
             * make every node to its grandparent
             *
             * or make every node to its root
             */
            a[i] = a[a[i]];
            i = a[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j)
        {
            return;
        }
        if (size[i] <= size[j])
        {
            a[i] = j;
            size[j] += size[i];
        }
        else
        {
            a[j] = i;
            size[i] += size[j];
        }
    }

    public boolean connected(int i, int j)
    {
        return root(i) == root(j);
    }
}
```

```java
/**
 * Monte Carlo simulation of N-by-N percolation.
 * simulate: 0.59234112
 * answer: 0.592746
 */
public class MonteOfPercolation {
    private int[] grid;
    private boolean[] open;
    private int[] size;
    private int openedCount;
    private int openedIndex;
    private int[] closedSite;
    private int n;

    public MonteOfPercolation (int N) {
        n = N;
        grid = new int[N * N + 2];
        size = new int[N * N + 2];
        open = new boolean[N * N + 2];
        open[0] = true;
        open[N * N + 1] = true;
        closedSite = new int[N * N];

        for (int i = 0; i != N * N + 2; ++i)
        {
            grid[i] = i;
            size[i] = 1;
            if (i < N * N)
            {
                closedSite[i] = i;
            }
        }

        /**
         * Get a random grid from N-by-N grids later.
         */
        StdRandom.shuffle(closedSite);

        for (int i = 1; i != N + 1; ++i)
        {
            union(i, 0);
        }

        for (int i = N * (N - 1) + 1; i != N * N + 1; ++i)
        {
            union(i, N * N + 1);
        }
    }

    private int root(int i) {
        while (i != grid[i])
        {
            grid[i] = grid[grid[i]];
            i = grid[i];
        }
        return i;
    }

    public void openRandomSite() {
        int site = closedSite[openedIndex++];
        int index = site + 1;

        open[index] = true;
        openedCount += 1;
        if ((index - 1) % n != 1 && open[index - 1] == true)
        {
            union(index - 1, index);
        }
        if ((index + 1) % n != 0 && open[index + 1] == true)
        {
            union(index + 1, index);
        }
        if ((index - n) > 0 && open[index - n] == true)
        {
            union(index - n, index);
        }
        if ((index + n) < n * n && open[index + n] == true)
        {
            union(index + n, index);
        }
    }

    public double getSimulateEstimate()
    {
        return (double) openedCount / (n * n);
    }

    public int getOpenedCount() {
        return openedCount;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j)
        {
            return;
        }

        if (q == 0 || q == n * n + 1)
        {
            grid[i] = j;
            size[j] += size[i];
        }

        if (open[p] == false || open[q] == false)
        {
            return;
        }

        if (size[i] <= size[j])
        {
            grid[i] = j;
            size[j] += size[i];
        }
        else
        {
            grid[j] = i;
            size[i] += size[j];
        }
    }

    public boolean connected(int i, int j)
    {
        return root(i) == root(j);
    }

    public static void simulate(int count) {
        int opened = 0;

        for (int i = 0; i != count; ++i)
        {
            MonteOfPercolation m = new MonteOfPercolation(1000);
            while (!m.connected(0, 1000 * 1000 + 1))
            {
                m.openRandomSite();
            }
            opened += m.getOpenedCount();
        }
        StdOut.println((double) opened / (1000 * 1000 * count));
    }

    public static void main(String[] args){
        simulate(10);
    }
}
```
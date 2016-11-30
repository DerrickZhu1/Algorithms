public class Solution {
    public boolean validTree(int n, int[][] edges) {
            int[] root = new int[n];
            for (int i = 0; i < n; i++)
                root[i] = i;
            for (int i = 0; i < edges.length; i++) {
                int root1 = find(root, edges[i][0]);
                int root2 = find(root, edges[i][1]);
                if (root1 == root2)
                   return false;
                root[root2] = root1;
            }
            
           return edges.length == n - 1;
    }
    private int find(int[] root, int e) {
            if(root[e] == e)
              return e;
            else
              return find(root, root[e]);
    }
}


Number of Connected Components in an Undirected Graph
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i; 

        for (int[] e : edges) {
           int root1 = find(roots, e[0]);
           int root2 = find(roots, e[1]);
           if (root1 != root2) {      
              roots[root1] = root2;  // union
              n--;
           }
        }
        return n;
    }
    
    public int find(int[] roots, int id) {
        while (roots[id] != id) {
           roots[id] = roots[roots[id]];  // optional: path compression
           id = roots[id];
        }
        return id;
    }
}



// build the graph using adjacent list
// DFS, using stack
    private boolean validDFS(int n, int[][] edges) {
        // build the graph using adjacent list
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // no cycle
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node])
                return false;
            visited[node] = true;
            for(int neighbor : graph.get(node))
            {
                stack.push(neighbor);
                // graph.get(neighbor).remove(node);
                graph.get(neighbor).remove(node);
            }
        }
        
        // fully connected
        for(boolean result : visited)
        {
            if(!result)
                return false;
        }
        
        return true;
    }

// build the graph using adjacent list
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // no cycle
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(0);
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            if(visited[node])
                return false;
            visited[node] = true;
            for(int neighbor : graph.get(node))
            {
                queue.offer(neighbor);
                graph.get(neighbor).remove((Integer)node);
            }
        }
        
        // fully connected
        for(boolean result : visited)
        {
            if(!result)
                return false;
        }
        
        return true;
    




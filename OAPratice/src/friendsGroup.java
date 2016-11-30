import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class friendsGroup {
	static int friendCircles(String[] friends) {
        
        if (friends == null || friends.length == 0 ) return 0;
        int n = friends.length;
                
        // queue and visited flag for BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        // min-heap holds the next friend to process at top
        PriorityQueue<Integer> remaining = new PriorityQueue<>();
        // Set<Integer> remaining = new HashSet<>();
                
        for (int i = 0; i < n; ++i) {
             visited[i] = false;
             remaining.add(i);
        }
                
        // enqueue 0, the first friend
        bfs(0, queue, visited, remaining);
                
        int circles = 0;
        while (true) {        
                int cur = queue.poll();
                char[] friendsOfCur = friends[cur].toCharArray();
                for (int i = 0; i < n; i++) {
                        if (friendsOfCur[i] == 'Y' && cur != i && !visited[i]) {
                            bfs(i, queue, visited, remaining);
                        }
                }
                        
                // Either all done or move to next circle
                if (queue.isEmpty()) {
                        circles++;
                        //all done, exit the loop
                        if (remaining.isEmpty()) break;
                        // otherwise pick up the smallest friend that has not been processed
                        bfs(remaining.peek(), queue, visited, remaining);
                }
        }
                
        return circles;
}
        
        
    static private void bfs(int idx, Queue<Integer> q, boolean[] visited, PriorityQueue<Integer> remaining ){
        q.offer(idx);
        visited[idx] = true;
        remaining.remove(idx); 
    }
    
    
    static int unionFind(String[] friends) {
    	if (friends == null || friends.length == 0 ) return 0;
    	int n = friends.length;
    	int[] roots = new int[n];
    	
    	for (int i = 0; i < n; i++) roots[i] = i;
    	
    	for (int i = 0; i < n; i++) {
    		char[] friendsOfCur = friends[i].toCharArray();
    		for (int j = 0; j < n; j++) {
    			if (friendsOfCur[j] == 'Y' && i != j) {
    				int root1 = find(roots, i);
    				int root2 = find(roots, j);
    				if (root1 != root2) {
    					roots[root1] = root2; // union
    					n--;
    				}
    				
    			}
    		}
    	}
    	
    	return n;
    		
    }
    
    public static int find(int[] roots, int id) {
    	while (roots[id] != id) {
    		roots[id] = roots[roots[id]]; // path compression
    		id = roots[id];
    	}
    	return id;
    }
    
    public static void main(String[] args) {
    	String[] inputs = new String[] {"YYNN", "YYYN", "NYYN", "NNNY"};
    	int result1 = friendCircles(inputs);
    	int result2 = unionFind(inputs);
    	System.out.println(result1);
    	System.out.println(result2);
    }
    


}

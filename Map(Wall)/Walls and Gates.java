-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room.

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

 3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

from gate to empty room
Because 0 represents gate so we can just use one queue.

public class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    int[][] DIRECTIONS = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
           for (int col = 0; col < n; col++) {
               if (rooms[row][col] == GATE) {
                 q.add(new int[] { row, col });
               }
           }
        }
        while (!q.isEmpty()) {
           int[] point = q.poll();
           int row = point[0];
           int col = point[1];
           for (int[] direction : DIRECTIONS) {
              int r = row + direction[0];
              int c = col + direction[1];
              if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                 continue;
              }
              rooms[r][c] = rooms[row][col] + 1;
              q.add(new int[] { r, c });
           }
        }
     }
}

public void wallsAndGates(int[][] rooms) {
    if (rooms.length == 0) return;
    for (int row = 0; row < rooms.length; row++) {
        for (int col = 0; col < rooms[0].length; col++) {
            if (rooms[row][col] == EMPTY) {
                rooms[row][col] = distanceToNearestGate(rooms, row, col);
            }
        }
    }
}

private int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
    int m = rooms.length;
    int n = rooms[0].length;
    int[][] distance = new int[m][n];
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { startRow, startCol });
    while (!q.isEmpty()) {
        int[] point = q.poll();
        int row = point[0];
        int col = point[1];
        for (int[] direction : DIRECTIONS) {
            int r = row + direction[0];
            int c = col + direction[1];
            // distance[r][c] != 0 represents visited
            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] == WALL
                    || distance[r][c] != 0) {
                continue;
            }
            distance[r][c] = distance[row][col] + 1;
            if (rooms[r][c] == GATE) {
                return distance[r][c];
            }
            q.add(new int[] { r, c });
        }
    }
    return Integer.MAX_VALUE;
}


















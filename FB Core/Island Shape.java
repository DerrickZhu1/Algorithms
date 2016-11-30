Island Shape

Island Shape
class IslandShape {
    private static int[] X = {0, 0, 1, -1};
    private static int[] Y = {1, -1, 0, 0};
    public int uniqueShape(int[][] matrix) {
        Set<Long> shapes = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                    Long shape = explore(matrix, row, col);
                    if (!shapes.contains(shape)) {
                        shapes.add(shape);
                    }
                }
            }
        }
        return shapes.size();
    }

    private long explore(int[][] matrix, int row, int col) {
        long shape = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        matrix[row][col] = 2;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int[] next = new int[]{point[0] + X[k], point[1] + Y[k]};
                if (next[0] < 0 || next[0] >= matrix.length || next[1] < 0 || next[1] >= matrix[0].length
                        || matrix[next[0]][next[1]] != 1) {
                    continue;
                }
                shape = shape * 10 + k;
                queue.offer(next);
                matrix[next[0]][next[1]] = 2;
            }
        }
        return shape;
    }
}
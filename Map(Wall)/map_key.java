public class Solution {
        public static class Node {
                int r;
                int c;
                Set<Character> keys = new HashSet<>();
                Node parent = null;

                Node(int r, int c) {
                        this.r = r;
                        this.c = c;
                }

        }

        public static Node shortestPath(String[] map, int sx, int sy) {

                
                Queue<Node> que = new LinkedList<>();
                que.offer(new Node(sx, sy));
                Set<Node> visited = new HashSet<>();

                while (!que.isEmpty()) {
                        Node node = que.poll();

                        if (map[node.r].charAt(node.c) == '3') {
                                return node;
                        }

                        int[] arr = {-1,0,1,0,-1};
                        for (int i = 0; i < 4; i++) {

                                int r = node.r + arr[i];
                                int c = node.c + arr[i+1];

                                if (r < 0 || r >= map.length || c < 0 || c >= map[0].length()) {
                                        continue;
                                }
                                
                                char letter = map[r].charAt(c);
                                if (letter == '0') {
                                        continue;
                                }

                                if ('A' <= letter && letter <= 'Z') {
                                        // System.out.printf("DOOR:%c\n", letter);
                                        char key = (char)('a' + (letter - 'A'));
                                        if (!node.keys.contains(key)) {
                                                // System.out.printf("node:%s does NOT contains key\n", node);
                                                continue;
                                        } else {
                                                // System.out.printf("node:%s contains key\n", node);
                                        }
                                }

                                Node neighbor = new Node(r, c);
                                neighbor.parent = node;
                                neighbor.keys.addAll(node.keys);                                
                                if ('a' <= letter && letter <= 'z') {
                                        neighbor.keys.add(letter);
                                }

                                // parent 和 keys 都变了
                                if (visited.contains(neighbor)) {
                                        continue;
                                }
                                que.offer(neighbor);
                                visited.add(neighbor);

                        }
                }
                return null;

        }
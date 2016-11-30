find 2nd mutal friend
输出是，这个user的所有二度好友，并按共同好友数排序

class MutalFriend {
    public List<GraphNode> findMutalFriends(GraphNode me) {
        Queue<GraphNode> explore = new LinkedList<>();
        Set<GraphNode> friends = new HashSet<>();
        HashMap<GraphNode, Integer> mutalToCount = new HashMap<>();

        int level = 0;
        explore.offer(me);
        friends.add(me);

        while (!explore.isEmpty() && level <= 2) {
            level++;
            int size = explore.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = explore.poll();
                for (GraphNode friend : node.friend) {
                    if (level == 1) {
                        
                        // 一度好友
                        friends.add(friend);
                        explore.offer(friend);
                        continue;

                    }

                    if (friends.contains(friend)) {
                        continue;
                    }

                    if (!mutalToCount.containsKey(friend)) {
                        mutalToCount.put(friend, 1);
                    }
                    else {
                        mutalToCount.put(friend, mutalToCount.get(friend) + 1);
                    }
                }

            }
      }
      List<GraphNode> result = new ArrayList<>();
      for (GraphNode node : mutalToCount.keySet()) {
            result.add(node);
      }
      Collections.sort(result, new NodeComparator(mutalToCount));
      return result;
}

    class NodeComparator implements Comparator<GraphNode> {
        private HashMap<GraphNode, Integer> map;
        public NodeComparator(HashMap<GraphNode, Integer> map) {
            this.map = map;
        }
        @Override
        public int compare(GraphNode node1, GraphNode node2) {
            return map.get(node2) - map.get(node1);
        }
    }
}

class GraphNode {
    String name;
    List<GraphNode> friend;
    public GraphNode(String name) {
        this.name = name;
        this.friend = new ArrayList<>();
    }
}

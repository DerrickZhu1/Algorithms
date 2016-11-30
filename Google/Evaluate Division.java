public class Solution {
    public void addArc(Map<String, Map<String, Double>> graph, String vexStart, String vexEnd, double value) {
        Map<String, Double> arcMap;
        if (graph.containsKey(vexStart)) {
            arcMap = graph.get(vexStart);
        } else {
            arcMap = new HashMap<>();
        }
        arcMap.put(vexEnd, value);
        graph.put(vexStart, arcMap);
    }

    // Map<String, Map<String, Double>> graph
    public double getValue(Map<String, Map<String, Double>> graph, String vexStart, String vexEnd) {
        if (graph.get(vexStart) == null || graph.get(vexEnd) == null) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();   //queue uesd for bfs
        // value 用来存各个点的value, 并运算
        Map<String, Double> value = new HashMap<>();    //distance from vexStart
        Set<String> validation = new HashSet<>();   //check if the vertex has been in the queue

        //init
        queue.add(vexStart);
        validation.add(vexStart);
        // 1d
        value.put(vexStart, 1d);

        String currentNode, nextNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            // Map.Entry<String, Double> arc : graph.get(currentNode).entrySet()
            for (Map.Entry<String, Double> arc : graph.get(currentNode).entrySet()) {
                nextNode = arc.getKey();
                value.put(nextNode, value.get(currentNode) * arc.getValue());
                if (nextNode.equals(vexEnd)) {
                    return value.get(vexEnd);
                } else if (!validation.contains(nextNode)) {
                    queue.add(nextNode);
                    validation.add(nextNode);
                }
            }
        }
        return -1;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            //add arcs for both directions
            addArc(graph, equations[i][0], equations[i][1], values[i]);
            addArc(graph, equations[i][1], equations[i][0], 1 / values[i]);
        }

        double[] answer = new double[queries.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = getValue(graph, queries[i][0], queries[i][1]);
        }

        return answer;
    }
}





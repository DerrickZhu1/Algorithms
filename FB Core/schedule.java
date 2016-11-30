schedule2
2. Task execution with k period cooldown (keep order), all tasks take 1 time period. e.g.
[1,1,2,1] with k = 2, time consumption is 7 (1 _ _ 1 2 _ 1)
optimize storage, you dont need to store all task numbers.
提议用LinkedHashMap，要说明至少一种implementation 方式，并且每次执行task都检查最早的element，如果执行记录远久直接移除。只有15分钟所以写了pseudo code

http://www.1point3acres.com/bbs/thread-207862-3-1.html

# task
# mission order , same task cannot be called in a period  (missions, task, cd)
    public static int missionOrder(int[] mission, int N) {
        if (mission.length == 0) {
            return 0;
        } 
        HashMap<Integer, Integer> map = new HashMap<>();
        int time = 0;
        for (int i = 0; i < mission.length; i++) {
            time++;
            if (!map.containsKey(mission[i])) {
                map.put(mission[i], time);
            }
            else {
                if (time - map.get(mission[i]) > N) {
                    map.put(mission[i], time);
                }
                else {
                    time = N + map.get(mission[i]) + 1;
                    map.put(mission[i], time);
                }
            }
        }
        return time;
    }
    


public static int schedule2(List<Character> task){
         Queue<Character> queue = new LinkedList<Character>();
         int total = 0; 
         int i = 0;
         int coolDown = 2;
        while (i < task.size() {
             if(queue.isEmpty() || !queue.contains(task.get(i))) {
                      queue.add(task.get(i));
                      i++;
             }
             else {
                    queue.add(null);
             }
                    total++;
                    if (queue.size()>coolDown){
                                queue.poll();
                     }
             }
            return total;
}



试写了一下code，先统计了frequency of tasks然后用maxHeap做的
public static String taskSchedule(String str, int k) {
        StringBuilder rearranged = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) { 
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });

        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()) {
            
            int i = 0;
            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();

            while (i <= k && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> curr = maxHeap.poll();
                rearranged.append(curr.getKey());
                curr.setValue(curr.getValue() - 1);
                temp.add(curr);
                i++;
            }
            for (Map.Entry<Character, Integer> e : temp) {
                if (e.getValue() > 0) {
                    maxHeap.offer(e);
                }
            }
        }
        return rearranged.toString();
}


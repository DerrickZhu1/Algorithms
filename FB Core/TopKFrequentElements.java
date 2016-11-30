public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer>[] bucket = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

    // getOrDefault
    for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}
	    
    //bucket[frequency]
     for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
		     bucket[frequency] = new ArrayList<>();
		 }
	   	 bucket[frequency].add(key);
	  }

	  List<Integer> res = new ArrayList<>();

	  for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		   if (bucket[pos] != null) {
			 res.addAll(bucket[pos]);
	       }
	   }
	  return res;
}


Using HashMap and Heap
O(n*log(k))

class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num = num;
        this.count = count;
    }
}
 
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else{
                map.put(num, 1);
            }
        }
 
        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.count - b.count;
            }
        });
 
        //maintain a heap of size k. 
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if (queue.size() > k) {
                queue.poll();
            }
        }
 
        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while (queue.size()>0){
            result.add(queue.poll().num);
        }
        //reverse the order
        Collections.reverse(result);
 
        return result;
    }
}

Time is O(n)

public List<Integer> topKFrequent(int[] nums, int k) {
    //count the frequency for each element
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num: nums) {
        if (map.containsKey(num)){
            map.put(num, map.get(num)+1);
        } else{
            map.put(num, 1);
        }
    }
 
    //get the max frequency
    int max = 0;
    for (Map.Entry<Integer, Integer> entry: map.entrySet()){
        max = Math.max(max, entry.getValue());
    }
 
    //initialize an array of ArrayList. index is frequency, value is list of numbers
    ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
    for (int i = 1; i <= max; i++) {
        arr[i] = new ArrayList<Integer>();
    }
 
    for (Map.Entry<Integer, Integer> entry: map.entrySet()){
        int count = entry.getValue();
        int number = entry.getKey();
        arr[count].add(number);
    }
 
    List<Integer> result = new ArrayList<Integer>();
 
    //add most frequent numbers to result
    for (int j = max; j >= 1; j--) {
        if (arr[j].size() > 0) {
            for (int a: arr[j]) {
                result.add(a);
            }
        }
 
        if (result.size() >= k)
            break;
    }
 
    return result;
}






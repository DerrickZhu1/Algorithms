1.  binary search (mlg(n))
2. O(m + n) 双指针

Map<Integer, Integer> vector1 = new HashMap<Integer, Integer>();
Map<Integer, Integer> vector2 = new HashMap<Integer, Integer>();
int size = 0;
for(int i=0; i<k; i++) {
	String line = in.nextLine();
	String[] split = line.split("\\s+");  
	int key = Integer.parseInt(split[0]);
	int value = Integer.parseInt(split[1]);
	vector1.put(key, value);
	size = size>key ? size : key;
}
for(int i=0; i<n; i++) {
	String line = in.nextLine();
	String[] split = line.split("\\s+");  
	int key = Integer.parseInt(split[0]);
	int value = Integer.parseInt(split[1]);
	vector2.put(key, value);
	size = size>key ? size : key;
}

int dotProd = 0;
for(int i=0; i<=size; i++) {
	if(vector1.get(i) != null && vector2.get(i) != null) {
		dotProd += (vector1.get(i) * vector2.get(i));
	}
}
System.out.println(dotProd);

int [][] arrm = new int[m][2];
int [][] arrn = new int[n][2];
for(int i=0;i<m;i++){
	arrm[i][0] = in.nextInt();
	arrm[i][1] = in.nextInt();
}
for(int i=0; i<n;i++){
	arrn[i][0] = in.nextInt();
	arrn[i][1] = in.nextInt();
}

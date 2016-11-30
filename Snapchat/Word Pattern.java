Given a pattern and a string str, find if str follows the same pattern.

pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        int len = pattern.length();
        if(arr.length != len){
            return false;
        }
        
        Map<Character, String> map = new HashMap<Character, String>();
        for( int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if( map.containsKey(c) && !map.get(c).equals(arr[i])) {
                return false;
            }
            else if(!map.containsKey(c) && map.containsValue(arr[i])) {
                return false;
            }
            else{
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}

else if 

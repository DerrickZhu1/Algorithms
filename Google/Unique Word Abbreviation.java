public class ValidWordAbbr {
    //Input: ["a","a"],isUnique("a") Output: [false] Expected: [true]
    Map<String, String> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String dic : dictionary) {
           String key = getKey(dic);
           if (map.containsKey(key)) {
              if(!map.get(key).equals(dic)) 
                 map.put(key, "");//duplicate case 
           } else {
                map.put(key, dic);
           }
        }
    }

    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }
    
    private String getKey(String word) {
        String key;
        if(word.length() <= 2){
            key = word;
        } else {
            key = word.charAt(0)+Integer.toString(word.length()-2) + word.charAt(word.length()-1);
        }
        return key;
    }
}


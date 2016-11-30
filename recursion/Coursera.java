import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Dict.java
public class Dict implements DictEntry {
  private Map<String, DictEntry> map;

  public Dict(Map<String, DictEntry> map) {
    this.map = map;
  }

  public boolean isDict() {
    return true;
  }

  public Set<String> getKeys() {
    return map.keySet();
  }

  public DictEntry get(String key) {
    return map.get(key);
  }
}

// DictEntry.java
public interface DictEntry {
  public boolean isDict();
}

// StringWrapper.java
public class StringWrapper implements DictEntry {

  private String str;

  public StringWrapper(String str) {
    this.str = str;
  }

  public boolean isDict() {
    return false;
  }

  public String getValue() {
    return str;
  }
}

dict("a": "apple", "b": dict("b": "blueberry")) => '{"a":"apple", "b":{"b":"blueberry", "c":"cranberry"}}'



public class Solution {
    /*
 * Complete the function below.
 */
    //dict(“a”: “apple”, “b”: dict(“b”: “blueberry”, “c”: “cranberry”))
    static String dictionaryToJson(Dict dict) {
        if(dict.getKeys.size()==0)return "";
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String key:dict.getKeys()) {
            sb.append(key+":");
            if(dict.get(key).isDict()) {
              Dict di = (Dict) dict.get(key);
              sb.append(dictionaryToJson(di));
            else {
              StringWrapper str = (StringWrapper) dict.get(key);
              sb.append(str.getValue());
            }
            sb.append(",");
        }
        String res = sb.toString().substring(0,sb.length()-1);
        return res+"}";
    }
    
    int pos=0;
    static Dict JsonToDictionary(String str){
        if(str==null||str.length()==0)return null;
        pos++;
        int start=pos;
        while(pos<str.length()&&str.charAt(pos)!='}'){
            char ch=str.charAt(pos);
            if(ch==':'){
                
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        res = dictionaryToJson();
        bw.write(res);
        bw.newLine();
        
        bw.close();
    }
}
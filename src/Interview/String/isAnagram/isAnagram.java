package Interview.String.isAnagram;

import java.util.HashMap;
import java.util.Map;

public class isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> temp = new HashMap<>();
        for (int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if (temp.containsKey(s.charAt(i))){
                temp.replace(c,temp.get(c)+1);
            }else {
                temp.put(c,1);
            }
        }
        for (int i=0;i<t.length();i++){
            Character c = t.charAt(i);
            if (temp.containsKey(c)){
                if (temp.get(c)==1){
                    temp.remove(c);
                }else {
                    temp.replace(c,temp.get(c)-1);
                }
            }else {
                return false;
            }
        }
        return true;
    }
}

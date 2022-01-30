package Interview.String.firstUniqChar;

import java.util.HashSet;
import java.util.Set;

public class firstUniqChar {
    public static int firstUniqChar(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0;i<s.length();i++){
            String str = s.substring(i,i+1);
            if (s.substring(i+1,s.length()).contains(str) ){
                set.add(str);
                continue;
            }else if (!set.contains(str)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}

package Interview2.No3lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")){
            return 0;
        }
        char bre=' ';
        int endbre=0;
        int res =1;
        for (int begin=0;begin<s.length()-1;begin++) {
            if (s.charAt(begin) != bre || endbre==begin) {
                Set<Character> set = new HashSet<>();
                set.add(s.charAt(begin));
                for (int end = begin + 1; end < s.length(); end++) {
                    Character c = s.charAt(end);
                    if (set.contains(c)) {
                        bre = c;
                        endbre=end;
                        break;
                    } else {
                        set.add(c);
                    }
                }
                res = Math.max(res, set.size());
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(lengthOfLongestSubstring(str));
    }
}

package DataStructureMID.No409longestPalindrome;

//        给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//        在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。
//
//        注意:
//        假设字符串的长度不会超过 1010。
//
//        示例 1:
//        输入:
//        "abccccdd"
//
//        输出:
//        7
//        解释:
//        我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longestPalindrome {
//    执行用时：12 ms, 在所有 Java 提交中击败了5.68%的用户
//    内存消耗：36.4 MB, 在所有 Java 提交中击败了84.49%的用户
    public static int longestPalindrome(String s) {
        List<Character> save = new ArrayList<>();
        Map<Character,Integer> temp = new HashMap<>();
        int res = 0;
        int odd = 0;
        for (int i=0;i<s.length();i++){
            if (!temp.containsKey(s.charAt(i))){
                temp.put(s.charAt(i),1);
                save.add(s.charAt(i));
            }else {
                temp.replace(s.charAt(i), temp.get(s.charAt(i))+1);
            }
        }
        for (int i=0;i<save.size();i++){
            int value = temp.get(save.get(i));
            if (value%2==0){
                res = res+value;
            }else {
                res = res+value-1;
                odd++;
            }
        }
        return odd==0?res:res+1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}

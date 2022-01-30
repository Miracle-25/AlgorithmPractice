package Interview.String.partition;

import java.util.ArrayList;
import java.util.List;

public class partition {
    static List<List<String>> res = new ArrayList<>();
    static List<String> temp = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        compute(0,s);
        return res;
    }
    public static void compute(int begin,String s){
        if (begin>=s.length()){
            List<String> str_temp = new ArrayList<>();
            for (String i:temp){
                str_temp.add(i);
            }
            res.add(str_temp);
            return;
        }
        for (int i=begin+1;i<=s.length();i++){
            String one = s.substring(begin,i);
            if (isPalindrome(one)){
                temp.add(one);
                compute(i,s);
                temp.remove(temp.size()-1);
            }
        }

    }
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

//        System.out.println(partition("aab"));
        System.out.println(partition("cbbbcc"));
    }
}
//[["c","b","b","b","c","c"],["b","b","b","c","cc"],["b","c","bb","c","c"],["b","bb","c","cc"],["c","bb","b","c","c"],["bb","b","c","cc"],["c","bbb","c","c"],["bbb","c","cc"],["cbbbc","c"]]
//
//[["c","b","b","b","c","c"],["c","b","b","b","cc"],["c","b","bb","c","c"],["c","b","bb","cc"],["c","bb","b","c","c"],["c","bb","b","cc"],["c","bbb","c","c"],["c","bbb","cc"],["cbbbc","c"]]
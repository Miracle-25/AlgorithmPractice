package Practice.No784letterCasePermutation;

//        给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
//        示例：
//        输入：S = "a1b2"
//        输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//        输入：S = "3z4"
//        输出：["3z4", "3Z4"]
//
//        输入：S = "12345"
//        输出：["12345"]
//
//        提示：
//        S的长度不超过12。
//        S仅由数字和字母组成。

import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation {
//    执行用时：8 ms, 在所有 Java 提交中击败了44.39%的用户
//    内存消耗：39.7 MB, 在所有 Java 提交中击败了5.18%的用户
    static String temp="";
    static List<String> res = new ArrayList<>();
    public static List<String> letterCasePermutation(String s) {
        count(s,s.length());
        return res;
    }

    public static void count(String s,int len){
        String save=temp;
        if (len==0){
            res.add(temp);
            return;
        }
        len--;
        if (isChar(s.charAt(0))=='0'){
            temp=save+s.charAt(0);
            count(s.substring(1),len);

        }else if (isChar(s.charAt(0))=='A'){
            temp=save+s.charAt(0);
            count(s.substring(1),len);

            temp=save+(char)(s.charAt(0)+32);
            count(s.substring(1),len);
        }else {
            temp=save+s.charAt(0);
            count(s.substring(1),len);

            temp=save+(char)(s.charAt(0)-32);
            count(s.substring(1),len--);
        }
    }

    public static Character isChar(char c){
        if (c>=65 && c<=90){
            return 'A';
        }else if (c>=97 && c<=122){
            return 'a';
        }else {
            return '0';
        }
    }

    public static void main(String[] args) {
        String test = "a1b2";
        System.out.println(letterCasePermutation(test));
//        char c='e';
//        System.out.println((char)(c-32));
    }
}

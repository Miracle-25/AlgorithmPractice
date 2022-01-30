package DataStructureMID.No5longestPalindrome;

//        给你一个字符串 s，找到 s 中最长的回文子串。
//
//        示例 1：
//        输入：s = "babad"
//        输出："bab"
//        解释："aba" 同样是符合题意的答案。
//
//        示例 2：
//        输入：s = "cbbd"
//        输出："bb"
//
//        示例 3：
//        输入：s = "a"
//        输出："a"
//
//        示例 4：
//        输入：s = "ac"
//        输出："a"

public class longestPalindrome {
//    执行用时：700 ms, 在所有 Java 提交中击败了5.01%的用户
//    内存消耗：39.1 MB, 在所有 Java 提交中击败了47.33%的用户
    public static String longestPalindrome(String s) {
        if (s.length()==1){
            return s;
        }
        String res=s.substring(0,1);
        int len = 1;
        for (int i=0;i<s.length()-len;i++){
            for (int j=s.length()-1;j>i;j--){
                if (s.charAt(i)==s.charAt(j)){
                    if (judge(s.substring(i,j+1))){
                        if (j-i+1>len){
                            len = j-i;
                            res = s.substring(i,j+1);
                        }
                    }
                }
            }
        }
        return res;

    }
    public static boolean judge(String s){
        for (int i=0,j=s.length()-1;i<j;i++,j--){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println( longestPalindrome("cbbd") );
    }
}

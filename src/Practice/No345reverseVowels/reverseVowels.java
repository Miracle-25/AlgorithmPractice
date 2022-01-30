package Practice.No345reverseVowels;
//  给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//  元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。

//        示例 1：
//        输入：s = "hello"
//        输出："holle"

//        示例 2：
//        输入：s = "leetcode"
//        输出："leotcede"

public class reverseVowels {

//    执行用时：418 ms, 在所有 Java 提交中击败了5.00%的用户
//    内存消耗：40.6 MB, 在所有 Java 提交中击败了5.00%的用户
    public static String reverseVowels1(String s) {
        int len = s.length();
        int l = 0;
        int r = len-1;
        char[] sarray = new char[len];

        while(l<=r){
            if (s.charAt(l) == 'a' || s.charAt(l) == 'e' || s.charAt(l) == 'i' || s.charAt(l) == 'o' || s.charAt(l) == 'u' ||
                    s.charAt(l) == 'A' || s.charAt(l) == 'E' || s.charAt(l) == 'I' || s.charAt(l) == 'O' || s.charAt(l) == 'U'){
                if(s.charAt(r) == 'a' || s.charAt(r) == 'e' || s.charAt(r) == 'i' || s.charAt(r) == 'o' || s.charAt(r) == 'u' ||
                        s.charAt(r) == 'A' || s.charAt(r) == 'E' || s.charAt(r) == 'I' || s.charAt(r) == 'O' || s.charAt(r) == 'U'){
                    sarray[r]=s.charAt(l);
                    sarray[l]=s.charAt(r);
                    r--;
                    l++;
                }else {
                    sarray[r]=s.charAt(r);
                    r--;
                }
            }else {
                sarray[l] = s.charAt(l);
                l++;
            }
        }
        String res = ""+sarray[0];
        for (int i=1;i<len;i++){
            res = res+sarray[i];
        }
        return res;
    }

//    执行用时：223 ms, 在所有 Java 提交中击败了5.00%的用户
//    内存消耗：41.2 MB, 在所有 Java 提交中击败了5.00%的用户
    public static String reverseVowels2(String s){
        int len = s.length();
        int l = 0;
        int r = len-1;
        String rstr = "";
        String lstr = "";

        while(l<=r){
            if (s.charAt(l) == 'a' || s.charAt(l) == 'e' || s.charAt(l) == 'i' || s.charAt(l) == 'o' || s.charAt(l) == 'u' ||
                    s.charAt(l) == 'A' || s.charAt(l) == 'E' || s.charAt(l) == 'I' || s.charAt(l) == 'O' || s.charAt(l) == 'U'){
                if(s.charAt(r) == 'a' || s.charAt(r) == 'e' || s.charAt(r) == 'i' || s.charAt(r) == 'o' || s.charAt(r) == 'u' ||
                        s.charAt(r) == 'A' || s.charAt(r) == 'E' || s.charAt(r) == 'I' || s.charAt(r) == 'O' || s.charAt(r) == 'U'){
                    rstr = s.charAt(l) + rstr;
                    if (l!=r){
                    lstr = lstr + s.charAt(r);
                    }
                    l++;
                    r--;
                }else {
                    rstr = s.charAt(r) + rstr;
                    r--;
                }
            }else {
                lstr = lstr + s.charAt(l);
                l++;
            }
        }
        return lstr+rstr;
    }

    //官方
    public String reverseVowels3(String s) {
            int n = s.length();
            char[] arr = s.toCharArray();
            int i = 0, j = n - 1;
            while (i < j) {
                while (i < n && !isVowel(arr[i])) {
                    ++i;
                }
                while (j > 0 && !isVowel(arr[j])) {
                    --j;
                }
                if (i < j) {
                    swap(arr, i, j);
                    ++i;
                    --j;
                }
            }
            return new String(arr);
        }
    public boolean isVowel(char ch) {
            return "aeiouAEIOU".indexOf(ch) >= 0;
        }
    public void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


    public static void main(String[] args) {
        //System.out.println(reverseVowels.reverseVowels("Hello"));
        System.out.println(reverseVowels2("a."));
    }
}

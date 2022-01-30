package December.No1446maxPower;

//        给你一个字符串s，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
//        请你返回字符串的能量。
//
//        示例 1：
//        输入：s = "leetcode"
//        输出：2
//        解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
//
//        示例 2：
//        输入：s = "abbcccddddeeeeedcba"
//        输出：5
//        解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
//
//        示例 3：
//        输入：s = "triplepillooooow"
//        输出：5
//
//        示例 4：
//        输入：s = "hooraaaaaaaaaaay"
//        输出：11
//
//        示例 5：
//        输入：s = "tourist"
//        输出：1


public class maxPower {

//    执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：37.1 MB, 在所有 Java 提交中击败了52.74%的用户
    public static int maxPower(String s) {
        int fin=0;
        int res = 1;
        char temp=s.charAt(0);
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)==temp){
                res++;
            }else {
                fin = Math.max(fin,res);
                res=1;
                temp=s.charAt(i);
            }
        }

        return Math.max(fin,res);
    }

    public static void main(String[] args) {
        String test = "leetcode";
        System.out.println(maxPower(test));
    }
}

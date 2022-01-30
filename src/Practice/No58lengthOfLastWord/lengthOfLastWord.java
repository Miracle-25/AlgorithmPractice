package Practice.No58lengthOfLastWord;

//        给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
//        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
//        示例 1：
//        输入：s = "Hello World"
//        输出：5
//
//        示例 2：
//        输入：s = "   fly me   to   the moon  "
//        输出：4
//
//        示例 3：
//        输入：s = "luffy is still joyboy"
//        输出：6


public class lengthOfLastWord {

//    执行用时：1 ms, 在所有 Java 提交中击败了37.44%的用户
//    内存消耗：36.8 MB, 在所有 Java 提交中击败了24.07%的用户
    public static int lengthOfLastWord1(String s) {
        String[] temp = s.split(" ");
        return temp[temp.length-1].length();
    }

//    执行用时：1 ms, 在所有 Java 提交中击败了37.44%的用户
//    内存消耗：38.6 MB, 在所有 Java 提交中击败了5.04%的用户
    public static int lengthOfLastWord2(String s) {
        return s.split(" ")[s.split(" ").length-1].length();
    }



    public static void main(String[] args) {
        System.out.println(lengthOfLastWord1("Hello World"));
        System.out.println(lengthOfLastWord1("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord1("luffy is still joyboy"));
    }

}

package December.No383canConstruct;

//        为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
//        给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
//        如果可以构成，返回 true ；否则返回 false 。
//        magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//        示例 1：
//        输入：ransomNote = "a", magazine = "b"
//        输出：false
//
//        示例 2：
//        输入：ransomNote = "aa", magazine = "ab"
//        输出：false
//
//        示例 3：
//        输入：ransomNote = "aa", magazine = "aab"
//        输出：true

import java.util.HashMap;
import java.util.Map;

public class canConstruct {
//    执行用时：10 ms, 在所有 Java 提交中击败了21.17%的用户
//    内存消耗：39 MB, 在所有 Java 提交中击败了16.76%的用户
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> temp = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            if (temp.containsKey(c)){
                temp.replace(c,temp.get(c)+1);
            }else {
                temp.put(c,1);
            }
        }
        for (int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if (!temp.containsKey(c)){
                return false;
            }else {
                temp.replace(c,temp.get(c)-1);
                if (temp.get(c)==0){
                    temp.remove(c);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(canConstruct("aab","baa"));
    }
}

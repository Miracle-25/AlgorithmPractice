package DataStructureMID.No187findRepeatedDnaSequences;

import java.util.*;

//        所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
//        编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
//
//        示例 1：
//        输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//        输出：["AAAAACCCCC","CCCCCAAAAA"]
//
//        示例 2：
//        输入：s = "AAAAAAAAAAAAA"
//        输出：["AAAAAAAAAA"]


public class findRepeatedDnaSequences {
//    执行用时：25 ms, 在所有 Java 提交中击败了25.63%的用户
//    内存消耗：47.7 MB, 在所有 Java 提交中击败了6.53%的用户
    public static List<String> findRepeatedDnaSequences(String s){
        if (s.length()<=10){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Map<String,Integer> temp = new HashMap<>();
        for (int i=0;i<s.length()-9;i++){
            if (temp.containsKey(s.substring(i,i+10))){
                if (temp.get(s.substring(i,i+10))==1){
                    res.add(s.substring(i,i+10));
                    temp.put(s.substring(i,i+10),temp.get(s.substring(i,i+10))+1);
                }
            }else {
                temp.put(s.substring(i,i+10),1);
            }
        }
        return res;
    }

//    执行用时：17 ms, 在所有 Java 提交中击败了82.92%的用户
//    内存消耗：46.9 MB, 在所有 Java 提交中击败了47.52%的用户
    public List<String> findRepeatedDnaSequences2(String s){
         List<String> res = new ArrayList<>();
         Set temp = new HashSet();

         for (int i=0;i<s.length()-10+1;i++){
             String word = s.substring(i,i+10);
             if (temp.contains(word)){
                 if (!res.contains(word)){
                 res.add(word);
                 }
             }else {
                 temp.add(word);
             }
         }
         return res;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}

package DataStructureMID.No49groupAnagrams;

//        给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//        字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
//
//        示例 1:
//        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//        示例 2:
//        输入: strs = [""]
//        输出: [[""]]
//
//        示例 3:
//        输入: strs = ["a"]
//        输出: [["a"]]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class groupAnagrams {
//    执行用时：1011 ms, 在所有 Java 提交中击败了5.00%的用户
//    内存消耗：45.4 MB, 在所有 Java 提交中击败了5.02%的用户
    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null){
            return null;
        }

        boolean[] judge = new boolean[strs.length];
        HashMap<Character,Integer>[] map = new HashMap[strs.length];
        for (int i=0;i< strs.length;i++){
            map[i]=change(strs[i]);
        }

        for (int i=0;i<strs.length;i++){
            if (!judge[i]){
             HashMap<Character, Integer> tempMap = map[i];
             List<String> temp = new ArrayList<>();
             temp.add(strs[i]);
             judge[i]=true;
             for (int j=i+1;j< strs.length;j++){
                 if (!judge[j]){
                     if (tempMap.equals(map[j])){
                         temp.add(strs[j]);
                         judge[j]=true;
                     }
                 }
             }
             res.add(temp);
            }
        }
        return res;
    }
    public static HashMap<Character,Integer> change(String strs){
        HashMap<Character,Integer> res = new HashMap<>();
        for (int i=0;i<strs.length();i++){
            if (res.containsKey(strs.charAt(i))){
                res.put(strs.charAt(i), res.get(strs.charAt(i))+1);
            }else {
                res.put(strs.charAt(i),1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"a"};
        System.out.println(groupAnagrams(test));
    }
}

package Interview.dynamic.longestSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class longestSubstring {
    public static int longestSubstring(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        for (Character c: map.keySet()){
            if (map.get(c)<k){
                list.add(c);
            }
        }
        if (list.size()<=0){
            return s.length();
        }
        List<Integer> node = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            if (list.contains(s.charAt(i))){
                node.add(i);
            }
        }
        Integer[] arr = node.toArray(new Integer[node.size()]);
        int left = 0;
        int res = 0;
        for (int i=0;i<arr.length;i++){
            if (is(s.substring(left,arr[i]),k)){
                res = arr[i]-left;
            }else {
                res = Math.max(res,longestSubstring(s.substring(left,arr[i]),k));
                System.out.println(res);
            }

            left = arr[i]+1;
        }
        if (is(s.substring(left,s.length()),k)){
            res = Math.max(res,s.length()-left);
        }else {
            res = Math.max(res,longestSubstring(s.substring(left,s.length()),k));
//            System.out.println(res);
        }

        return res;
    }

    public static   boolean is(String s,int k){
        if (s.length()<=0){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        for (int i: map.values()){
            if (i<k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("zzzzzzzzzzaaaaaaaaabbbbbbbbhbhbhbhbhbhbhicbcbcibcbccccccccccbbbbbbbbaaaaaaaaafffaahhhhhiaahiiiiiiiiifeeeeeeeeee",10));
    }
}

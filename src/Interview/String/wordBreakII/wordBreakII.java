package Interview.String.wordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBreakII {
    static List<String> list = new ArrayList<>();
    static List<String> temp = new ArrayList<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] record = new boolean[s.length()+1];
        record[0]=true;

        for (int i=1;i<s.length()+1;i++){
            for (int j=0;j<i;j++){
                String str = s.substring(j,i);
                if (record[j] && wordDict.contains(str)){
                    record[i]=true;
                    break;
                }
            }
        }
        if (record[s.length()]){
            compute(record,s,0,wordDict);
        }
        return list;
    }
    public static void compute(boolean[] record,String s,int begin,List<String> wordDict){
        if (begin==s.length()){
            list.add(changeString(temp));
            return;
        }
        for (int i=begin;i<=s.length();i++){
            if (record[i]){
                String str = s.substring(begin,i);
                if (wordDict.contains(str)){
                temp.add(s.substring(begin,i));
                compute(record,s,i,wordDict);
                temp.remove(temp.size()-1);
                }
            }
        }
    }
    public static String changeString(List<String> temp){
        String res="";
        for (String str:temp){
            res = res+" "+str;
        }
        return res.substring(1);
    }

    public static void main(String[] args) {
        String test1 = "catsanddog";
        String[] test2 = new String[]{"cat","cats","and","sand","dog"};
        System.out.println(wordBreak(test1, Arrays.asList(test2)));
    }
}

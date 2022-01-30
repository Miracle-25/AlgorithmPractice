package Interview.String.wordBreak;

import java.util.Arrays;
import java.util.List;

public class wordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
       boolean[] record = new boolean[s.length()+1];
       record[0] = true;

       for (int i=1;i<s.length()+1;i++){
           for (int j=0;j<i;j++){
               String str = s.substring(j,i);
               if (record[j] && wordDict.contains(str)){
                   record[i]=true;
                   break;
               }
           }
       }
       return record[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
    }


}

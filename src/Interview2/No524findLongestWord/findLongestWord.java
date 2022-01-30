package Interview2.No524findLongestWord;

import java.util.Collections;
import java.util.List;

public class findLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        int max=0;
        String res="";
        for(String dic:dictionary){
            if (dic.length()>max){
                if (isright(s,dic)){
                    res=dic;
                    max=dic.length();
                }
            }
        }
        return res;
    }
    public static boolean isright(String s,String dic){
        int temp=0;
        for (int i=0;i<s.length() && temp<dic.length();i++){
            if (dic.charAt(temp)==s.charAt(i)){
                temp++;
            }
        }
        return temp==dic.length();
    }

    public static void main(String[] args) {
        System.out.println(isright("abpcplea","apple"));
    }
}

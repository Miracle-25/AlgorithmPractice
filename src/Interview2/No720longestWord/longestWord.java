package Interview2.No720longestWord;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class longestWord {
    public static String longestWord(String[] words) {
        Queue<String> queue = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        String res="";
        int maxLength=0;

        for (String s:words){
            if (s.length()==1){
                queue.offer(s);
            }else {
                list.add(s);
            }
        }
        String temp="";
        while (!queue.isEmpty()){
            temp = queue.poll();
            if (list.size()>0) {
                for (int i = 0; i < list.size(); ) {
                    if (judge(temp, list.get(i))) {
                        if (temp.length() > maxLength) {
                            maxLength = temp.length();
                            res = temp;
                        }
                        queue.offer(list.get(i));
                        list.remove(list.get(i));
                    } else {
                        i++;
                    }
                }
            }else {
                if (temp.length() > maxLength) {
                    maxLength = temp.length();
                    res = temp;
                }
            }
        }
        return temp.length()>res.length()?temp:res;
    }
    public static boolean judge(String str1,String str2){
        return str2.substring(0,str2.length()-1).equals(str1);
    }

    public static void main(String[] args) {
        String[] test = new String[]
//                {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        {"t","ti","tig","tige","tiger",
                "e","en", "eng","engl","engli","englis","english",
                "h","hi","his","hist","histo","histor","history"};
        System.out.println(longestWord(test));
    }
}

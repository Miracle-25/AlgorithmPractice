package Interview.String.Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    List<String> list;
    public Trie() {
        list = new ArrayList<>();
    }

    public void insert(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        return list.contains(word);
    }

    public boolean startsWith(String prefix) {
        int len = prefix.length();
        for (String str : list){
            if (str.length()<len){
                continue;
            }
            if (str.substring(0,len).equals(prefix)){
                return true;
            }
        }
        return false;
    }
}

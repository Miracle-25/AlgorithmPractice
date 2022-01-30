package Interview.Graph.ladderLength;

import java.util.ArrayList;
import java.util.List;

public class ladderLength {

//        第一步 判断两条路通不通
//        第二步 记录当前节点走没走过
//        深度遍历
//        是否还需要计算
    static int res = 0;
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] isreach = new boolean[wordList.size()]; //记录当前节点走没走过
        for (int i=0;i<wordList.size();i++){
//            if (wordList.get(i)==beginWord){
//                continue;
//            }
            if (isPass(beginWord,wordList.get(i))){
                isreach[i]=true;
                boolean temp=canReach(wordList.get(i),endWord,wordList,isreach,1);
                if (temp){
                    break;
                }
                isreach[i]=false;
            }
        }

        return res;
    }

    public static boolean canReach(String beginWord,String endWord,List<String> wordList,boolean[] isreach,int numNode){
        for (int i=0;i<wordList.size();i++){
            if (!isreach[i]){
                if (isPass(beginWord,wordList.get(i))){
                    isreach[i] = true;
                    if (wordList.get(i).equals(endWord)){
                        res = numNode;
                        return true;
                    }else {

                        boolean canget = canReach(wordList.get(i),endWord,wordList,isreach,numNode+1);
                        if (canget){
                            return true;
                        }
                    }
                    isreach[i] = false;
                }else {
                    continue;
                }
            }
            else {
                continue;
            }
        }
        return false;
    }

    //判断两条路通不通
    public static boolean isPass(String beginWord,String endWord){
        int temp = 0;
        for (int i=0;i<beginWord.length();i++){
            if (beginWord.charAt(i) != endWord.charAt(i)){
                temp++;
            }
        }
        return temp == 1?true:false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength("hit","cog",list));
    }
}

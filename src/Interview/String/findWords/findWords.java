package Interview.String.findWords;

import java.util.ArrayList;
import java.util.List;

public class findWords {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word:words){
            if (findWord(board,word)){
                res.add(word);
            }
        }
        return res;
    }

    public static boolean findWord(char[][] board,String str){
      boolean res = false;
      char c = str.charAt(0);
      for (int i=0;i< board.length;i++){
          for (int j=0;j<board[0].length;j++){
              if (board[i][j]==c){
                  boolean[][] target = new boolean[board.length][board[0].length];
                  target[i][j]=true;
                  if (str.length()==1){
                      return true;
                  }
                  res = find(board,str.substring(1),i+1,j,target);
                  if (res){
                      return res;
                  }
                  res = find(board,str.substring(1),i,j+1,target);
                  if (res){
                      return res;
                  }
                  res = find(board,str.substring(1),i-1,j,target);
                  if (res){
                      return res;
                  }
                  res = find(board,str.substring(1),i,j-1,target);
                  if (res){
                      return res;
                  }
              }
          }
      }
      return false;
    }
    public static boolean find(char[][] board,String str,int i,int j,boolean[][] target){
        int x = board.length;
        int y = board[0].length;
        if (i<0 || i>=x || j<0 || j>=y){
            return false;
        }
        if (str.length()==1 && str.charAt(0)==board[i][j] && !target[i][j]){
            return true;
        }else if (board[i][j]!=str.charAt(0)){
            return false;
        }else if (target[i][j]){
            return false;
        }else {
            target[i][j]=true;
            if (find(board,str.substring(1),i+1,j,target)
                    || find(board,str.substring(1),i,j+1,target)
                    || find(board,str.substring(1),i-1,j,target)
                    ||find(board,str.substring(1),i,j-1,target)){
                return true;
            }else {
                target[i][j]=false;
                return false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b','c'},
                {'a','e','d'},
                {'a','f','g'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
//        System.out.println(findWords(board,words));
        System.out.println(findWord(board,"eaabcdgfa"));
    }
}

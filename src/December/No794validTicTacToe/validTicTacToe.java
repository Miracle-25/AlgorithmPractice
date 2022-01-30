package December.No794validTicTacToe;

//        给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
//        井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
//
//        以下是井字游戏的规则：
//        玩家轮流将字符放入空位（' '）中。
//        玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
//        'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
//        当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
//        当所有位置非空时，也算为游戏结束。
//        如果游戏结束，玩家不允许再放置字符。
//
//        示例 1：
//        输入：board = ["O  ","   ","   "]
//        输出：false
//        解释：玩家 1 总是放字符 "X" 。
//
//        示例 2：
//        输入：board = ["XOX"," X ","   "]
//        输出：false
//        解释：玩家应该轮流放字符。
//
//        示例 3：
//        输入：board = ["XXX","   ","OOO"]
//        输出：false
//
//        Example 4:
//        输入：board = ["XOX","O O","XOX"]
//        输出：true


public class validTicTacToe {
    static int NONE = 0;
    static int XWIN = 1;
    static int OWIN = 2;
    public static boolean validTicTacToe(String[] board) {
        int numX = 0;
        int numO = 0;
        int result = someoneWin(board);
        System.out.println(result);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (board[i].charAt(j)=='X'){
                    numX++;
                }else if (board[i].charAt(j)=='O'){
                    numO++;
                }
            }
        }
        if (numO>numX){
            return false;
        }
        if (result==0){
            if (!(numX-numO==1 || numX==numO)){
                return false;
            }
        }else if (result==1){
            if (numX-numO!=1){
                return false;
            }
        }else {
            if (numO!=numX){
                return false;
            }
        }
        return true;
    }
    public static int someoneWin(String[] board){
        for (int i=0;i<3;i++){
            if (board[i]=="XXX"){
                return XWIN;
            }
            if (board[0].charAt(i)=='X'&&
            board[1].charAt(i)=='X'&&
            board[2].charAt(i)=='X'){
                return XWIN;
            }
        }
        if (board[0].charAt(0)=='X' && board[1].charAt(1)=='X' && board[2].charAt(2)=='X'){
            return XWIN;
        }
        if (board[0].charAt(2)=='X' && board[1].charAt(1)=='X' && board[2].charAt(0)=='X'){
            return XWIN;
        }

        for (int i=0;i<3;i++){
            if (board[i]=="OOO"){
                return OWIN;
            }
            if(board[0].charAt(i)=='O'&&
                    board[1].charAt(i)=='O'&&
                    board[2].charAt(i)=='O'){
                return OWIN;
            }
        }
        if (board[0].charAt(0)=='O' && board[1].charAt(1)=='O' && board[2].charAt(2)=='O'){
            return OWIN;
        }
        if (board[0].charAt(2)=='O' && board[1].charAt(1)=='O' && board[2].charAt(0)=='O'){
            return OWIN;
        }

        return NONE;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"XXX","   ","OOO"};
        System.out.println(validTicTacToe(test));
    }
}

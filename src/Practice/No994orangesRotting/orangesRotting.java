package Practice.No994orangesRotting;

//        在给定的网格中，每个单元格可以有以下三个值之一：
//
//        值0代表空单元格；
//        值1代表新鲜橘子；
//        值2代表腐烂的橘子。
//        每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
//
//        返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
//
//        示例 1：
//        输入：[[2,1,1],[1,1,0],[0,1,1]]
//        输出：4
//
//        示例 2：
//        输入：[[2,1,1],[0,1,1],[1,0,1]]
//        输出：-1
//        解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
//
//        示例 3：
//        输入：[[0,2]]
//        输出：0
//        解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。

public class orangesRotting {
    public int orangesRotting(int[][] grid) {
        int[][] temp = grid;
        int res = 0;
        try {
        while (!judgeAll(grid)){
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                //判断grid[i][j]是是否是腐烂的橘子
                if (grid[i][j]==2){
                    //判断grid[i][j]周围是否由新鲜橘子
                    if (haveFresh(grid,i,j)){
                        //根据grid的情况腐烂新鲜橘子，记录在grid，res+1
                        becomRot(temp,i,j);
                    }
                }
                //如果每个腐烂的橘子周围都没新鲜的橘子，跳出
            }
        }
        grid=temp;
        res++;
        }
        return res;
        }catch (Exception e){
            return -1;
        }
    }
    public boolean judgeAll(int[][] temp){
        for (int i=0;i<temp.length;i++){
            for (int j=0;j<temp[0].length;j++){
                if (temp[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }
    //腐烂橘子
    public void becomRot(int[][] temp,int i,int j){
        if (i==0){
            temp[i+1][j]=2;
            if (j==0 ){
                temp[i][j+1]=2;
            }else if (j==temp[0].length-1){
                temp[i][j-1]=2;
            }else {
                temp[i][j+1]=2;
                temp[i][j-1]=2;
            }
        }
        else if (i==temp.length-1){
            temp[i-1][j]=2;
            if (j==0){
                temp[i][j+1]=2;
            }else if (j==temp[0].length-1){
                temp[i][j-1]=2;
            }else {
                temp[i][j+1]=2;
                temp[i][j-1]=2;
            }
        }
        else if (j==0){
            temp[i][j+1]=2;
            if (i==0){
                temp[i+1][j]=2;
            }else if (j==temp[0].length-1){
                temp[i-1][j]=2;
            }else {
                temp[i+1][j]=2;
                temp[i-1][j]=2;
            }
        }
        else if (j==temp[0].length-1){
            temp[i][j-1]=2;
            if (i==0){
                temp[i+1][j]=2;
            }else if (j==temp[0].length-1){
                temp[i-1][j]=2;
            }else {
                temp[i+1][j]=2;
                temp[i-1][j]=2;
            }
        }else {
            temp[i-1][j]=2;
            temp[i+1][j]=2;
            temp[i][j-1]=2;
            temp[i][j+1]=2;
        }
    }

    //判断grid[i][j]周围是否由新鲜橘子
    public boolean haveFresh(int[][] grid,int i,int j){
        if (i==0){
            if (j==0){
                if (grid[i+1][j]==1 || grid[i][j+1]==1){
                    return true;
                }else {
                    return false;
                }
            }else if (j==grid[0].length-1){
                if (grid[i+1][j]==1 || grid[i][j-1]==1){
                    return true;
                }else {
                    return false;
                }
            }else {
                if (grid[i+1][j]==1 || grid[i][j-1]==1 || grid[i][j+1]==1){
                    return true;
                }else {
                    return false;
                }
            }
        }
        else if (i==grid.length-1){
            if (j==0){
                if (grid[i-1][j]==1 || grid[i][j+1]==1){
                    return true;
                }else {
                    return false;
                }
            }else if (j==grid[0].length-1){
                if (grid[i-1][j]==1 || grid[i][j-1]==1){
                    return true;
                }else {
                    return false;
                }
            }else {
                if (grid[i-1][j]==1 || grid[i][j-1]==1 || grid[i][j+1]==1){
                    return true;
                }else {
                    return false;
                }
            }
        }
        else if (j==0){
            if (i==0){
                if (grid[i+1][j]==1 || grid[i][j+1]==1){
                    return true;
                }else {
                    return false;
                }
            }else if (i==grid.length-1){
                if (grid[i-1][j]==1 || grid[i][j+1]==1){
                    return true;
                }else {
                    return false;
                }
            }else {
                if (grid[i][j+1]==1 | grid[i-1][j]==1 | grid[i+1][j]==1){
                    return true;
                }else {
                    return false;
                }
            }

        }
        else if (j==grid[0].length-1){
            if (i==0){
                if (grid[i+1][j]==1 || grid[i][j-1]==1){
                    return true;
                }else {
                    return false;
                }
            }else if (i==grid.length-1){
                if (grid[i-1][j]==1 || grid[i][j-1]==1){
                    return true;
                }else {
                    return false;
                }
            }else {
                if (grid[i][j-1]==1 | grid[i-1][j]==1 | grid[i+1][j]==1){
                    return true;
                }else {
                    return false;
                }
            }

        }

        if (grid[i-1][j]==1 || grid[i+1][j]==1 || grid[i][j-1]==1 || grid[i][j+1]==1){
            return true;
        }else {
            return false;
        }
    }
}

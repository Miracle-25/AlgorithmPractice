package OfferII.No091minCost;

public class minCost {
    public static int minCost(int[][] costs) {
        int n = costs.length;
//        统计各个房子的颜色，记录colors[]
        int[] colors = new int[n];
//        统计截止到目前的最低价格 minCost[]
        int[] minCost = new int[n];

        colors[0]=getMinIndex(costs[0],-1);
        minCost[0]=costs[0][colors[0]];
        for (int i=1;i<n;i++){
            //        计算数组中除某个元素外最低价格temp
            int temp = getMinIndex(costs[i],colors[i-1]);
            int tempCost = minCost[i-1];
            //        temp与排除与元素相比，如果小，continue；如果大，回滚计算
            if (costs[i][temp]<=costs[i][colors[i-1]]){
                minCost[i]=tempCost+costs[i][temp];
                colors[i]=temp;
                continue;
            }else {
//                rollback
                int tempEnd = i;
                int tempColors = colors[i-1];
                int end = tempColors;
                int tempDescCost = costs[tempEnd][tempColors];
                int descCost = costs[tempEnd][temp];
                colors[tempEnd]=tempColors;
                int j=tempEnd-1;
                for (;j>=0;j--){
                    tempColors = getMinIndex(costs[j],colors[j+1]);
                    tempDescCost = costs[j][tempColors]+tempDescCost;
                    descCost = descCost+costs[j][colors[j]];
                    if (tempColors == colors[j]){
                        break;
                    }else if (descCost<=tempDescCost){
                        break;
                    }else {
                        colors[j]=tempColors;
                    }
                }
                if (j>0){
                    minCost[i]=tempDescCost+minCost[j-1];
                }else {
                    minCost[i]=tempDescCost;
                }
                colors[i]=tempColors;
            }
        }
        return minCost[n-1];
    }
    public static int getMinIndex(int[] arr,int n){
        int res = 0;
        int temp = Integer.MAX_VALUE;
        for (int i=0;i<3;i++){
            if (i==n){
                continue;
            }else if (arr[i]<temp){
                res=i;
                temp = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] test = new int[][]{{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}};
        int[][] test =new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        System.out.println(minCost(test));
    }
}

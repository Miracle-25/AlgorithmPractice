package OfferII.No88minCostClimbingStairs;

public class minCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int num = cost.length;
        if (num==1){
            return cost[0];
        }
        if (num==2){
            return cost[1];
        }
        int[] res= new int[num];
        res[0]=cost[0];
        res[1]=cost[1];
        for (int i=2;i<num;i++){
            res[i]=cost[i]+Math.min(res[i-1],res[i-2]);
        }
        return Math.min(res[num-2],res[num-1]);
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(test));
    }
}

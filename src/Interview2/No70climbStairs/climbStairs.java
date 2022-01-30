package Interview2.No70climbStairs;

public class climbStairs {
    public int climbStairs(int n){
//        if (n==1){
//            return 1;
//        }else if (n==2){
//            return 2;
//        }else {
//            return climbStairs(n-1)+climbStairs(n-2);
//        }
        int res = 3;
        int p=1,q=2;
        for (int i=0;i<n-3;i++){
            p=q;
            q=res;
            res = p+q;
        }
        return res;
    }
}

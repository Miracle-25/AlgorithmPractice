package Interview2.No322coinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class coinChange {
    static int res = 0;
    static List list = new ArrayList();
    public static int coinChange(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }
        Arrays.sort(coins);
        int[] temp = new int[coins.length];
        for (int i=0;i<coins.length;i++){
            temp[i]=coins[coins.length-1-i];
        }
        int x = compute(temp,amount);

        return x;
    }

    public static int compute(int[] coins,int amount){
        for (int i=0;i<coins.length;i++){
            if (amount>coins[i]){
                res++;
                if (compute(coins,amount-coins[i])!=-1){
                    list.add(res);
                    res--;
                    break;
                }else {
                    res--;
                    continue;
                }
            }else if (amount==coins[i]){
                res++;
                list.add(res);
                res--;
                break;
            }
        }
        return -1;
    }

//    public static int compute(int[] coins,int amount){
//        for (int i=0;i<coins.length;i++){
//            if (amount>coins[i]){
//                res++;
//                if (compute(coins,amount-coins[i])!=-1){
//                    return res;
//                }else {
//                    res--;
//                    continue;
//                }
//            }else if (amount==coins[i]){
//                res++;
//                return res;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        int[] test = new int[]{186,419,83,408};
        System.out.println(coinChange(test,6249));
    }
}

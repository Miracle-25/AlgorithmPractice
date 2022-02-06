package OfferII.No003countBits;

public class countBits {
    public static int[] countBits(int n) {
        int temp = 0;
        int[] res = new int[n+1];
        res[0]=0;
        res[1]=1;
        for (int i=2;i<n+1;i++){
            if (isTwoParent(i)){
                res[i]=1;
                temp = i;
            }else {
                res[i]=1+res[i-temp];
            }
        }

        return res;
    }
    public static boolean isTwoParent(int n){
        int mod = 0;
        while (n!=1 && mod!=1){
            mod=n%2;
            n=n/2;
        }
        return mod==1?false:true;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }
}

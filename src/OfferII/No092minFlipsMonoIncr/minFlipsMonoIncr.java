package OfferII.No092minFlipsMonoIncr;

public class minFlipsMonoIncr {
    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] res = new int[n][2];
        for (int i=0;i<n;i++){
            if (i==0){
                if (s.charAt(0)=='0'){
                    res[i][0]=0;
                    res[i][1]=1;
                }else {
                    res[i][0]=1;
                    res[i][1]=0;
                }
            }else {
                if (s.charAt(i)=='0'){
//                    res[i][0]=Math.min(res[i-1][0],res[i-1][1]+1);
                    res[i][0]=res[i-1][0];
                    res[i][1]=Math.min(res[i-1][0]+1,res[i-1][1]+1);
                }else {
                    res[i][0]=res[i-1][0]+1;
                    res[i][1]=Math.min(res[i-1][1],res[i-1][0]);
                }
            }
        }
        return Math.min(res[n-1][0],res[n-1][1]);
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00011000"));
    }
}

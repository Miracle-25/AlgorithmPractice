package OfferII.No020countSubstrings;

public class countSubstrings {
    public static int countSubstrings(String s) {
        int n=s.length();
        if (n==1){
            return 1;
        }
        int[] res = new int[n];
        res[0]=1;
        for (int i=1;i<n;i++){
            int temp = res[i-1];
            for (int j=i-1;j>=0;j--){
                if (isSubString(s.substring(j,i+1))){
                    temp++;
                }
            }
            res[i]=temp+1;
        }
        return res[n-1];
    }
    public static boolean isSubString(String s){
        int begin = 0;
        int end = s.length()-1;
        while (end>begin){
            if (s.charAt(begin)==s.charAt(end)){
                begin++;
                end--;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaaa"));
    }
}

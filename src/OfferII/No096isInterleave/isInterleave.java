package OfferII.No096isInterleave;

public class isInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.equals("")){
//            return s3.equals(s2);
//        }else if (s2.equals("")){
//            return s3.equals(s1);
//        }else if (s3.length()!=s1.length()+s2.length()){
//            return false;
//        }
//        boolean res1=true,res2=true;
//        int l1=0,l2=0;
//        int r1=0,r2=0;
//        try {
//        for (int i=0;i<s3.length();i++){
//            if (l1<s1.length() && s3.charAt(i)==s1.charAt(l1)){
//                l1++;
//            }else if (l2<s2.length() && s3.charAt(i)==s2.charAt(l2)){
//                l2++;
//            }else {
//                res1=false;
//            }
//
//            if (r2<s2.length() && s3.charAt(i)==s2.charAt(r2)){
//                r2++;
//            }else if (r1<s1.length() && s3.charAt(i)==s1.charAt(r1)){
//                r1++;
//            }else {
//                res2=false;
//            }
//        }
//        }catch (Exception e){
//            return false;
//        }
//        return res1 || res2;
        if (s1.equals("")){
            return s3.equals(s2);
        }else if (s2.equals("")){
            return s3.equals(s1);
        }else if (s3.length()!=s1.length()+s2.length()){
            return false;
        }
    }

    public static void main(String[] args) {
        String s1="aabcc";
        String s2="dbbca";
        String s3="aadbcbbcac";
        System.out.println(isInterleave(s1,s2,s3));
    }
}

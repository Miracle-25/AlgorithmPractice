package Interview2.No97isInterleave;

public class isInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.equals("") && !s2.equals(s3)){
            return false;
        }else if (s2.equals("") && !s1.equals(s3)){
            return false;
        }else if (s1.equals("") && s2.equals(s3)){
            return true;
        }else if (s2.equals("") && s1.equals(s3)){
            return true;
        }else if (s1.charAt(0)!=s3.charAt(0) && s2.charAt(0)!=s3.charAt(0)){
            return false;
        }else if ( s1.charAt(0)==s3.charAt(0)){
            for (int i=0;i<s1.length();i++){
                if (s1.charAt(i)!=s3.charAt(i)){
                    return isInterleave(s1.substring(i),s2,s3.substring(i));
                }
            }
            return isInterleave("",s2,s3.substring(s1.length()));
        }else if (s2.charAt(0)==s3.charAt(0)){
            for (int i=0;i<s2.length();i++){
                if (s2.charAt(i)!=s3.charAt(i)){
                    return isInterleave(s1,s2.substring(i),s3.substring(i));
                }
            }
            return isInterleave(s1,"",s3.substring(s2.length()));
        }
        return false;
    }

    public static boolean isInterleave2(String s1, String s2, String s3){
        String res = "";
        for (int i=0,j=0;i<s3.length();i++){
            if (j<s1.length()){
            if (s3.charAt(i)==s1.charAt(j)){
                j++;
                continue;
            }else {
                res = res+s3.charAt(i);
            }
            }else {
                res = res+s3.charAt(i);
            }
        }
        return s2.equals(res);
    }

    public static void main(String[] args) {
        String str1 ="aabcc" ;
        String str2 ="dbbca" ;
        String str3 ="aadbcbbcac" ;
        System.out.println(isInterleave2(str1,str2,str3) );
    }
}

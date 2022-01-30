package Interview.String.isPalindrome;

import java.util.Locale;

public class isPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        s = s.toLowerCase();
        while (left<right){
            if (isChar(s.charAt(left)) && isChar(s.charAt(right))){
                if (s.charAt(left)==s.charAt(right)){
                    left++;
                    right--;
                    continue;
                }else {
                    return false;
                }
            }else if (!isChar(s.charAt(left))){
                left++;
                continue;
            }else if (!isChar(s.charAt(right))){
                right--;
                continue;
            }
        }
        return true;
    }
    public boolean isChar(Character c){
        if (c>=97 && c<=122){
            return true;
        }else if (c>=48 && c<=57){
            return true;
        }else {
            return false;
        }
    }
}

package DataStructureMID.No415addStrings;

//        给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
//        你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
//
//        示例 1：
//        输入：num1 = "11", num2 = "123"
//        输出："134"
//
//        示例 2：
//        输入：num1 = "456", num2 = "77"
//        输出："533"
//        示例 3：
//
//        输入：num1 = "0", num2 = "0"
//        输出："0"

public class addStrings {
//    执行用时：11 ms, 在所有 Java 提交中击败了5.69%的用户
//    内存消耗：38.7 MB, 在所有 Java 提交中击败了7.67%的用户
    public static String addStrings(String num1, String num2) {
        int[] arr1=new int[num1.length()];
        int len1 = num1.length();
        int[] arr2=new int[num2.length()];
        int len2 = num2.length();
        for (int i=0;i<num1.length();i++){
            arr1[i]=num1.charAt(i)-48;
        }
        for (int i=0;i<num2.length();i++){
            arr2[i]=num2.charAt(i)-48;
        }
        int carry=0;
        if (len1>len2){
            for (int i=len2-1;i>-1;i--){
                arr1[len1-1] = arr1[len1-1]+carry;
                carry = (arr2[i]+arr1[len1-1])/10;
                arr1[len1-1] = (arr2[i]+arr1[len1-1])%10;
                len1--;
            }
            while (true){
            if (carry==1){
                try {
                    arr1[len1 - 1] = (arr1[len1 - 1] + 1);
                    carry = arr1[len1 - 1] / 10;
                    arr1[len1 - 1] = arr1[len1 - 1] % 10;
                    len1--;
                }catch (Exception e){
                    return "1"+change(arr1);
                }
            }else {
                return change(arr1);
            }
            }
        }else {
            for (int i=len1-1;i>-1;i--){
                arr2[len2-1] = arr2[len2-1]+carry;
                carry = (arr1[i]+arr2[len2-1])/10;
                arr2[len2-1] = (arr1[i]+arr2[len2-1])%10;
                len2--;
            }
            while (true){
                if (carry==1){
                    try {
                        arr2[len2 - 1] = (arr2[len2 - 1] + 1);
                        carry = arr2[len2 - 1] / 10;
                        arr2[len2 - 1] = arr2[len2 - 1] % 10;
                        len2--;
                    }catch (Exception e){
                        return "1"+change(arr2);
                    }
                }else {
                    return change(arr2);
                }
            }
        }
    }
    public static String change(int[] nums){
        String res = "";
        for (int i=0;i< nums.length;i++){
            res = res+nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(addStrings("923","187"));
    }
}

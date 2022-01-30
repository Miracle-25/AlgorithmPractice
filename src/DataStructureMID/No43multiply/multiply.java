package DataStructureMID.No43multiply;

//        给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
//
//        示例 1:
//        输入: num1 = "2", num2 = "3"
//        输出: "6"
//
//        示例2:
//        输入: num1 = "123", num2 = "456"
//        输出: "56088"
//
//        说明：
//        num1和num2的长度小于110。
//        num1 和num2 只包含数字0-9。
//        num1 和num2均不以零开头，除非是数字 0 本身。
//        不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。


public class multiply {
//    执行用时：8 ms, 在所有 Java 提交中击败了43.85%的用户
//    内存消耗：38.5 MB, 在所有 Java 提交中击败了53.73%的用户
    public static String multiply(String num1, String num2) {
        String res = "";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] n1 = new int[len1];
        int[] n2 = new int[len2];
        for (int i=0;i<len1;i++){
            n1[i]=num1.charAt(i)-'0';
        }
        for (int i=0;i<len2;i++){
            n2[i]=num2.charAt(i)-'0';
        }
        int[][] temp = new int[len2][len1+len2];

        for (int i=len2;i>0;i--){
            int len = len1+len2;
            for (int j=len1;j>0;j--){
                temp[temp.length-i][len- temp.length+i-1]=n2[i-1]*n1[j-1];
                len--;
            }
        }
        int[] total = new int[len1+len2];
        int ten = 0;

        for (int i=len1+len2;i>0;i--){
            int sum = ten;
            for (int j=0;j<len2;j++){
                sum = temp[j][i-1]+sum;
            }
            total[i-1]=sum%10;
            ten = sum/10;
        }
        for (int i=0;i<len1+len2;i++){
            if (res=="" && total[i]==0){
                continue;
            }else {
                res = res + total[i];
            }
        }
        return res==""?"0":res;
    }

    public static void main(String[] args) {

        System.out.println(multiply("3","2"));
    }
}

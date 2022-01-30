package Practice.No273numberToWords;

//        将非负整数 num 转换为其对应的英文表示。
//
//        示例 1：
//        输入：num = 123
//        输出："One Hundred Twenty Three"
//
//        示例 2：
//        输入：num = 12345
//        输出："Twelve Thousand Three Hundred Forty Five"
//
//        示例 3：
//        输入：num = 1234567
//        输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//
//        示例 4：
//        输入：num = 1 234 567 891
//        输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

public class numberToWords {
//    执行用时：13 ms, 在所有 Java 提交中击败了20.93%的用户
//    内存消耗：40.8 MB, 在所有 Java 提交中击败了5.34%的用户
    static int BILLION = 1000000000;
    static int MILLION = 1000000;
    static int THOUSAND = 1000;
    public static String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String res = "";

        int remainder = num%BILLION;
        int result = num/BILLION;
        switch (result){
            case 0:break;
            case 1:res = res + "One Billion";break;
            case 2:res = res + "Two Billion";break;
        }

        result = remainder/MILLION;
        remainder = remainder%MILLION;
        if (result>0){
            if (res!=""){
                res = res+" "+belowThousand(result)+" Million";
            }else {
                res = res+belowThousand(result)+" Million";
            }
        }


        result = remainder/THOUSAND;
        remainder = remainder%THOUSAND;
        if (result>0){
            if (res!=""){
                res = res+" "+belowThousand(result)+" Thousand";
                if (belowThousand(remainder)!=""){
                    res = res + " "+belowThousand(remainder);
                }
            }else {
                res = res+belowThousand(result)+" Thousand";
                if (belowThousand(remainder)!=""){
                    res = res + " "+belowThousand(remainder);
                }
            }
        }else {
            if (res!=""){
                if (belowThousand(remainder)!=""){
                    res = res + " "+belowThousand(remainder);
                }
            }else {
                if (belowThousand(remainder)!=""){
                    res = res +belowThousand(remainder);
                }
            }
        }
        return res;
    }
    public static String belowThousand(int num){
        String res = "";
        int remainder = num%100;
        int result = num/100;
        if (result>0){
        //hundred
        switch (result){
            case 1:res = res+"One";break;
            case 2:res = res+"Two";break;
            case 3:res = res+"Three";break;
            case 4:res = res+"Four";break;
            case 5:res = res+"Five";break;
            case 6:res = res+"Six";break;
            case 7:res = res+"Seven";break;
            case 8:res = res+"Eight";break;
            case 9:res = res+"Nine";break;
        }
        res = res+" "+"Hundred";
        }
        result = remainder/10;
        if (result==1) {
            if (res!=""){
            res = res + " ";
            }
            //11,12,13,...
            switch (remainder) {
                case 10:
                    res = res + "Ten";
                    break;
                case 11:
                    res = res + "Eleven";
                    break;
                case 12:
                    res = res + "Twelve";
                    break;
                case 13:
                    res = res + "Thirteen";
                    break;
                case 14:
                    res = res + "Fourteen";
                    break;
                case 15:
                    res = res + "Fifteen";
                    break;
                case 16:
                    res = res + "Sixteen";
                    break;
                case 17:
                    res = res + "Seventeen";
                    break;
                case 18:
                    res = res + "Eighteen";
                    break;
                case 19:
                    res = res + "Nineteen";
                    break;
            }
        }else {
            remainder = remainder % 10;
            if (result!=0){
                if (res!=""){
                    res = res + " ";
                }
            //20,30,40,...
            switch (result) {
                case 2:
                    res = res + "Twenty";
                    break;
                case 3:
                    res = res + "Thirty";
                    break;
                case 4:
                    res = res + "Forty";
                    break;
                case 5:
                    res = res + "Fifty";
                    break;
                case 6:
                    res = res + "Sixty";
                    break;
                case 7:
                    res = res + "Seventy";
                    break;
                case 8:
                    res = res + "Eighty";
                    break;
                case 9:
                    res = res + "Ninety";
                    break;
            }
            }
            result = remainder;
            if (res!="" && result!=0){
                res = res + " ";
            }
            switch (result){
                case 1:res = res+"One";break;
                case 2:res = res+"Two";break;
                case 3:res = res+"Three";break;
                case 4:res = res+"Four";break;
                case 5:res = res+"Five";break;
                case 6:res = res+"Six";break;
                case 7:res = res+"Seven";break;
                case 8:res = res+"Eight";break;
                case 9:res = res+"Nine";break;
            }
        }
        return res;
    }

public static void main(String[] args) {
//    2 147 483 647
//    1 234 567 891
    System.out.println(numberToWords(1000));
    System.out.println(numberToWords(1000000));
    System.out.println(numberToWords(1000000000));
    System.out.println(belowThousand(0));

    }

}

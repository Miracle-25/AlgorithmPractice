package OfferII.No001divide;

public class divide {
    public static int divide(int a, int b) {
        if (a==0){
            return 0;
        }

        if((a>=2147483647 && b==1) || (a<=-2147483648 && b==-1)){
            return 2147483647;
        }
        if((a>=2147483647 && b==-1) || (a<=-2147483648 && b==1)){
            return -2147483648;
        }

        int res=0;
        if (a>0 && b>0){
           while (a>0){
               if(a-b>=0){
                a=a-b;
                res++;
               }else {
                   break;
               }
           }
        }else if (a<0 && b<0){
            while (a<0){
                if(a-b<=0){
                a=a-b;
                res++;
                }else {
                    break;
                }
            }
        }else if (a>0 && b<0){
            while (a>0){
                if (a+b>=0){
                a=a+b;
                res--;
                }else {
                    break;
                }
            }
        }else {
            while (a<0){
                if (a+b<=0){
                a=a+b;
                res--;
                }else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(divide(-2147483648,2));
        System.out.println(divide(7,-3));
//        System.out.println(divide(0,1));
//        System.out.println(divide(1,1));
    }
}

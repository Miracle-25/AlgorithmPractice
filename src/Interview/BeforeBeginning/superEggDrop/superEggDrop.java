package Interview.BeforeBeginning.superEggDrop;

public class superEggDrop {
    public static int superEggDrop(int k, int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        return compute(k,0,n);
    }
    public static int compute(int k,int begin,int end){
        if (k==1){
            return end-begin+1;
        }
        if (end-begin==1){
            return 2;
        }
        return 1+compute(k-1,(begin+end)/2+1,end);
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(2,4));
        System.out.println(superEggDrop(2,6));
        System.out.println(superEggDrop(3,14));
    }
}

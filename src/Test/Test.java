package Test;

public class Test {
    public static void main(String[] args) {
        char a=0;
        byte[] b=new byte[100];
        System.out.println(a);
        System.out.println(b);

        for (byte i=0;i<100;i++){
            b[i] = i;
            System.out.print(i+": "+ new String(b) + "\n");
        }

        //System.out.println(new String(b));
    }
}

package Interview.StackHeapQueue.MedianFinder;

public class MedianFinder {
    double[] arr;
    int len;
    public MedianFinder() {
        arr = new double[1];
        len = 1;
    }

    public void addNum(int num) {
        if (len==1 ){
            arr[0]=num;
            len++;
        }else {
            double[] newArr = new double[arr.length+1];
            for (int i=0,j=0;i<newArr.length;i++){
                try {
                    if (arr[j]<=num){
                        newArr[i]=arr[j];
                        j++;
                    }else {
                        newArr[i]=num;
                        num = Integer.MAX_VALUE;
                    }
                }catch (Exception e){
                    newArr[i]=num;
                }
            }
            arr = newArr;
        }
    }

    public double findMedian() {
        int length = arr.length;
        int temp = length/2;
        if (length%2==0){
            return (arr[temp]+arr[temp-1])/2;
        }else {
            return arr[temp];
        }
    }

    public static void main(String[] args) {
        MedianFinder test = new MedianFinder();
        test.addNum(-1);
        test.addNum(-2);
        System.out.println(test.findMedian());
    }
}

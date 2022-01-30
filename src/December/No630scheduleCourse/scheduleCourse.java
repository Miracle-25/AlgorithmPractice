package December.No630scheduleCourse;

//        这里有 n 门不同的在线课程，按从 1 到 n编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
//        你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
//        返回你最多可以修读的课程数目。
//
//        示例 1：
//        输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
//        输出：3
//        解释：
//        这里一共有 4 门课程，但是你最多可以修 3 门：
//        首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
//        第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
//        第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
//        第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
//
//        示例 2：
//        输入：courses = [[1,2]]
//        输出：1
//
//        示例 3：
//        输入：courses = [[3,2],[4,3]]
//        输出：0

public class scheduleCourse {
    public int scheduleCourse1(int[][] courses) {
        int res = 0;
        int limit = 0;
        int now = 0;
        courses = sort(courses);
        for(int i=0;i<courses.length;i++){
            if (now+courses[i][0]<=courses[i][1] || now+courses[i][0]<=limit){
                now = now+courses[i][0];
                limit = Math.max(limit,courses[i][1]);
                res++;
            }
        }

        return res;
    }

    public static int scheduleCourse2(int[][] courses){
        System.out.println();
        int res = 0;
        courses = sort(courses);

        int limit = 0;
        int[] temp = new int[0];
//        int check = 0;

        for (int i=0;i<courses.length;i++){
            //跟新最后日期
            if (courses[i][1]>limit) {
                limit = courses[i][1];
                temp = copyArr(temp, new int[limit]);
//                check = checkEmpty(temp,courses[i][1]);
            }
            //判断当前课程能否被安排
            if (courses[i][0]<=checkEmpty(temp,courses[i][1])){
                for (int j = courses[i][1]-1,x=courses[i][0];x>0;j--){
                    if (temp[j]==0){
                        temp[j]=1;
                        x--;
                    }
                }
//                check = check-courses[i][0];
                res++;
            }
        }
        return res;
    }
    //检查某天之前还有几天空余
    public static int checkEmpty(int[] temp,int last){
        int res = 0;
        for (int i=0;i<last;i++){
            if (temp[i]==0){
                res++;
            }
        }
        return res;
    }
    //将旧的数组拷贝到新的数组
    public static int[] copyArr(int[] temp,int[] res){
        for (int i=0;i<temp.length;i++){
            res[i]=temp[i];
        }
        return res;
    }
    //将数组按持续上课天数排序
    public static int[][] sort(int[][] courses){
        for (int i=courses.length-1;i>-1;i--){
            for (int j=0;j<i;j++){
                if (courses[j][0]>courses[j+1][0]){
                    int[] temp = courses[j];
                    courses[j]=courses[j+1];
                    courses[j+1]=temp;
                }
            }
        }
        return courses;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{7,11},{1,11},{1,3},{2,6},{5,6},{7,7},{4,8},{2,20},{1,17},{8,11}};
        int[] test2 = new int[10];
        System.out.println(scheduleCourse2(test));
    }
}

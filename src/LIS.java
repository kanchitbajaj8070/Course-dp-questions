import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class LIS {
    public static void main(String[] args) {
       //int[] a={10,22,9,33,21,50,41,60,80,6};
       //answer is 6
      //  int[]a={3,2};
        int[]a={10,33,44,5,6,7,11,222,11,99};
    int [] dp=new int[a.length];
    Arrays.fill(dp,1);
        for (int i = 1; i < a.length; i++) {
             int max=1;
             for (int j = 0; j <i ; j++) {
               if(a[j]<a[i]&&dp[j]+1>max)
               {
                   max=dp[j]+1;
               }
            }
            dp[i]=max;
        }
        Arrays.sort(dp);
        System.out.println(dp[a.length-1]);
    }
}

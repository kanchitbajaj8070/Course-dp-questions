import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.next();
        String b = s.next();
        int m = a.length() - 1;
        int n = b.length() - 1;
        long t1, t2 = 0;
        int[][] memo = new int[a.length()][b.length()];
        for (int[] e : memo)
            Arrays.fill(e, -1);
  /*      t1=System.currentTimeMillis();
      int ians=  lcsRecursiveSolution(a,b,m,n);//top-down
        t2=System.currentTimeMillis();
        System.out.println(ians+" time taken"+ (t2-t1)+sb.toString());
        t1=System.currentTimeMillis();
        int iians=  lcsRecursiveSolutionBottomUp(a,b,0,0);//bottom up
        t2=System.currentTimeMillis();
        System.out.println(iians+":time taken"+(t2-t1));*/
       /* t1 = System.currentTimeMillis();
        int ans = lcdmemoization(a, b, 0, 0, memo);//memoization
        t2 = System.currentTimeMillis();
        System.out.println(ans + ":time taken" + (t2 - t1));
        */t1 = System.currentTimeMillis();
        int ans2 = lcsWithdp(a, b);//dp
        t2 = System.currentTimeMillis();
        System.out.println(ans2 + ":time taken" + (t2 - t1));
    }

    //top-down aproach
    public static StringBuilder sb = new StringBuilder();

    private static int lcsRecursiveSolution(String a, String b, int m, int n) {
        if (m < 0 || n < 0)
            return 0;

        if (a.charAt(m) == b.charAt(n)) {
            return 1 + lcsRecursiveSolution(a, b, m - 1, n - 1);
        } else {
            return Math.max(lcsRecursiveSolution(a, b, m, n - 1), lcsRecursiveSolution(a, b, m - 1, n));
        }


    }

    //bottom-up approach
    private static int lcsRecursiveSolutionBottomUp(String a, String b, int m, int n) {
        if (m >= a.length() || n >= b.length())
            return 0;
        if (a.charAt(m) == b.charAt(n))
            return 1 + lcsRecursiveSolutionBottomUp(a, b, m + 1, n + 1);
        else {
            return Math.max(lcsRecursiveSolutionBottomUp(a, b, m, n + 1), lcsRecursiveSolutionBottomUp(a, b, m + 1, n));
        }
    }

    public static int lcdmemoization(String a, String b, int m, int n, int[][] memo) {
        if (memo[m][n] != -1)
            return memo[m][n];
        if (m >= a.length() || n >= b.length())
            return 0;
        if (a.charAt(m) == b.charAt(n)) {
            memo[m][n] = 1 + lcsRecursiveSolutionBottomUp(a, b, m + 1, n + 1);
            return memo[m][n];
        } else {
            memo[m][n] = Math.max(lcsRecursiveSolutionBottomUp(a, b, m, n + 1), lcsRecursiveSolutionBottomUp(a, b, m + 1, n));

            return memo[m][n];
        }
    }

    public static int lcsWithdp(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (a.charAt(i - 1) == b.charAt(j - 1))
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
       System.out.println(commonsbsequence(a, b, dp).toUpperCase());
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[m][n];

    }
// transverse in direction opposite to how we reached the end
    public static String commonsbsequence(String a, String b, int[][] dp) {
        int m = a.length();
        int n = b.length();
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while (i >0&& j>0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1 && a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.insert(0,a.charAt(i - 1));
                i--;
                j--;

            } else if ( dp[i-1][j] > dp[i][j-1]) {
                i--;

            } else {
            j--;

            }
         }
  return sb.toString();
    }
}
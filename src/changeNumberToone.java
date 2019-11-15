public class changeNumberToone {
    public static void main(String[] args) {
        int n=21;
        int [] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
       // System.out.println(solve(n));
       int ans= solveByDp(n,dp);
        System.out.println(ans);

    }

    private static int solveByDp(int n,int[] dp) {

        for (int i = 3; i <= n; i++) {
            int a1=Integer.MAX_VALUE;
            int a2=Integer.MAX_VALUE;
            int a3=Integer.MAX_VALUE;
            if(i%2==0)
                a1=dp[i/2];
            if(i%3==0&&i>3)
            a2=dp[i/3];
            if(i-1>=1)
                a3=dp[i-1];
            dp[i]=1+Math.min(a2,Math.min(a1,a3));
            System.out.println(i+" th   "+dp[i]+"    ");
        }

    return dp[n];
    }

    private static int  solve( int n) {
        if(n<=1)
            return 0;
        if(n==2)
            return 1;
        int a1=Integer.MAX_VALUE;
        int a2=Integer.MAX_VALUE;
        int a3=Integer.MAX_VALUE;
        if(n%3==0)
            a1= 1+solve(n/3);
        if(n-1>=1)
            a2= 1+solve(n-1);
        if(n%2==0)
            a3= 1+solve(n/2);

    return Math.min(a1,Math.min(a2,a3));
    }
}

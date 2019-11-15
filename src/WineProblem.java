import java.util.Arrays;

public class WineProblem {
    static int count=0;
    public static void main(String[] args) {
        int[] cost = {2, 3, 5, 1, 4};
        int profit = 0;
        int[][]memo=new int[cost.length][cost.length];
        for(int[]e:memo)
            Arrays.fill(e,-1);
      /*  System.out.println(solveWineProbMemoization(cost, 0, cost.length - 1, 1,memo)+" count are   "+count);
        System.out.println();
        count=0;
        System.out.println(solveWineProb(cost,0,cost.length-1,0,1)+" counts are "+count);
        System.out.println(solveBydp(cost));*/
        System.out.println(solveBydp(cost));

    }

    //my approach brute force
    public static int solveWineProb(int[] cost, int s, int e, int profit, int year) {
        count++;
        if (s > e)
            return profit;
        int selectedfirst = solveWineProb(cost, s + 1, e, profit + cost[s] * year, year + 1);
        int selectedLast = solveWineProb(cost, s, e - 1, profit + cost[e] * year, year + 1);
        return Math.max(selectedfirst, selectedLast);
        /* things changing here are profit and year so 2d dp is required as two things are changing
         *  */
    }

    public static int solveBydp(int[] cost) {
        int n = cost.length;
        int year=n;
        int[][] dp = new int[n][n];
        for (int i = 0; i <n ; i++) {
            dp[i][i]=cost[i]*year;
        }
        year--;
        int s=0;
        int e=1;
        int k=1;
        while(k<n) {
            s=0;
            e=k;
            while (e < n && e > s) {
                dp[s][e] = Math.max(cost[s] * year + dp[s + 1][e], cost[e] * year + dp[s][e - 1]);
                s++;
                e++;

            }
            year--;
            k++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[0][n-1];
    }

    public static int solveWineProbMemoization(int[] cost, int s, int e, int year, int[][] memo) {

        count++;
        if (s > e)
            return 0;
        if(memo[s][e]!=-1)
            return memo[s][e];

        int selectedfirst = cost[s] * year + solveWineProbMemoization(cost, s + 1, e, year + 1, memo);
        int selectedLast = cost[e] * year + solveWineProbMemoization(cost, s, e - 1, year + 1, memo);
       memo[s][e]= Math.max(selectedfirst, selectedLast);
       return memo[s][e];
    }
}


import java.util.Arrays;

public class rodCutting {
    public static void main(String[] args) {
        int[] cost={2,3,2,5};
        int[]lengths={1,2,3,4};
        int n=cost.length;
     /*   int a=solveRodCuttingProblem(cost,lengths,0,n);
        System.out.println(a);
        int[] profit= new int[n+1];
        profit[0]=0;
        Arrays.fill(profit,-1);
        System.out.println(solveRodCuttingProblemMemoized(cost,lengths,0,n,profit));*/
        System.out.println(solveBydp(cost,lengths,n));

    }

    private static int solveRodCuttingProblem(int[] cost, int[] lengths, int i, int length) {

        if(length==0)
            return 0;
        int ans=0;
        int rrans=0;
        for (int j = 0; j < cost.length; j++) {

            if(lengths[j]<=length)
            {
                rrans=cost[j]+solveRodCuttingProblem(cost,lengths,0,length-lengths[j]);

            }
            ans=Math.max(ans,rrans);
        }

        return ans;
    }
    private static int solveRodCuttingProblemMemoized(int[] cost, int[] lengths, int i, int length,int[]profit) {

        if(length==0)
            return 0;

        if(profit[length]!=-1&&length>=0)
            return profit[length];

        int ans=0;
        int rrans=0;
        for (int j = 0; j < cost.length; j++) {

            if(lengths[j]<=length)
            {
                rrans=cost[j]+solveRodCuttingProblemMemoized(cost,lengths,0,length-lengths[j],profit);

            }
            ans=Math.max(ans,rrans);
        }
        profit[length]=ans;
        return ans;
    }


    private static int solveBydp(int[]costs,int[]lengths,int totalLength)
    {
        int [] dp= new int[totalLength+1];
        dp[0]=0;
        for (int len = 1; len <=totalLength ; len++) {
            int bestFromAllcuts=Integer.MIN_VALUE;
            for (int cutAtPos = 1; cutAtPos <=len ; cutAtPos++) {
                bestFromAllcuts=Math.max(bestFromAllcuts,costs[cutAtPos-1]+dp[totalLength-lengths[cutAtPos-1]]);
            }
            dp[len]=bestFromAllcuts;
        }


        for(int j:dp)
        {
            System.out.print(j+"    ");
        }
        System.out.println();
        return dp[totalLength];
    }
}

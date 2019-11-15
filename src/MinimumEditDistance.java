public class MinimumEditDistance {
    public static void main(String[] args) {
        /* sunday --> saturday is 3*/
        String a="sunday";
        String b="saturday";
        int ans=solveRecursion(a,b,0,0);
        System.out.println(ans);
    }

    private static int solveRecursion(String a, String b, int i, int j) {
    if(i>=a.length()||j>=b.length())
        return 0;
    int insert=Integer.MAX_VALUE;
    int ans=0;
    int del=Integer.MAX_VALUE;
    int replace=Integer.MAX_VALUE;
    if(a.charAt(i)!=b.charAt(j)) {
        insert = 1 + solveRecursion(a, b, i, j + 1);
        replace = 1 + solveRecursion(a, b, i + 1, j + 1);
        del = 1 + solveRecursion(a, b, i + 1, j);
        ans = Math.min(insert, Math.min(del, replace));
    }
    else
    {
        return solveRecursion(a,b,i+1,j+1);
    }
    return ans;
    }
}

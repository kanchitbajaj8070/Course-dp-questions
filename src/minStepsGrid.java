public class minStepsGrid {
    public static void main(String[] args) {
        int[][]grid={{1,2,3},{4,8,2},{1,5,3}};
        int n=grid.length;
        for (int i = 1; i < n; i++) {
         grid[0][i]+=grid[0][i-1];
         grid[i][0]+=grid[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println(grid[n-1][n-1]);
    }
}

import java.util.*;

public class Main{
    static int m,n;
    static int[][] map, dp;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];
        dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
    }
    
    public static int dfs(int x, int y){
        if(x == m-1 && y == n-1)
            return 1;
        if(dp[x][y] != -1)
            return dp[x][y];
        
        dp[x][y] = 0;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= m || ny >= n)
                continue;
            
            if(map[x][y] > map[nx][ny]){
                dp[x][y] += dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
}
import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] map;
    static int[][] dp;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        map = new int[n][n];
        dp = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans,dfs(i,j));
            }
        }
        System.out.println(ans);
    }
    
    public static int dfs(int x, int y){
        if(dp[x][y] != 0){
            return dp[x][y];
        }
        dp[x][y] = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;
            if(map[x][y] < map[nx][ny]){
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
}
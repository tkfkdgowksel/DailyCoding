import java.util.*;

public class Main{
    private static int dx[] = {0,0,-1,1};
    private static int dy[] = {1,-1,0,0};
    private static int[] aparts = new int[25*25];
    private static int n;
    private static int cnt = 0;
    private static boolean[][] visited = new boolean[25][25];
    private static int[][] map = new int[25][25];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            String temp = sc.next();
            for(int j = 0; j < n; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    dfs(i,j);
                }
            }
        }
        Arrays.sort(aparts);
        System.out.println(cnt);
        
        for(int i = 0; i < aparts.length; i++){
            if(aparts[i] != 0){
                System.out.println(aparts[i]);
            }
        }
    }
    
    private static void dfs(int x, int y){
        visited[x][y] = true;
        aparts[cnt]++;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}
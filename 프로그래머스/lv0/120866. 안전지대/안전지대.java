class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int x,y;
        boolean[][] boom = new boolean[board.length][board.length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                y = i;
                x = j;
                if(board[y][x] == 0)    continue;
                boom[y][x] = true;
                for(int k = 0; k < 8; k++){
                    int temp_y = y + dy[k];
                    int temp_x = x + dx[k];
                    if(temp_y < 0 || temp_y >= board.length || temp_x < 0 || temp_x >= board.length)
                        continue;
                    boom[temp_y][temp_x] = true;
                }
            }
        }
        for(int i = 0; i < boom.length; i++){
            for(int j = 0; j < boom.length; j++){
                if(!boom[i][j])
                    answer++;
            }
        }
        return answer;
    }
}
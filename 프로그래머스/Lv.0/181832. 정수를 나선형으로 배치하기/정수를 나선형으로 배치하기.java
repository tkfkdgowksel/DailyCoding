class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int dir = 0;    // 0 = 오른쪽, 1 = 밑, 2 = 왼쪽, 3 = 위쪽
        int i = 0, j = 0;
        answer[0][0] = 1;
        for(int k = 2; k <= n*n; k++){
            switch(dir){
                
                case 0:
                    if(j == n-1 || answer[i][j+1] != 0){
                        dir = 1;
                        i++;
                        answer[i][j] = k;
                    }
                    else{
                        j++;
                        answer[i][j] = k;
                    }
                    break;
                    
                case 1:
                    if(i == n-1 || answer[i+1][j] != 0){
                        dir = 2;
                        j--;
                        answer[i][j] = k;
                    }
                    else{
                        i++;
                        answer[i][j] = k;
                    }
                    break;
                    
                case 2:
                    if(j == 0 || answer[i][j-1] != 0){
                        dir = 3;
                        i--;
                        answer[i][j] = k;
                    }
                    else{
                        j--;
                        answer[i][j] = k;
                    }
                    break;
                    
                case 3:
                    if(i == 0 || answer[i-1][j] != 0){
                        dir = 0;
                        j++;
                        answer[i][j] = k;
                    }
                    else{
                        i--;
                        answer[i][j] = k;
                    }
                    break;                    
            }
        }
        return answer;
    }
}
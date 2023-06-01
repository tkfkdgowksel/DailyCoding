import java.util.Queue;
import java.util.LinkedList;

class Solution {
    boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int index, int[][] computers){
        visit[index] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i = 0; i < computers.length; i++){
                if(computers[temp][i] == 1 && !visit[i]){
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
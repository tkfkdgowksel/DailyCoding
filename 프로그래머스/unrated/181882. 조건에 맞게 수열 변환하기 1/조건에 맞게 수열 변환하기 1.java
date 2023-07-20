class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        int cnt = 0;
        for(int ans : arr){
            if(ans >= 50 && (ans%2 == 0))
                ans /= 2;
            else if(ans < 50 && (ans%2 == 1))
                ans *= 2;
            answer[cnt++] = ans;
        }
        return answer;
    }
}
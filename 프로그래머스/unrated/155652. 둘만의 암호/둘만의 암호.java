import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int count = 0;
        
        boolean[] alphabet_skip = new boolean[26];
        Arrays.fill(alphabet_skip, false);
        
        
        for(int i = 0; i < skip.length(); i++){
            alphabet_skip[skip.charAt(i) - 'a'] = true;
        }
        
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            int temp_idx = temp - 'a';
            if(temp_idx == 25)
                temp_idx = 0;
            else
                temp_idx++;
            count = 0;
            while(count < index){
                if(temp_idx == 26)
                    temp_idx = 0;
                
                if(alphabet_skip[temp_idx]){
                    temp_idx++;
                }
                else{
                    count++;
                    temp_idx++;
                }
            }
            answer += (char)(--temp_idx + 'a');            
        }
        
        return answer;
    }
}
class Solution {
    public String solution(String code) {
        String answer = "";
        boolean mode = false;
        for(int i = 0; i < code.length(); i++){
            if(mode){
                if(code.charAt(i) == '1'){
                    mode = false;
                    continue;
                }
                if(i%2 == 1){
                    answer += code.charAt(i);
                    continue;
                }
            }
            else{
                if(code.charAt(i) == '1'){
                    mode = true;
                    continue;
                }
                if(i%2 == 0){
                    answer += code.charAt(i);
                    continue;
                }
            }
        }
        if(answer.length() == 0)
            return "EMPTY";
        return answer;
    }
}
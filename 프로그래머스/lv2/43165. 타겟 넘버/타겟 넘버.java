class Solution {
    public int solution(int[] numbers, int target) {
        return dps(numbers, 0 ,0 ,target);
    }
    
    public int dps(int[] numbers, int index, int cur_sum, int target){
        if(index == numbers.length){
            if(cur_sum == target)
                return 1;
            else
                return 0;
        }
        return dps(numbers, index+1, cur_sum+numbers[index], target) 
            + dps(numbers, index+1, cur_sum-numbers[index], target);
    }
}
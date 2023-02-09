import java.util.*;

class Solution {
        int[] number;
        char[] operator;
        int[][] D_MAX;
        int[][] D_MIN;
            
    public int solution(String arr[]) {
        number = new int[arr.length / 2 + 1];
        operator = new char[arr.length];
        int number_idx = 0;
        int oper_idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0){
                number[number_idx++] = Integer.parseInt(arr[i]);
            }
            else{
                operator[oper_idx++] = arr[i].charAt(0);
            }
        }
        D_MAX = new int[number.length][number.length];
        D_MIN = new int[number.length][number.length];
        for(int[] a : D_MAX)    Arrays.fill(a,-987654321);
        for(int[] a : D_MIN)    Arrays.fill(a,987654321);
        return dinamic_max(0,number.length - 1);
            
    }
    
    public int dinamic_max(int start, int end){
        if(D_MAX[start][end] != -987654321) return D_MAX[start][end];
        if(start == end){
            D_MAX[start][end] = number[start];
            return D_MAX[start][end];
        }
        D_MAX[start][end] = 0;
        int max_value = -987654321;
        for(int k = start; k < end; k++){
            int temp_value;
            if(operator[k] == '+'){
                temp_value = dinamic_max(start,k) + dinamic_max(k+1,end);
            }
            else{
                temp_value = dinamic_max(start,k) - dinamic_min(k+1,end);
            }
            max_value = Math.max(temp_value,max_value);
        }
        D_MAX[start][end] = max_value;
        return D_MAX[start][end];
    }
    
    public int dinamic_min(int start, int end){
        if(D_MIN[start][end] != 987654321) return D_MIN[start][end];
        if(start == end){
            D_MIN[start][end] = number[start];
            return D_MIN[start][end];
        }
        D_MIN[start][end] = 0;
        int min_value = 987654321;
        for(int k = start; k < end; k++){
            int temp_value;
            if(operator[k] == '+'){
                temp_value = dinamic_min(start,k) + dinamic_min(k+1,end);
            }
            else{
                temp_value = dinamic_min(start,k) - dinamic_max(k+1,end);
            }
            min_value = Math.min(temp_value,min_value);
        }
        D_MIN[start][end] = min_value;
        return D_MIN[start][end];
    }
}
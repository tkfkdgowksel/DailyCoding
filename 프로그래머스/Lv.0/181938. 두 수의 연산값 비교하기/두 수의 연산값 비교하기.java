class Solution {
    public int solution(int a, int b) {
        String temp = Integer.toString(a) + Integer.toString(b);
        return Integer.parseInt(temp) > 2*a*b ? Integer.parseInt(temp) : 2*a*b;
    }
}
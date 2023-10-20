import java.util.*;

public class Main{
    static int n;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int ans = 0;
        int total = 1000 - n;
        while(total >= 500){
            total -= 500;
            ans++;
        }
        while(total >= 100){
            total -= 100;
            ans++;
        }
        while(total >= 50){
            total -= 50;
            ans++;
        }
        while(total >= 10){
            total -= 10;
            ans++;
        }
        while(total >= 5){
            total -= 5;
            ans++;
        }
        while(total >= 1){
            total -= 1;
            ans++;
        }
        System.out.println(ans);
    }
}
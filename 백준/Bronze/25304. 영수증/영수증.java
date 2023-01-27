import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int n = sc.nextInt();
        int ret = 0;
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ret += a * b;
        }
        if(X == ret)
            System.out.println("Yes");
        else
            System.out.println("No");
        return;
    }
}
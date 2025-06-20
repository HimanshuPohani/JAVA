import java.util.Scanner;
public class q6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =1; i<n;i++){
            if(i%3 ==0 || i%5 ==0){
                System.err.println(i);
            }
        }
    }
}
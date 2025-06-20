import java.util.Scanner;
public class q5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1;i<=10;i++){
            System.err.println(n +"x"+i+"="+(n*i));
        }
    }
}
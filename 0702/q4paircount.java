
import java.util.Scanner;
public class q4paircount {
    public static void main(String[] args) {
        System.out.println("輸入n ：");  //使用者輸入值
        Scanner target = new Scanner(System.in);
        int n = target.nextInt();
        
        int []arr = new int[n];
        for(int i =0; i<n;i++){
            arr[i] = target.nextInt();
        }


        int count = 0;  // 配對總數
        int ops=0;//迴圈次數

        for(int i=0; i<n-1 ; i++){
            for(int j=i+1; j<n ; j++){
                count++;
                ops++;
            }
        }
        System.out.println(count);
        System.out.println(ops);
    }
}

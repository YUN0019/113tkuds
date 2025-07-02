
import java.util.Scanner;
public class q2seqsearch {
    public static void main(String[] args) {
        System.out.println("輸入Key值：");
        Scanner target = new Scanner(System.in);
        int key = target.nextInt();

        int [] n ={1,3,5,7,9,11,13};
        boolean found = false;
        for(int i =0; i<n.length ; i++){
            if(n[i] == key){
                found = true;
                break;
            }
        }
            if(found){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
    }
    
}

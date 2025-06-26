import java.util.Scanner;

public class ds_02{
    public static void main(String[] var0) {
        
        try (Scanner x = new Scanner(System.in)) {
            System.out.println("輸入圓半徑：");
            int i = x.nextInt();

            System.out.println("面積："+i*i*3.14);
        }
     
    }
}
import java.util.Scanner;

public class ds_03{
    public static void main(String[] var0) {
        
        Scanner x = new Scanner(System.in);
        System.out.println("輸入您的名字：");
        String name = x.nextLine();
        System.out.println("輸入您的年齡：");
        int age = x.nextInt();
        System.out.println("您的城市：");
        String city = x.nextLine();
        
        System.out.println("名子："+name + "年齡："+age + "城市："+city);
        
     

    }
}
import java.util.Scanner;
public class linear_search_trace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int []arr = {1,3,5,7,9};
        int index = seq(arr, 7);
        if(index == -1) {
            System.out.println("沒有查找到");
        } else {
            System.out.println("找到, 索引為 = "+index);
        }
    }


public static int seq(int[] arr, int value) {
    //逐一比對，發現有相同值就返回索引
    for(int i = 0; i < arr.length; i++){
        if(arr[i] == value) {
            return i;
        }
    }
return -1;
    }
}

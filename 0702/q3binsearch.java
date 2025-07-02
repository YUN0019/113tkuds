
import java.util.Scanner;

public class q3binsearch {
    // 二元搜尋演算法 架構
    public static int binarySearch(int[] arr, int key) {
    int left = 0;
    int right = arr.length - 1;
    int count =0;

    while (left <= right) {
        int mid = (left + right) / 2;
        count++;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        
    }
    System.out.println(count);  // 這個位置是不管怎樣都要印出count 次數
    return -1;
}
    public static void main(String[] args) {
        System.out.println("請輸入key值：");
        Scanner target = new Scanner(System.in);
        int key = target.nextInt();
        int []arr = {2,4,6,8,10,12,14,16};
        int result = binarySearch(arr, key);
        System.out.println(result);
        
    }
  

 }

 /*
二元搜尋演算法

  public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;  //用來計算次數

        while (left <= right) {
            int mid = (left + right) / 2;
            count++;

            if (arr[mid] == key) {
                System.out.println(count); // 👈 找到時也印出操作次數
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(count); // 👈 找不到也要印
        return -1;
    }
  */


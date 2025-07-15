/*
 * Time Complexity: O(1)
 * 說明：陣列長度固定為 7，反轉時最多只需 3 次交換，操作次數為常數。
 */
package midterm;

import java.util.Scanner;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }
        // 反轉陣列
        for (int l = 0, r = 6; l < r; l++, r--) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        for (int i = 0; i < 7; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：走訪 n 筆輸入資料，依序存入陣列並輸出，n 為站點數。
 */
package midterm;

import java.util.Scanner;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] station = new String[n];
        int[][] price = new int[n][2];
        for (int i = 0; i < n; i++) {
            station[i] = sc.next();
            price[i][0] = sc.nextInt();
            price[i][1] = sc.nextInt();
        }
        System.out.println("Station|Standard|Business");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s|%d|%d\n", station[i], price[i][0], price[i][1]);
        }
    }
}

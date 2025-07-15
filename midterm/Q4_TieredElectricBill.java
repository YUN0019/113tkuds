/*
 * Time Complexity: O(n)
 * 說明：每個用電量計算費用時，僅需依序檢查各級距，總共走訪 n 次輸入，n 為用戶數。
 */
package midterm;

import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] kwhs = new int[n];
        for (int i = 0; i < n; i++) {
            kwhs[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int bill = calc(kwhs[i]);
            sum += bill;
            System.out.println("Bill: $" + bill);
        }
        int avg = (int)Math.round(sum * 1.0 / n);
        System.out.println("Total: $" + sum);
        System.out.println("Average: $" + avg);
    }

    // 計算單一用戶電費
    private static int calc(int kwh) {
        int[] limits = {120, 330, 500, 700, 1000};
        double[] prices = {1.68, 2.45, 3.61, 4.39, 4.97, 8.46};
        int[] seg = new int[6];
        int remain = kwh;
        for (int i = 0; i < 5; i++) {
            int use = Math.min(remain, limits[i] - (i == 0 ? 0 : limits[i-1]));
            seg[i] = use;
            remain -= use;
        }
        seg[5] = remain;
        
        double total = 0;
        for (int i = 0; i < 6; i++) {
            total += seg[i] * prices[i];
        }
        return (int)Math.round(total);
    }
}

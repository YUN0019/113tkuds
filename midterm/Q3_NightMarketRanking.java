/*
 * Time Complexity: O(n^2)
 * 說明：使用選擇排序，每次外圈需遍歷 n 次，內圈最多 n 次，總共 n(n-1)/2 次比較。
 */
package midterm;

import java.util.Locale;
import java.util.Scanner;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // 保證小數點為 .
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }
        // 選擇排序（由大到小）
        for (int i = 0; i < Math.min(5, n); i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            // 交換
            double tmp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = tmp;
        }
        // 輸出前 5 名（或全部）
        for (int i = 0; i < Math.min(5, n); i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
    }
}

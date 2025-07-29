/*
 * Time Complexity: O(n)
 * 說明：每個收入計算稅額時，僅需依序檢查各級距，總共走訪 n 次輸入，n 為收入筆數。
 */

import java.util.Scanner;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取收入筆數
        int n = sc.nextInt();
        
        // 2025年綜合所得稅級距（假設值，實際應根據官方規定）
        int[] thresholds = {0, 560000, 1260000, 2520000, 4720000, Integer.MAX_VALUE};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};
        
        int totalTax = 0;
        
        // 處理每個收入
        for (int i = 0; i < n; i++) {
            int income = sc.nextInt();
            int tax = calculateTax(income, thresholds, rates);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }
        
        // 計算並輸出平均稅額
        int avgTax = (int)Math.round(totalTax * 1.0 / n);
        System.out.println("Average: $" + avgTax);
    }
    
    // 計算個人所得稅
    private static int calculateTax(int income, int[] thresholds, double[] rates) {
        int tax = 0;
        
        // 依序計算各級距稅額
        for (int i = 0; i < rates.length; i++) {
            int lowerBound = thresholds[i];
            int upperBound = thresholds[i + 1];
            
            if (income > lowerBound) {
                int taxableAmount = Math.min(income, upperBound) - lowerBound;
                tax += (int)(taxableAmount * rates[i]);
            }
        }
        
        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：使用記憶化動態規劃，每個階梯只計算一次，避免重複計算，n 為階梯數。
 */

import java.util.Scanner;

public class F08_ClimbStairsMemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取階梯數
        int n = sc.nextInt(); // n ≤ 40
        
        // 使用記憶化動態規劃計算路徑數
        long ways = climbStairsMemo(n);
        
        // 輸出結果
        System.out.println("Ways: " + ways);
    }
    
    // 記憶化陣列，避免重複計算
    private static long[] memo = new long[41]; // n ≤ 40
    
    // 使用記憶化動態規劃計算爬樓梯路徑數
    private static long climbStairsMemo(int n) {
        // 基礎情況
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        
        // 檢查是否已經計算過
        if (memo[n] != 0) {
            return memo[n];
        }
        
        // 遞迴關係式：f(n) = f(n-1) + f(n-2) + f(n-3)
        memo[n] = climbStairsMemo(n - 1) + 
                   climbStairsMemo(n - 2) + 
                   climbStairsMemo(n - 3);
        
        return memo[n];
    }
}

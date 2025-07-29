/*
 * Time Complexity: O(log(min(a,b)))
 * 說明：使用輾轉相減法遞迴求GCD，每次遞迴至少減少一半，再計算LCM = a*b/GCD。
 */

import java.util.Scanner;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取兩個正整數
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // 計算GCD
        int gcd = gcdRecursive(a, b);
        
        // 計算LCM = a*b/GCD
        long lcm = (long)a * b / gcd;
        
        // 輸出結果
        System.out.println("LCM: " + lcm);
    }
    
    // 使用輾轉相減法遞迴求GCD
    private static int gcdRecursive(int a, int b) {
        // 基礎情況：當其中一個數為0時，另一個數即為GCD
        if (a == 0) return b;
        if (b == 0) return a;
        
        // 遞迴情況：輾轉相減法
        if (a > b) {
            return gcdRecursive(a - b, b);
        } else {
            return gcdRecursive(a, b - a);
        }
    }
}

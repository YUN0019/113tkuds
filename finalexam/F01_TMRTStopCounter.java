/*
 * Time Complexity: O(n)
 * 說明：需遍歷一次停靠站序列找起點與終點索引，n 為停靠站數量。
 */


import java.util.Scanner;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取停靠站數量
        int n = sc.nextInt(); // 1≤n≤131
        
        // 讀取停靠站序列
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next(); // 站代碼 (例 R10、G07)
        }
        
        // 讀取起訖站代碼
        String start = sc.next();
        String end = sc.next();
        
        // 尋找起訖站索引
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIdx = i;
            }
            if (stops[i].equals(end)) {
                endIdx = i;
            }
        }
        
        // 檢查是否找到起訖站
        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            // 計算含兩端的停靠站數 = |i1-i2|+1
            int count = Math.abs(startIdx - endIdx) + 1;
            System.out.println(count);
        }
    }
}

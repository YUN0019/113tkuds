/*
 * Time Complexity: O(log n)
 * 說明：將時刻表轉換為分鐘後，利用二分搜尋找出第一個大於查詢時間的班次，n 為班次數量。
 */

 // -encoding UTF-8 
package midterm;

import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        String[] timeStrs = new String[n];
        for (int i = 0; i < n; i++) {
            timeStrs[i] = sc.next();
            times[i] = toMinutes(timeStrs[i]);
        }
        String queryStr = sc.next();
        int query = toMinutes(queryStr);

        int idx = binarySearch(times, query);
        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(timeStrs[idx]);
        }
    }

    // 將 HH:mm 轉換為自 00:00 起的分鐘數
    private static int toMinutes(String t) {
        String[] parts = t.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 回傳第一個大於 query 的索引，若無則回傳 n
    private static int binarySearch(int[] arr, int query) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > query) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
 
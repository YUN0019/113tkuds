/*
 * Time Complexity: O(log n)
 * 說明：將時間轉換為分鐘後，利用二分搜尋找出第一個大於查詢時間的時刻，n 為回補時刻數量。
 */



import java.util.Scanner;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取回補時刻數量
        int n = sc.nextInt();
        
        // 讀取已排序的回補時刻表
        int[] times = new int[n];
        String[] timeStrs = new String[n];
        for (int i = 0; i < n; i++) {
            timeStrs[i] = sc.next(); // HH:mm 格式
            times[i] = toMinutes(timeStrs[i]); // 轉換為分鐘
        }
        
        // 讀取查詢時間
        String queryStr = sc.next();
        int query = toMinutes(queryStr);
        
        // 使用二分搜尋找到第一個大於查詢時間的時刻
        int idx = binarySearch(times, query);
        
        // 輸出結果
        if (idx == n) {
            System.out.println("No bike");
        } else {
            System.out.println(timeStrs[idx]);
        }
    }
    
    // 將 HH:mm 格式轉換為自 00:00 起的分鐘數
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    
    // 二分搜尋：回傳第一個大於 query 的索引，若無則回傳 n
    private static int binarySearch(int[] arr, int query) {
        int left = 0, right = arr.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > query) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}

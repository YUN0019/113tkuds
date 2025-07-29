/*
 * Time Complexity: O(n)
 * 說明：使用遞迴分治法，每次將陣列分成兩半，合併時比較兩個子陣列的最大值和次大值，n 為陣列長度。
 */

import java.util.Scanner;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取陣列長度
        int n = sc.nextInt(); // n≥2
        
        // 讀取陣列元素
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 使用遞迴找到第二大值
        int secondMax = findSecondLargest(arr, 0, n - 1);
        
        // 輸出結果
        System.out.println("SecondMax: " + secondMax);
    }
    
    // 遞迴找到第二大值，回傳 (max, second) 對
    private static int findSecondLargest(int[] arr, int left, int right) {
        // 基礎情況：只有一個元素
        if (left == right) {
            return Integer.MIN_VALUE; // 沒有次大值
        }
        
        // 基礎情況：只有兩個元素
        if (left + 1 == right) {
            return Math.min(arr[left], arr[right]);
        }
        
        // 遞迴情況：分治法
        int mid = (left + right) / 2;
        
        // 遞迴處理左半部分
        int leftSecond = findSecondLargest(arr, left, mid);
        int leftMax = Math.max(arr[left], arr[mid]);
        
        // 遞迴處理右半部分
        int rightSecond = findSecondLargest(arr, mid + 1, right);
        int rightMax = Math.max(arr[mid + 1], arr[right]);
        
        // 合併結果：找到整體的最大值和次大值
        int globalMax = Math.max(leftMax, rightMax);
        int globalSecond = Math.max(
            Math.min(leftMax, rightMax),  // 較小的最大值
            Math.max(leftSecond, rightSecond)  // 兩個次大值中的較大者
        );
        
        return globalSecond;
    }
}

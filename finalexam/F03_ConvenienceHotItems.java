/*
 * Time Complexity: O(n²)
 * 說明：使用插入排序，最壞情況下需要 n(n-1)/2 次比較和交換，n 為商品數量。
 */

import java.util.Scanner;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取商品數量
        int n = sc.nextInt(); // n ≤ 200
        
        // 讀取商品資料
        String[] names = new String[n];
        int[] qtys = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            qtys[i] = sc.nextInt();
        }
        
        // 使用插入排序按銷售量從高到低排序
        insertionSort(names, qtys);
        
        // 輸出前10名商品
        int outputCount = Math.min(10, n);
        for (int i = 0; i < outputCount; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
    }
    
    // 插入排序：按銷售量從高到低排序
    private static void insertionSort(String[] names, int[] qtys) {
        int n = names.length;
        for (int i = 1; i < n; i++) {
            String currentName = names[i];
            int currentQty = qtys[i];
            int j = i - 1;
            
            // 將當前商品插入到正確位置
            while (j >= 0 && qtys[j] < currentQty) {
                names[j + 1] = names[j];
                qtys[j + 1] = qtys[j];
                j--;
            }
            
            names[j + 1] = currentName;
            qtys[j + 1] = currentQty;
        }
    }
}

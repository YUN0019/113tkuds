/*
 * Time Complexity: O(n)
 * 說明：遍歷字串一次計算字母頻次，再檢查奇數頻次字母數量，n 為字串長度。
 */

import java.util.Scanner;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取一行字串
        String input = sc.nextLine();
        
        // 判斷是否能重排成回文
        boolean canFormPalindrome = checkAnagramPalindrome(input);
        
        // 輸出結果
        if (canFormPalindrome) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
    
    // 判斷字串是否能重排成回文
    private static boolean checkAnagramPalindrome(String str) {
        // 統計字母頻次（大小寫不區分，忽略非字母）
        int[] letterCount = new int[26];
        
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                // 轉換為小寫並計算頻次
                int index = Character.toLowerCase(c) - 'a';
                letterCount[index]++;
            }
        }
        
        // 計算奇數頻次的字母數量
        int oddCount = 0;
        for (int count : letterCount) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        
        // 回文條件：最多只能有一個奇數頻次的字母（作為中心）
        return oddCount <= 1;
    }
}

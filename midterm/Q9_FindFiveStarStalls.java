/*
 * Time Complexity: O(n)
 * 說明：走訪 n 筆評分資料，依序檢查是否等於 5，n 為攤位數。
 */
package midterm;

import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                if (found) System.out.print(" ");
                System.out.print(i);
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
}

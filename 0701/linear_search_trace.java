import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        // 陣列可寫死
        int[] s = {1, 3, 5, 7, 9};

        // 使用 Scanner 讀取使用者輸入
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數字：");
        int target = scanner.nextInt();

        boolean found = false;

        // 線性搜尋並印出比對過程
        for (int i = 0; i < s.length; i++) {
            System.out.println("比對中：" + target + " vs " + s[i]);
            if (s[i] == target) {
                found = true;
                break; // 找到即結束搜尋
            }
        }

        // 結果輸出
        if (found) {
            System.out.println("結果：找到");
        } else {
            System.out.println("結果：沒找到");
        }

        scanner.close();
    }
}

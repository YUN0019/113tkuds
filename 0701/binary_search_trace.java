import java.util.Scanner;

public class binary_search_trace {
    public static void main(String[] args) {
        // 已排序的整數陣列（升冪）
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要搜尋的數字：");
        int target = scanner.nextInt();

        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.printf("搜尋範圍：left = %d, right = %d, mid = %d → arr[mid] = %d\n",
                              left, right, mid, arr[mid]);

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1; // 向右搜尋
            } else {
                right = mid - 1; // 向左搜尋
            }
        }

        if (found) {
            System.out.println("結果：已找到！");
        } else {
            System.out.println("結果：找不到該數字。");
        }

        // 額外補充比較效率
        System.out.println("\n🔍 效率比較：");
        System.out.println("二元搜尋時間複雜度：O(log n)");
        System.out.println("線性搜尋時間複雜度：O(n)");
        System.out.println("※ 當資料筆數變大時，二元搜尋更快速！");
    }
}

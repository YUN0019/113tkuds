public class array_mode_count {
    public static void main(String[] args) {
        // 自訂陣列內容
        int[] arr = {3, 7, 3, 1, 1, 1};

        int maxCount = 0;
        int mode = arr[0];

        // 使用巢狀迴圈找出眾數
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            // 印出比對過程
            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

            // 若當前次數大於最大次數，更新眾數與次數
            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        // 印出結果
        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}

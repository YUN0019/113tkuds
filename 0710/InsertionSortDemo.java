class InsertionSortDemo {
    /**
     * 插入排序實作
     * 時間複雜度：最佳 O(n)，最壞 O(n²)，平均 O(n²)
     * 空間複雜度：O(1)
     * 穩定性：穩定排序
     * 特點：對於小規模或部分排序的資料效率很高
     */
    static void insertionSort(int[] array) {
        int n = array.length;
        int totalComparisons = 0;
        int totalShifts = 0;
        
        System.out.println("插入排序過程：");
        System.out.println("已排序部分 | 未排序部分");
        System.out.println("------------|------------");
        
        for (int i = 1; i < n; i++) {
            int key = array[i];  // 當前要插入的元素
            int j = i - 1;       // 已排序部分的最後一個元素索引
            
            System.out.printf("\n第 %d 步：插入元素 %d\n", i, key);
            
            // 顯示當前狀態
            System.out.print("插入前：");
            for (int k = 0; k < i; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.print("| ");
            for (int k = i; k < n; k++) {
                if (k == i) {
                    System.out.print("[" + array[k] + "] ");
                } else {
                    System.out.print(array[k] + " ");
                }
            }
            System.out.println();
            
            // 將比 key 大的元素向右移動
            while (j >= 0 && array[j] > key) {
                totalComparisons++;
                System.out.printf("  比較 %d > %d，將 %d 向右移動\n", 
                                array[j], key, array[j]);
                array[j + 1] = array[j];
                totalShifts++;
                j--;
            }
            
            if (j >= 0) {
                totalComparisons++;  // 最後一次比較
            }
            
            // 插入 key 到正確位置
            array[j + 1] = key;
            System.out.printf("  將 %d 插入到位置 %d\n", key, j + 1);
            
            // 顯示插入後的狀態
            System.out.print("插入後：");
            for (int k = 0; k <= i; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.print("| ");
            for (int k = i + 1; k < n; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }
        
        System.out.printf("\n排序完成！總比較次數：%d，總移動次數：%d\n", 
                        totalComparisons, totalShifts);
    }
    
    /**
     * 二分插入排序：使用二分搜尋找到插入位置
     */
    static void binaryInsertionSort(int[] array) {
        System.out.println("\n二分插入排序過程：");
        
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            
            // 使用二分搜尋找到插入位置
            int insertPos = binarySearchInsertPosition(array, 0, i - 1, key);
            
            System.out.printf("將 %d 插入到位置 %d\n", key, insertPos);
            
            // 將元素向右移動
            for (int j = i; j > insertPos; j--) {
                array[j] = array[j - 1];
            }
            
            array[insertPos] = key;
            System.out.println("目前陣列：" + java.util.Arrays.toString(array));
        }
    }
    
    /**
     * 在已排序的陣列區間中找到插入位置
     */
    static int binarySearchInsertPosition(int[] array, int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        int[] numbers1 = {64, 34, 25, 12, 22, 11, 90};
        int[] numbers2 = numbers1.clone();
        
        System.out.println("原始陣列：" + java.util.Arrays.toString(numbers1));
        
        // 基本插入排序
        System.out.println("\n=== 基本插入排序 ===");
        insertionSort(numbers1);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers1));
        
        // 二分插入排序
        System.out.println("\n=== 二分插入排序 ===");
        binaryInsertionSort(numbers2);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers2));
    }
}

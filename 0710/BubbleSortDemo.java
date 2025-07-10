class BubbleSortDemo {
    /**
     * 基本氣泡排序實作
     * 時間複雜度：最佳 O(n)，最壞 O(n²)，平均 O(n²)
     * 空間複雜度：O(1)
     * 穩定性：穩定排序
     */
    static void bubbleSort(int[] array) {
        int n = array.length;
        int totalComparisons = 0;
        int totalSwaps = 0;
        
        System.out.println("氣泡排序過程：");
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            int roundComparisons = 0;
            int roundSwaps = 0;
            
            System.out.printf("\n第 %d 輪排序：\n", i + 1);
            
            // 每一輪都會將當前最大的元素「浮」到正確位置
            for (int j = 0; j < n - i - 1; j++) {
                roundComparisons++;
                totalComparisons++;
                
                System.out.printf("比較 array[%d]=%d 與 array[%d]=%d ", 
                                j, array[j], j + 1, array[j + 1]);
                
                if (array[j] > array[j + 1]) {
                    // 交換相鄰元素
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    
                    swapped = true;
                    roundSwaps++;
                    totalSwaps++;
                    System.out.println("→ 交換");
                } else {
                    System.out.println("→ 不交換");
                }
            }
            
            System.out.printf("第 %d 輪結束：比較 %d 次，交換 %d 次\n", 
                            i + 1, roundComparisons, roundSwaps);
            System.out.println("目前陣列：" + java.util.Arrays.toString(array));
            
            // 最佳化：如果這一輪沒有交換，代表陣列已經排序完成
            if (!swapped) {
                System.out.println("提早結束：陣列已經排序完成");
                break;
            }
        }
        
        System.out.printf("\n排序完成！總比較次數：%d，總交換次數：%d\n", 
                        totalComparisons, totalSwaps);
    }
    
    /**
     * 改良版氣泡排序：雙向氣泡排序（雞尾酒排序）
     */
    static void cocktailSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        boolean swapped = true;
        
        System.out.println("\n雞尾酒排序過程：");
        
        while (swapped && left < right) {
            swapped = false;
            
            // 從左到右，將大元素往右移
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            right--;
            
            // 從右到左，將小元素往左移
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
            left++;
            
            System.out.println("目前陣列：" + java.util.Arrays.toString(array));
        }
    }
    
    public static void main(String[] args) {
        int[] numbers1 = {64, 34, 25, 12, 22, 11, 90};
        int[] numbers2 = numbers1.clone();
        
        System.out.println("原始陣列：" + java.util.Arrays.toString(numbers1));
        
        // 基本氣泡排序
        System.out.println("\n=== 基本氣泡排序 ===");
        bubbleSort(numbers1);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers1));
        
        // 雞尾酒排序
        System.out.println("\n=== 雞尾酒排序 ===");
        cocktailSort(numbers2);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers2));
    }
}

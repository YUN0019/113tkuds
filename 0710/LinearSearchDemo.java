public class LinearSearchDemo {
   
        /**
         * 基本線性搜尋：找到第一個符合的元素
         * 時間複雜度：最佳 O(1)，最壞 O(n)，平均 O(n/2)
         * 空間複雜度：O(1)
         */
        static int linearSearch(int[] array, int target) {
            int comparisons = 0;
            
            for (int i = 0; i < array.length; i++) {
                comparisons++;
                System.out.printf("第 %d 次比較：array[%d] = %d，目標值 = %d\n", 
                                comparisons, i, array[i], target);
                
                if (array[i] == target) {
                    System.out.printf("找到目標值！總共比較了 %d 次\n", comparisons);
                    return i;  // 找到了，回傳索引位置
                }
            }
            
            System.out.printf("找不到目標值，總共比較了 %d 次\n", comparisons);
            return -1;  // 找不到，回傳 -1
        }
        
        /**
         * 進階線性搜尋：找到所有符合的元素位置
         */
        static int[] linearSearchAll(int[] array, int target) {
            // 首先計算有多少個符合的元素
            int count = 0;
            for (int value : array) {
                if (value == target) {
                    count++;
                }
            }
            
            // 如果沒有找到任何符合的元素
            if (count == 0) {
                return new int[0];  // 回傳空陣列
            }
            
            // 建立結果陣列並填入所有符合的索引
            int[] result = new int[count];
            int resultIndex = 0;
            
            for (int i = 0; i < array.length; i++) {
                if (array[i] == target) {
                    result[resultIndex++] = i;
                }
            }
            
            return result;
        }
        
        public static void main(String[] args) {
            int[] numbers = {64, 25, 12, 22, 11, 90, 22, 15};
            int target = 22;
            
            System.out.println("陣列內容：" + java.util.Arrays.toString(numbers));
            System.out.println("搜尋目標：" + target);
            System.out.println();
            
            // 基本線性搜尋
            System.out.println("=== 基本線性搜尋 ===");
            int result = linearSearch(numbers, target);
            
            if (result != -1) {
                System.out.printf("在索引位置 %d 找到目標值 %d\n", result, target);
            } else {
                System.out.printf("找不到目標值 %d\n", target);
            }
            
            // 搜尋所有符合的位置
            System.out.println("\n=== 搜尋所有符合位置 ===");
            int[] allPositions = linearSearchAll(numbers, target);
            
            if (allPositions.length > 0) {
                System.out.printf("目標值 %d 出現在以下位置：", target);
                for (int i = 0; i < allPositions.length; i++) {
                    System.out.print(allPositions[i]);
                    if (i < allPositions.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.printf("\n總共出現 %d 次\n", allPositions.length);
            } else {
                System.out.printf("找不到目標值 %d\n", target);
            }
        }
    }
    


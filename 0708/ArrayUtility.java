public class ArrayUtility {
   

        // 列印陣列內容
        public static void printArray(int[] array) {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    
        // 原地反轉陣列
        public static void reverseArray(int[] array) {
            int left = 0, right = array.length - 1;
            while (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    
        // 複製陣列
        public static int[] copyArray(int[] array) {
            int[] copy = new int[array.length];

            for (int i = 0; i < array.length; i++) {
                copy[i] = array[i];
            }
            return copy;
        }
    
        // 找出第二大的數值
        public static int findSecondLargest(int[] array) {
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
    
            for (int num : array) {
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num > second && num < first) {
                    second = num;
                }
            }
    
            return second;
        }
    
        // 主程式
        public static void main(String[] args) {
            int[] array = {3, 7, 1, 9, 4, 6, 8, 2, 5};
    
            System.out.print("原始陣列：");
            printArray(array);
    
            int[] copiedArray = copyArray(array);
            System.out.print("複製陣列：");
            printArray(copiedArray);
    
            reverseArray(array);
            System.out.print("反轉後的陣列：");
            printArray(array);
    
            int secondLargest = findSecondLargest(array);
            System.out.println("第二大的數值：" + secondLargest);
        }
    }
    

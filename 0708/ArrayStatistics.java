public class ArrayStatistics {
    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        double average;
        int max = numbers[0], min = numbers[0];
        int maxIndex = 0, minIndex = 0;
        int countAboveAverage = 0;
        int evenCount = 0, oddCount = 0;

        // 計算總和、最大最小值及其索引位置
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            sum += num;

            if (num > max) {
                max = num;
                maxIndex = i;
            }
            if (num < min) {
                min = num;
                minIndex = i;
            }

            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        average = (double) sum / numbers.length;

        // 計算大於平均的數量
        for (int num : numbers) {
            if (num > average) {
                countAboveAverage++;
            }
        }

        // 輸出結果（表格形式）
        System.out.println("+---------------------------+------------------+");
        System.out.printf("| %-25s | %-16d |\n", "總和", sum);
        System.out.printf("| %-25s | %-16.2f |\n", "平均值", average);
        System.out.printf("| %-25s | %-16d |\n", "最大值", max);
        System.out.printf("| %-25s | %-16d |\n", "最大值索引", maxIndex);
        System.out.printf("| %-25s | %-16d |\n", "最小值", min);
        System.out.printf("| %-25s | %-16d |\n", "最小值索引", minIndex);
        System.out.printf("| %-25s | %-16d |\n", "大於平均值的數量", countAboveAverage);
        System.out.printf("| %-25s | %-16d |\n", "偶數數量", evenCount);
        System.out.printf("| %-25s | %-16d |\n", "奇數數量", oddCount);
        System.out.println("+---------------------------+------------------+");
    }
}

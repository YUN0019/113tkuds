public class GradeProcessor {
   
        public static void main(String[] args) {
            // 1. 建立包含 8 位學生成績的陣列
            int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};
    
            // 2. 計算總分與平均分（保留兩位小數）
            int total = 0;
            for (int score : scores) {
                total += score;
            }
            double average = (double) total / scores.length;
            System.out.printf("總分：%d%n", total);
            System.out.printf("平均分數：%.2f%n", average);
    
            // 3. 找出最高分與最低分及其索引位置
            int maxScore = scores[0], minScore = scores[0];
            int maxIndex = 0, minIndex = 0;
    
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] > maxScore) {
                    maxScore = scores[i];
                    maxIndex = i;
                }
                if (scores[i] < minScore) {
                    minScore = scores[i];
                    minIndex = i;
                }
            }
    
            System.out.println("最高分：" + maxScore + "（索引：" + maxIndex + "）");
            System.out.println("最低分：" + minScore + "（索引：" + minIndex + "）");
    
            // 4. 計算超過平均分的人數
            int countAboveAverage = 0;
            for (int score : scores) {
                if (score > average) {
                    countAboveAverage++;
                }
            }
            System.out.println("成績高於平均分的人數：" + countAboveAverage);
    
            // 5. 輸出所有成績（格式：學生編號: 成績）
            System.out.println("所有成績：");
            for (int i = 0; i < scores.length; i++) {
                System.out.println("學生 " + i + ": " + scores[i]);
            }
        }
    }
    


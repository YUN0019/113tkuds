public class StudentGradeSystem {
    

        // 根據分數回傳等級
        public static char getGrade(int score) {
            if (score >= 90) return 'A';
            else if (score >= 80) return 'B';
            else if (score >= 70) return 'C';
            else return 'D';
        }
    
        // 計算平均分
        public static double getAverage(int[] scores) {
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            return (double) sum / scores.length;
        }
    
        // 統計各等級人數：A=0, B=1, C=2, D=3
        public static int[] countGradeDistribution(int[] scores) {
            int[] counts = new int[4];
            for (int score : scores) {
                char grade = getGrade(score);
                switch (grade) {
                    case 'A': counts[0]++; break;
                    case 'B': counts[1]++; break;
                    case 'C': counts[2]++; break;
                    case 'D': counts[3]++; break;
                }
            }
            return counts;
        }
    
        // 找出最高分位置
        public static int getHighestIndex(int[] scores) {
            int maxIndex = 0;
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] > scores[maxIndex]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    
        // 找出最低分位置
        public static int getLowestIndex(int[] scores) {
            int minIndex = 0;
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] < scores[minIndex]) {
                    minIndex = i;
                }
            }
            return minIndex;
        }
    
        // 計算高於平均分比例
        public static double getAboveAverageRate(int[] scores, double average) {
            int count = 0;
            for (int score : scores) {
                if (score > average) count++;
            }
            return (double) count / scores.length * 100;
        }
    
        // 顯示完整報告
        public static void printReport(int[] scores) {
            System.out.println("=========== 學生成績報告 ===========");
            System.out.println("學號\t分數\t等級");
            System.out.println("------------------------------------");
    
            for (int i = 0; i < scores.length; i++) {
                char grade = getGrade(scores[i]);
                System.out.println((i + 1) + "\t" + scores[i] + "\t" + grade);
            }
    
            System.out.println("------------------------------------");
    
            double avg = getAverage(scores);
            int[] gradeCounts = countGradeDistribution(scores);
            int maxIndex = getHighestIndex(scores);
            int minIndex = getLowestIndex(scores);
            double aboveAvgRate = getAboveAverageRate(scores, avg);
    
            System.out.printf("全班平均分數：%.2f%n", avg);
            System.out.println("最高分學生：學號 " + (maxIndex + 1) + "（" + scores[maxIndex] + "分）");
            System.out.println("最低分學生：學號 " + (minIndex + 1) + "（" + scores[minIndex] + "分）");
            System.out.println("等級統計：A: " + gradeCounts[0] + "人, B: " + gradeCounts[1] +
                    "人, C: " + gradeCounts[2] + "人, D: " + gradeCounts[3] + "人");
            System.out.printf("高於平均分數的學生比例：%.1f%%\n", aboveAvgRate);
            System.out.println("====================================");
        }
    
        public static void main(String[] args) {
            int[] studentScores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
            printReport(studentScores);
        }
    }


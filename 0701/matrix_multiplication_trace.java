public class matrix_multiplication_trace {
    public static void main(String[] args) {
        // 寫死的兩個 2x2 矩陣
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2]; // 結果矩陣

        // 三層迴圈進行矩陣乘法
        for (int i = 0; i < 2; i++) { // 第 i 列
            for (int j = 0; j < 2; j++) { // 第 j 行
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                int sum = 0;
                for (int k = 0; k < 2; k++) {
                    int product = a[i][k] * b[k][j];
                    sum += product;
                    System.out.print(a[i][k] + "*" + b[k][j]);
                    if (k < 1) System.out.print(" + ");
                }
                System.out.print(" = ");

                // 再次列出乘法結果的加總
                for (int k = 0; k < 2; k++) {
                    System.out.print((a[i][k] * b[k][j]));
                    if (k < 1) System.out.print(" + ");
                }
                System.out.println(" = " + sum);

                c[i][j] = sum;
            }
        }

        // 印出結果矩陣
        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

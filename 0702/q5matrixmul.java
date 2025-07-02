
import java.util.Scanner;
public class q5matrixmul {
    public static int[][] matrixMultiply(int[][] A, int[][] B,int[] ops){

        int n = A.length;
        int[][]C =new int[n][n];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                C[i][j] += A[i][k] * B[k][j];
            }
        }
    }
    return  C;

}

    public static void main(String[] args) {
        System.out.println("請輸入n：");
        Scanner target = new Scanner(System.in);
        int n = target.nextInt();
        int[][]A = new int[n][n];
        int[][]B = new int [n][n];

         // 矩陣 A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = target.nextInt();
            }
        }

        // 矩陣 B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = target.nextInt();
            }
        }
        int[] ops = new int[1];

        // 矩陣乘法
        int[][] result = matrixMultiply(A, B,ops);

        // 矩陣 C
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println(n + " ");
        }

        // 輸出總操作次數
        System.out.println(ops[0]);
    }
    
 }


/*
矩陣相乘（Matrix Multiplication
三層for迴圈 --->  O(n³) 矩陣乘法

     int n = A.length;
        int[][]C =new int[n][n];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                C[i][j] += A[i][k] * B[k][j];
            }
        }
    }
    return  C;


 */
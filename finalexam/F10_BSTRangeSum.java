/*
 * Time Complexity: O(n)
 * 說明：使用中序走訪結合剪枝技術，最壞情況遍歷所有節點，但剪枝可減少實際訪問節點數，n 為節點數量。
 */

import java.util.*;

public class F10_BSTRangeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取BST的節點數量
        int n = sc.nextInt();
        
        // 讀取BST的節點值
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        
        // 讀取區間 [L, R]
        int L = sc.nextInt();
        int R = sc.nextInt();
        
        // 建立BST
        TreeNode root = buildBST(values);
        
        // 計算區間總和
        int sum = rangeSumBST(root, L, R);
        
        // 輸出結果
        System.out.println("Sum: " + sum);
    }
    
    // 二元搜尋樹節點類別
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // 建立BST（假設輸入已排序）
    private static TreeNode buildBST(int[] values) {
        if (values.length == 0) return null;
        
        // 使用遞迴建立平衡BST
        return buildBSTHelper(values, 0, values.length - 1);
    }
    
    private static TreeNode buildBSTHelper(int[] values, int start, int end) {
        if (start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(values[mid]);
        
        root.left = buildBSTHelper(values, start, mid - 1);
        root.right = buildBSTHelper(values, mid + 1, end);
        
        return root;
    }
    
    // 使用中序走訪結合剪枝計算區間總和
    private static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        
        int sum = 0;
        
        // 如果當前節點值在區間內，加入總和
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        
        // 剪枝：如果當前節點值大於L，才需要走訪左子樹
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }
        
        // 剪枝：如果當前節點值小於R，才需要走訪右子樹
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }
        
        return sum;
    }
}

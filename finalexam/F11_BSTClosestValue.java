/*
 * Time Complexity: O(h)
 * 說明：使用迭代方式在BST中搜尋，每次比較後往左或右移動，h 為BST高度。
 */

import java.util.*;

public class F11_BSTClosestValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取BST的節點數量
        int n = sc.nextInt();
        
        // 讀取BST的節點值
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        
        // 讀取目標值
        int target = sc.nextInt();
        
        // 建立BST
        TreeNode root = buildBST(values);
        
        // 找到最接近的節點值
        int closestValue = findClosestValue(root, target);
        
        // 輸出結果
        System.out.println("Closest: " + closestValue);
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
    
    // 使用迭代方式找到最接近目標值的節點
    private static int findClosestValue(TreeNode root, int target) {
        if (root == null) return Integer.MAX_VALUE;
        
        int closest = root.val;
        int minDiff = Math.abs(root.val - target);
        
        TreeNode current = root;
        
        while (current != null) {
            int currentDiff = Math.abs(current.val - target);
            
            // 更新最接近值
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                closest = current.val;
            } else if (currentDiff == minDiff && current.val < closest) {
                // 如果差值相同，取較小值
                closest = current.val;
            }
            
            // 根據目標值決定搜尋方向
            if (target < current.val) {
                current = current.left;
            } else if (target > current.val) {
                current = current.right;
            } else {
                // 找到完全相等的值
                return current.val;
            }
        }
        
        return closest;
    }
}

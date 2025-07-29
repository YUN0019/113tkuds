/*
 * Time Complexity: O(n)
 * 說明：使用後序遞迴遍歷二元樹，每個節點只訪問一次，同時計算高度和直徑，n 為節點數量。
 */

import java.util.*;

public class F12_TreeDiameter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取節點數量
        int n = sc.nextInt();
        
        // 讀取節點值（假設為層序序列）
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        
        // 建立二元樹
        TreeNode root = buildTree(values);
        
        // 計算樹直徑
        int diameter = calculateDiameter(root);
        
        // 輸出結果
        System.out.println("Diameter: " + diameter);
    }
    
    // 二元樹節點類別
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // 建立二元樹（假設輸入為層序序列）
    private static TreeNode buildTree(int[] values) {
        if (values.length == 0) return null;
        
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            
            // 處理左子節點
            if (i < values.length && values[i] != -1) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;
            
            // 處理右子節點
            if (i < values.length && values[i] != -1) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }
        
        return root;
    }
    
    // 全域變數記錄最大直徑
    private static int maxDiameter = 0;
    
    // 計算樹直徑
    private static int calculateDiameter(TreeNode root) {
        maxDiameter = 0;
        getHeight(root);
        return maxDiameter;
    }
    
    // 後序遞迴：返回高度同時計算直徑
    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        
        // 後序遞迴：先處理左右子樹
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        // 計算通過當前節點的直徑
        int currentDiameter = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter, currentDiameter);
        
        // 返回當前節點的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

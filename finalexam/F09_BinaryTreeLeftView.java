/*
 * Time Complexity: O(n)
 * 說明：使用廣度優先搜尋遍歷二元樹，每個節點只訪問一次，n 為節點數量。
 */

import java.util.*;

public class F09_BinaryTreeLeftView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取層序序列
        String[] input = sc.nextLine().split(" ");
        int n = input.length;
        
        // 建立二元樹
        TreeNode root = buildTree(input);
        
        // 使用BFS找到左視圖
        List<Integer> leftView = getLeftView(root);
        
        // 輸出結果
        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
        System.out.println();
    }
    
    // 二元樹節點類別
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // 從層序序列建立二元樹
    private static TreeNode buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("-1")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode node = queue.poll();
            
            // 處理左子節點
            if (i < input.length && !input[i].equals("-1")) {
                node.left = new TreeNode(Integer.parseInt(input[i]));
                queue.offer(node.left);
            }
            i++;
            
            // 處理右子節點
            if (i < input.length && !input[i].equals("-1")) {
                node.right = new TreeNode(Integer.parseInt(input[i]));
                queue.offer(node.right);
            }
            i++;
        }
        
        return root;
    }
    
    // 使用BFS找到左視圖
    private static List<Integer> getLeftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // 取每一層的第一個節點（最左側）
            result.add(queue.peek().val);
            
            // 處理當前層的所有節點
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                // 先入隊左子節點，再入隊右子節點
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return result;
    }
}

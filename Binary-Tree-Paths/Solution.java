/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> path = new LinkedList<Integer>(); 
        traverse(root, path, result);
        return result;
    }
    
    private void traverse(TreeNode node, LinkedList<Integer> currentPath, List<String> result) {
        currentPath.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(convert(currentPath));
            currentPath.removeLast();
            return;
        }
        if (node.left != null) {
            traverse(node.left, currentPath, result);
        }
        if (node.right != null) {
            traverse(node.right, currentPath, result);
        }
        currentPath.removeLast();
    }
    
    private String convert(LinkedList<Integer> currentPath) {
        StringBuffer result = new StringBuffer();
        
        for (int i = 0; i < currentPath.size(); i++) {
            if (i == 0) {
                result.append(currentPath.get(0));
            } else {
                result.append("->");
                result.append(currentPath.get(i));
            }
        }
        
        return result.toString();
    }
}

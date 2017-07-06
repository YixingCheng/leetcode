/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
       if (root == null) return;
       TreeNode levelStart = root, dummy = new TreeNode(0);
       while(levelStart != null) {
         TreeNode cur = levelStart, child = dummy;
         while(cur != null) {
           if (cur.left != null) {
             child.next = cur.left;
             child = child.next;
           }
           if (cur.right != null) {
             child.next = cur.right;
             child = child.next;
           }
           cur = cur.next;
         }
         levelStart = dummy.next;
         dummy.next = null;
       } 
    }
}

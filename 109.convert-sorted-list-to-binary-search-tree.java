/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
       if (head == null) return null;
       return buildBST(head, null); 
    }

    private ListNode buildBST(ListNode head, ListNode tail) {
      if (head == null) return null;
      ListNode slow = head, fast = head;
      while (fast != tail && fast.next != tail) {
        slow = slow.next;
        fast = fast.next.next;
      }
      TreeNode node = new TreeNode(slow.val);
      node.left = buildBST(head, slow);
      node.right = buildBST(slow.next, tail);
      return node;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        ListNode newList = null;
        ListNode cur = A;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = newList;
            newList = cur;
            cur = next;
        }
        while(cur != null) {
            if(cur.val != newList.val) {
                break;
            }
            cur = cur.next;
            newList = newList.next;
            return true;
        }
        return false;
    }
}
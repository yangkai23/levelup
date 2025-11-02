package linkedlist;


/**
 * @author Anirudh
 * @since 01/11/25
 */
public class DeleteNodesFromLinkedListPresentInArray {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next = new ListNode(2);
        int[] nums = {5};
        modifiedList(nums, head);
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        int max = -1;
        for (int val : nums)
            max = Math.max(val, max);

        boolean[] freq = new boolean[max+1];

        for (int num : nums) {
            freq[num] = true;
        }

        ListNode temp = new ListNode();
        ListNode curr = temp;
        while (head != null) {
            if (head.val >= freq.length || !freq[head.val]) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;
        return temp.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
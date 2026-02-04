package linkedlist;

/**
 * @author Anirudh
 * @since 04/02/26
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode head = null;
        ListNode merged = null;

        while (t1 != null && t2 != null) {
            ListNode currNode = null;
            if (t1.val < t2.val) {
                currNode = t1;
                t1 = t1.next;
            } else {
                currNode = t2;
                t2 = t2.next;
            }

            if (merged == null) {
                merged = currNode;
                head = currNode;
            } else {
                merged.next = currNode;
                merged = merged.next;
            }

        }

        while (t1 != null) {

            if (merged == null) {
                merged = t1;
                head = t1;
            } else {
                merged.next = t1;
                merged = merged.next;
            }

            t1 = t1.next;

        }
        while (t2 != null) {
            if (merged == null) {
                merged = t2;
                head = t2;
            } else {
                merged.next = t2;
                merged = merged.next;
            }

            t2 = t2.next;
        }
        return head;
    }
}

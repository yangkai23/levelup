package linkedlist;

/**
 * @author Anirudh
 * @since 04/02/26
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = buildList(new int[]{0});
        ListNode l2 = buildList(new int[]{0});
        System.out.println(addTwoNumbers(l1, l2));
    }

    static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = null;
        ListNode temp = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            if (dummy == null) {
                dummy = new ListNode(val);
                temp = dummy;

            } else {
                temp.next = new ListNode(val);
                temp = temp.next;
            }

            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            if (dummy == null) {
                dummy = new ListNode(val);
                temp = dummy;

            } else {
                temp.next = new ListNode(val);
                temp = temp.next;
            }

            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            if (dummy == null) {
                dummy = new ListNode(val);
                temp = dummy;

            } else {
                temp.next = new ListNode(val);
                temp = temp.next;
            }
            l2 = l2.next;
        }
        if(carry!=0){
            temp.next=new ListNode(carry);
        }
        return dummy;

    }
}

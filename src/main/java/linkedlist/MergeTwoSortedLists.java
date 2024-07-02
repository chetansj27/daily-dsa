package linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode first, ListNode second) {

        ListNode result = new ListNode();
        ListNode temp = result;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                result.next = first;
                first = first.next;
            } else {
                result.next = second;
                second = second.next;
            }
            result = result.next;
        }
        if (first != null) {
            result.next = first;
        }
        if (second != null) {
            result.next = second;
        }
        return temp.next;
    }
}

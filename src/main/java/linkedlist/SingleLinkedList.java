package linkedlist;

public class SingleLinkedList {
    ListNode head;
    ListNode tail;


    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertAtBeginning(5);
        singleLinkedList.insertAtBeginning(4);
        singleLinkedList.insertAtBeginning(3);
        singleLinkedList.insertAtBeginning(2);
        singleLinkedList.insertAtBeginning(1);
        /*singleLinkedList.insertAtBeginning(7);
        singleLinkedList.insertAtBeginning(6);
        singleLinkedList.insertAtBeginning(3);
        singleLinkedList.insertAtBeginning(2);
        singleLinkedList.insertAtBeginning(1);
        singleLinkedList.insertAtMiddle(4);
        singleLinkedList.insertAtMiddle(5);
        singleLinkedList.insertAtEnd(8);
        singleLinkedList.insertAtEnd(9);
        singleLinkedList.insertAtPosition(10, 1);
        System.out.println(singleLinkedList.findElement(10));
        System.out.println(singleLinkedList.findElement(7));
        System.out.println(singleLinkedList.findMiddleElement());
        singleLinkedList.deleteFromPosition(2);*/

        // singleLinkedList.deleteMiddleElement();
        // singleLinkedList.deleteFromBeginning();
        singleLinkedList.deleteFromPosition(2);
        System.out.println(singleLinkedList);
    }

    private void insertAtBeginning(int data) {
        ListNode current = new ListNode(data);
        if (head == null) {
            head = current;
            tail = current;
        } else {
            current.next = head;
            head = current;
        }
    }

    private void insertAtEnd(int data) {
        ListNode current = new ListNode(data);
        if (head == null) {
            head = current;
        } else {
            tail.next = current;
        }
        tail = current;
    }

    private ListNode insertAtPosition(int data, int position) {
        ListNode current = new ListNode(data);
        if (head == null) {
            head = current;
            return head;
        } else {
            ListNode temp = head;
            int index = 0;
            while (index != position - 1 && temp != null) {
                temp = temp.next;
                index++;
            }
            current.next = temp.next;
            temp.next = current;
            return temp;
        }
    }

    private void insertAtMiddle(int data) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode current = new ListNode(data);
        current.next = slow.next;
        slow.next = current;
    }

    private ListNode deleteFromBeginning() {
        if (head == null || head.next == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    private ListNode deleteMiddleElement() {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    private ListNode deleteFromPosition(int position) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            if (index == position - 1) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            index++;
        }
        return head;
    }


    private int findMiddleElement() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    private int findElement(int data) {
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.val == data) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    private boolean hasCycle() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public ListNode reverseList() {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}

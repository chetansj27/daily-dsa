package linkedlist;

public class SingleLinkedList {
    Node head;
    Node tail;


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
        Node current = new Node(data);
        if (head == null) {
            head = current;
            tail = current;
        } else {
            current.next = head;
            head = current;
        }
    }

    private void insertAtEnd(int data) {
        Node current = new Node(data);
        if (head == null) {
            head = current;
        } else {
            tail.next = current;
        }
        tail = current;
    }

    private Node insertAtPosition(int data, int position) {
        Node current = new Node(data);
        if (head == null) {
            head = current;
            return head;
        } else {
            Node temp = head;
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
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node current = new Node(data);
        current.next = slow.next;
        slow.next = current;
    }

    private Node deleteFromBeginning() {
        if (head == null || head.next == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    private Node deleteMiddleElement() {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    private Node deleteFromPosition(int position) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
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
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    private int findElement(int data) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    private boolean hasCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public Node reverseList() {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}

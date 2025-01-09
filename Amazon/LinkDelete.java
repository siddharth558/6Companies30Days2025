
public class LinkDelete {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void linkdelete(Node head, int n, int m) {
        Node curr = head;
        while (curr != null) {
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) {
                break;
            }
            Node temp = curr.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
    }
}

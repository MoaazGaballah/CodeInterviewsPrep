package AlgoExpret.LinkedLists.ShiftLinkedList;

public class ShiftLinkedList {

    /*


  Write a function that takes in the head of a Singly Linked List and an integer
  k, shifts the list in place (i.e., doesn't create a brand new
  list) by k positions, and returns its new head.

  Shifting a Linked List means moving its nodes forward or backward and wrapping
  them around the list where appropriate. For example, shifting a Linked List
  forward by one position would make its tail become the new head of the linked
  list.


  Whether nodes are moved forward or backward is determined by whether k is positive
  or negative.


  Each LinkedList node has an integer value as well as a next node pointing to the
  next node in the list or to None / null if it's the tail of the list.

  Sample Input:
  head  = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0
  k  = 2

  Sample Output:
  4 -> 5 -> 0 -> 1 -> 2 -> 3 // the new head node with value 4

 */

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.

        if (k > 0 )
            for (int i = 0; i < k; i ++)
                setTailAsHead(head);
        else
            for (int i = 0; i < Math.abs(k); i ++)
                setHeadAsTail(head);

        return head;
    }

    public static void setHeadAsTail(LinkedList head) {

        if (head.next == null) return;

        LinkedList tempHead = head;

        while (tempHead.next != null) tempHead = tempHead.next;

        int headValue = head.value;

        head.value = head.next.value;
        head.next = head.next.next;

        tempHead.next = new LinkedList(headValue);
    }

    public static void setTailAsHead(LinkedList head) {

        if (head.next == null) return;

        LinkedList tempHead = head;
        while (tempHead.next.next != null) tempHead = tempHead.next;

        int tailValue = tempHead.next.value;
        tempHead.next = null;

        LinkedList tempHeadNext = new LinkedList(head.value);
        tempHeadNext.next = head.next;

        LinkedList newHead = new LinkedList(tailValue);
        head.value = newHead.value;
        head.next = tempHeadNext;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }

        public void printInfo() {
            System.out.print(this.value);

            LinkedList tempHead = this;

            while (tempHead.next != null) {
                System.out.print(" -> " + tempHead.next.value);
                tempHead = tempHead.next;
            }
            System.out.println();
            System.out.println("------------------------------");
        }
    }

    public static void main(String[] args) {
        LinkedList n1 = new LinkedList(0);
        LinkedList n2 = new LinkedList(1);
        LinkedList n3 = new LinkedList(2);
        LinkedList n4 = new LinkedList(3);
        LinkedList n5 = new LinkedList(4);
        LinkedList n6 = new LinkedList(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1.printInfo();

        shiftLinkedList(n1, 2);

        n1.printInfo();


    }
}

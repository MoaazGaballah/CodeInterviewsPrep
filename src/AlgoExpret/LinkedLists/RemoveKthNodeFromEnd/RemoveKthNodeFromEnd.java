package AlgoExpret.LinkedLists.RemoveKthNodeFromEnd;

/*

  Write a function that takes in the head of a Singly Linked List and an integer
  k and removes the kth node from the end of the list.


  The removal should be done in place, meaning that the original data structure
  should be mutated (no new structure should be created).


  Furthermore, the input head of the linked list should remain the head of the
  linked list after the removal is done, even if the head is the node that's
  supposed to be removed. In other words, if the head is the node that's
  supposed to be removed, your function should simply mutate its value and next
  pointer.

  Note that your function doesn't need to return anything.


  You can assume that the input Linked List will always have at least two nodes
  and, more specifically, at least k nodes.


  Sample Input:
  head  = 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 // the head node with value 0
  k  = 4

  Sample Output:
  // No output required.
  // The 4th node from the end of the list (the node with value 6) is removed.
  0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 9

 */

public class RemoveKthNodeFromEnd {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        int firstPointer = 1;
        int secondPointer = 1;

        LinkedList temp = head;
        while (temp.next != null) {
            secondPointer++;
            temp = temp.next;
        }

        int prevPosition = secondPointer - k;
        temp = head;
        if (prevPosition == 0){
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while (temp.next != null) {
            if (firstPointer == prevPosition) {
                temp.next = temp.next.next;
                return;
            }
            firstPointer++;
            temp = temp.next;
        }
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
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
        LinkedList n1 = new LinkedList(1);
        LinkedList n2 = new LinkedList(2);
        LinkedList n3 = new LinkedList(3);
        LinkedList n4 = new LinkedList(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.printInfo();

        removeKthNodeFromEnd(n1, 4);
        n1.printInfo();

    }
}

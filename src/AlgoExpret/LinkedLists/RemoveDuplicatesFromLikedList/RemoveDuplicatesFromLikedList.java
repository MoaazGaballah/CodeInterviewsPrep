package AlgoExpret.LinkedLists.RemoveDuplicatesFromLikedList;

/*
/
  You're given the head of a Singly Linked List whose nodes are in sorted order
  with respect to their values. Write a function that returns a modified version
  of the Linked List that doesn't contain any nodes with duplicate values. The
  Linked List should be modified in place (i.e., you shouldn't create a brand
  new list), and the modified Linked List should still have its nodes sorted
  with respect to their values.

  Sample Input:
  linkedList = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 // the head node with value 1

  Sample Output:
  1 -> 3 -> 4 -> 5 -> 6 // the head node with value 1
 */

public class RemoveDuplicatesFromLikedList {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        removeDupilcates(linkedList);

        return linkedList;
    }

    public static void removeDupilcates(LinkedList current){

        if (current.next == null)
            return;
        if (current.value == current.next.value){
            current.next = current.next.next;
            removeDupilcates(current);
        }else
            removeDupilcates(current.next);

    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(6);
        LinkedList l1 = new LinkedList(6);
        LinkedList l2 = new LinkedList(5);
        LinkedList l3 = new LinkedList(4);
        LinkedList l4 = new LinkedList(4);
        LinkedList l5 = new LinkedList(4);
        LinkedList l6 = new LinkedList(3);
        LinkedList l7 = new LinkedList(1);
        LinkedList l8 = new LinkedList(1);

        head.next =l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        removeDuplicatesFromLinkedList(head);
    }
}

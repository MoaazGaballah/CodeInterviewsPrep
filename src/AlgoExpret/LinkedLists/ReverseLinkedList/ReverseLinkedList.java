package AlgoExpret.LinkedLists.ReverseLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedList {

    /*


  Write a function that takes in the head of a Singly Linked List, reverses the
  list in place (i.e., doesn't create a brand new list), and returns its new head.

  Each LinkedList node has an integer value as well as a next node pointing to the
  next node in the list or to None / null if it's the tail of the list.


  You can assume that the input Linked List will always have at least one node; in other
  words, the head will never be None / null.

  Sample Input:
  head  = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0
  k  = 2

  Sample Output:
  5 -> 4 -> 3 -> 2 -> 1 -> 0  // the new head node with value 5

 */

    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.

        Deque<LinkedList> stack = new ArrayDeque<>();

        LinkedList temp = head;
        while (temp != null){
            LinkedList tempNode = new LinkedList(temp.value);
            stack.push(tempNode);

            temp = temp.next;
        }

        LinkedList newHead = stack.pop();

        LinkedList newHeadTemp = newHead;

        while (stack.peek() != null){
            newHeadTemp.next = stack.pop();
            newHeadTemp = newHeadTemp.next;
        }
        head = newHead;
        return head;
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

        reverseLinkedList(n1).printInfo();
    }
}

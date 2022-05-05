package AlgoExpret.LinkedLists.NodeSwap;

public class NodeSwap {
    /*

  Write a function that takes in the head of a Singly Linked List, swaps every
  pair of adjacent nodes in place (i.e., doesn't create a brand new list), and
  returns its new head.

  If the input Linked List has an odd number of nodes, its final node should
  remain the same.

  Each LinkedList node has an integer value as well as a next node pointing to the
  next node in the list or to None / null if it's the tail of the list.


  You can assume that the input linked lists will always have at least one node; in other
  words, the heads will never be None / null.

  Sample Input:
  head = 0 -> 1 -> 2 -> 3 -> 4 -> 5  // the head node with value 0

  Sample Output:
  1 -> 0 -> 3 -> 2 -> 5 -> 4  // the new head node with value 1

 */


    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
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

    public static LinkedList nodeSwap(LinkedList head) {
        // Write your code here.
//        LinkedList tempNode = new LinkedList(0);
//        tempNode.next = head;
//
//        LinkedList prevNode = tempNode;
//        while (prevNode.next != null && prevNode.next.next != null) {
//            LinkedList firstNode = prevNode.next;
//            LinkedList secondNode = prevNode.next.next;
//
//            firstNode.next = secondNode.next;
//            secondNode.next = firstNode;
//            prevNode.next =secondNode;
//
//            prevNode = firstNode;
//        }
//        return tempNode.next;

        // recursive solution
        if (head == null || head.next == null) return head;

        LinkedList nextNode = head.next;
        head.next = nodeSwap(head.next.next);
        nextNode.next = head;

        return nextNode;
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

        nodeSwap(n1).printInfo();
    }
}

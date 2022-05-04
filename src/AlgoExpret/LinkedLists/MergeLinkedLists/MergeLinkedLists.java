package AlgoExpret.LinkedLists.MergeLinkedLists;

public class MergeLinkedLists {

    /*



  Write a function that takes in the heads of two Singly Linked Lists that are
  in sorted order, respectively. The function should merge the lists in place
  (i.e., it shouldn't create a brand new list) and return the head of the merged
  list; the merged list should be in sorted order.


  Each LinkedList node has an integer value as well as a next node pointing to the
  next node in the list or to None / null if it's the tail of the list.


  You can assume that the input linked lists will always have at least one node; in other
  words, the heads will never be None / null.

  Sample Input:
  headOne  = 2 -> 6 -> 7 -> 8  // the head node with value 2
  headTwo  = 1 -> 3 -> 4 -> 5 -> 9 -> 10 // the head node with value 1
  k  = 2

  Sample Output:
  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10  // the new head node with value 1

 */

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
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

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList p1 =headOne;
        LinkedList p1Prev = null;
        LinkedList p2 = headTwo;
//
//        while (p1 != null && p2 != null){
//            if (p1.value < p2.value){
//                p1Prev = p1;
//                p1 = p1.next;
//            } else {
//                if (p1Prev != null) p1Prev.next = p2;
//                p1Prev = p2;
//                p2 = p2.next;
//                p1Prev.next = p1;
//            }
//        }
//        if (p1 == null) p1Prev.next = p2;

        // recursive solution
        recursiveMerge(p1, p2, p1Prev);

        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public static void recursiveMerge(LinkedList p1, LinkedList p2, LinkedList p1Prev){
        if (p1 == null) {
            p1Prev.next = p2;
            return;
        }
        if (p2 == null) return;

        if (p1.value < p2.value){
            recursiveMerge(p1.next, p2, p1);
        } else {
            if (p1Prev != null) p1Prev.next = p2;
            LinkedList newP2 = p2.next;
            p2.next = p1;
            recursiveMerge(p1, newP2, p2);
        }
    }

    public static void main(String[] args) {
        LinkedList n1 = new LinkedList(1);
        LinkedList n2 = new LinkedList(2);
        LinkedList n3 = new LinkedList(3);
        LinkedList n4 = new LinkedList(4);

        LinkedList n5 = new LinkedList(5);
        LinkedList n6 = new LinkedList(6);
        LinkedList n7 = new LinkedList(7);
        LinkedList n8 = new LinkedList(8);
        LinkedList n9 = new LinkedList(9);
        LinkedList n10 = new LinkedList(10);

        n2.next = n6;
        n6.next = n7;
        n7.next = n8;

        n1.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n9;
        n9.next = n10;

        n2.printInfo();

        n1.printInfo();

        mergeLinkedLists(n2, n1).printInfo();

    }

}

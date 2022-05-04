package AlgoExpret.LinkedLists.FindLoop;

import java.util.HashSet;

public class FindLoop {

    /*


    Write a function that takes in the head of a Singly Linked List that contains
    a loop (in other words, the list's tail node points to some node in the list
    instead of None / null ). The function should return
    the node (the actual node--not just its value) from which the loop originates
    in constant space.

    Each LinkedList node has an integer value as well as next node pointing to the
    next node in the list.

    Sample Input:
    head  = 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 // the head node with value 0
                                ^         v
                                9 <- 8 <- 7

    Sample Output:
    4 -> 5 -> 6  // the node with value 4
    ^         v
    9 <- 8 <- 7

    */

    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.

        HashSet<LinkedList> nodeSet = new HashSet<>();

        LinkedList temp = head;

        while (true){
            if (nodeSet.contains(temp))
                break;
            nodeSet.add(temp);
            temp = temp.next;
        }
        return temp;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList n0 = new LinkedList(0);
        LinkedList n1 = new LinkedList(1);
        LinkedList n2 = new LinkedList(2);
        LinkedList n3 = new LinkedList(3);
        LinkedList n4 = new LinkedList(4);
        LinkedList n5 = new LinkedList(5);
        LinkedList n6 = new LinkedList(6);
        LinkedList n7 = new LinkedList(7);
        LinkedList n8 = new LinkedList(8);
        LinkedList n9 = new LinkedList(9);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n4;

        System.out.println(findLoop(n0).value);
        System.out.println(findLoop(n0).next);

    }
}

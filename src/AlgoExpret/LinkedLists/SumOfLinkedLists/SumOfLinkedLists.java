package AlgoExpret.LinkedLists.SumOfLinkedLists;

public class SumOfLinkedLists {

    /*

  You're given two Linked Lists of potentially unequal length. Each Linked List
  represents a non-negative integer, where each node in the Linked List is a
  digit of that integer, and the first node in each Linked List always
  represents the least significant digit of the integer. Write a function that
  returns the head of a new Linked List that represents the sum of the integers
  represented by the two input Linked Lists.

  Each LinkedList node has an integer value as well as a next node pointing to
  the next node in the list or to None / null if it's the tail of the list. The
  value of each LinkedList node is always in the range of 0 - 9.

  Note: your function must create and return a new Linked List, and you're not
  allowed to modify either of the input Linked Lists.

  Sample Input:
  linkedListOne  = 2 -> 4 -> 7 -> 1
  linkedListTwo  = 9 -> 4 -> 5

  Sample Output:
  1 -> 9 -> 2 -> 2
  // linkedListOne represents 1742
  // linkedListTwo represents 549

 */

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

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.

        LinkedList result = new LinkedList(0);

        int remind = 0;
        int nodeValue = 0;
        int sum = 0;

        LinkedList firstNumberTempHead = linkedListOne;
        LinkedList secondNumberTempHead = linkedListTwo;
        LinkedList resultNumberTempHead = result;

        while ((firstNumberTempHead != null || secondNumberTempHead != null)
                || remind != 0) {
            if (firstNumberTempHead != null) {
                sum += firstNumberTempHead.value;
                firstNumberTempHead = firstNumberTempHead.next;
            }
            if (secondNumberTempHead != null) {
                sum += secondNumberTempHead.value;
                secondNumberTempHead = secondNumberTempHead.next;
            }
            sum += remind;
            if (sum > 9) {
                remind = (sum - (sum % 10)) / 10;
                nodeValue = sum % 10;
            } else {
                remind = 0;
                nodeValue = sum;
            }
            LinkedList digit = new LinkedList(nodeValue);
            resultNumberTempHead.next = digit;
            resultNumberTempHead = digit;
            sum = 0;
        }
        return result.next;
    }

    public static void main(String[] args) {

        LinkedList n1 = new LinkedList(1);
        LinkedList n2 = new LinkedList(7);
        LinkedList n3 = new LinkedList(4);
        LinkedList n4 = new LinkedList(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.printInfo();

        LinkedList n5 = new LinkedList(5);
        LinkedList n6 = new LinkedList(4);
        LinkedList n7 = new LinkedList(9);

        n5.next = n6;
        n6.next = n7;

        n5.printInfo();

        sumOfLinkedLists(n1, n5).printInfo();

    }
}

package com.roshan.leetcode;

public class P2AddTwoLinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode fHead = l1;
        ListNode sHead = l2;
        ListNode result = new ListNode(0);
        ListNode curr = result;


        int carry = 0;

        while(fHead != null || sHead!= null){
            int sum = (fHead == null ? 0 :fHead.val)  + (sHead == null ? 0: sHead.val) + carry;
            carry = sum /10;
            sum = sum%10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            fHead = fHead !=null ? fHead.next:fHead;
            sHead = sHead != null ? sHead.next:sHead;
        }

        if(carry != 0){
            curr.next = new ListNode(carry);
        }


        return result.next;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode res = addTwoNumbers(l1,l2);
        print(res);

    }


    public static void print(ListNode l){
        if(l!=null){
            System.out.print(l.val + " ");
            print(l.next);
        }
    }

    static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}



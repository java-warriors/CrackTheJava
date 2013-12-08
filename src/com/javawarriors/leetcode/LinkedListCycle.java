package com.javawarriors.leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slowR = head;
        ListNode fastR = head;
        while(true){
            fastR = fastR.next.next;
            slowR = slowR.next;
            if(slowR == fastR){
                fastR = head;
                while(slowR != fastR){
                    slowR = slowR.next;
                    fastR = fastR.next;
                }
                return slowR;
            }
            if(fastR == null || fastR.next == null){
                return null;
            }
        }
        
    }
}

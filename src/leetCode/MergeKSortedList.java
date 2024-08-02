package leetCode;

import java.util.LinkedList;

public class MergeKSortedList {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNodeVal = lists[0];

        for(int i=1;i<lists.length;i++){
             ListNode ls=lists[i];
             while (ls.next!=null){
                 addToListAtParticular(listNodeVal,ls.val);
                 ls=ls.next;
             }
        }

        return listNodeVal;
    }

    public void addToListAtParticular(ListNode head,int val){
        ListNode current=head;
        ListNode previous=current;
        while (current.next!=null){
            if(current.val>val){
                ListNode newList=new ListNode(val);
                newList.next=previous.next;
                previous.next=newList;
                return;
            }
            previous=current;
            current=current.next;
        }
        current.next= new ListNode(val);

    }

}

package leetCode;

import java.util.LinkedList;
import java.util.Random;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[4];

        // Example sorted linked lists
        listNodes[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        listNodes[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        listNodes[2] = new ListNode(2, new ListNode(6));
//        listNodes[3] = new ListNode(10, new ListNode(11, new ListNode(12)));

        ListNode temp= mergeKLists(listNodes);
        while (temp!=null){
            System.out.print(STR."\{temp.val}->");
            temp=temp.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode listNodeVal = lists[0];
        for(int i=1;i<lists.length;i++){
             ListNode ls=lists[i];
             listNodeVal=mergeListAlgoUpdated(listNodeVal,ls);
        }
        return listNodeVal;
    }
    public static ListNode mergeListAlgoUpdated(ListNode list1,ListNode list2){
        //Primary head
        ListNode head=list1;
        ListNode tempL=list1;
        ListNode tempR=list2;
        ListNode trackPreviousTempL=null;
        while (tempR!=null && tempL!=null){
            if(tempL.val<=tempR.val){
                trackPreviousTempL=tempL;
                tempL=tempL.next;
            }else{
                if(trackPreviousTempL==null){
                    trackPreviousTempL=tempR;
                    tempR=tempR.next;
                    trackPreviousTempL.next=head.next;
                    head=trackPreviousTempL;
                }else{
                    ListNode temp=tempR;
                    tempR=tempR.next;
                    temp.next=trackPreviousTempL.next;
                    trackPreviousTempL.next=temp;
                    trackPreviousTempL=temp;
                }
            }
        }
        if (tempR!=null && trackPreviousTempL!=null){
            trackPreviousTempL.next=tempR;
        }
        return head;
    }
    public static ListNode mergeListAlgo(ListNode list1,ListNode list2){
        ListNode tempR=list2;
        ListNode tempL=list1;
        ListNode head=null;
        ListNode tail=null;
        while (tempR!=null && tempL!=null){
            if(tempL.val<=tempR.val){
                head=addToList(head,tail,tempL);
                tail=tempL;
                tempL=tempL.next;
            } else {
                head=addToList(head,tail,tempR);
                tail=tempR;
                tempR=tempR.next;
            }
        }
        while (tempR!=null){
            head=addToList(head,tail,tempR);
            tail=tempR;
            tempR=tempR.next;
        }
        while (tempL!=null){
            head=addToList(head,tail,tempL);
            tail=tempL;
            tempL=tempL.next;
        }
        return head;
    }
    public static ListNode addToList(ListNode head,ListNode tail,ListNode node){
        if(head==null){
            return node;
        }
        tail.next=node;
        return head;
    }



}

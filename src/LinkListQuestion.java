import leetCode.ListNode;

import java.util.Random;
import java.util.Stack;

public class LinkListQuestion {


    public static boolean searchInList(LinkListDataType head, int val) {
        LinkListDataType temp = head;
        if (temp == null) {
            return false;
        }
        while (temp != null) {
            if (temp.val == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static LinkListDataType insertNodeHead(LinkListDataType head, int val) {
        return new LinkListDataType(val, head);
    }

    public static void showList(LinkListDataType head) {
        LinkListDataType temp = head;
        if (temp == null) {
            return;
        }
        while (temp != null) {
            System.out.print(temp.val + " ,");
            temp = temp.next;
        }
        System.out.println();
    }

    public static LinkListDataType deleteHead(LinkListDataType head) {
        return head.next;
    }

    public static LinkListDataType deleteNode(LinkListDataType head, int index) {
        if (head == null) {
            return null;
        }
        if (index == 1) {
            return head.next;
        }
        LinkListDataType temp = head;
        LinkListDataType prev = null;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == index) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static LinkListDataType deleteNodeByValue(LinkListDataType head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        LinkListDataType temp = head;
        LinkListDataType prev = null;
        while (temp != null) {
            if (temp.val == val) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static int lengthOfLength(LinkListDataType head) {
        LinkListDataType temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static LinkListDataType insertTail(LinkListDataType head, LinkListDataType node) {
        if (head == null) {
            return node;
        }
        LinkListDataType temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    public static LinkListDataType insertAtAnyPosition(LinkListDataType head, int val, int position) {
        if (head == null) {
            if (position == 1) return new LinkListDataType(val);
            return null;
        }
        if (position == 1) {
            return new LinkListDataType(val);
        }
        int count = 0;
        LinkListDataType temp = head;
        while (temp != null) {
            count++;
            if (count == position - 1) {
                temp.next = new LinkListDataType(val, temp.next);
                return head;
            }
            temp = temp.next;
        }

        return head;
    }

    public static LinkListDataType insertBeforeValue(LinkListDataType head, int val, int value) {
        if (head == null) {
            return null;
        }
        if (head.val == value) {
            return new LinkListDataType(val, head);
        }
        int count = 0;
        LinkListDataType temp = head;
        while (temp.next != null) {

            if (temp.next.val == value) {
                temp.next = new LinkListDataType(val, temp.next);
                return head;
            }
            temp = temp.next;
        }

        return head;
    }

    public static LinkListDataType deleteHeadDoublyLink(LinkListDataType head) {
        if (head == null || head.next == null) {
            return null;
        }
        head.next.previous = null;
        return head.next;
    }

    public static LinkListDataType insertAtHeadDoublyLink(LinkListDataType head, int val) {
        if (head == null) {
            return new LinkListDataType(val);
        }
        LinkListDataType newNode = new LinkListDataType(val, head);
        head.previous = newNode;
        return newNode;
    }

    public static LinkListDataType deleteAtHeadDoublyLinkList(LinkListDataType head) {
        if (head == null) {
            return null;
        }
        LinkListDataType temp = head;
        temp.next.previous = null;
        temp = temp.next;
        return temp;
    }

    public static void deleteAtIndexDoublyLinkList(LinkListDataType head, int index) {
        if (head == null) {
            return;
        }
        if (index == 1) {
            deleteHeadDoublyLink(head);
            return;
        }
        int count = 0;
        LinkListDataType temp = head;
        while (temp.next != null) {
            count++;
            if (count == index) {
                temp.next.previous = temp.previous;
                temp.previous.next = temp.next;
                temp.previous = null;
                temp.next = null;
                return;
            }
            temp = temp.next;
        }
        temp.previous.next = null;
        temp.previous = null;
    }

    public static void deleteAtNodeDoublyLinkList(LinkListDataType node) {

        if (node.next == null) {
            node.previous.next = null;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public static LinkListDataType insertDoublyAtIndex(int index,
                                                       int val, LinkListDataType head) {
        LinkListDataType listDataType = new LinkListDataType(val);
        if (head == null) {
            return listDataType;
        }
        if (index == 1) {
            return insertAtHeadDoublyLink(head, val);
        }
        int count = 0;
        LinkListDataType temp = head;
        while (temp != null) {
            count++;
            if (count == index - 1) {
                listDataType.next = temp.next;
                listDataType.previous = temp;
                if (temp.next != null) {
                    temp.next.previous = listDataType;
                }
                temp.next = listDataType;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    public static LinkListDataType reverseDll(LinkListDataType head) {
        //O(2n) SC-> O(n)
//        LinkListDataType temp=head;
//        Stack<Integer> stack=new Stack<>();
//        while (temp!=null){
//            stack.push(temp.val);
//            temp=temp.next;
//        }
//        temp=head;
//        while (temp!=null && !stack.empty()){
//            temp.val=stack.pop();
//            temp=temp.next;
//        }
        // TC-> O(n) SC->O(1)
        LinkListDataType temp = head;
        LinkListDataType prev = null;
        while (temp != null) {
            LinkListDataType val = temp.previous;
            temp.previous = temp.next;
            temp.next = val;
            prev = temp;
            temp = temp.previous;
        }

        return prev;
    }

    public LinkListDataType addTwoNumbers(LinkListDataType l1, LinkListDataType l2) {
        // TC-> O(max(l1,l2) SC->O(max(l1,l2)
        LinkListDataType a = new LinkListDataType();
        LinkListDataType current = a;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new LinkListDataType(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new LinkListDataType(carry);
        }

        return a.next;


    }

    public static LinkListDataType oddEvenList(LinkListDataType head) {
//        LinkListDataType temp=head.next;
//        LinkListDataType prev=head;
//        LinkListDataType odd=head;
//        int index=1;
//        while(temp!=null){
//            index++;
//            if((index%2)!=0){
//                System.out.println(STR."\{prev.val} \{temp.val} \{index}");
//                prev.next=temp.next;
//                temp.next=prev;
//                odd.next=temp;
//                odd=temp;
//            }
//            prev=temp;
//            temp=temp.next;
//        }
//        return head;
        // TC -> O(n) SC-> O(1)
        if (head == null || head.next == null) {
            return head;
        }

        LinkListDataType odd = head;
        LinkListDataType even = head.next;
        LinkListDataType evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;

            even = even.next;
        }
        odd.next = evenHead;
        return head;


    }

    public static LinkListDataType sortLLO12(LinkListDataType head){
        if(head==null || head.next==null){
            return head;
        }
        LinkListDataType temp=head;
        LinkListDataType zeroHead=new LinkListDataType();
        LinkListDataType oneHead=new LinkListDataType();
        LinkListDataType twoHead=new LinkListDataType();
        LinkListDataType zero=zeroHead;
        LinkListDataType one = oneHead;
        LinkListDataType two =twoHead;
        while (temp!=null){
            LinkListDataType val=temp.next;
            if(temp.val==0){
                zero.next=temp;

                zero=temp;
            }else if(temp.val==1){
                one.next=temp;

                one=temp;
            }else{
                two.next=temp;

                two=temp;
            }
            temp=val;
        }
        zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
        one.next=twoHead.next;
        two.next=null;
        return zeroHead.next;
    }
    public LinkListDataType removeNthFromEnd(LinkListDataType head, int n) {

        //TC -> O(len) + O(len-n) = O(2 * len)  SC->O(1)
//        int l=lengthOfLength(head);
//        if(n==1 && l==1){
//            return null;
//        }
//        int prevIndex=l-n;
//        LinkListDataType temp=head;
//        int count =0;
//        if(prevIndex==0){
//            return temp.next;
//        }
//
//        while(temp!=null){
//            count++;
//            if(count == prevIndex){
//                System.out.println(count);
//                temp.next=temp.next.next;
//                return head;
//            }
//            temp=temp.next;
//        }
//        return head;

        // TC -> O(len) sc->O(1)

        if(head==null){
            return null;
        }
        LinkListDataType fast=head;
        LinkListDataType slow=head;
        for(int i=1;i<=n;i++){
            fast=fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public ListNode reverseList(ListNode head) {
//        Stack<Integer> val = new Stack<>();
//        ListNode temp=head;
//        while(temp!=null){
//            val.push(temp.val);
//            temp=temp.next;
//        }
//        temp=head;
//        while(temp!=null && !val.empty()){
//            temp.val=val.pop();
//            temp=temp.next;
//        }
//        return head;
        // TC -> O(n) SC->O(1)
//        ListNode temp=head;
//        ListNode prev=null;
//        while (temp!=null){
//            ListNode front=temp.next;
//            temp.next=prev;
//            prev=temp;
//            temp=front;
//        }
//        return prev;

        if(head == null || head.next==null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;

    }

    public static void showDoublyList(LinkListDataType head) {
        if (head == null) {
            return;
        }
//        System.out.println("From Front");
        LinkListDataType temp = head;
        while (temp.next != null) {
            System.out.print(STR."\{temp.val}->");
            temp = temp.next;
        }
        System.out.println(temp.val);
//        System.out.println("From Back");
//        while (temp.previous!=null){
//            System.out.print(STR."\{temp.val}->");
//            temp=temp.previous;
//        }
//        System.out.println(temp.val);
    }

    public static void main() {
        LinkListDataType head = null;
        Random random=new Random();
        for (int i = 0; i <= 4; i++) {
            head = insertAtHeadDoublyLink(head, random.nextInt(3));
        }
        showDoublyList(head);
        head = sortLLO12(head);
        showDoublyList(head);

    }


}

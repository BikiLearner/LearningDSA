import leetCode.ListNode;

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
        for (int i = 0; i <= 10; i++) {
            head = insertAtHeadDoublyLink(head, i);
        }
        showDoublyList(head);
        head = reverseDll(head);
        showDoublyList(head);

    }


}

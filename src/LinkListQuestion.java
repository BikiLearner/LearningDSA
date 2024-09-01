public class LinkListQuestion {


    public static boolean searchInList(LinkListDataType head,int val) {
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

    public static LinkListDataType insertNodeHead(LinkListDataType head,int val) {
        return new LinkListDataType(val,head);
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

    public static LinkListDataType insertTail(LinkListDataType head,LinkListDataType node){
        if(head==null){
            return node;
        }
        LinkListDataType temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        return head;
    }
    public static LinkListDataType insertAtAnyPosition(LinkListDataType head,int val,int position){
        if(head==null){
            if(position==1) return new LinkListDataType(val);
            return null;
        }
        if(position==1){
            return new LinkListDataType(val);
        }
        int count=0;
        LinkListDataType temp=head;
        while (temp!=null){
            count++;
            if(count==position-1){
                temp.next= new LinkListDataType(val,temp.next);
                return head;
            }
            temp=temp.next;
        }

        return head;
    }

    public static LinkListDataType insertBeforeValue(LinkListDataType head,int val,int value){
        if(head==null){
            return null;
        }
        if(head.val==value){
            return new LinkListDataType(val,head);
        }
        int count=0;
        LinkListDataType temp=head;
        while (temp.next!=null){

            if(temp.next.val==value){
                temp.next= new LinkListDataType(val,temp.next);
                return head;
            }
            temp=temp.next;
        }

        return head;
    }

    public static LinkListDataType insertAtHeadDoublyLink(LinkListDataType head,int val){
        if(head==null){
            return new LinkListDataType(val);
        }
        LinkListDataType newNode=new LinkListDataType(val,head);
        head.previous= newNode;
        return newNode;
    }
    public static LinkListDataType deleteAtHeadDoublyLinkList(LinkListDataType head){
        if(head==null){
            return null;
        }
        LinkListDataType temp=head;
        temp.next.previous=null;
        temp=temp.next;
        return temp;
    }
    public static void showDoublyList(LinkListDataType head){
        if(head==null){
            return;
        }
//        System.out.println("From Front");
        LinkListDataType temp=head;
        while (temp.next!=null){
            System.out.print(STR."\{temp.val}->");
            temp=temp.next;
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
            head = insertAtHeadDoublyLink(head,i);
        }
        showDoublyList(head);
        showDoublyList(head);
    }

}

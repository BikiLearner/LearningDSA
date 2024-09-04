public class LinkListDataType {


    int val;
    LinkListDataType next;
    LinkListDataType previous;
    public LinkListDataType() {
    }
    public LinkListDataType(int val, LinkListDataType next) {
        this.val = val;
        this.next = next;
    }
    public LinkListDataType(int val){
        this.val=val;
        this.next=null;
        this.previous=null;
    }
    public LinkListDataType(int val,LinkListDataType next,LinkListDataType previous){
        this.val=val;
        this.next=next;
        this.previous=previous;
    }
}

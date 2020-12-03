public class SortedLinkedList {
    public INode head;
    public INode sorted;

    private final MyLinkedList myLinkedList;

    public SortedLinkedList() {
        this.myLinkedList = new MyLinkedList();
        this.head = null;
        this.sorted = null;
    }

    public void add(INode myNode){
        INode tempnode = head;
        while(tempnode.getNext()!=null){
            if(tempnode.compareTo(myNode)<0){
                myLinkedList.append(myNode);
            }
        }
    }

    public void printStack(){
        myLinkedList.printMyNodes();
    }

}

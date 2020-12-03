public class SortedLinkedList {
    public INode head;
    public INode tail;

    private final MyLinkedList myLinkedList;

    public SortedLinkedList() {
        this.myLinkedList = new MyLinkedList();
        this.head = null;
        this.tail= null;
    }

    public void add(INode myNode){
        INode tempnode = head;
        INode prevNode = null;
        while (tempnode != null && (int) myNode.getKey() >= (int) tempnode.getKey()) {
                prevNode = tempnode;
                tempnode = tempnode.getNext();
        }
        if(prevNode == null)
            this.head = myNode;
        else
            prevNode.setNext(myNode);
        myNode.setNext(tempnode);
    }

    public void printStack(){
        myLinkedList.printMyNodes();
    }

}

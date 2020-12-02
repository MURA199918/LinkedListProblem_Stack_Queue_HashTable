
public class MyLinkedList {
    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode mynewNode) {
        if(this.tail == null){
            this.tail = mynewNode;
        }
        if(this.head == null){
            this.head = mynewNode;
        }else{
            INode tempnode = this.head;
            this.head = mynewNode;
            this.head.setNext(tempnode);
        }
    }

    public void append(INode myNode) {
        if(this.head==null){
            this.head=myNode;
        }
        if(this.tail==null){
            this.tail=myNode;
        }
        else{
            this.tail.setNext(myNode);
            this.tail=myNode;
        }
    }

    public void insert(INode myNode, INode newNode) {
        INode tempnode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempnode);
    }

    public INode pop(){
        INode tempnode = this.head;
        this.head = head.getNext();
        return tempnode;
    }

    public INode popLast(){
        INode tempnode = head;
        while(!tempnode.getNext().equals(tail)){
            tempnode = tempnode.getNext();
        }
        this.tail = tempnode;
        tempnode = tempnode.getNext();
        return tempnode;
    }

    public void printMyNodes(){
        StringBuffer myNodes = new StringBuffer("My Nodes: ");
        INode tempnode = head;
        while(tempnode.getNext()!=null){
            myNodes.append(tempnode.getKey());
            if(!tempnode.equals(tail)) myNodes.append("->");
            tempnode=tempnode.getNext();
        }
        myNodes.append(tempnode.getKey());
        System.out.println(myNodes);
    }
}

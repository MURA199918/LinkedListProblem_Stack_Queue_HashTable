import java.util.List;

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

    public <k> INode search(k key){
        INode tempnode = head;
        INode value = null;
        while(tempnode!=null && tempnode.getNext()!=null){
            if(tempnode.getKey()==key){
                value = tempnode;
                break;
            }
            tempnode = tempnode.getNext();
        }
        return value;
    }

    public <k> INode delete(k key){
        INode tempnode = head;
        INode result=null;
        if(tempnode!=null && tempnode.getKey()==key){
            result = tempnode;
            this.head = tempnode.getNext();
            return result;
        }
        while (tempnode!=null && tempnode.getNext()!=null){
            if(tempnode.getKey()==key){
                result = tempnode;
                this.head=tempnode.getNext();
                break;
            }
            tempnode = tempnode.getNext();
        }
        return result;
    }
    public void sortandadd(INode myNode){
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

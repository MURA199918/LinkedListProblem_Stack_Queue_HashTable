import java.util.List;

public class MyLinkedList<k> {
    public INode<k> head;
    public INode<k> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode<k> mynewNode) {
        if(this.tail == null){
            this.tail = mynewNode;
        }
        if(this.head == null){
            this.head = mynewNode;
        }else{
            INode<k> tempnode = this.head;
            this.head = mynewNode;
            this.head.setNext(tempnode);
        }
    }

    public void append(INode<k> myNode) {
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

    public void insert(INode<k> myNode, INode<k> newNode) {
        INode<k> tempnode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempnode);
    }

    public INode<k> pop(){
        INode<k> tempnode = this.head;
        this.head = head.getNext();
        return tempnode;
    }

    public INode<k> popLast(){
        INode<k> tempnode = head;
        while(!tempnode.getNext().equals(tail)){
            tempnode = tempnode.getNext();
        }
        this.tail = tempnode;
        tempnode = tempnode.getNext();
        return tempnode;
    }

    public INode<k> search(k key){
        INode<k> tempnode =  head;
        while(tempnode!=null && tempnode.getNext()!=null){
            if(tempnode.getKey().equals(key)){
                return tempnode;
            }
            tempnode = tempnode.getNext();
        }
        return null;
    }

    public  INode<k> delete(k key){
        INode<k> tempnode =  head;
        INode<k> result=null;
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

    public void sortandadd(INode<k> myNode){
        INode<k> tempnode = head;
        INode<k> prevNode = null;
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
        INode<k> tempnode = head;
        while(tempnode.getNext()!=null){
            myNodes.append(tempnode.getKey());
            if(!tempnode.equals(tail)) myNodes.append("->");
            tempnode=tempnode.getNext();
        }
        myNodes.append(tempnode.getKey());
        System.out.println(myNodes);
    }

    @Override
    public String toString(){
        return "MyLinkedListNodes{" + head + '}';
    }
}

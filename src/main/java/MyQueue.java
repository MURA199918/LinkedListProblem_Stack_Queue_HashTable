public class MyQueue {
    private final MyLinkedList myLinkedList;

    public MyQueue(){
        this.myLinkedList=new MyLinkedList();
    }

    public void enqueu(INode myNode){
        myLinkedList.append(myNode);
    }

    public void printStack() {
        myLinkedList.printMyNodes();
    }

    public INode dequeue(){
        return myLinkedList.pop();
    }
}

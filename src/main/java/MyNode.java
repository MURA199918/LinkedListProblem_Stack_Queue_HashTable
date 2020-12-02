public class MyNode<k> {
    private k key;
    private MyNode next;
    public MyNode(k key){
        this.key = key;
        this.next = null;
    }
    public MyNode getNext(){
        return next;
    }
    public void setNext(MyNode next){
        this.next=next;
    }


   /* @Override
    public k getKey() {
        return null;
    }

    public void setKey(k key){
        this.key=key;
    }
    public INode<k> getNext() {
        return next;
    }
    @Override
    public void setNext(INode next){
        this.next=(MyNode<k>) next;
    }*/

}

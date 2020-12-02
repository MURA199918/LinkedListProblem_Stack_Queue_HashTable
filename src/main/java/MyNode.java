public class MyNode<k> implements INode<k> {
    private k key;
    private INode next;
    public MyNode(k key){
        this.key = key;
        this.next = null;
    }

    @Override
    public k getKey() {
        return key;
    }

    @Override
    public void setKey(k key) {
        this.key=key;
    }

    public INode getNext(){
        return next;
    }
    public void setNext(INode next){
        this.next=next;
    }
}

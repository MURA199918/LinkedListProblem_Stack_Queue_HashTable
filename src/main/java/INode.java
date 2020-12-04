public interface INode<k> {
    k getKey();
    void setKey(k key);

    INode<k> getNext();
    void setNext(INode<k> next);

}

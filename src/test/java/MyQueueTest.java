import org.junit.Assert;
import org.junit.Test;

public class MyQueueTest {
    @Test
    public void given3NumberswhenAddedtoQueueshouldhaveAppendedNode(){
        MyNode<Integer> myFirstNode = new MyNode<>(56);
        MyNode<Integer> mySecondNode = new MyNode<>(30);
        MyNode<Integer> myThirdNode = new MyNode<>(70);
        MyQueue myQueue = new MyQueue();
        myQueue.enqueu(myFirstNode);
        myQueue.enqueu(mySecondNode);
        myQueue.enqueu(myThirdNode);
        myQueue.printStack();
    }

}

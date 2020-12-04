import java.util.ArrayList;

public class MyLinkedHashMap<k,v> {
    private final int numBuckets;
    ArrayList<MyLinkedList<k>> myBucketArray;

    public MyLinkedHashMap(){
        this.numBuckets = 10;
        this.myBucketArray = new ArrayList<>(numBuckets);
        for(int i=0;i<numBuckets;i++){
            this.myBucketArray.add(null);
        }
    }

    //This implements hash function to find index for a key
    private int getBucketIndex(k key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        //System.out.println("Key: "+key+" hashcode: "+hashCode+" index: "+index);
        return index;
    }

    public v get(k key) {
        int index= this.getBucketIndex(key);
        MyLinkedList<k> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) return null;
        MyMapNode<k,v> myMapNode = (MyMapNode<k,v>)myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }


    public void add(k key, v value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<k> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null){
            myLinkedList = new MyLinkedList<>();
            this.myBucketArray.set(index,myLinkedList);
        }
        MyMapNode<k,v> myMapNode = (MyMapNode<k,v>)myLinkedList.search(key);
        if(myMapNode == null){
            myMapNode = new MyMapNode<>(key,value);
            myLinkedList.append(myMapNode);
        }
        else{
            myMapNode.setValue(value);
        }
    }

    @Override
    public String toString(){
        return "MyLinkedHashMap List{" + myBucketArray + '}';
    }
}

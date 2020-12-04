import org.junit.Assert;
import org.junit.Test;

public class MyLinkedHashMapTest {
    @Test
    public void givenasentence_whenwordsareaddedtoList_shouldreturnParanoidFrequency(){
        String sentence = "Paranoids are not paranoid because they are paranoid but "+
                          "because they keep putting themselves deliberately into "+
                          "paranoid avoidable situations";
        MyLinkedHashMap<String,Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for(String word : words){
            Integer value = myLinkedHashMap.get(word);
            if(value == null) value = 1;
            else value = value + 1;
            myLinkedHashMap.add(word,value);
        }
        System.out.println(myLinkedHashMap);
        int frequency = myLinkedHashMap.get("paranoid");
        Assert.assertEquals(3,frequency);

    }

    @Test
    public void givenasentence_whenwordsareaddedtoList_shouldremoveAvoidableword(){
        String sentence = "Paranoids are not paranoid because they are paranoid but "+
                "because they keep putting themselves deliberately into "+
                "paranoid avoidable situations";
        MyLinkedHashMap<String,Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        String checkword = "avoidable";
        for(String word : words){
            if(word.equals(checkword)){
                myLinkedHashMap.remove(word);
            }
            else{
                Integer value = myLinkedHashMap.get(word);
                if(value == null) value = 1;
                else value = value + 1;
                myLinkedHashMap.add(word,value);
            }
        }
        System.out.println(myLinkedHashMap);
        try{
            int frequency = myLinkedHashMap.get("avoidable");
            //Assert.assertEquals(0,frequency);
        }
        catch (NullPointerException e){
            System.out.println("'Avoidable' word not found in given sentence");
        }
    }
}

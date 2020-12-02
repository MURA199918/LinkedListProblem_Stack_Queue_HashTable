import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myNumberList = new ArrayList<Integer>();
        for(int i=0;i<5;i++){
            myNumberList.add(i);
        }
        Iterator<Integer> itr=myNumberList.iterator();
        while (itr.hasNext()){
            Integer i=itr.next();
            System.out.println("Iterator value: "+i);
        }

        //Method2. Traversing with explicit consumer interface
        class MyConsumer implements Consumer<Integer> {
            public void accept(Integer t){
                System.out.println("Method2: Consumer impl value:"+t);
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);

        //Method3. Traversing with anonymous consumer Interface
        myNumberList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("Method3: forEach anonymous class value:"+t);
            }
        });

        //Method4. Explicit Lambda Function
        Consumer<Integer> myListAction = n->{
            System.out.println("Method4: forEach Lambda impl value:" +n);
        };
        myNumberList.forEach(myListAction);

        //Method5. Implicit Lambda Function
        myNumberList.forEach(n->{
            System.out.println("Method5: forEach Lambda impl value:"+n);
        });

        //Method6. Implicit Lambda Function to print double
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n->{
            System.out.println("Method6: forEach Lambda double value:"+toDoubleFunction.apply(n));
        });

        //Method7. Implicit Lambda Function to check even
        Predicate<Integer> isEvenFunction = n-> n>0 && n%2==0;
        myNumberList.forEach(n->{
            System.out.println("Method7: forEach value of:"+n+" check for Even: "+ isEvenFunction.test(n));
        });

        //Method8. Processing the Stream
        myNumberList.stream().forEach(n->{
            System.out.println("Method8: Stream forEach value: "+n);
        });

        //Method9. Process the Stream, Apply Operations on Stream and store result
        List<Double> StreamList = myNumberList.stream()
                                  .filter(isEvenFunction)
                                  .peek(n->System.out.println("Peek Even Number: "+n))
                                  .map(toDoubleFunction)
                                  .collect(Collectors.toList());
        System.out.println("Method9: Printing Double List: "+StreamList);

        //Method10. Listing first Even
        Integer first = myNumberList.stream()
                        .filter(isEvenFunction)
                        .peek(n-> System.out.println("Peek Even Number: "+n))
                        .findFirst()
                        .orElse(null);
        System.out.println("Method10: First Even: "+first);

        //Method11. Minimum and Maximum
        Integer min = myNumberList.stream()
                      .filter(isEvenFunction)
                      .min((n1,n2)->n1-n2)
                      .orElse(null);
        System.out.println("Method11: Min even: "+min);
        Integer max = myNumberList.stream()
                      .filter(isEvenFunction)
                      .max(Comparator.comparing(Integer::intValue))
                      .orElse(null);
        System.out.println("Method11: Max value: "+max);

        //Method12. Sum and Average
        Integer sum = myNumberList.stream()
                      .reduce(0,Integer::sum);
        Long count = myNumberList.stream().count();
        System.out.println("Method12: Average of "+sum+"/"+count+"="+sum/count);


        //Method13. Check all even, single even or none divisible by 6
        boolean allEven = myNumberList.stream().filter(isEvenFunction).allMatch(isEvenFunction);
        boolean oneEven = myNumberList.stream().anyMatch(isEvenFunction);
        boolean nonemultofsix = myNumberList.stream().noneMatch(i->i>0 && i%6 == 0);
        System.out.println("allEven: "+allEven+" oneEven: "+oneEven+" nonemultofsix: "+nonemultofsix);
    }
}

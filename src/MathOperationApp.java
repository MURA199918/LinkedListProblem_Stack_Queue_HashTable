@FunctionalInterface
interface Mathfunction{
    int calculate(int a,int b);
    static  void printresult(int a, int b, String function,Mathfunction obj ){
        System.out.println("Result of "+function+" is "+obj.calculate(a,b));
    }
}
public class MathOperationApp {
    public static void main(String[] args){
        //Mathfunction add=(int a,int b)->a+b;

        Mathfunction add = Integer::sum;
        Mathfunction sub = (x,y)->x-y;
        Mathfunction multiply = (x,y)->x*y;
        Mathfunction divide = (int x,int y)->{
            if(y==0) return 0;
            return x/y;
        };

        System.out.println("Addition is :"+add.calculate(6,3));
        System.out.println("Subtraction is :"+sub.calculate(6,3));
        System.out.println("Multiplication is :"+multiply.calculate(6,3));
        try{
            System.out.println("Division is "+divide.calculate(6,3));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        Mathfunction.printresult(6,3,"Addition",add);
        Mathfunction.printresult(6,3,"Subtraction",sub);
        Mathfunction.printresult(6,3,"Multiplication",multiply);
        Mathfunction.printresult(6,3,"Division",divide);
        
    }

}

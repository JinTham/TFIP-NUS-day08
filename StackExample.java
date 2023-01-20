import java.util.Iterator;
import java.util.Stack;

public class StackExample {
    public void example(){
        Stack<Integer> stack = new Stack<>();
        //Pushing or puting something onto the stack
        for (int i=0;i<10;i++){
            stack.push(i);
        }
        //Pop or taking something from the stack
        for (int i=0;i<5;i++){
            Integer stackItem = stack.pop();
            System.out.println("Stack Item (pop): "+stackItem);
        }
        //See what is the last item on top of the stack
        Integer peekItem = stack.peek();
        System.out.println("Peek item: "+peekItem);
        
        //See what is the first item on the bottom of the stack
        Integer firstItem = stack.firstElement();
        System.out.println("First item of stack: "+firstItem);

        //Search item
        Integer index = stack.search(2);
        System.out.println("Stack element found at index "+ index);

        //Iterate through stack
        Iterator<Integer> iter = stack.iterator();
        while (iter.hasNext()){
            Integer item = iter.next();
            System.out.println("Iterator: " + item);
        }
    }
}

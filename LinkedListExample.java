import java.util.LinkedList;

public class LinkedListExample {
    public void example(){
        LinkedList<String> ll = new LinkedList<>();
    
        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add("E");
        ll.add("F");
        ll.add("G");

   
        System.out.println(ll);
        //remove an element
        ll.remove("C");
        System.out.println(ll);
        //remove first and last element
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
    
}
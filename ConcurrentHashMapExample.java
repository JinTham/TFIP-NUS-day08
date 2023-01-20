import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public void example(){
        Map<String,Integer> laptops = new ConcurrentHashMap<>();
        laptops.put("Acer",25);
        laptops.put("Apple",10);
        laptops.put("MSI",10);
        laptops.put("Asus",15);
        laptops.put("Empty",18);
        //Get the total size of the map objects
        System.out.println("Total laptops: " + laptops.size());

        //Iterate through the Map (laptops), use keySet method
        for (String key : laptops.keySet()){
            System.out.println(key + "-" + laptops.get(key));
        }
        String searchString = "Asus";
        if (laptops.containsValue(searchString)){
            System.out.println(searchString + "-" + laptops.get(searchString));
        }

        Enumeration<Integer> elems = ((ConcurrentHashMap<String,Integer>) laptops).elements();
        while (elems.hasMoreElements()){
            System.out.println(elems.nextElement());
        }

        Integer value = laptops.putIfAbsent("Empty", 100);
        System.out.println("Empty: "+laptops.get("Empty"));
    }
}

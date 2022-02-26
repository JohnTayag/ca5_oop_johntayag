import java.io.IOException;
import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        //Q1,2
        ArrayList<tshirt> shirtsArraylist = new ArrayList<>();
        shirtsArraylist.add(new tshirt("gucci1", 11784, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci2", 12742, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci3", 18462, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci4", 46283, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci5", 81642, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci6", 13542, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci7", 51732, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci8", 61742, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci9", 91000, 200.50, 8.7));
        shirtsArraylist.add(new tshirt("gucci10", 17352, 200.50, 8.7));
//        displaytshirtsArrayList(shirtsArraylist);

        //Q3,4
        Map<Long, tshirt> shirtsMap = new HashMap<>();

        shirtsMap.put(100034L, new tshirt("gucci1", 11784, 200.50, 8.7));
        shirtsMap.put(200034L, new tshirt("gucci2", 12742, 200.50, 8.7));
        shirtsMap.put(300034L, new tshirt("gucci3", 18462, 200.50, 8.7));
        shirtsMap.put(400034L, new tshirt("gucci4", 46283, 200.50, 8.7));
        shirtsMap.put(500034L, new tshirt("gucci5", 81642, 200.50, 8.7));
        shirtsMap.put(600034L, new tshirt("gucci6", 13542, 200.50, 8.7));
        shirtsMap.put(700034L, new tshirt("gucci7", 51732, 200.50, 8.7));
        shirtsMap.put(800034L, new tshirt("gucci8", 61742, 200.50, 8.7));
        shirtsMap.put(990034L, new tshirt("gucci9", 91000, 200.50, 8.7));
        shirtsMap.put(250034L, new tshirt("gucci10", 17352, 200.50, 8.7));

//        System.out.println("Enter key value:");
//        Long key = kb.nextLong();
//        findShirtMapByKey(key,shirtsMap);

        //Q5
        TreeMap<String, tshirt> shirtsTreeMap = new TreeMap<>();
        shirtsTreeMap.put("P641Bf", new tshirt("gucci1", 11784, 200.50, 8.7));
        shirtsTreeMap.put("L641Bf", new tshirt("gucci2", 12742, 200.50, 8.7));
        shirtsTreeMap.put("E641Bf", new tshirt("gucci3", 18462, 200.50, 8.7));
        shirtsTreeMap.put("X641Bf", new tshirt("gucci4", 46283, 200.50, 8.7));
        shirtsTreeMap.put("F641Bf", new tshirt("gucci5", 81642, 200.50, 8.7));
        shirtsTreeMap.put("B641Bf", new tshirt("gucci6", 13542, 200.50, 8.7));
        shirtsTreeMap.put("A641Bf", new tshirt("gucci7", 51732, 200.50, 8.7));
        shirtsTreeMap.put("G641Bf", new tshirt("gucci8", 61742, 200.50, 8.7));
        shirtsTreeMap.put("Z641Bf", new tshirt("gucci9", 91000, 200.50, 8.7));
        shirtsTreeMap.put("H641Bf", new tshirt("gucci10", 17352, 200.50, 8.7));
//        displaytshirtsTreeMap(shirtsTreeMap);

        //Q6
        PriorityQueue<tshirt> queue
                = new PriorityQueue<tshirt>(new tshirtCodeComparator(SortType.Ascending));

        queue.add(new tshirt("gucci13", 27232, 138.50, 1.5));
        queue.add(new tshirt("gucci12", 19573, 199.99, 9.0));

        //add two 3rd-priority elements
        queue.add(new tshirt("gucci15", 47232, 238.50, 8.5));
        queue.add(new tshirt("gucci15", 37232, 238.50, 8.5));
        //add two 2rd-priority elements
        queue.add(new tshirt("gucci16", 15232, 238.50, 8.5));
        queue.add(new tshirt("gucci17", 13232, 238.50, 8.5));
        //add one top-priority element
        queue.add(new tshirt("gucci17", 90232, 238.50, 8.5));

        //remove and display one element


        //remove display all elements in priority order
//        System.out.println("Values in order of code Priority:");
//        while(!queue.isEmpty()){
//            System.out.println(queue.remove());
//        }

        //Q7
        System.out.println("tshirts in priority order using two field comparison");
        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }

    }




    public static void displaytshirtsArrayList(ArrayList<tshirt> shirts) {
        for (tshirt x : shirts) {
            System.out.println(x);
        }
    }

    public static void displaytshirtsTreeMap(TreeMap<String, tshirt> shirtsTreeMap) {
        Set<String> keySet = shirtsTreeMap.keySet();

        for (String key : keySet) {
            tshirt shirt = shirtsTreeMap.get(key);

            System.out.println("Key:" + key + " Name:" + shirt.getName() + " Price:" + shirt.getPrice());

        }




    }

    public static void findShirtMapByKey(Long key, Map<Long,tshirt> shirtsmap){
        if (shirtsmap.containsKey(key)) {
            System.out.println("shirtsMap contains the key" + key + " with value " + shirtsmap.get(key));
        } else {
            System.out.println("shirtsMap does NOT contain the key " + key);
        }
    }
}








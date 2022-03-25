import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    public void start() {

        try {
            displayMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException {
        Scanner kb = new Scanner(System.in);

        List<tshirt> productsArrayList = new ArrayList<>();
        productsArrayList.add(new tshirt("Asos Design Relaxed Fit", 11784, 55.50, 8.5));
        productsArrayList.add(new tshirt("Adidas Striped Shirt", 12742, 20.99, 9));
        productsArrayList.add(new tshirt("Polo Ralph Lauren icon logo long sleeve poplin shirt in blue", 18462, 100.50, 7));
        productsArrayList.add(new tshirt("Levi's slouchy revere collar shirt in abrstact print", 46283, 66, 10));
        productsArrayList.add(new tshirt("MIX & MATCH COLLUSION Unisex boxy shirt co-ord in warped print", 81642, 80.50, 6.5));
        productsArrayList.add(new tshirt("Puma crew tshirt", 13542, 30, 7));
        productsArrayList.add(new tshirt("Jack & Jones Originals short sleeve revere collar shirt in pink mini animal print", 51732, 40.50, 8.5));
        productsArrayList.add(new tshirt("Pull&Bear shirt", 61742, 33.50, 7.5));
        productsArrayList.add(new tshirt("Tommy Jeans slim fit oxford shirt in white", 91000, 66.20, 5));
        productsArrayList.add(new tshirt("Adidas oversized shirt", 17352, 70.80, 8));

        Map<Long, tshirt> productsMap = new HashMap<>();
        productsMap.put(100034L, new tshirt("Asos Design Relaxed Fit", 11784, 55.50, 8.5));
        productsMap.put(200034L, new tshirt("Adidas Striped Shirt", 12742, 20.99, 9));
        productsMap.put(300034L, new tshirt("Polo Ralph Lauren icon logo long sleeve poplin shirt in blue", 18462, 100.50, 7));
        productsMap.put(400034L, new tshirt("Levi's slouchy revere collar shirt in abrstact print", 46283, 66, 10));
        productsMap.put(500034L, new tshirt("MIX & MATCH COLLUSION Unisex boxy shirt co-ord in warped print", 81642, 80.50, 6.5));
        productsMap.put(600034L, new tshirt("Puma crew tshirt", 13542, 30, 7));
        productsMap.put(700034L, new tshirt("Jack & Jones Originals short sleeve revere collar shirt in pink mini animal print", 51732, 40.50, 8.5));
        productsMap.put(800034L, new tshirt("Pull&Bear shirt", 61742, 33.50, 7.5));
        productsMap.put(990034L, new tshirt("Tommy Jeans slim fit oxford shirt in white", 91000, 66.20, 5));
        productsMap.put(250034L, new tshirt("Adidas oversized shirt", 17352, 70.80, 8));

        TreeMap<String, tshirt> productsTreeMap = new TreeMap<>();
        productsTreeMap.put("P641Bf", new tshirt("Asos Design Relaxed Fit", 11784, 55.50, 8.5));
        productsTreeMap.put("L641Bf", new tshirt("Adidas Striped Shirt", 12742, 20.99, 9));
        productsTreeMap.put("E641Bf", new tshirt("Polo Ralph Lauren icon logo long sleeve poplin shirt in blue", 18462, 100.50, 7));
        productsTreeMap.put("X641Bf", new tshirt("Levi's slouchy revere collar shirt in abrstact print", 46283, 66, 10));
        productsTreeMap.put("F641Bf", new tshirt("MIX & MATCH COLLUSION Unisex boxy shirt co-ord in warped print", 81642, 80.50, 6.5));
        productsTreeMap.put("B641Bf", new tshirt("Jack & Jones Originals short sleeve revere collar shirt in pink mini animal print", 51732, 40.50, 8.5));
        productsTreeMap.put("A641Bf", new tshirt("Puma crew tshirt", 13542, 30, 7));
        productsTreeMap.put("G641Bf", new tshirt("Pull&Bear shirt", 61742, 33.50, 7.5));
        productsTreeMap.put("Z641Bf", new tshirt("Tommy Jeans slim fit oxford shirt in white", 91000, 66.20, 5));
        productsTreeMap.put("H641Bf", new tshirt("Adidas oversized shirt", 17352, 70.80, 8));

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. Display shirts from ArrayList\n"
                + "2. Find shirt by key from map\n"
                + "3. Display shirts from TreeMap\n"
                + "4. Order PriorityQueue one-comparison\n"
                + "5. Order PriorityQueue two-comparison\n"
                + "6. Exit\n"
                + "Enter Option [1,6]";

        final int SHIRTSARRAYLIST = 1;
        final int FINDBYKEY = 2;
        final int SHIRTSTREEMAP = 3;
        final int PRIORITYQUEUEONECOMPARISON = 4;
        final int PRIORITYQUEUETWOCOMPARISON = 5;
        final int EXIT = 6;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case SHIRTSARRAYLIST:
                        System.out.println("Display tshirts from ArrayList");
                        displaytshirtsArrayList(productsArrayList);
                        break;

                    case FINDBYKEY:
                        System.out.println("Find Shirt by Key from Map");
                        System.out.println("Enter key value:");

                        Long key = kb.nextLong();
                        findShirtByKey(key, productsMap);
                        break;

                    case SHIRTSTREEMAP:
                        System.out.println("Display tshirts from TreeMap");
                        displaytshirtsTreeMap(productsTreeMap);
                        break;

                    case PRIORITYQUEUEONECOMPARISON:
                        System.out.println("Display priorityqueue one-comparison(code)");
                        PriorityQueue<tshirt> queue = new PriorityQueue<>(new tshirtCodeComparator(SortType.Ascending));
                        addPriorityQueue(queue);
                        while (!queue.isEmpty()) {
                            System.out.println(queue.remove());
                        }
                        break;

                    case PRIORITYQUEUETWOCOMPARISON:
                        System.out.println("Display priorityqueue two-comparison(name,code)");
                        PriorityQueue<tshirt> queue2 = new PriorityQueue<>();
                        addPriorityQueue(queue2);
                        while (!queue2.isEmpty()) {
                            System.out.println(queue2.remove());
                        }

                        break;

                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;

                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

    public static void displaytshirtsArrayList(List<tshirt> products) {
        for (tshirt x : products) {
            System.out.println(x);
        }
    }

    public static void displaytshirtsTreeMap(TreeMap<String, tshirt> products) {
        Set<String> keySet = products.keySet();

        for (String key : keySet) {
            tshirt shirt = products.get(key);

            System.out.println("Key:" + key + " Name:" + shirt.getName() + " Price:" + shirt.getPrice());

        }

    }

    public static void findShirtByKey(Long key, Map<Long, tshirt> products) {
        if (products.containsKey(key)) {
            System.out.println("shirtsMap contains the key:" + key + " with " + products.get(key));
        } else {
            System.out.println("shirtsMap does NOT contain the key " + key);
        }
    }

    public static void addPriorityQueue(PriorityQueue<tshirt> queue) {
        queue.add(new tshirt("Adidas Striped Shirt", 27232, 138.50, 9));
        queue.add(new tshirt("Asos Design Relaxed Fit", 19573, 199.99, 8.5));

        //add two 3rd-priority elements
        queue.add(new tshirt("Levi's slouchy revere collar shirt in abrstact print", 47232, 238.50, 10));
        queue.add(new tshirt("Polo Ralph Lauren icon logo long sleeve poplin shirt in blue", 37232, 238.50, 7));
        //add two 2rd-priority elements
        queue.add(new tshirt("Puma crew tshirt", 15232, 238.50, 7));
        queue.add(new tshirt("Puma crew tshirt", 13232, 238.50, 7.5));

//        System.out.println("\nRemove and display one element");
//        System.out.println("Printing out top element and removing it : \n "+ queue.poll());

        //add one top-priority element
        queue.add(new tshirt("Adidas oversized shirt", 90232, 238.50, 8));
    }
}








import DAOs.MySqlProductDao;
import DAOs.UserDaoInterface;
import DTOs.Product;
import Exceptions.DaoException;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DaoException {
        Scanner kb = new Scanner(System.in);

        UserDaoInterface IUserDao = new MySqlProductDao();
        try {

//            System.out.println("\nCall findAllProductsJSON():");
//            String allProductsJSON = IUserDao.findAllProductsJSON();
//            System.out.println(allProductsJSON);

            System.out.println("\nCall findProductJSONById():");
            System.out.println("Enter product Id to find:");
            int Json_id = kb.nextInt();

            String findProductByIDJSON = IUserDao.findProductIDJSON(Json_id);
            System.out.println(findProductByIDJSON);

//            System.out.println("\nCall findAllProducts():");
//            List<Product> products = IUserDao.findAllProducts();
//
//            if (products.isEmpty())
//                System.out.println("There are no Products");
//            else {
//                for (Product product : products)
//                    System.out.println("Product: " + product.toString());
//            }



//            System.out.println("\nCall findProductById():");
//            System.out.println("Enter product Id to find:");
//            int id = kb.nextInt();
//
//            Product product = IUserDao.findProductByID(id);
//            if( product != null ) // null returned if product_id not valid
//                System.out.println("product found: " + product);
//            else
//                System.out.println("Product with that id not found");
//
//            System.out.println("\n"+"test dao - with an invalid ID (i.e. not in database):");
//            int test_id = 67;
//
//            product = IUserDao.findProductByID(test_id);
//
//            if(product != null)
//                System.out.println("Product was found: " + product);
//            else
//                System.out.println("Product Id: " + test_id + " is not valid.");
//
//            System.out.println("\nCall deleteProductById():");
//            System.out.println("Enter product Id to delete:");
//            int delete_test_id = kb.nextInt();

//            IUserDao.deleteProductByID(delete_test_id);
//
//            System.out.println("Display products after delete:");
//
//            products = IUserDao.findAllProducts();     // call a method in the DAO
//
//            if (products.isEmpty())
//                System.out.println("There are no Products");
//            else {
//                for (Product after_deleted_products : products)
//                    System.out.println("Product: " + after_deleted_products.toString());
//            }

//            System.out.println("\nCall addProduct()");
//
//            System.out.println("Enter product name:");
//            String pName = kb.nextLine();
//            System.out.println("Enter product price:");
//            Double pPrice = kb.nextDouble();
//            System.out.println("Enter product size:");
//            Double pSize = kb.nextDouble();
//
//            IUserDao.addProduct(new Product(pName,  pPrice, pSize));
//            if( products.isEmpty() )
//                System.out.println("There are no Products");
//            else {
//                for (Product u : products)
//                    System.out.println("product: " + u.toString());
//            }
//
//            System.out.println("\nCall filterProduct()");
//
//            //filter by size
//            double filterQuery = 6.5;
//            List <Product> filteredProducts = IUserDao.filterProducts(filterQuery);     // call a method in the DAO
//
//            if (filteredProducts.isEmpty())
//                System.out.println("There are no Products with size: " + filterQuery);
//            else {
//                for (Product p : filteredProducts)
//                    System.out.println("Product(s) with size " + filterQuery + ": " +  p.toString());
//            }

        } catch (DaoException e) {
            e.printStackTrace();
        }

//        Main app = new Main();
//        app.start();
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

        List<Product> productsArrayList = new ArrayList<>();
        productsArrayList.add(new Product("Asos Design Relaxed Fit", 11784, 55.50, 8.5));
        productsArrayList.add(new Product("Adidas Striped Shirt", 12742, 20.99, 9));
        productsArrayList.add(new Product("Polo Ralph Lauren icon logo long sleeve poplin shirt in blue", 18462, 100.50, 7));
        productsArrayList.add(new Product("Levi's slouchy revere collar shirt in abrstact print", 46283, 66, 10));
        productsArrayList.add(new Product("MIX & MATCH COLLUSION Unisex boxy shirt co-ord in warped print", 81642, 80.50, 6.5));
        productsArrayList.add(new Product("Puma crew DTOs.Product", 13542, 30, 7));
        productsArrayList.add(new Product("Jack & Jones Originals short sleeve revere collar shirt in pink mini animal print", 51732, 40.50, 8.5));
        productsArrayList.add(new Product("Pull&Bear shirt", 61742, 33.50, 7.5));
        productsArrayList.add(new Product("Tommy Jeans slim fit oxford shirt in white", 91000, 66.20, 5));
        productsArrayList.add(new Product("Adidas oversized shirt", 17352, 70.80, 8));

        Map<Long, Product> productsMap = new HashMap<>();
        productsMap.put(100034L, new Product("Asos Design Relaxed Fit", 11784, 55.50, 8.5));
        productsMap.put(200034L, new Product("Adidas Striped Shirt", 12742, 20.99, 9));
        productsMap.put(300034L, new Product("Polo Ralph Lauren icon logo long sleeve poplin shirt in blue", 18462, 100.50, 7));
        productsMap.put(400034L, new Product("Levi's slouchy revere collar shirt in abrstact print", 46283, 66, 10));
        productsMap.put(500034L, new Product("MIX & MATCH COLLUSION Unisex boxy shirt co-ord in warped print", 81642, 80.50, 6.5));
        productsMap.put(600034L, new Product("Puma crew DTOs.Product", 13542, 30, 7));
        productsMap.put(700034L, new Product("Jack & Jones Originals short sleeve revere collar shirt in pink mini animal print", 51732, 40.50, 8.5));
        productsMap.put(800034L, new Product("Pull&Bear shirt", 61742, 33.50, 7.5));
        productsMap.put(990034L, new Product("Tommy Jeans slim fit oxford shirt in white", 91000, 66.20, 5));
        productsMap.put(250034L, new Product("Adidas oversized shirt", 17352, 70.80, 8));

        TreeMap<String, Product> productsTreeMap = new TreeMap<>();
        productsTreeMap.put("P641Bf", new Product("Asos Design Relaxed Fit", 11784, 55.50, 8.5));
        productsTreeMap.put("L641Bf", new Product("Adidas Striped Shirt", 12742, 20.99, 9));
        productsTreeMap.put("E641Bf", new Product("Polo Ralph Lauren icon logo long sleeve poplin shirt in blue", 18462, 100.50, 7));
        productsTreeMap.put("X641Bf", new Product("Levi's slouchy revere collar shirt in abrstact print", 46283, 66, 10));
        productsTreeMap.put("F641Bf", new Product("MIX & MATCH COLLUSION Unisex boxy shirt co-ord in warped print", 81642, 80.50, 6.5));
        productsTreeMap.put("B641Bf", new Product("Jack & Jones Originals short sleeve revere collar shirt in pink mini animal print", 51732, 40.50, 8.5));
        productsTreeMap.put("A641Bf", new Product("Puma crew DTOs.Product", 13542, 30, 7));
        productsTreeMap.put("G641Bf", new Product("Pull&Bear shirt", 61742, 33.50, 7.5));
        productsTreeMap.put("Z641Bf", new Product("Tommy Jeans slim fit oxford shirt in white", 91000, 66.20, 5));
        productsTreeMap.put("H641Bf", new Product("Adidas oversized shirt", 17352, 70.80, 8));

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
                        PriorityQueue<Product> queue = new PriorityQueue<>(new tshirtCodeComparator(SortType.Ascending));
                        addPriorityQueue(queue);
                        while (!queue.isEmpty()) {
                            System.out.println(queue.remove());
                        }
                        break;

                    case PRIORITYQUEUETWOCOMPARISON:
                        System.out.println("Display priorityqueue two-comparison(name,code)");
                        PriorityQueue<Product> queue2 = new PriorityQueue<>();
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

    public static void displaytshirtsArrayList(List<Product> products) {
        for (Product x : products) {
            System.out.println(x);
        }
    }

    public static void displaytshirtsTreeMap(TreeMap<String, Product> products) {
        Set<String> keySet = products.keySet();

        for (String key : keySet) {
            Product shirt = products.get(key);

            System.out.println("Key:" + key + " Name:" + shirt.getName() + " Price:" + shirt.getPrice());

        }

    }

    public static void findShirtByKey(Long key, Map<Long, Product> products) {
        if (products.containsKey(key)) {
            System.out.println("shirtsMap contains the key:" + key + " with " + products.get(key));
        } else {
            System.out.println("shirtsMap does NOT contain the key " + key);
        }
    }

    public static void addPriorityQueue(PriorityQueue<Product> queue) {
        queue.add(new Product("Adidas Striped Shirt", 27232, 138.50, 9));
        queue.add(new Product("Asos Design Relaxed Fit", 19573, 199.99, 8.5));

        //add two 3rd-priority elements
        queue.add(new Product("Levi's slouchy revere collar shirt in abrstact print", 47232, 238.50, 10));
        queue.add(new Product("Polo Ralph Lauren icon logo long sleeve poplin shirt in blue", 37232, 238.50, 7));
        //add two 2rd-priority elements
        queue.add(new Product("Puma crew DTOs.Product", 15232, 238.50, 7));
        queue.add(new Product("Puma crew DTOs.Product", 13232, 238.50, 7.5));

//        System.out.println("\nRemove and display one element");
//        System.out.println("Printing out top element and removing it : \n "+ queue.poll());

        //add one top-priority element
        queue.add(new Product("Adidas oversized shirt", 90232, 238.50, 8));
    }
}








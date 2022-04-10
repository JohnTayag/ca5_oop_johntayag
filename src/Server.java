import DAOs.MySqlProductDao;
import DAOs.UserDaoInterface;
import DTOs.Product;
import Exceptions.DaoException;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Locale;

public class Server {

    UserDaoInterface dao = new MySqlProductDao();

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start() {
        try {
            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection,
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber)); // create a new ClientHandler for the client,
                t.start();                                                  // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e) {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;

        public ClientHandler(Socket clientSocket, int clientNumber) {
            try {
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);

                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

                this.clientNumber = clientNumber;  // ID number that we are assigning to this client

                this.socket = clientSocket;  // store socket ref for closing

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {

            Gson gsonParser = new Gson();

            String message;
            try {
                while ((message = socketReader.readLine()) != null) {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);
                    final String COMMAND_REQUEST_DISPLAY_ALL = "DisplayAll";
                    final String COMMAND_REQUEST_FIND_BY_ID = "FindbyId";
                    final String COMMAND_REQUEST_DELETE_BY_ID = "DeletebyId";
                    final String COMMAND_REQUEST_ADD_PRODUCT = "AddProduct";

                    if (message.equalsIgnoreCase(COMMAND_REQUEST_DISPLAY_ALL)) {

//take out pretty print becuase it makes a line, in client it stops when it sees that \n

                        List<Product> products = dao.findAllProducts();
                        System.out.println("server run" + products);

                        String gsonparsed = gsonParser.toJson(products);
                        System.out.println(gsonparsed);
                        socketWriter.println(gsonParser.toJson(products));


                    } else if (message.startsWith(COMMAND_REQUEST_FIND_BY_ID)) {

                        String tokens[] = message.split(" ");
                        int num = Integer.parseInt(tokens[1]);

                        Product product = dao.findProductByID(num);


                        String gsonparsed = gsonParser.toJson(product);
                        System.out.println(gsonparsed);
                        socketWriter.println(gsonParser.toJson(product));


                    } else if (message.startsWith(COMMAND_REQUEST_DELETE_BY_ID))   {
                        String result;
                        String tokens[] = message.split(" ");
                        int num = Integer.parseInt(tokens[1]);

                        boolean deleted = dao.deleteProductByID(num);

                        if (!deleted) {
                            result = "delete by id did not work(cant find id or wrong input)";
                        } else {
                            result = "delete by id did work";
                        }
                        socketWriter.println(result);


                    }
                    else if (message.startsWith(COMMAND_REQUEST_ADD_PRODUCT)) {

                        String tokens[] = message.split(" ");
                        String name = (tokens[1]);
                        Double price = Double.parseDouble(tokens[2]);
                        Double size = Double.parseDouble(tokens[3]);
                        Product add_product = new Product(name,price,size);

                        Product product = dao.addProduct(add_product);


                        String gsonparsed = gsonParser.toJson(product);
                        System.out.println(gsonparsed);
                        socketWriter.println(gsonParser.toJson(product));


                    }
                    else {
                        socketWriter.println("I'm sorry I don't understand :(");
                    }
                }

                socket.close();

            } catch (IOException | DaoException ex) {
                ex.printStackTrace();
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

}

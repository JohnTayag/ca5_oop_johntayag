

/**
 * CLIENT                                                  March 2021
 * <p>
 * This Client program asks the user to input commands to be sent to the server.
 * <p>
 * There are only two valid commands in the protocol: "Time" and "Echo"
 * <p>
 * If user types "Time" the server should reply with the current server time.
 * <p>
 * If the user types "Echo" followed by a message, the server will echo back the message.
 * e.g. "Echo Nice to meet you"
 * <p>
 * If the user enters any other input, the server will not understand, and
 * will send back a message to the effect.
 * <p>
 * NOte: You must run the server before running this the client.
 * (Both the server and the client will be running together on this computer)
 */


import DTOs.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import jdk.swing.interop.SwingInterOpUtils;
import org.json.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start() {
        Gson gsonParser = new GsonBuilder().setPrettyPrinting().create();
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 8080);  // connect to server socket
            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort());

            System.out.println("Client message: The Client is running and has connected to the server");

            System.out.println("Please enter a command:  (\"DisplayAll\" to display all entities) \n>");
            String command = in.nextLine();

            OutputStream os = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);   // true => auto flush buffers

            socketWriter.println(command);

            Scanner socketReader = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply
            final String COMMAND_REQUEST_DISPLAY_ALL = "DisplayAll";
            //ADDED
            boolean keep_looking = true;
            while (keep_looking) {
                if (command.equalsIgnoreCase(COMMAND_REQUEST_DISPLAY_ALL))   //we expect the server to return a time
                {
                    //parse the json, populate and display
                    String jsonString = socketReader.nextLine();
//                    System.out.println("Client message: Response from server Time: " + jsonString);
                    Type userListType = new TypeToken<ArrayList<Product>>(){}.getType();

                    ArrayList<Product> userArray = gsonParser.fromJson(jsonString, userListType);
                    System.out.println(Product.getTableHeader());
                    for(Product product : userArray) {
                        System.out.println(product);
                    }





                } else   // the user has entered the Echo command or an invalid command
                {
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                System.out.println("Enter next Command: ");
                command = in.nextLine();
                socketWriter.println(command);
            }

            socketWriter.close();
            socketReader.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Client message: IOException: " + e);
        }
    }
}


//  LocalTime time = LocalTime.parse(timeString); // Parse timeString -> convert to LocalTime object if required
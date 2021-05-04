//Сервер
package server;
import java.io.*;
import java.util.Scanner;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static Socket clientSocket; 
    static ServerSocket server; 
    static BufferedReader in; 
    static BufferedWriter out; 

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket (4004); 
                System.out.println ("Сервер запущен!"); 
             
                clientSocket = server.accept (); 
               
                try { 
                    
                    in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream ()));
                 
                    out = new BufferedWriter (new OutputStreamWriter (clientSocket.getOutputStream ()));

                    String word = in.readLine (); 
                    System.out.println (word);
                 
                    out.write ("Привет, это Сервер! Подтверждаю, вы написали. что ваше имя: " + word + "\n");
                    out.flush (); 

                } finally { 
                    clientSocket.close ();
                   
                    in.close ();
                    out.close ();
                }
            } finally {
                System.out.println 
                server.close ();
            }
        } catch (IOException e) {
            System.err.println (e);
        }
    }
}


//Клиент
package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

         Socket clientSocket = null; 
        BufferedReader reader; 
     
       BufferedReader in; 
       BufferedWriter out; 

        try {
            try {
               
                clientSocket = new Socket("localhost", 4004); 
             
                reader = new BufferedReader(new InputStreamReader(System.in));
               
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Напишите своё имя. пожалуйста:");
                
                String word = reader.readLine(); 
               
                out.write(word + "\n"); 
                out.flush();
                String serverWord = in.readLine(); 
                System.out.println(serverWord); 
            } finally { 
                System.out.println("Клиент был закрыт...");
                clientSocket.close();

            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}

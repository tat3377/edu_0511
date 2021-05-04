package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        System.out.println("Сервер запущен");
        try {
            ServerSocket serverSocket = new ServerSocket(8188);
            while (true){
                Socket socket = serverSocket.accept(); //Ожидаем клиента
                System.out.println("Клиент подключился");
                User currentUser = new User(socket);
                users.add(currentUser);
                Thread thread = new Thread(new Runnable() { // Создаёи поток для подключившегося клиента
                    @Override
                    public void run() {
                        try {
                            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                            DataInputStream in = new DataInputStream(socket.getInputStream());
                            out.writeUTF("Введите имя:");
                            String userName = in.readUTF();
                            currentUser.setUserName(userName);
                            out.writeUTF(currentUser.getUserName()+" добро пожаловать на сервер!");
                            while (true){
                                System.out.println("Ожидаем сообщение от пользователя");
                                String request = in.readUTF(); // Ожидаем сообщение от клиента
                                System.out.println(currentUser.getUserName()+": "+request);
                                for (User user:users) {
                                    if(currentUser.equals(user)) continue;
                                    DataOutputStream userOut = new DataOutputStream(user.getSocket().getOutputStream());
                                    userOut.writeUTF(userName+": "+request);
                                }
                            }
                        } catch (IOException exception) {
                            users.remove(currentUser);
                            for (User user:users) {
                                try {
                                    DataOutputStream userOut = new DataOutputStream(user.getSocket().getOutputStream());
                                    userOut.writeUTF(currentUser.getUserName()+" покинул чат");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }
                });
                thread.start();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}


package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("45.80.70.161",8188);
            System.out.println("Подключился");
            DataInputStream  in =new DataInputStream(socket.getInputStream());
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            String response = in.readUTF(); // Ждём сообщение от сервера
            System.out.println("Ответ от сервера: "+response);
            Scanner scanner = new Scanner(System.in);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            String response = in.readUTF();
                            System.out.println(response);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            while(true){
                String request = scanner.nextLine(); // Читам пользовательский ввод
                out.writeUTF(request); // Отправляем на сервер текст с коносли
            }


        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}


package server;

        import java.net.Socket;
        import java.util.UUID;

public class User{
    private Socket socket;
    private String userName;
    private UUID uuid;

    public User(Socket socket) {
        this.socket = socket;
        this.userName = "Гость";
        this.uuid = UUID.randomUUID();
    }

    public void setUserName(String userName) { this.userName = userName; }
    public String getUserName() { return userName; }
    public Socket getSocket() { return socket; }
    public UUID getUuid() { return uuid; }
    public boolean equals(User user) {
        return (this.uuid.toString().equals(user.getUuid().toString()));
    }
}

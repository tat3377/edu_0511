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
    static Socket clientSocket; //сокет для общения
    static ServerSocket server; // серверсокет
    static BufferedReader in; // поток чтения из сокета
    static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket (4004); // серверсокет прослушивает порт 4004
                System.out.println ("Сервер запущен!"); // хорошо бы серверу
                //   объявить о своем запуске
                clientSocket = server.accept (); // accept() будет ждать пока
                //кто-нибудь не захочет подключиться
                try { // установив связь и воссоздав сокет для общения с клиентом можно перейти
                    // к созданию потоков ввода/вывода.
                    // теперь мы можем принимать сообщения
                    in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream ()));
                    // и отправлять
                    out = new BufferedWriter (new OutputStreamWriter (clientSocket.getOutputStream ()));

                    String word = in.readLine (); // ждём пока клиент что-нибудь нам напишет
                    System.out.println (word);
                    // не долго думая отвечает клиенту
                    out.write ("Привет, это Сервер! Подтверждаю, вы написали. что ваше имя: " + word + "\n");
                    out.flush (); // выталкиваем все из буфера

                } finally { // в любом случае сокет будет закрыт
                    clientSocket.close ();
                    // потоки тоже хорошо бы закрыть
                    in.close ();
                    out.close ();
                }
            } finally {
                System.out.println ("Сервер закрыт!");
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

         Socket clientSocket = null; //сокет для общения
        BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
        // мы узнаем что хочет сказать клиент?
       BufferedReader in; // поток чтения из сокета
       BufferedWriter out; // поток записи в сокет

        try {
            try {
                // адрес - локальный хост, порт - 4004, такой же как у сервера
                clientSocket = new Socket("localhost", 4004); // этой строкой мы запрашиваем
                //  у сервера доступ на соединение
                reader = new BufferedReader(new InputStreamReader(System.in));
                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать туда же
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Напишите своё имя. пожалуйста:");
                // если соединение произошло и потоки успешно созданы - мы можем
                //  работать дальше и предложить клиенту что то ввести
                // если нет - вылетит исключение
                String word = reader.readLine(); // ждём пока клиент что-нибудь
                // не напишет в консоль
                out.write(word + "\n"); // отправляем сообщение на сервер
                out.flush();
                String serverWord = in.readLine(); // ждём, что скажет сервер
                System.out.println(serverWord); // получив - выводим на экран
            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Клиент был закрыт...");
                clientSocket.close();

            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}

import java.io.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static AffableThread SecondThread;
    //2 способ

    public static void main(String[] args) throws FileNotFoundException {
        SecondThread = new AffableThread();
        SecondThread.start();

        System.out.println("Главный поток завершён...");
    }

    static class AffableThread extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("Привет из побочного потока!");
        }
    }
    public static class Program
    {
        static AffableThread SecondThread;

    }

}

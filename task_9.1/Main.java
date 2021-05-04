package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Клиент сетевого чата");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}




package sample;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Controller {
    Socket socket;
    DataOutputStream out;
    @FXML//анотация для работы кнопки
    TextArea text1;
    @FXML
    TextField text2;

    @FXML
    private void onSubmit(){
        String text = text2.getText ();
        text1.appendText (text+"\n");
        text2.clear ();
        try {
            out.writeUTF (text);
        } catch (IOException exception) {
            text1.appendText ("Произошла ошибка");
            exception.printStackTrace ();
        }
    }
    @FXML //подключение к серверу
    private void connect () {
        try {
            socket = new Socket ("45.80.70.161", 8188);
            DataInputStream in = new DataInputStream (socket.getInputStream ());
            out = new DataOutputStream (socket.getOutputStream ());
            String response = in.readUTF (); // Ждём сообщение от сервера
            text1.appendText (response + "\n");//приветственное слово от сервера

            Thread thread = new Thread (new Runnable () {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String response = in.readUTF ();//ждем сообщение от сервера
                            text1.appendText (response + "\n");
                        } catch (IOException exception) {
                            exception.printStackTrace ();
                        }
                    }
                }
            });
            thread.start ();

        } catch (IOException exception) {
            exception.printStackTrace ();
        }
    }


    }




<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="300.0" prefWidth="275.0" xmlns="http://javafx.com/javafx/11.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.Controller">
   <children>
      <Button onAction="#connect" prefHeight="40.0" prefWidth="Infinity" text="Подключиться">
         <VBox.margin>
            <Insets bottom="6.0" left="2.0" right="2.0" top="6.0" />
         </VBox.margin></Button>
      <TextArea fx:id="text1" editable="false" prefHeight="240.0" prefWidth="275.0">
         <VBox.margin>
            <Insets bottom="3.0" left="3.0" right="3.0" />
         </VBox.margin></TextArea>
      <HBox prefHeight="60.0" prefWidth="275.0">
         <children>
            <TextField fx:id="text2" onAction="#onSubmit" prefHeight="30.0" prefWidth="210.0">
               <HBox.margin>
                  <Insets bottom="6.0" left="3.0" right="3.0" top="3.0" />
               </HBox.margin></TextField>
            <Button maxHeight="30.0" mnemonicParsing="false" onAction="#onSubmit" text="Отправить">
               <HBox.margin>
                  <Insets bottom="6.0" left="3.0" right="3.0" top="3.0" />
               </HBox.margin></Button>
         </children></HBox>
   </children>
</VBox>

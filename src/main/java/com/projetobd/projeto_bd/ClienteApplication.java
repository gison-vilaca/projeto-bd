package com.projetobd.projeto_bd;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ClienteApplication extends Application{

    @Override
    public void start(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ClienteApplication.class.getResource("cliente-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 480, 420);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch();
    }
}

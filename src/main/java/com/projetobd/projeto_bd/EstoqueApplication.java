package com.projetobd.projeto_bd;


        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;

        import static javafx.application.Application.launch;

public class EstoqueApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EstoqueApplication.class.getResource("estoque-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 320);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}

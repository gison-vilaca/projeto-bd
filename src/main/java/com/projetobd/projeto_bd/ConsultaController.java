package com.projetobd.projeto_bd;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConsultaController {

    @FXML
    private Button realizar;
    @FXML
    private TextField txtComando ;
    @FXML
    private Label txtsaida;


    @FXML
    protected void onRealizarButtonClick() {

        String comando= txtComando.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Consulta realizada com sucesso!");
        alert.show();
    }
}

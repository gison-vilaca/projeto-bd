package com.projetobd.projeto_bd;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ArmazemController {

    @FXML
    private Button salvo;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEndereco;

    @FXML
    protected void onSalvarButtonClick(){

        String nome = txtNome.getText();
        String endereco = txtEndereco.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Armazem salvo com sucesso!");
        alert.show();
    }
}

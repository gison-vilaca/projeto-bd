package com.projetobd.projeto_bd;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CategoriaController {

    @FXML
    private Button salvo;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtDescricao;

    @FXML
    protected void onSalvarButtonClick() {

        String nome = txtNome.getText();
        String descricao = txtDescricao.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Categoria salva com sucesso!");
        alert.show();
    }
}

package com.projetobd.projeto_bd;

import Models.Armazem;
import Models.DAO.ArmazemDAO;
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

        Armazem armazem = new Armazem();
        armazem.setNome(nome);
        armazem.setEndereco(endereco);

        try {
            ArmazemDAO armazemDAO = new ArmazemDAO();
            armazemDAO.create(armazem);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Armazem salvo com sucesso!");
        alert.show();
    }
}

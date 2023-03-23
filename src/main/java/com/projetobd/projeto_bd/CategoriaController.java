package com.projetobd.projeto_bd;

import Models.Categoria;
import Models.DAO.CategoriaDAO;
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

    CategoriaDAO categoriaDAO  = new CategoriaDAO();
    @FXML
    protected void onSalvarButtonClick() {

        try {
            String nome = txtNome.getText();
            String descricao = txtDescricao.getText();

            Categoria categoria = new Categoria();
            categoria.setNome(nome);
            categoria.setDescricao(descricao);

            categoriaDAO.create(categoria);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Categoria salva com sucesso!");
            alert.show();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onDeleteButtonClick(){
        try{

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

package com.projetobd.projeto_bd;

import Models.DAO.EstoqueDAO;
import Models.Estoque;
import com.projetobd.projeto_bd.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EstoqueController implements Initializable {

    @FXML
    private Button salvo;
    @FXML
    private TextField txtCodigoEstoque;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private TextField txtIdProduto;
    @FXML
    private TextField txtIdArmazem;

    @FXML
    protected void onSalvarButtonClick() {
        try {
            String codigo = txtCodigoEstoque.getText();
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            int idProduto = Integer.parseInt(txtIdProduto.getText());
            int idArmazem = Integer.parseInt(txtIdArmazem.getText());

            Estoque estoque = new Estoque();
            estoque.setCod_estoque(codigo);
            estoque.setQuantidade(quantidade);
            estoque.setId_produto(idProduto);
            estoque.setId_armazem(idArmazem);

            try {
                EstoqueDAO estoqueDAO = new EstoqueDAO();
                estoqueDAO.create(estoque);
            }catch (Exception e){
                throw new RuntimeException(e);
            }


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Estoque cadastrado com sucesso!");
            alert.show();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType. ERROR, "Digite um numero  valido!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldInteger(txtQuantidade); //para aceitar apenas inteiros no campo
        Constraints.setTextFieldInteger(txtIdProduto); //para aceitar apenas inteiros no campo
        Constraints.setTextFieldInteger(txtIdArmazem);
    }

}

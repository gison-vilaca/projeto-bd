package com.projetobd.projeto_bd;

import com.projetobd.projeto_bd.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Pedido_produtoController implements Initializable {

    @FXML
    private Button salvo;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private TextField txtIdProduto;
    @FXML
    private TextField txtPrecoProduto;

    @FXML
    protected void onSalvarButtonClick(){

        try {
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            int idProduto = Integer.parseInt(txtIdProduto.getText());
            float precoProduto = Float.parseFloat(txtPrecoProduto.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Pedido de produto salvo com sucesso!");
            alert.show();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType. ERROR, "Digite um valor valido!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldInteger(txtQuantidade); //para aceitar apenas inteiros no campo de id
        Constraints.setTextFieldInteger(txtIdProduto); //para aceitar apenas inteiros no campo
        Constraints.setTextFieldDouble(txtPrecoProduto);
    }
}

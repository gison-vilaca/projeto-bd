package com.projetobd.projeto_bd;

import Models.DAO.Pedido_ProdutoDAO;
import Models.Pedido_Produto;
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
    private TextField txtIdPedido;

    @FXML
    protected void onSalvarButtonClick(){

        try {
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            int idProduto = Integer.parseInt(txtIdProduto.getText());
            float precoProduto = Float.parseFloat(txtPrecoProduto.getText());
            int id_pedido = Integer.parseInt(txtIdPedido.getText());

            Pedido_Produto pedido_produto = new Pedido_Produto();
            pedido_produto.setId_produto(idProduto);
            pedido_produto.setPreco_produto(precoProduto);
            pedido_produto.setId_pedido(id_pedido);
            pedido_produto.setQuantidade(quantidade);

            try {
                Pedido_ProdutoDAO pedidoProdutoDAO = new Pedido_ProdutoDAO();
                pedidoProdutoDAO.create(pedido_produto);
            }catch (Exception e){
                throw new RuntimeException(e);
            }

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

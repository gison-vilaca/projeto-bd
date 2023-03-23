package com.projetobd.projeto_bd;

import com.projetobd.projeto_bd.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ProdutoController implements Initializable {
    @FXML
    private Button salvo;
    @FXML
    private TextField txtPrecoCusto;
    @FXML
    private TextField txtPrecoVenda;
    @FXML
    private TextField txtPrecoVendaMinima;
    @FXML
    private DatePicker datePickerGarantia;
    @FXML
    private TextField txtIdFornecedor;
    @FXML
    private TextField txtProdutoDescricao;
    @FXML
    private TextField txtValorStatus;
    @FXML
    private TextField txtIdCategoria;
    @FXML
    private TextField txtProdutoNome;
    @FXML
    private TextField txtDescricaoProduto;

    @FXML
    protected void onSalvarButtonClick() {
        try {
            float precoCusto = Float.parseFloat(txtPrecoCusto.getText());
            float precoVendaMinima = Float.parseFloat(txtPrecoVendaMinima.getText());
            float precoVenda = Float.parseFloat(txtPrecoVenda.getText());
            float valorStatus = Float.parseFloat(txtValorStatus.getText());
            LocalDate dataGarantia = datePickerGarantia.getValue();
            int idFornecedor = Integer.parseInt(txtIdFornecedor.getText());
            int idCategoria = Integer.parseInt(txtIdCategoria.getText());
            String nomeProduto = txtProdutoNome.getText();
            String descricaoProduto = txtDescricaoProduto.getText();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Produto cadastrado com sucesso!");
            alert.show();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType. ERROR, "Digite um valor valido!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldInteger(txtIdCategoria); //para aceitar apenas inteiros no campo de id
        Constraints.setTextFieldInteger(txtIdFornecedor); //para aceitar apenas inteiros no campo de id
        Constraints.setTextFieldDouble(txtValorStatus); //para garantir que o numero sera de ponto flutuante e '.'
        Constraints.setTextFieldDouble(txtPrecoCusto);
        Constraints.setTextFieldDouble(txtPrecoVenda);
        Constraints.setTextFieldDouble(txtPrecoVendaMinima);
    }
}

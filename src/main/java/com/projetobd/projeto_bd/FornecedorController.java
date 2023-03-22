package com.projetobd.projeto_bd;

import com.projetobd.projeto_bd.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FornecedorController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtLocalidade;
    @FXML
    private TextField txtTipoFornecedor;
    @FXML
    private TextField txtCpfCnpj;

    @FXML
    protected void onSalvarButtonClick(){

        String nome = txtNome.getText();
        String localidade = txtLocalidade.getText();
        String tipoFornecedor = txtTipoFornecedor.getText();
        String cpfCnpj = txtCpfCnpj.getText();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Fornecedor salvo com sucesso!");
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldInteger(txtCpfCnpj); //para aceitar apenas inteiros no campo de cpf
        Constraints.setTextFieldMaxLength(txtCpfCnpj,14); // para garantir que o cpf/cnpj tenha apenas 14 digitos
    }

}

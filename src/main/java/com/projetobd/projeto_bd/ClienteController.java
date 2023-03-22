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

public class ClienteController implements Initializable {

    @FXML
    private Button salvo;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtPais;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtLimiteCredito;
    @FXML
    private DatePicker datePickerCadastro;


    @FXML
    protected void onSalvarButtonClick() {
        try {
            String nome = txtNome.getText();
            int telefone = Integer.parseInt(txtTelefone.getText());
            String cidade = txtCidade.getText();
            String estado = txtEstado.getText();
            String pais = txtPais.getText();
            String email = txtEmail.getText();
            double limiteCredito = Double.parseDouble(txtLimiteCredito.getText());
            LocalDate data = datePickerCadastro.getValue();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cliente salvo!");
            alert.show();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType. ERROR, "Digite um numero de telefone inteiro e valido!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldInteger(txtTelefone); //para aceitar apenas inteiros no campo de telefone
        Constraints.setTextFieldMaxLength(txtTelefone,9); // para garantir que o numero de telefone tenha apenas 9 digitos
        Constraints.setTextFieldDouble(txtLimiteCredito); //para garantir que o numero sera de ponto flutuante e '.'
    }
}

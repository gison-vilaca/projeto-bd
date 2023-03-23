package com.projetobd.projeto_bd;

import Models.Cliente;
import Models.DAO.ClienteDAO;
import com.projetobd.projeto_bd.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
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

    ClienteDAO clienteDAO = null;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }

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
            Date data = Date.valueOf(datePickerCadastro.getValue());

            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);
            cliente.setPais(pais);
            cliente.setLimite_credito(limiteCredito);
            cliente.setData_cadastro(data);

            clienteDAO.create(cliente);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cliente salvo!");
            alert.show();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType. ERROR, "Digite um numero de telefone inteiro e valido!");
            alert.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldInteger(txtTelefone); //para aceitar apenas inteiros no campo de telefone
        Constraints.setTextFieldMaxLength(txtTelefone,9); // para garantir que o numero de telefone tenha apenas 9 digitos
        Constraints.setTextFieldDouble(txtLimiteCredito); //para garantir que o numero sera de ponto flutuante e '.'
    }
}

package com.projetobd.projeto_bd;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class PedidoController {

    @FXML
    private Button salvo;
    @FXML
    private DatePicker datePickerdataPedido;
    @FXML
    private TextField txtModoEncomenda;
    @FXML
    private TextField txtClientePedido;
    @FXML
    private TextField txtStatusPedido;
    @FXML
    private DatePicker datePickerdataEntegra;
    @FXML
    private TextField txtIdCliente;

    @FXML
    protected void onSalvarButtonClick() {
        try {
            LocalDate dataPedido = datePickerdataPedido.getValue();
            String modoEncomenda = txtModoEncomenda.getText();
            String clientePedido = txtClientePedido.getText();
            String statusPedido= txtStatusPedido.getText();
            LocalDate dataEntrega = datePickerdataEntegra.getValue();
            int idCliente = Integer.parseInt(txtIdCliente.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Pedido cadastrado com sucesso!");
            alert.show();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType. ERROR, "Digite um numero valido!");
            alert.show();
        }
    }


}

package com.projetobd.projeto_bd;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClienteController {

    @FXML
    private Label salvo;

    @FXML
    protected void onSalvarButtonClick() {
        salvo.setText("Cliente Salvo!");
    }
}

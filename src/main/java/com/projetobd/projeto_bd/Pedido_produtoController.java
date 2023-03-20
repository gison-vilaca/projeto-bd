package com.projetobd.projeto_bd;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Pedido_produtoController {

    @FXML
    private final Label welcomeText;

    public Pedido_produtoController(Label welcomeText) {
        this.welcomeText = welcomeText;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application! ");
    }
}

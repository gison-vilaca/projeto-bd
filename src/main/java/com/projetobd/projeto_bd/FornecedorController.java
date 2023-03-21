package com.projetobd.projeto_bd;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FornecedorController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application! ");
    }
}

package com.projetobd.projeto_bd;

import Models.Consulta;
import Models.DAO.consultaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class ConsultaController {

    @FXML
    private Button realizar;
    @FXML
    private TextArea txtconsulta ;
    @FXML
    private Label txtsaida;


    @FXML
    protected void onRealizarButtonClick() {

        try {
            String comando = txtconsulta.getText();

            Consulta consulta = new Consulta(comando);

            consultaDAO consultaDAO = new consultaDAO();

            ArrayList<String> res = consultaDAO.resultado(consulta);

            txtsaida.setText(formatarString(res));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Consulta realizada com sucesso!");
            alert.show();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Verifique sua consulta");
            alert.show();
        }
    }

    public String formatarString(ArrayList<String> res){
        return res.toString();
    }
}

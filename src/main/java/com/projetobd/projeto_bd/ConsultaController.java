package com.projetobd.projeto_bd;

import Models.Consulta;
import Models.DAO.consultaDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.ArrayList;

public class ConsultaController {

    @FXML
    private Button realizar;
    @FXML
    private TextArea txtconsulta ;
    @FXML
    private TableView txtsaida;
    public VBox saida;


    @FXML
    protected void onRealizarButtonClick() {

        try {
            String comando = txtconsulta.getText();

            Consulta consulta = new Consulta(comando);

            consultaDAO consultaDAO = new consultaDAO();

            ArrayList<String> res = consultaDAO.resultado(consulta);
            saida.getChildren().clear();
            saida.getChildren().addAll(formatarString(res));

            //txtsaida.setItems(formatarString(res));
            //txtsaida.refresh();
                    //setText(formatarString(res));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Consulta realizada com sucesso!");
            alert.show();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Verifique sua consulta");
            alert.show();
        }
    }

    public TableView formatarString(ArrayList<String> res){
        String saida="";
        for(String coluna : res) {
            saida+= coluna + '\n';
        }
        //String dados = saida;

        TableView tabela = new TableView();

// Separar os dados da String por linhas
        String[] linhas = saida.split("\n");

// Criar as colunas
        String[] titulos = linhas[0].split(";");
        for (int i = 0; i < titulos.length; i++) {
            final int indice = i;
            TableColumn coluna = new TableColumn(titulos[i]);
            coluna.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[indice]));
                }
            });
            tabela.getColumns().add(coluna);
        }

// Adicionar os dados
        ObservableList<String[]> listaDados = FXCollections.observableArrayList();
        for (int i = 1; i < linhas.length; i++) {
            String[] campos = linhas[i].split(";");
            listaDados.add(campos);
        }
        tabela.setItems(listaDados);


// Adicionar a tabela a um container

        return tabela;
    }
}

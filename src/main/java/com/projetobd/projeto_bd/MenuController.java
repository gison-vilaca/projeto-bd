package com.projetobd.projeto_bd;

import Models.Categoria;
import com.projetobd.projeto_bd.MenuApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController extends Stage {

    @FXML
    private Button btCliente;
    @FXML
    private Button btProduto;
    @FXML
    private Button btEstoque;
    @FXML
    private Button btCategoria;
    @FXML
    private Button btPedido;
    @FXML
    private Button btArmazem;
    @FXML
    private Button btFornecedor;
    @FXML
    private Button btConsulta;


    Stage stage = new Stage();
    @FXML
    protected void onCLickAbrirCliente(){

        ClienteApplication clienteApplication = new ClienteApplication();
        clienteApplication.start(stage);
    }

    @FXML
    protected void onCLickAbrirProduto() throws IOException {
        ProdutoApplication produtoApplication = new ProdutoApplication();
        produtoApplication.start(stage);
    }

    @FXML
    protected void onCLickAbrirEstoque() throws IOException {
        EstoqueApplication estoqueApplication = new EstoqueApplication();
        estoqueApplication.start(stage);
    }

    @FXML
    protected void onCLickAbrirCategoria() throws IOException {
        CategoriaApplication categoriaApplication = new CategoriaApplication();
        categoriaApplication.start(stage);
    }
    @FXML
    protected void onCLickAbrirPedido() throws IOException {
        PedidoApplication pedidoApplication = new PedidoApplication();
        pedidoApplication.start(stage);
    }
    @FXML
    protected void onCLickAbrirArmazem() throws IOException {
        ArmazemApplication armazemApplication = new ArmazemApplication();
        armazemApplication.start(stage);
    }
    @FXML
    protected void onCLickAbrirFornecedor() throws IOException {
        FornecedorApplication fornecedorApplication = new FornecedorApplication();
        fornecedorApplication.start(stage);
    }
    @FXML
    protected void onCLickAbrirConsulta() throws IOException {
        ConsultaApplication consultaApplication = new ConsultaApplication();
        consultaApplication.start(stage);
    }


}

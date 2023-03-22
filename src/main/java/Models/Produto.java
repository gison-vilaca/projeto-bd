package Models;

import java.util.ArrayList;
import java.util.Date;

public class Produto {


    private int id_produto;
    private float preco_custo;
    private float preco_venda;
    private float preco_venda_minimo;
    private Date data_garantia;
    private float valor_status;
    private int id_fornecedor;
    private int id_categoria;
    private ArrayList<String> produto_descricao;
    private ArrayList<String> produto_nome;


    public Produto( float preco_custo, float preco_venda, float preco_venda_minimo, Date data_garantia,
                   float valor_status, int id_fornecedor, int id_categoria,
                   ArrayList<String> produto_descricao, ArrayList<String> produto_nome) {

        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.preco_venda_minimo = preco_venda_minimo;
        this.data_garantia = data_garantia;
        this.valor_status = valor_status;
        this.id_fornecedor = id_fornecedor;
        this.id_categoria = id_categoria;
        this.produto_descricao = produto_descricao;
        this.produto_nome = produto_nome;
    }

    public Produto() {
    }

    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    public float getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(float preco_custo) {
        this.preco_custo = preco_custo;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public float getPreco_venda_minimo() {
        return preco_venda_minimo;
    }

    public void setPreco_venda_minimo(float preco_venda_minimo) {
        this.preco_venda_minimo = preco_venda_minimo;
    }

    public Date getData_garantia() {
        return data_garantia;
    }

    public void setData_garantia(Date data_garantia) {
        this.data_garantia = data_garantia;
    }

    public float getValor_status() {
        return valor_status;
    }

    public void setValor_status(float valor_status) {
        this.valor_status = valor_status;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public ArrayList<String> getProduto_descricao() {
        return produto_descricao;
    }

    public void setProduto_descricao(ArrayList<String> produto_descricao) {
        this.produto_descricao = produto_descricao;
    }

    public ArrayList<String> getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(ArrayList<String> produto_nome) {
        this.produto_nome = produto_nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id_produto=" + id_produto +
                ", preco_custo=" + preco_custo +
                ", preco_venda=" + preco_venda +
                ", preco_venda_minimo=" + preco_venda_minimo +
                ", data_garantia=" + data_garantia +
                ", valor_status=" + valor_status +
                ", id_fornecedor=" + id_fornecedor +
                ", id_categoria=" + id_categoria +
                ", produto_descricao=" + produto_descricao +
                ", produto_nome=" + produto_nome +
                '}';
    }
}

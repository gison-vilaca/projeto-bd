package Models;

public class Pedido_Produto {



    private int id_pedido;
    private int quantidade;
    private int id_produto;
    private float preco_produto;

    public Pedido_Produto(int quantidade, int id_produto, int preco_produto) {
        this.quantidade = quantidade;
        this.id_produto = id_produto;
        this.preco_produto = preco_produto;
    }

    public Pedido_Produto() {
    }

    public int getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public float getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(float preco_produto) {
        this.preco_produto = preco_produto;
    }

    @Override
    public String toString() {
        return "Pedido_Produto{" +
                "id_pedido=" + id_pedido +
                ", quantidade=" + quantidade +
                ", id_produto=" + id_produto +
                ", preco_produto=" + preco_produto +
                '}';
    }
}

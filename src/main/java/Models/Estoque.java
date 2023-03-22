package Models;

public class Estoque {



    private int id_estoque;
    private String cod_estoque;
    private int quantidade;
    private int id_produto;
    private int id_armazem;

    public Estoque(String cod_estoque, int quantidade, int id_produto, int id_armazem) {
        this.cod_estoque = cod_estoque;
        this.quantidade = quantidade;
        this.id_produto = id_produto;
        this.id_armazem = id_armazem;
    }

    public Estoque() {
    }

    public int getId_estoque() {
        return id_estoque;
    }
    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }
    public String getCod_estoque() {
        return cod_estoque;
    }

    public void setCod_estoque(String cod_estoque) {
        this.cod_estoque = cod_estoque;
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

    public int getId_armazem() {
        return id_armazem;
    }

    public void setId_armazem(int id_armazem) {
        this.id_armazem = id_armazem;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id_estoque=" + id_estoque +
                ", cod_estoque=" + cod_estoque +
                ", quantidade=" + quantidade +
                ", id_produto=" + id_produto +
                ", id_armazem=" + id_armazem +
                '}';
    }
}

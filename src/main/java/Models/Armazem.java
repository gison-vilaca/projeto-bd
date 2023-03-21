package Models;

public class Armazem {

    private int id_armazem;
    private String nome;

    private String endereco;

    public Armazem( String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Armazem() {
    }

    public int getId_armazem() {
        return id_armazem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Armazem{" +
                "id_armazem=" + id_armazem +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}

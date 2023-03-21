package Models;

public class Fornecedor {

    private int id_fornecedor;
    private String nome;
    private String localidade;
    private String tipo_fornecedor;
    private String cpf_cnpj;

    public Fornecedor(String nome, String localidade, String tipo_fornecedor, String cpf_cnpj) {
        this.nome = nome;
        this.localidade = localidade;
        this.tipo_fornecedor = tipo_fornecedor;
        this.cpf_cnpj = cpf_cnpj;
    }

    public Fornecedor() {
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getTipo_fornecedor() {
        return tipo_fornecedor;
    }

    public void setTipo_fornecedor(String tipo_fornecedor) {
        this.tipo_fornecedor = tipo_fornecedor;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id_fornecedor=" + id_fornecedor +
                ", nome='" + nome + '\'' +
                ", localidade='" + localidade + '\'' +
                ", tipo_fornecedor='" + tipo_fornecedor + '\'' +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                '}';
    }
}

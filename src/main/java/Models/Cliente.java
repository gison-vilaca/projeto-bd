package Models;

import java.util.Date;

public class Cliente {
    private int id_cliente;
    private String nome;
    private String pais;
    private String estado;
    private String cidade;
    private double limite_credito;
    private Date data_cadastro;

    public Cliente(String nome, String pais, String estado, String cidade, double limite_credito) {
        this.nome = nome;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.limite_credito = limite_credito;
        this.data_cadastro = new Date();
    }

    public Cliente(){

    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(double limite_credito) {
        this.limite_credito = limite_credito;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nome='" + nome + '\'' +
                ", pais='" + pais + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", limite_credito=" + limite_credito +
                ", data_cadastro=" + data_cadastro +
                '}';
    }
}

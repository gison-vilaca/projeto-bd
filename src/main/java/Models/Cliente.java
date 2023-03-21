package Models;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {


    private int id_cliente;
    private String nome;
    private String pais;
    private String estado;
    private String cidade;
    private double limite_credito;
    private Date data_cadastro;
    private ArrayList<String> emails;
    private ArrayList<String> telefones;

    public Cliente(String nome, String pais, String estado, String cidade, double limite_credito,
                   String email,String telefone) {

        this.emails = new ArrayList<>();
        this.telefones = new ArrayList<>();

        this.nome = nome;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.limite_credito = limite_credito;
        this.data_cadastro = new Date();
        this.emails.add(email);
        this.telefones.add(telefone);

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

    public ArrayList<String> getEmails() {
        return emails;
    }

    public ArrayList<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<String> telefones) {
        this.telefones = telefones;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
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
                ", email=" + emails +
                ", telefone=" + telefones+
                '}';
    }
}

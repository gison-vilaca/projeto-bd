package Models;

import java.util.Date;

public class Pedido {
    private int id_pedido;
    private Date data_pedido;
    private String modo_encomenda;
    private String cliente_pedido;
    private String status_pedido;
    private Date data_entrega;
    private int id_cliente;

    public Pedido(int id_pedido, Date data_pedido, String modo_encomenda, String cliente_pedido,
                  String status_pedido, Date data_entrega, int id_cliente) {
        this.id_pedido = id_pedido;
        this.data_pedido = data_pedido;
        this.modo_encomenda = modo_encomenda;
        this.cliente_pedido = cliente_pedido;
        this.status_pedido = status_pedido;
        this.data_entrega = data_entrega;
        this.id_cliente = id_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getModo_encomenda() {
        return modo_encomenda;
    }

    public void setModo_encomenda(String modo_encomenda) {
        this.modo_encomenda = modo_encomenda;
    }

    public String getCliente_pedido() {
        return cliente_pedido;
    }

    public void setCliente_pedido(String cliente_pedido) {
        this.cliente_pedido = cliente_pedido;
    }

    public String getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(String status_pedido) {
        this.status_pedido = status_pedido;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", data_pedido=" + data_pedido +
                ", modo_encomenda='" + modo_encomenda + '\'' +
                ", cliente_pedido='" + cliente_pedido + '\'' +
                ", status_pedido='" + status_pedido + '\'' +
                ", data_entrega=" + data_entrega +
                ", id_cliente=" + id_cliente +
                '}';
    }
}

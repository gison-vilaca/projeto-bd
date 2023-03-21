package Models.DAO;

import Models.Pedido;

import java.util.List;

public class PedidoDAO implements inteface<Pedido>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Pedido object) {

    }

    @Override
    public Pedido read(int id) {
        return null;
    }

    @Override
    public void update(Pedido object) {

    }

    @Override
    public void delete(Pedido object) {

    }

    @Override
    public List<Pedido> all() throws Exception {
        return null;
    }
}

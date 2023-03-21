package Models.DAO;

import Models.Pedido_Produto;

import java.util.List;

public class Pedido_ProdutoDAO implements inteface<Pedido_Produto>{
    DAO dao = DAO.getInstance();
    @Override
    public void create(Pedido_Produto object) {

    }

    @Override
    public Pedido_Produto read(int id) {
        return null;
    }

    @Override
    public void update(Pedido_Produto object) {

    }

    @Override
    public void delete(Pedido_Produto object) {

    }

    @Override
    public List<Pedido_Produto> all() throws Exception {
        return null;
    }
}

package Models.DAO;

import Models.Produto;

import java.util.List;

public class ProdutoDAO implements inteface<Produto>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Produto object) {

    }

    @Override
    public Produto read(int id) {
        return null;
    }

    @Override
    public void update(Produto object) {

    }

    @Override
    public void delete(Produto object) {

    }

    @Override
    public List<Produto> all() throws Exception {
        return null;
    }
}

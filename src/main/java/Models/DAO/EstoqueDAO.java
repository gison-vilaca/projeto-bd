package Models.DAO;

import Models.Estoque;

import java.util.List;

public class EstoqueDAO implements inteface<Estoque>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Estoque object) {

    }

    @Override
    public Estoque read(int id) {
        return null;
    }

    @Override
    public void update(Estoque object) {

    }

    @Override
    public void delete(Estoque object) {

    }

    @Override
    public List<Estoque> all() throws Exception {
        return null;
    }
}

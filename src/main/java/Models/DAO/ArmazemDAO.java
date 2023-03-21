package Models.DAO;

import Models.Armazem;

import java.util.List;

public class ArmazemDAO implements inteface<Armazem>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Armazem object) {

    }

    @Override
    public Armazem read(int id) {
        return null;
    }

    @Override
    public void update(Armazem object) {

    }

    @Override
    public void delete(Armazem object) {

    }

    @Override
    public List<Armazem> all() throws Exception {
        return null;
    }
}

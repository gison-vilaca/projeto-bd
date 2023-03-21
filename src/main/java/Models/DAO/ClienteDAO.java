package Models.DAO;

import Models.Cliente;

import java.util.List;

public class ClienteDAO implements inteface<Cliente>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Cliente object) {

    }

    @Override
    public Cliente read(int id) {
        return null;
    }

    @Override
    public void update(Cliente object) {

    }

    @Override
    public void delete(Cliente object) {

    }

    @Override
    public List<Cliente> all() throws Exception {
        return null;
    }
}

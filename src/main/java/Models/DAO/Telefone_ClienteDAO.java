package Models.DAO;

import Models.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Telefone_ClienteDAO {
    DAO dao = DAO.getInstance();

    public Telefone_ClienteDAO() {
    }

    public void create(Cliente cliente, int id) throws Exception {
        List<String> telefones = cliente.getTelefones();
        for(int i = 0; i < telefones.size(); i++){
            try {
                String sql = "INSERT INTO TELEFONE_CLIENTE(ID_CLIENTE,TELEFONE)" + "VALUES(?,?)";
                PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.setString(2, telefones.get(i));

                // Executa a instrução INSERT
                int linhasAfetadas = stmt.executeUpdate();

                System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);
            }catch (SQLException e){
                throw new SQLException("erro ao inserir telefone!");
            }
        }
    }

    public ArrayList<String> read(int id_cliente) throws Exception {
        ResultSet rs = null;
        ArrayList<String> telefones = new ArrayList<>();

        try {
            String sql = "SELECT * FROM TELEFONE_CLIENTE WHERE ID_CLIENTE = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id_cliente);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                String telefone = rs.getString("telefones");
                telefones.add(telefone);
            }

            return telefones;

        }catch (SQLException e){
            throw new Exception("Erro read telefones!");
        }
    }

    public void update(Cliente cliente, int id) throws Exception {
        //uma primary key não pode ser alterada e telefone é primary key
    }

    public List<String> all() throws Exception {
        ResultSet rs = null;
        List<String> todos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM telefone_cliente";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                String telefone = rs.getString("telefone");

                todos.add(telefone);
            }
        }catch (Exception e){
            throw new Exception("Erro all telefone!");
        }
        return todos;
    }
}

package Models.DAO;

import Models.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Email_clienteDAO{
    DAO dao = DAO.getInstance();
    public Email_clienteDAO() {
    }

    public void create(Cliente cliente, int id) throws Exception {
        List<String> emails = cliente.getEmails();
        for(int i = 0; i < emails.size(); i++){
            try {
                String sql = "INSERT INTO EMAIL_CLIENTE(ID_CLIENTE,EMAIL)" + "VALUES(?,?)";
                PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.setString(2, emails.get(i));

                // Executa a instrução INSERT
                int linhasAfetadas = stmt.executeUpdate();

                System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);
            }catch (SQLException e){
                throw new SQLException("erro ao inserir emails");
            }
        }
    }

    public ArrayList<String> read(int id) throws Exception {
        ResultSet rs = null;
        ArrayList<String> emails = new ArrayList<>();

        try {
            String sql = "SELECT * FROM EMAIL_CLIENTE WHERE ID_CLIENTE = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                String email = rs.getString("Nome");
                emails.add(email);
            }

            return emails;
        }catch (SQLException e){
            throw new Exception("Erro read emails!");
        }
    }

    public void update(Cliente cliente, int id) throws Exception {

    }

    public void delete(Cliente cliente, int id) throws Exception {

    }

    public List<String> all() throws Exception {
        return null;
    }
}

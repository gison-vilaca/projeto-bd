package Models.DAO;

import Models.Categoria;
import Models.Cliente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements inteface<Cliente>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Cliente cliente) throws Exception {
        ResultSet rs = null;
        int id_cliente = 0;
        try{
            String sql = "INSERT INTO CLIENTE (NOME,PAIS,ESTADO,CIDADE,LIMITE_CREDITO,DATA_CADASTRO) "+"VALUES(?,?,?,?,?,?)";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getPais());
            stmt.setString(3,cliente.getEstado());
            stmt.setString(4,cliente.getCidade());
            stmt.setDouble(5,cliente.getLimite_credito());
            stmt.setDate(6, (Date) cliente.getData_cadastro());

            // Executa a instrução INSERT
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);

            if (linhasAfetadas > 0){
                //bucar o utimo cliente inserido
                String busca = "SELECT TOP 1 * FROM Cliente ORDER BY id_cliente DESC";
                PreparedStatement res = dao.getConnection().prepareStatement(sql);
                // Executa a consulta SELECT
                rs = stmt.executeQuery();

                while (rs.next()) {
                   id_cliente = rs.getInt("ID_CLIENTE");
                }
                inseriremails(cliente, id_cliente);
                inserirTelefones(cliente, id_cliente);
                System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);
            }

        } catch (SQLException e){
            throw new Exception("");
        }
    }

    public void inseriremails(Cliente cliente, int id_cliente) throws SQLException {
        List<String> emails = cliente.getEmails();
        for(int i = 0; i < emails.size(); i++){
            try {
                String sql = "INSERT INTO EMAIL_CLIENTE(ID_CLIENTE,EMAIL)" + "VALUES(?,?)";
                PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

                stmt.setInt(1, id_cliente);
                stmt.setString(2, emails.get(i));

                // Executa a instrução INSERT
                int linhasAfetadas = stmt.executeUpdate();

                System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);
            }catch (SQLException e){
                throw new SQLException("erro ao inserir emails");
            }
        }
    }
    public  void inserirTelefones(Cliente cliente, int id_cliente) throws SQLException {
        List<String> telefones = cliente.getTelefones();
        for(int i = 0; i < telefones.size(); i++){
            try {
                String sql = "INSERT INTO TELEFONE_CLIENTE(ID_CLIENTE,TELEFONE)" + "VALUES(?,?)";
                PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

                stmt.setInt(1, id_cliente);
                stmt.setString(2, telefones.get(i));

                // Executa a instrução INSERT
                int linhasAfetadas = stmt.executeUpdate();

                System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);
            }catch (SQLException e){
                throw new SQLException("erro ao inserir telefone!");
            }
        }
    }

    @Override
    public Cliente read(int id) throws Exception{
        ResultSet rs = null;
        Cliente cliente = null;

        try{
            String sql = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_cliente = rs.getInt("ID_CLIENTE");
                String nome = rs.getString("Nome");
                String pais = rs.getString("Pais");
                String estado = rs.getString("Estado");
                String cidade = rs.getString("Cidade");
                double limite_credito = rs.getDouble("Limite_credito");
                Date data_cadastro = rs.getDate("data_cadastro");

                cliente = new Cliente();
                cliente.setId_cliente(id_cliente);
                cliente.setNome(nome);
                cliente.setPais(pais);
                cliente.setEstado(estado);
                cliente.setCidade(cidade);
                cliente.setLimite_credito(limite_credito);
                cliente.setData_cadastro(data_cadastro);
            }

            cliente.setEmails(readEmailsCliente(id));
            cliente.setTelefones(readTelefonesCliente(id));

            return cliente;

        } catch (SQLException e){
            throw new Exception("Erro read Cliente!");
        }
    }

    public ArrayList<String> readEmailsCliente(int id_cliente) throws Exception {
        ResultSet rs = null;
        ArrayList<String> emails = new ArrayList<>();

        try {
            String sql = "SELECT * FROM EMAIL_CLIENTE WHERE ID_CLIENTE = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id_cliente);

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

    public ArrayList readTelefonesCliente(int id_cliente) throws Exception {
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

    @Override
    public void update(Cliente cliente) throws Exception {
        try{
            String sql = "UPDATE CLIENTE SET nome = ?, descricao = ? WHERE id_categoria = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getPais());
            stmt.setString(3,cliente.getEstado());

            // Executa a instrução UPDATE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("");
        }
    }

    @Override
    public void delete(Cliente object) {

    }

    @Override
    public List<Cliente> all() throws Exception {
        return null;
    }
}

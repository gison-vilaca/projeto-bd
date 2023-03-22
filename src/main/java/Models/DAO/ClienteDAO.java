package Models.DAO;

import Models.Armazem;
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
                rs = res.executeQuery();

                while (rs.next()) {
                   id_cliente = rs.getInt("ID_CLIENTE");
                }

                Email_clienteDAO emailCliente = new Email_clienteDAO();
                emailCliente.create(cliente, id_cliente);
                Telefone_ClienteDAO telefoneCliente = new Telefone_ClienteDAO();
                telefoneCliente.create(cliente, id_cliente);

                System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);
            }

        } catch (SQLException e){
            throw new Exception("Erro ao inserir cliente!");
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
            Email_clienteDAO emailCliente = new Email_clienteDAO();
            Telefone_ClienteDAO telefoneCliente = new Telefone_ClienteDAO();
            cliente.setEmails(emailCliente.read(id));
            cliente.setTelefones(telefoneCliente.read(id));

            return cliente;

        } catch (SQLException e){
            throw new Exception("Erro read Cliente!");
        }
    }


    @Override
    public void update(Cliente cliente) throws Exception {
        try{
            String sql = "UPDATE CLIENTE SET nome = ?, pais = ?, estado = ?, cidade = ?, limite_credito = ? WHERE id_cliente = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getPais());
            stmt.setString(3,cliente.getEstado());
            stmt.setString(4,cliente.getCidade());
            stmt.setDouble(5,cliente.getLimite_credito());

            // Executa a instrução UPDATE
            int linhasAfetadas = stmt.executeUpdate();


            System.out.println("Dados atualizados com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro update cliente!");
        }
    }

    @Override
    public void delete(Cliente cliente) throws Exception {
        try {
            String sql = "DELETE FROM CLIENTE WHERE id_cliente = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1, cliente.getId_cliente());

            // Executa a instrução DELETE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados deletados com sucesso! Linhas afetadas: " + linhasAfetadas);
        }catch (Exception e){
            throw new Exception("Erro deletar cliente!");
        }
    }

    @Override
    public List<Cliente> all() throws Exception {
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> todos = new ArrayList<>();

        try{
            String sql = "SELECT * FROM CLIENTE";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_cliente = rs.getInt("ID_CLIENTE");
                String nome = rs.getString("Nome");
                String pais = rs.getString("pais");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                double limite_credito = rs.getDouble("limite_credito");
                Date data_cadastro = rs.getDate("data_cadastro");

                cliente = new Cliente();
                cliente.setId_cliente(id_cliente);
                cliente.setNome(nome);
                cliente.setPais(pais);
                cliente.setEstado(estado);
                cliente.setCidade(cidade);
                cliente.setLimite_credito(limite_credito);
                cliente.setData_cadastro(data_cadastro);

                todos.add(cliente);
            }

            return todos;

        } catch (SQLException e){
            throw new Exception("Erro all cliente!");
        }
    }


}

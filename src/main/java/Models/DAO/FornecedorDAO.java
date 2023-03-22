package Models.DAO;

import Models.Categoria;
import Models.Fornecedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements inteface<Fornecedor>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Fornecedor fornecedor) throws Exception {

        try{
            String sql = "INSERT INTO FORNECEDOR(NOME,LOCALIDADE,TIPO_FORNECEDOR,CPF_CNPJ) "+"VALUES(?,?,?,?)";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,fornecedor.getNome());
            stmt.setString(2,fornecedor.getLocalidade());
            stmt.setString(3,fornecedor.getTipo_fornecedor());
            stmt.setString(4,fornecedor.getCpf_cnpj());

            // Executa a instrução INSERT
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro ao inserir fornecedor!");
        }
    }

    @Override
    public Fornecedor read(int id) throws Exception {
        ResultSet rs = null;
        Fornecedor fornecedor = null;

        try{
            String sql = "SELECT * FROM FORNECEDOR WHERE ID_FORNECEDOR = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_fornecedor = rs.getInt("ID_FORNECEDOR");
                String nome = rs.getString("nome");
                String localidade = rs.getString("localidade");
                String tipo_fornecedor = rs.getString("tipo_fornecedor");
                String cpf_cnpj = rs.getString("cpf_cnpj");

                fornecedor = new Fornecedor();
                fornecedor.setId_fornecedor(id_fornecedor);
                fornecedor.setNome(nome);
                fornecedor.setLocalidade(localidade);
                fornecedor.setTipo_fornecedor(tipo_fornecedor);
                fornecedor.setCpf_cnpj(cpf_cnpj);
            }

            return fornecedor;

        } catch (SQLException e){
            throw new Exception("Erro read fornecedor!");
        }
    }

    @Override
    public void update(Fornecedor fornecedor) throws Exception {
        try{
            String sql = "UPDATE FORNECEDOR SET nome = ?, LOCALIDADE = ?, TIPO_FORNECEDOR = ?, CPF_CNPJ = ? WHERE ID_FORNECEDOR = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,fornecedor.getNome());
            stmt.setString(2,fornecedor.getLocalidade());
            stmt.setString(3,fornecedor.getTipo_fornecedor());
            stmt.setString(4, fornecedor.getCpf_cnpj());
            stmt.setInt(5,fornecedor.getId_fornecedor());

            // Executa a instrução UPDATE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro ao atualizar fornecedor!");
        }
    }

    @Override
    public void delete(Fornecedor fornecedor) throws Exception {
        try{
            String sql = "DELETE FROM FORNECEDOR WHERE ID_FORNECEDOR = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,fornecedor.getId_fornecedor());

            // Executa a instrução DELETE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados deletados com sucesso! Linhas afetadas: " + linhasAfetadas);
        }catch (Exception e){
            throw new Exception("Erro ao deletar fornecedor!");
        }
    }

    @Override
    public List<Fornecedor> all() throws Exception {
        ResultSet rs = null;
        Fornecedor fornecedor = null;
        List<Fornecedor> todos = new ArrayList<>();

        try{
            String sql = "SELECT * FROM FORNECEDOR";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_fornecedor = rs.getInt("ID_FORNECEDOR");
                String nome = rs.getString("nome");
                String localidade = rs.getString("localidade");
                String tipo_fornecedor = rs.getString("tipo_fornecedor");
                String cpf_cnpj = rs.getString("cpf_cnpj");

                fornecedor = new Fornecedor();
                fornecedor.setNome(nome);
                fornecedor.setLocalidade(localidade);
                fornecedor.setTipo_fornecedor(tipo_fornecedor);
                fornecedor.setCpf_cnpj(cpf_cnpj);

                todos.add(fornecedor);
            }

            return todos;

        } catch (SQLException e){
            throw new Exception("Erro ao buscar todos fornecedores!");
        }
    }
}

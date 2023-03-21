package Models.DAO;

import Models.Categoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements inteface<Categoria>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Categoria categoria) throws Exception{
        try{
            String sql = "INSERT INTO CATEGORIA(NOME,DESCRICAO) "+"VALUES(?,?)";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,categoria.getNome());
            stmt.setString(2,categoria.getDescricao());

            // Executa a instrução INSERT
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("");
        }
    }

    @Override
    public Categoria read(int id) throws Exception {
        ResultSet rs = null;
        Categoria categoria = null;

        try{
            String sql = "SELECT * FROM CATEGORIA WHERE ID_CATEGORIA = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_categoria = rs.getInt("ID_CATEGORIA");
                String nome = rs.getString("Nome");
                String descricao = rs.getString("Descricao");

                categoria = new Categoria();
                categoria.setId_categoria(id_categoria);
                categoria.setNome(nome);
                categoria.setDescricao(descricao);
            }

            return categoria;

        } catch (SQLException e){
             throw new Exception("");
        }

    }

    @Override
    public void update(Categoria categoria) throws Exception {
        try{
            String sql = "UPDATE CATEGORIA SET nome = ?, descricao = ? WHERE id_categoria = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,categoria.getNome());
            stmt.setString(2,categoria.getDescricao());
            stmt.setInt(3,categoria.getId_categoria());

            // Executa a instrução UPDATE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("");
        }
    }

    @Override
    public void delete(Categoria categoria) throws Exception {
        String sql = "DELETE FROM CATEGORIA WHERE id_categoria = ?";
        PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
        stmt.setInt(1,categoria.getId_categoria());

        // Executa a instrução DELETE
        int linhasAfetadas = stmt.executeUpdate();

        System.out.println("Dados deletados com sucesso! Linhas afetadas: " + linhasAfetadas);
    }

    @Override
    public List<Categoria> all() throws Exception {
        ResultSet rs = null;
        Categoria categoria = null;
        List<Categoria> todas = new ArrayList<>();

        try{
            String sql = "SELECT * FROM CATEGORIA";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_categoria = rs.getInt("ID_CATEGORIA");
                String nome = rs.getString("Nome");
                String descricao = rs.getString("Descricao");

                categoria = new Categoria();
                categoria.setId_categoria(id_categoria);
                categoria.setNome(nome);
                categoria.setDescricao(descricao);

                todas.add(categoria);
            }

            return todas;

        } catch (SQLException e){
            throw new Exception("Erro");
        }

    }
}

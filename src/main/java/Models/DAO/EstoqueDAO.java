package Models.DAO;

import Models.Categoria;
import Models.Estoque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO implements inteface<Estoque>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Estoque estoque) throws Exception {
        try{
            String sql = "INSERT INTO ESTOQUE(COD_ESTOQUE,QUANTIDADE,ID_PRODUTO,ID_ARMAZEM) "+"VALUES(?,?,?,?)";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,estoque.getCod_estoque());
            stmt.setInt(2,estoque.getQuantidade());
            stmt.setInt(3,estoque.getId_produto());
            stmt.setInt(4,estoque.getId_armazem());

            // Executa a instrução INSERT
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("");
        }
    }

    @Override
    public Estoque read(int id) throws Exception {
        ResultSet rs = null;
        Estoque estoque = null;

        try{
            String sql = "SELECT * FROM ESTOQUE WHERE ID_ESTOQUE = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_estoque = rs.getInt("ID_ESTOQUE");
                String cod_estoque = rs.getString("cod_estoque");
                int quantidade = rs.getInt("quantidade");
                int id_produto = rs.getInt("id_produto");
                int id_armazem = rs.getInt("id_armazem");

                estoque = new Estoque();
                estoque.setId_estoque(id_estoque);
                estoque.setCod_estoque(cod_estoque);
                estoque.setQuantidade(quantidade);
                estoque.setId_produto(id_produto);
                estoque.setId_armazem(id_armazem);
            }

            return estoque;

        } catch (SQLException e){
            throw new Exception("Erro ao read estoque!");
        }

    }

    @Override
    public void update(Estoque estoque) throws Exception {
        try{
            String sql = "UPDATE ESTOQUE SET cod_estoque = ?, quantidade = ?, id_produto = ?, id_armazem = ? WHERE id_estoque = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,estoque.getCod_estoque());
            stmt.setInt(2,estoque.getQuantidade());
            stmt.setInt(3,estoque.getId_produto());
            stmt.setInt(4,estoque.getId_armazem());

            // Executa a instrução UPDATE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro ao atualizar estoque!");
        }
    }

    @Override
    public void delete(Estoque estoque) throws Exception {
        try{
            String sql = "DELETE FROM ESTOQUE WHERE id_estoque = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,estoque.getId_estoque());

            // Executa a instrução DELETE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados deletados com sucesso! Linhas afetadas: " + linhasAfetadas);
        }catch (Exception e){
            throw new Exception("Erro ao deletar estoque");
        }
    }

    @Override
    public List<Estoque> all() throws Exception {
        ResultSet rs = null;
        Estoque estoque = null;
        List<Estoque> todos = new ArrayList<>();

        try{
            String sql = "SELECT * FROM ESTOQUE";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_estoque = rs.getInt("ID_ESTOQUE");
                String cod_estoque = rs.getString("cod_estoque");
                int quantidade = rs.getInt("quantidade");
                int id_produto = rs.getInt("id_produto");
                int id_armazem = rs.getInt("id_armazem");

                estoque = new Estoque();
                estoque.setId_estoque(id_estoque);
                estoque.setCod_estoque(cod_estoque);
                estoque.setQuantidade(quantidade);
                estoque.setId_produto(id_produto);
                estoque.setId_armazem(id_armazem);

                todos.add(estoque);
            }

            return todos;

        } catch (SQLException e){
            throw new Exception("Erro ao buscar estoque!");
        }
    }
}

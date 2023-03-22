package Models.DAO;

import Models.Pedido;
import Models.Pedido_Produto;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pedido_ProdutoDAO implements inteface<Pedido_Produto>{
    DAO dao = DAO.getInstance();
    @Override
    public void create(Pedido_Produto pedido_produto) throws Exception {
        try{
            String sql = "INSERT INTO PEDIDO_PRODUTO(ID_PEDIDO,QUANTIDADE,PRECO,ID_PRODUTO) "+"VALUES(?,?,?,?)";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1, pedido_produto.getId_pedido());
            stmt.setInt(2,pedido_produto.getQuantidade());
            stmt.setFloat(3,pedido_produto.getPreco_produto());
            stmt.setInt(4,pedido_produto.getId_produto());

            // Executa a instrução INSERT
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro ao inserir pedido");
        }
    }

    @Override
    public Pedido_Produto read(int id) throws Exception {
        ResultSet rs = null;
        Pedido_Produto pedido_produto = null;

        try{
            String sql = "SELECT * FROM PEDIDO_PRODUTO WHERE ID_PEDIDO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_pedido = rs.getInt("ID_PEDIDO");
                int quantidade = rs.getInt("QUANTIDADE");
                float preco = rs.getFloat("PRECO");
                int id_produto = rs.getInt("ID_PRODUTO");

                pedido_produto = new Pedido_Produto();
                pedido_produto.setId_pedido(id_pedido);
                pedido_produto.setQuantidade(quantidade);
                pedido_produto.setPreco_produto(preco);
                pedido_produto.setId_produto(id_produto);
            }

            return pedido_produto;

        } catch (SQLException e){
            throw new Exception("Erro ao buscar pedido!");
        }
    }

    @Override
    public void update(Pedido_Produto object) {

    }

    @Override
    public void delete(Pedido_Produto pedido_produto) throws Exception {
        try{
            String sql = "DELETE FROM PEDIDO_PRODUTO WHERE ID_PEDIDO = ? and ID_PRODUTO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,pedido_produto.getId_pedido());
            stmt.setInt(2,pedido_produto.getId_produto());

            // Executa a instrução DELETE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados deletados com sucesso! Linhas afetadas: " + linhasAfetadas);
        }catch (Exception e){
            throw new Exception("Erro ao deletar pedido!");
        }
    }

    @Override
    public List<Pedido_Produto> all() throws Exception {
        ResultSet rs = null;
        Pedido_Produto pedido_produto = null;
        List<Pedido_Produto> todos = new ArrayList<>();

        try{
            String sql = "SELECT * FROM PEDIDO_PRODUTO";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_pedido = rs.getInt("ID_PEDIDO");
                int quantidade = rs.getInt("QUANTIDADE");
                float preco = rs.getFloat("PRECO");
                int id_produto = rs.getInt("ID_PRODUTO");

                pedido_produto = new Pedido_Produto();
                pedido_produto.setId_pedido(id_pedido);
                pedido_produto.setQuantidade(quantidade);
                pedido_produto.setPreco_produto(preco);
                pedido_produto.setId_produto(id_produto);

                todos.add(pedido_produto);
            }

            return todos;

        } catch (SQLException e){
            throw new Exception("Erro ao buscar pedidos");
        }
    }
}

package Models.DAO;

import Models.Categoria;
import Models.Pedido;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements inteface<Pedido>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Pedido pedido) throws Exception {
        try{
            String sql = "INSERT INTO PEDIDO(DATA_PEDIDO,MODO_ENCOMENDA,CLIENTE_PEDIDO,STATUS_PEDIDO,DATA_ENTREGA,ID_CLIENTE) "+"VALUES(?,?,?,?,?,?)";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setDate(1, (Date) pedido.getData_pedido());
            stmt.setString(2,pedido.getModo_encomenda());
            stmt.setString(3,pedido.getCliente_pedido());
            stmt.setString(4,pedido.getStatus_pedido());
            stmt.setDate(5, (Date) pedido.getData_entrega());
            stmt.setInt(6,pedido.getId_cliente());

            // Executa a instrução INSERT
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro ao inserir pedido");
        }
    }

    @Override
    public Pedido read(int id) throws Exception {
        ResultSet rs = null;
        Pedido pedido = null;

        try{
            String sql = "SELECT * FROM PEDIDO WHERE ID_PEDIDO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_pedido = rs.getInt("ID_PEDIDO");
                Date data_pedido = rs.getDate("data_pedido");
                String modo_encomenda = rs.getString("modo_encomenda");
                String cliente_pedido = rs.getString("cliente_pedido");
                String status_pedido = rs.getString("status_pedido");
                Date data_estrega = rs.getDate("data_estrega");
                int id_cliente = rs.getInt("modo_encomenda");

                pedido = new Pedido();
                pedido.setId_pedido(id_pedido);
                pedido.setData_pedido(data_pedido);
                pedido.setModo_encomenda(modo_encomenda);
                pedido.setCliente_pedido(cliente_pedido);
                pedido.setStatus_pedido(status_pedido);
                pedido.setData_entrega(data_estrega);
                pedido.setId_cliente(id_cliente);
            }

            return pedido;

        } catch (SQLException e){
            throw new Exception("Erro ao buscar pedido!");
        }
    }

    @Override
    public void update(Pedido pedido) throws Exception {
        try{
            String sql = "UPDATE PEDIDO SET DATA_PEDIDO = ?, MODO_ENCOMENDA = ?, CLIENTE_PEDIDO = ?, STATUS_PEDIDO = ?, DATA_ENTREGA = ?, ID_CLIENTE = ? WHERE ID_PEDIDO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            stmt.setDate(1, (Date) pedido.getData_pedido());
            stmt.setString(2,pedido.getModo_encomenda());
            stmt.setString(3,pedido.getCliente_pedido());
            stmt.setString(4,pedido.getStatus_pedido());
            stmt.setDate(5, (Date) pedido.getData_entrega());
            stmt.setInt(6,pedido.getId_cliente());

            // Executa a instrução UPDATE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro ao atualizar pedido!");
        }
    }

    @Override
    public void delete(Pedido pedido) throws Exception {
        try{
            String sql = "DELETE FROM PEDIDO WHERE ID_PEDIDO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,pedido.getId_pedido());

            // Executa a instrução DELETE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados deletados com sucesso! Linhas afetadas: " + linhasAfetadas);
        }catch (Exception e){
            throw new Exception("Erro ao deletar pedido!");
        }
    }

    @Override
    public List<Pedido> all() throws Exception {
        ResultSet rs = null;
        Pedido pedido = null;
        List<Pedido> todos = new ArrayList<>();

        try{
            String sql = "SELECT * FROM PEDIDO";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_pedido = rs.getInt("id_pedido");
                Date data_pedido = rs.getDate("data_pedido");
                String modo_encomenda = rs.getString("modo_encomenda");
                String cliente_pedido = rs.getString("cliente_pedido");
                String status_pedido = rs.getString("status_pedido");
                Date data_entrega = rs.getDate("data_entrega");
                int id_cliente = rs.getInt("id_cliente");

                pedido = new Pedido();
                pedido.setId_pedido(id_pedido);
                pedido.setData_pedido(data_pedido);
                pedido.setModo_encomenda(modo_encomenda);
                pedido.setCliente_pedido(cliente_pedido);
                pedido.setStatus_pedido(status_pedido);
                pedido.setData_entrega(data_entrega);
                pedido.setId_cliente(id_cliente);

                todos.add(pedido);
            }

            return todos;

        } catch (SQLException e){
            throw new Exception("Erro ao buscar pedidos");
        }
    }
}

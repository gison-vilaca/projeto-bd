package Models.DAO;

import Models.Armazem;
import Models.Produto;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements inteface<Produto>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Produto produto) throws Exception {
        ResultSet rs = null;
        int id_produto = 0;

        try{
            String sql = "INSERT INTO ARMAZEM(PRECO_CUSTO,PRECO_VENDA,PRECO_VENDA_MINIMO,DATA_GARANTIA,VALOR_STATUS,ID_FORNECEDOR,ID_CATEGORIA) "+"VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setDouble(1,produto.getPreco_custo());
            stmt.setDouble(2,produto.getPreco_venda());
            stmt.setDouble(3,produto.getPreco_venda_minimo());
            stmt.setDate(4, (Date) produto.getData_garantia());
            stmt.setDouble(5,produto.getValor_status());
            stmt.setInt(6,produto.getId_fornecedor());
            stmt.setInt(7,produto.getId_categoria());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0){
                //bucar o utimo produto inserido
                String busca = "SELECT TOP 1 * FROM PRODUTO ORDER BY id_produto DESC";
                PreparedStatement res = dao.getConnection().prepareStatement(sql);
                // Executa a consulta SELECT
                rs = res.executeQuery();

                while (rs.next()) {
                    id_produto = rs.getInt("ID_PRODUTO");
                }
                inserirDescricao(produto, id_produto);

                System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);
            }


        } catch (SQLException e){
            throw new Exception("Erro create armazem!");
        }
    }

    public void inserirDescricao(Produto produto , int id_produto) throws Exception {
        ArrayList<String> descricoes = produto.getProduto_descricao();

        for(int i = 0; i < descricoes.size(); i++){
            try {
                String sql = "INSERT INTO PRODUTO_DESCRICAO(ID_PRODUTO, DESCRICAO_PRODUTO)" + "VALUES(?,?)";
                PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
                stmt.setInt(1, id_produto);
                stmt.setString(2,descricoes.get(i));
                stmt.executeUpdate();

            }catch (Exception e){
                throw new Exception("Erro ao inserir descricao!");
            }
        }
    }

    public ArrayList<String> buscarDescricao(int id_produto) throws Exception {
        ResultSet rs = null;
        ArrayList<String> descricoes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PRODUTO_DESCRICAO WHERE ID_PRODUTO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id_produto);
            // Executa a consulta SELECT
            rs = stmt.executeQuery();
            while (rs.next()) {
                String descricao = rs.getString("descricao_produto");
                descricoes.add(descricao);
            }
        }catch (Exception e){
            throw new Exception("Erro ao burcar descricoes!");
        }

        return descricoes;
    }

    @Override
    public Produto read(int id) throws Exception {
        ResultSet rs = null;
        Produto produto = null;

        try{
            String sql = "SELECT * FROM PRODUTO WHERE ID_PRODUTO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_produto = rs.getInt("ID_PRODUTO");
                float preco_custo = rs.getFloat("preco_custo");
                float preco_venda = rs.getFloat("preco_venda");
                float preco_venda_minimo = rs.getFloat("preco_venda_minimo");
                Date data_garantia = rs.getDate("data_garantia");
                float valor_status = rs.getFloat("valor_status");
                int id_fornecedor = rs.getInt("id_fornecedor");
                int id_categoria = rs.getInt("id_categoria");

                produto = new Produto();
                produto.setId_produto(id_produto);
                produto.setPreco_custo(preco_custo);
                produto.setPreco_venda(preco_venda);
                produto.setPreco_venda_minimo(preco_venda_minimo);
                produto.setData_garantia(data_garantia);
                produto.setValor_status(valor_status);
                produto.setId_fornecedor(id_fornecedor);
                produto.setId_categoria(id_categoria);
                produto.setProduto_descricao(buscarDescricao(id_produto));
            }


            return produto;

        } catch (SQLException e){
            throw new Exception("Erro read produto!");
        }
    }

    @Override
    public void update(Produto produto) throws Exception {
        try{
            String sql = "UPDATE PRODUTO SET preco_custo = ?, preco_venda = ?, preco_venda_minimo = ?, data_garantia = ?, valor_status = ?, id_fornecedor = ?, id_categoria = ? WHERE ID_PRODUTO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setFloat(1,produto.getPreco_custo());
            stmt.setFloat(2,produto.getPreco_venda());
            stmt.setFloat(3,produto.getPreco_venda_minimo());
            stmt.setDate(4, (Date) produto.getData_garantia());
            stmt.setFloat(5,produto.getValor_status());
            stmt.setInt(6,produto.getId_fornecedor());
            stmt.setInt(7,produto.getId_categoria());

            // Executa a instrução UPDATE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro update armazem!");
        }
    }

    @Override
    public void delete(Produto produto) throws Exception {
        try {
            String sql = "DELETE FROM PRODUTO WHERE ID_PRODUTO = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,produto.getId_produto());

            // Executa a instrução DELETE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados deletados com sucesso! Linhas afetadas: " + linhasAfetadas);
        }catch (Exception e){
            throw new Exception("Erro ao deletar produto!");
        }

    }

    @Override
    public List<Produto> all() throws Exception {
        ResultSet rs = null;
        Produto produto = null;
        List<Produto> todos = new ArrayList<>();

        try{
            String sql = "SELECT * FROM PRODUTO";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_produto = rs.getInt("ID_PRODUTO");
                float preco_custo = rs.getFloat("preco_custo");
                float preco_venda = rs.getFloat("preco_venda");
                float preco_venda_minimo = rs.getFloat("preco_venda_minimo");
                Date data_garantia = rs.getDate("data_garantia");
                float valor_status = rs.getFloat("valor_status");
                int id_fornecedor = rs.getInt("id_fornecedor");
                int id_categoria = rs.getInt("id_categoria");

                produto = new Produto();
                produto.setId_produto(id_produto);
                produto.setPreco_custo(preco_custo);
                produto.setPreco_venda(preco_venda);
                produto.setPreco_venda_minimo(preco_venda_minimo);
                produto.setData_garantia(data_garantia);
                produto.setValor_status(valor_status);
                produto.setId_fornecedor(id_fornecedor);
                produto.setId_categoria(id_categoria);
                produto.setProduto_descricao(buscarDescricao(id_produto));

                todos.add(produto);
            }

            return todos;

        } catch (SQLException e){
            throw new Exception("Erro ao buscar todos os produtos");
        }
    }
}

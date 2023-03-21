package Models.DAO;

import Models.Armazem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArmazemDAO implements inteface<Armazem>{

    DAO dao = DAO.getInstance();
    @Override
    public void create(Armazem armazem) throws Exception{
        try{
            String sql = "INSERT INTO ARMAZEM(NOME,END_ARMAZEM) "+"VALUES(?,?)";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,armazem.getNome());
            stmt.setString(2,armazem.getEndereco());

            // Executa a instrução INSERT
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro create armazem!");
        }
    }

    @Override
    public Armazem read(int id) throws Exception{
        ResultSet rs = null;
        Armazem armazem = null;

        try{
            String sql = "SELECT * FROM ARMAZEM WHERE ID_ARMAZEM = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setInt(1,id);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_armazem = rs.getInt("ID_ARMAZEM");
                String nome = rs.getString("Nome");
                String endereco = rs.getString("End_armazem");

                armazem = new Armazem();
                armazem.setId_armazem(id_armazem);
                armazem.setNome(nome);
                armazem.setEndereco(endereco);
            }

            return armazem;

        } catch (SQLException e){
            throw new Exception("Erro read armazem!");
        }

    }

    @Override
    public void update(Armazem armazem) throws Exception{
        try{
            String sql = "UPDATE ARMAZEM SET nome = ?, end_armazem = ? WHERE ID_ARMAZEM = ?";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            stmt.setString(1,armazem.getNome());
            stmt.setString(2,armazem.getEndereco());
            stmt.setInt(3,armazem.getId_armazem());

            // Executa a instrução UPDATE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e){
            throw new Exception("Erro update armazem!");
        }
    }

    @Override
    public void delete(Armazem armazem) throws Exception {
        String sql = "DELETE FROM ARMAZEM WHERE ID_ARMAZEM = ?";
        PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
        stmt.setInt(1,armazem.getId_armazem());

        // Executa a instrução DELETE
        int linhasAfetadas = stmt.executeUpdate();

        System.out.println("Dados deletados com sucesso! Linhas afetadas: " + linhasAfetadas);
    }

    @Override
    public List<Armazem> all() throws Exception {
        ResultSet rs = null;
        Armazem armazem = null;
        List<Armazem> todos = new ArrayList<>();

        try{
            String sql = "SELECT * FROM ARMAZEM";
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);

            // Executa a consulta SELECT
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_armazem = rs.getInt("ID_ARMAZEM");
                String nome = rs.getString("Nome");
                String end_armazem = rs.getString("End_armazem");

                armazem = new Armazem();
                armazem.setId_armazem(id_armazem);
                armazem.setNome(nome);
                armazem.setEndereco(end_armazem);

                todos.add(armazem);
            }

            return todos;

        } catch (SQLException e){
            throw new Exception("Erro");
        }
    }
}

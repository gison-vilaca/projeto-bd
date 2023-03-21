package Models;

import Models.DAO.CategoriaDAO;
import Models.DAO.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

//        DAO dao = DAO.getInstance();
        try {
//            Statement stmt = dao.getConnection().createStatement();
//
//            ResultSet rs = stmt.executeQuery("SELECT * FROM ARMAZEM");
//
//            while (rs.next()) {
//                int id = rs.getInt("id_armazem");
//                String nome = rs.getString("nome");
//                String end_armazem = rs.getString("end_armazem");
//
//                System.out.println("id: "+id+"/ nome: "+nome+".end:"+end_armazem);
//
//            }
//
//            rs.close();
//            stmt.close();
//            dao.getConnection().close();
            Categoria cat = new Categoria("LUCIANO","JOSE LUCIANO A CARV");
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            System.out.println(categoriaDAO.all().toString());


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}

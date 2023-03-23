package Models.DAO;

import Models.Consulta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class consultaDAO {

    DAO dao = DAO.getInstance();

    public consultaDAO() {
    }

    public ArrayList<String> resultado(Consulta consulta) throws Exception {
        ResultSet rs = null;
        String col1 = "";
        ArrayList<String> res = new ArrayList<>();
        try {
            String sql = consulta.getComando();
            PreparedStatement stmt = dao.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int ncol = rsmd.getColumnCount();
            int x = 1;
//            double bonus = salario * (salario > 1000 ? 0.10 : 0.15);
            col1 = "";
            while(rs.next()){

                for(int i = 1; i <= ncol; i++){
                    col1 += rs.getString(i)+"|";
                }
                res.add(col1);
                col1 = "";
            }

            return  res;

        }catch (Exception e){
            throw new Exception("Verifique sua consulta");
        }

    }
}

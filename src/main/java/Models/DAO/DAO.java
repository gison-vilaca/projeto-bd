package Models.DAO;

import java.sql.*;
public class DAO {

        private static DAO instance = null;
        private Connection connection = null;
        private static final String CONNECTION_STRING = "jdbc:sqlserver://localhost\\SQLEXPRESS;database=projeto_bd;user=luciano;password=123456;encrypt=true;trustServerCertificate=true;";

        private DAO()  {

            try {
                Connection con = DriverManager.getConnection(CONNECTION_STRING);

                connection = con;
            } catch (SQLException e) {
                System.out.println("Tudo errado"+e.getMessage());
            }
        }

        public static synchronized DAO getInstance() {
            if (instance == null) {
                instance = new DAO();
            }
            return instance;
        }

        public Connection getConnection() {
            return connection;
        }
    }




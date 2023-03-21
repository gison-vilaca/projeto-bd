module com.projetobd.projeto_bd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.projetobd.projeto_bd to javafx.fxml;
    exports com.projetobd.projeto_bd;
}
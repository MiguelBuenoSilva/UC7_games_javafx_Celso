module br.senac.sp.gamesfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires java.sql;
    requires org.controlsfx.controls;
    requires java.desktop;

    opens br.senac.sp.gamesfx to javafx.fxml;
    opens br.senac.sp.gamesfx.model to javafx.base;
    exports br.senac.sp.gamesfx;
}
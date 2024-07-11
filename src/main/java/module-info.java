module group.crudgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires mysql.connector.j;

    opens group.crudgui to javafx.fxml;
    exports group.crudgui;
}
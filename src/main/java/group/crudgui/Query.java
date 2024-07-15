package group.crudgui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Query {

    //Connection connection = dbConn.getConnection();
    public void addStudent(Student student)
    {

        try {

            String query3 = "INSERT INTO student VALUES(?,?,?,?)";

            Connection conn = databaseConnection.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query3);

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getMiddleName());
            preparedStatement.setString(4,student.getLastName());

            try{
                int results = preparedStatement.executeUpdate();
                System.out.println( results + " fila(s) afectada(s)");
                //statement.executeQuery(query2);
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Fallo al conectar la Base de Datos");
            e.printStackTrace();
        }

    }

    public void deleteStudent( int studentId) {
        try {
            String insertSQL = "DELETE FROM student WHERE id = ?";

            Connection conn = databaseConnection.getConnection();

            PreparedStatement st = conn.prepareStatement(insertSQL);
            st.setInt(1, studentId);

            try{
                int results = st.executeUpdate();
                System.out.println(results+" fila(s) afectada(s)");
                System.out.println("Se ha eliminado estudiante: ") ;
            } catch (SQLException e){
                System.out.println("Error al eliminar");
                e.printStackTrace();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Fallo al conectar la Base de Datos");
        }
    }

    public ObservableList<Student> getStudentList() {
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        String query = "SELECT student.id, student.first_name, student.middle_name, student.last_name FROM student";
        String query2 = "SELECT * FROM student";
        try {
            Connection conn = databaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"), rs.getString("first_name"),
                        rs.getString("middle_name"), rs.getString("last_name"));
                studentList.add(student);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public void updateStudent(Student student)
    {
        try {
            Connection conn = databaseConnection.getConnection();
            String insertSQL = "UPDATE estudiante SET universidad = ? WHERE nombre=?";

            String insertSQL2 = "UPDATE student " +
                    "SET first_name = ?," +
                    " middle_name = ?," +
                    " last_name = ?" +
                    "WHERE id = ?;";

            PreparedStatement ps = conn.prepareStatement(insertSQL2);

            ps.setString(1,student.getFirstName());
            ps.setString(2,student.getMiddleName());
            ps.setString(3,student.getLastName());
            ps.setInt(4,student.getId());


            try{
                int results = ps.executeUpdate();
                System.out.println( results + " fila(s) afectada(s)");
                //statement.executeQuery(query2);
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void addCliente(Cliente cliente)
    {
        try {

            String query3 = "INSERT INTO Cliente VALUES(?,?,?,?)";

            Connection conn = databaseConnection.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query3);

            preparedStatement.setInt(1, cliente.getId());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getTelefono());

            try{
                int results = preparedStatement.executeUpdate();
                System.out.println( results + " fila(s) afectada(s)");
                //statement.executeQuery(query2);
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Fallo al conectar la Base de Datos");
            e.printStackTrace();
        }
    }

    public void deleteCliente(int clienteId)
    {
        try {
            String insertSQL = "DELETE FROM Cliente WHERE id = ?";

            Connection conn = databaseConnection.getConnection();

            PreparedStatement st = conn.prepareStatement(insertSQL);
            st.setInt(1, clienteId);

            try{
                int results = st.executeUpdate();
                System.out.println(results+" fila(s) afectada(s)");
                System.out.println("Se ha eliminado estudiante: ") ;
            } catch (SQLException e){
                System.out.println("Error al eliminar");
                e.printStackTrace();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Fallo al conectar la Base de Datos");
        }
    }

    public ObservableList<Cliente> getClienteList()
    {
        ObservableList<Cliente> clienteList = FXCollections.observableArrayList();
        //String query = "SELECT student.id, student.first_name, student.middle_name, student.last_name FROM student";
        String query2 = "SELECT * FROM Cliente";
        try {
            Connection conn = databaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {

                Cliente cliente =

                        new Cliente(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("direccion"), rs.getString("telefono"));

                clienteList.add(cliente);

            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clienteList;

    }

    public void updateCliente(Cliente cliente)
    {
        try {
            Connection conn = databaseConnection.getConnection();

            String insertSQL2 = "UPDATE Cliente " +
                    "SET nombre = ?," +
                    " direccion = ?," +
                    " telefono = ?" +
                    "WHERE id = ?;";

            PreparedStatement ps = conn.prepareStatement(insertSQL2);

            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getDireccion());
            ps.setString(3,cliente.getTelefono());
            ps.setInt(4,cliente.getId());


            try{
                int results = ps.executeUpdate();
                System.out.println( results + " fila(s) afectada(s)");
                //statement.executeQuery(query2);
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void addTarjeta(Tarjeta tarjeta)
    {
        try {

            String query3 = "INSERT INTO Tarjeta VALUES(?,?,?,?,?,?)";

            Connection conn = databaseConnection.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query3);
            //ps.setDate(2, Date.valueOf(fechaExp))
            preparedStatement.setInt(1, tarjeta.getId());
            preparedStatement.setString(2, tarjeta.getNumero_tarjeta());
            preparedStatement.setInt(3, tarjeta.getId_tipo_tarjeta());
            //preparedStatement.setDate(4, Date.valueOf(fechaExp));
            preparedStatement.setDate(4, tarjeta.getFecha_expiracion());
            preparedStatement.setInt(5,tarjeta.getId_facilitador_tarjeta());
            preparedStatement.setInt(6,tarjeta.getId_cliente());

            try{
                int results = preparedStatement.executeUpdate();
                System.out.println( results + " fila(s) afectada(s)");
                //statement.executeQuery(query2);
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Fallo al conectar la Base de Datos");
            e.printStackTrace();
        }
    }

    public void deleteTarjeta(int tarjetaId)
    {
        try {
            String insertSQL = "DELETE FROM Tarjeta WHERE id = ?";

            Connection conn = databaseConnection.getConnection();

            PreparedStatement st = conn.prepareStatement(insertSQL);
            st.setInt(1, tarjetaId);

            try{
                int results = st.executeUpdate();
                System.out.println(results+" fila(s) afectada(s)");
                System.out.println("Se ha eliminado estudiante: ") ;
            } catch (SQLException e){
                System.out.println("Error al eliminar");
                e.printStackTrace();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Fallo al conectar la Base de Datos");
        }
    }

    public ObservableList<Tarjeta> getTarjetaList()
    {
        ObservableList<Tarjeta> tarjetaList = FXCollections.observableArrayList();
        //String query = "SELECT student.id, student.first_name, student.middle_name, student.last_name FROM student";
        String query2 = "SELECT * FROM Tarjeta";
        try {
            Connection conn = databaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {

                Tarjeta tarjeta =

                        new Tarjeta(rs.getInt("id"), rs.getString("numero_tarjeta"),
                                rs.getInt("id_tipo_tarjeta"), rs.getDate("fecha_expiracion"),
                                rs.getInt("id_facilitador_tarjeta"), rs.getInt("id_cliente"));

                tarjetaList.add(tarjeta);

            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarjetaList;

    }

    public void updateTarjeta(Tarjeta tarjeta)
    {
        try {
            Connection conn = databaseConnection.getConnection();

            String insertSQL2 = "UPDATE Tarjeta " +
                    "SET numero_tarjeta = ?," +
                    " id_tipo_tarjeta = ?," +
                    " fecha_expiracion = ?," +
                    " id_facilitador_tarjeta = ?," +
                    " id_cliente = ?" +
                    "WHERE id = ?;";

            PreparedStatement ps = conn.prepareStatement(insertSQL2);

            ps.setString(1,tarjeta.getNumero_tarjeta());
            ps.setInt(2,tarjeta.getId_tipo_tarjeta());
            ps.setDate(3,tarjeta.getFecha_expiracion());
            ps.setInt(4,tarjeta.getId_facilitador_tarjeta());
            ps.setInt(5,tarjeta.getId_cliente());
            ps.setInt(6, tarjeta.getId());

            try{
                int results = ps.executeUpdate();
                System.out.println( results + " fila(s) afectada(s)");

            } catch (SQLException e){
                e.printStackTrace();
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void addTransaccion(Transaccion transaccion)
    {
        try {

            String query3 = "INSERT INTO Transaccion VALUES(?,?,?,?,?,?)";

            Connection conn = databaseConnection.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query3);

            preparedStatement.setInt(1, transaccion.getId());
            preparedStatement.setDate(2, transaccion.getFecha_compra());
            preparedStatement.setDouble(3, transaccion.getMonto_total());
            preparedStatement.setString(4, transaccion.getDescripcion());
            preparedStatement.setInt(5,transaccion.getId_tarjeta());
            preparedStatement.setInt(6,transaccion.getId_cliente());

            try{
                int results = preparedStatement.executeUpdate();
                System.out.println( results + " fila(s) afectada(s)");
                //statement.executeQuery(query2);
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Fallo al conectar la Base de Datos");
            e.printStackTrace();
        }
    }

    public void deleteTransaccion(int transaccionId)
    {
        try {
            String insertSQL = "DELETE FROM Transaccion WHERE id = ?";

            Connection conn = databaseConnection.getConnection();

            PreparedStatement st = conn.prepareStatement(insertSQL);
            st.setInt(1, transaccionId);

            try{
                int results = st.executeUpdate();
                System.out.println(results+" fila(s) afectada(s)");
                System.out.println("Se ha eliminado estudiante: ") ;
            } catch (SQLException e){
                System.out.println("Error al eliminar");
                e.printStackTrace();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Fallo al conectar la Base de Datos");
        }
    }

    public ObservableList<Transaccion> getTransaccionList()
    {
        ObservableList<Transaccion> transaccionList = FXCollections.observableArrayList();
        //String query = "SELECT student.id, student.first_name, student.middle_name, student.last_name FROM student";
        String query2 = "SELECT * FROM Transaccion";
        try {
            Connection conn = databaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {

                Transaccion transaccion =

                        new Transaccion(rs.getInt("id"), rs.getDate("fecha_compra"),
                                rs.getDouble("monto_total"), rs.getString("descripcion"),
                                rs.getInt("id_tarjeta"), rs.getInt("id_cliente"));

                transaccionList.add(transaccion);

            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaccionList;
    }

    public void updateTransaccion(Transaccion transaccion)
    {
        try {
            Connection conn = databaseConnection.getConnection();

            String insertSQL2 = "UPDATE Transaccion " +
                    "SET fecha_compra = ?," +
                    " monto_total = ?," +
                    " descripcion = ?, " +
                    " id_tarjeta = ?, " +
                    " id_cliente = ? " +
                    "WHERE id = ?; ";

            PreparedStatement ps = conn.prepareStatement(insertSQL2);

            ps.setDate(1,transaccion.getFecha_compra());
            ps.setDouble(2,transaccion.getMonto_total());
            ps.setString(3,transaccion.getDescripcion());
            ps.setInt(4,transaccion.getId_tarjeta());
            ps.setInt(5,transaccion.getId_cliente());
            ps.setInt(6,transaccion.getId());

            try{
                int results = ps.executeUpdate();
                System.out.println( results + " fila(s) afectada(s)");

            } catch (SQLException e){
                e.printStackTrace();
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void reporteAComprasRealizadas(int idCliente , Date fecha_inicio, Date fecha_fin) {

                try {
                    Connection conn = databaseConnection.getConnection();

                    String query = "SELECT " +
                            "t.id AS transaccion_id, " +
                            "t.fecha_compra, " +
                            "t.monto_total, " +
                            "t.descripcion, " +
                            "cl.nombre AS cliente_nombre, " +
                            "cl.direccion AS cliente_direccion, " +
                            "cl.telefono AS cliente_telefono " +

                            "FROM Transaccion t " +
                            "JOIN Cliente cl ON t.id_cliente = cl.id " +
                            "WHERE t.id_cliente = ? " +
                            "AND t.fecha_compra BETWEEN ? AND ? " +
                            "ORDER BY t.fecha_compra";

                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setInt(1, idCliente);
                    preparedStatement.setDate(2, fecha_inicio);
                    preparedStatement.setDate(3, fecha_fin);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
                    String fechaHoraActual = LocalDateTime.now().format(formatter);

                    String pathname = "src\\main\\resources\\group\\crudgui\\Reportes";
                    File reportesDir = new File(pathname);
                    if (!reportesDir.exists()) {
                        reportesDir.mkdirs();
                    }

                    File reporte = new File(reportesDir, "Reporte_A_" + fechaHoraActual + ".txt");

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporte))) {

                        while (resultSet.next()) {
                            int transaccionId = resultSet.getInt("transaccion_id");
                            Date fechaCompra = resultSet.getDate("fecha_compra");
                            double montoTotal = resultSet.getDouble("monto_total");
                            String descripcion = resultSet.getString("descripcion");
                            String clienteNombre = resultSet.getString("cliente_nombre");
                            String clienteDireccion = resultSet.getString("cliente_direccion");
                            String clienteTelefono = resultSet.getString("cliente_telefono");

                            writer.write("ID Transacción: " + transaccionId);
                            writer.newLine();
                            writer.write("Fecha de Compra: " + fechaCompra);
                            writer.newLine();
                            writer.write("Monto Total: " + montoTotal);
                            writer.newLine();
                            writer.write("Descripción: " + descripcion);
                            writer.newLine();
                            writer.write("Nombre del Cliente: " + clienteNombre);
                            writer.newLine();
                            writer.write("Dirección del Cliente: " + clienteDireccion);
                            writer.newLine();
                            writer.write("Teléfono del Cliente: " + clienteTelefono);
                            writer.newLine();
                            writer.write("---------------------------");
                            writer.newLine();

                            System.out.println("ID Transacción: " + transaccionId);
                            System.out.println("Fecha de Compra: " + fechaCompra);
                            System.out.println("Monto Total: " + montoTotal);
                            System.out.println("Descripción: " + descripcion);
                            System.out.println("Nombre del Cliente: " + clienteNombre);
                            System.out.println("Dirección del Cliente: " + clienteDireccion);
                            System.out.println("Teléfono del Cliente: " + clienteTelefono);
                            System.out.println("---------------------------");

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        resultSet.close();
                        preparedStatement.close();
                        conn.close();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }

    public void reporteBGastosMes(int id_cliente, LocalDate fecha_especifica) {
        try {
            Connection conn = databaseConnection.getConnection();

            String query = "SELECT " +
                    "SUM(t.monto_total) AS total_gastado " +
                    "FROM Transaccion t " +
                    "WHERE t.id_cliente = ? " +
                    "AND YEAR(t.fecha_compra) = ? " +
                    "AND MONTH(t.fecha_compra) = ?";

            String queryNombreCliente = "select Cliente.nombre from Cliente where Cliente.id = ?";

            try {
                PreparedStatement ps = conn.prepareStatement(queryNombreCliente);

                ps.setInt(2, id_cliente);

                ResultSet rs = ps.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id_cliente);
            preparedStatement.setInt(2, fecha_especifica.getYear());
            preparedStatement.setInt(3, fecha_especifica.getMonthValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String fechaHoraActual = LocalDateTime.now().format(formatter);

            String pathname = "src\\main\\resources\\group\\crudgui\\Reportes";
            File reportesDir = new File(pathname);

            if (!reportesDir.exists()) {
                reportesDir.mkdirs();
            }

            File reporte = new File(pathname, "Reporte_B_" + fechaHoraActual + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporte))) {

                if (resultSet.next()) {
                    double totalGastado = resultSet.getDouble("total_gastado");
                    writer.write("ID_cliente: " + id_cliente);
                    writer.newLine();
                    writer.write("Mes: " + fecha_especifica.getMonthValue());
                    writer.newLine();
                    writer.write("Año: " + fecha_especifica.getYear());
                    writer.newLine();
                    writer.write("Total Gastado: " + totalGastado);
                    writer.newLine();

                    System.out.println("ID_cliente: " + id_cliente);
                    System.out.println("Mes: " + fecha_especifica.getMonthValue());
                    System.out.println("Año: " + fecha_especifica.getYear());
                    System.out.println("Total Gastado: " + totalGastado);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                resultSet.close();
                preparedStatement.close();
                conn.close();
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reporteCTarjetas(int idCliente) throws SQLException {

        String queryCredito = "SELECT t.numero_tarjeta FROM Tarjeta t JOIN tipoTarjeta tt ON t.id_tipo_tarjeta = tt.id WHERE t.id_cliente = ? AND tt.nombre = 'Credito'";
        String queryDebito = "SELECT t.numero_tarjeta FROM Tarjeta t JOIN tipoTarjeta tt ON t.id_tipo_tarjeta = tt.id WHERE t.id_cliente = ? AND tt.nombre = 'Debito'";

        try {
            Connection conn = databaseConnection.getConnection();
             PreparedStatement psCredito = conn.prepareStatement(queryCredito);
             PreparedStatement psDebito = conn.prepareStatement(queryDebito);

            // Configurar los parámetros de la consulta
            psCredito.setInt(1, idCliente);
            psDebito.setInt(1, idCliente);

            ResultSet rsCredito = psCredito.executeQuery();
            ResultSet rsDebito = psDebito.executeQuery();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String fechaHoraActual = LocalDateTime.now().format(formatter);

            String pathname = "src\\main\\resources\\group\\crudgui\\Reportes";
            File reportesDir = new File(pathname);

            if (!reportesDir.exists()) {
                reportesDir.mkdirs();
            }

            File reporte = new File(reportesDir, "Reporte_C_" + fechaHoraActual + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporte))) {
                writer.write("Tarjetas de crédito:");
                writer.newLine();
                if (!rsCredito.next()) {
                    writer.write("N/A");
                    writer.newLine();
                } else {
                    do {
                        String numeroTarjeta = rsCredito.getString("numero_tarjeta");
                        writer.write(censurarNumeroTarjeta(numeroTarjeta));
                        writer.newLine();
                    } while (rsCredito.next());
                }

                writer.write("Tarjetas de Débito:");
                writer.newLine();
                if (!rsDebito.next()) {
                    writer.write("N/A");
                    writer.newLine();
                } else {
                    do {
                        String numeroTarjeta = rsDebito.getString("numero_tarjeta");
                        writer.write(censurarNumeroTarjeta(numeroTarjeta));
                        writer.newLine();
                    } while (rsDebito.next());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                rsCredito.close();
                rsDebito.close();
                psCredito.close();
                psDebito.close();
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static String censurarNumeroTarjeta(String numeroTarjeta)
        {
        if (numeroTarjeta == null || numeroTarjeta.length() < 4) {
            return "XXXX XXXX XXXX XXXX";
        }
        return "XXXX XXXX XXXX " + numeroTarjeta.substring(numeroTarjeta.length() - 4);
        }

    public void reporteDgenerarReporteClientesPorFacilitador(String facilitador) throws SQLException {

        String query = "SELECT " +
                "c.id AS cliente_id, " +
                "c.nombre AS cliente_nombre, " +
                "COUNT(t.id) AS cantidad_compras, " +
                "SUM(t.monto_total) AS total_gastado " +
                "FROM Cliente c " +
                "JOIN Tarjeta ta ON c.id = ta.id_cliente " +
                "JOIN Transaccion t ON ta.id = t.id_tarjeta " +
                "JOIN FacilitadorTarjeta ft ON ta.id_facilitador_tarjeta = ft.id " +
                "WHERE ft.nombre = ? " +
                "GROUP BY c.id, c.nombre " +
                "ORDER BY total_gastado DESC";

        try
        {
             Connection conn = databaseConnection.getConnection();

             PreparedStatement preparedStatement = conn.prepareStatement(query);

            // Configurar el parámetro de la consulta
            preparedStatement.setString(1, facilitador);

            ResultSet resultSet = preparedStatement.executeQuery();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String fechaHoraActual = LocalDateTime.now().format(formatter);

            String pathname = "src\\main\\resources\\group\\crudgui\\Reportes";
            File reportesDir = new File(pathname);

            if (!reportesDir.exists()) {
                reportesDir.mkdirs();
            }

            File reporte = new File(reportesDir, "ReporteD_ClientesPorFacilitador_" + fechaHoraActual + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporte)))
            {
                writer.write("Clientes que han realizado compras con el facilitador de tarjeta: " + facilitador);
                writer.newLine();
                writer.write("----------------------------------------------------------------");
                writer.newLine();

                while (resultSet.next())
                {
                    int clienteId = resultSet.getInt("cliente_id");
                    String clienteNombre = resultSet.getString("cliente_nombre");
                    int cantidadCompras = resultSet.getInt("cantidad_compras");
                    double totalGastado = resultSet.getDouble("total_gastado");

                    writer.write("ID Cliente: " + clienteId);
                    writer.newLine();
                    writer.write("Nombre Cliente: " + clienteNombre);
                    writer.newLine();
                    writer.write("Cantidad de Compras: " + cantidadCompras);
                    writer.newLine();
                    writer.write("Total Gastado: " + totalGastado);
                    writer.newLine();
                    writer.write("----------------------------------------------------------------");
                    writer.newLine();

                    System.out.println("ID Cliente: " + clienteId);
                    System.out.println("Nombre Cliente: " + clienteNombre);
                    System.out.println("Cantidad de Compras: " + cantidadCompras);
                    System.out.println("Total Gastado: " + totalGastado);
                    System.out.println("----------------------------------------------------------------");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                resultSet.close();
                preparedStatement.close();
                conn.close();
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }


    private ObservableList<StatementRecord> data;

    public Query() {
        data = FXCollections.observableArrayList();
    }

    public ObservableList<StatementRecord> getList() {
        return data;
    }

    public void generateStatement(int id) throws SQLException {
        Connection conn = databaseConnection.getConnection();

        String query =
                "SELECT " +
                        "Cliente.id, " +
                        "Cliente.nombre, " +
                        "Tarjeta.numero_tarjeta as 'tarjeta', " +
                        "Transaccion.descripcion, " +
                        "FacilitadorTarjeta.nombre as 'facilitador' " +
                        "FROM " +
                        "Cliente " +
                        "INNER JOIN Tarjeta ON Tarjeta.id = Cliente.id " +
                        "INNER JOIN Transaccion ON Tarjeta.id = Transaccion.id_tarjeta " +
                        "INNER JOIN FacilitadorTarjeta ON Tarjeta.id_facilitador_tarjeta = FacilitadorTarjeta.id " +
                        "WHERE FacilitadorTarjeta.id = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        data.clear(); // Clear previous data

        while (resultSet.next()) {
            int recordId = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String numeroTarjeta = resultSet.getString("tarjeta");
            String descripcion = resultSet.getString("descripcion");
            String facilitador = resultSet.getString(   "facilitador");

            data.add(new StatementRecord(recordId, nombre, numeroTarjeta, descripcion, facilitador));
        }

        conn.close();
    }



}

package group.crudgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

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
                    " fecha_expiracion = ?" +
                    " id_facilitador_tarjeta" +
                    " id_cliente" +
                    "WHERE id = ?;";

            PreparedStatement ps = conn.prepareStatement(insertSQL2);

            ps.setString(1,tarjeta.getNumero_tarjeta());
            ps.setInt(2,tarjeta.getId_tipo_tarjeta());
            ps.setDate(3,tarjeta.getFecha_expiracion());
            ps.setInt(4,tarjeta.getId_facilitador_tarjeta());
            ps.setInt(5,tarjeta.getId_cliente());

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
                    " descripcion = ?" +
                    " id_tarjeta" +
                    " id_cliente" +
                    "WHERE id = ?;";

            PreparedStatement ps = conn.prepareStatement(insertSQL2);

            ps.setDate(1,transaccion.getFecha_compra());
            ps.setDouble(2,transaccion.getMonto_total());
            ps.setString(3,transaccion.getDescripcion());
            ps.setInt(4,transaccion.getId_tarjeta());
            ps.setInt(5,transaccion.getId_cliente());

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



}

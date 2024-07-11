package group.crudgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Query {

    //Connection connection = dbConn.getConnection();
    public void addStudent(Student student)
    {

        try {
//          String query1= "SET IDENTITY_INSERT student ON";
//          String query2 = "SET IDENTITY_INSERT student OFF ";
            String query3 = "INSERT INTO student VALUES(?,?,?,?)";
            //String insertSQL = "INSERT INTO student (id, first_name, middle_name ,last_name) VALUES (?, ?, ?, ?)";
            //String insertSQL = "INSERT INTO student VALUES (?, ?, ?, ?)";

            Connection conn = databaseConnection.getConnection();
            //String query = "SELECT * FROM student";
            //Statement statement = conn.createStatement();
            //statement.executeQuery(query1);
            PreparedStatement preparedStatement = conn.prepareStatement(query3);

//            String nombre = txtNombreCliente.getText();
//            String direccion = txtDireccionCliente.getText();
//            String telefono = txtTelefonoCliente.getText();
//
//            boolean flag = false;
//
//            if (nombre.equals("")) {
//                lblErrorNombre.setText("Campo Obligatorio");
//                flag = true;
//            }
//            if (direccion.equals("")) {
//                lblErrorDireccion.setText("Campo Obligatorio");
//                flag = true;
//            }

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

}

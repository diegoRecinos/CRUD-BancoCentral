package group.crudgui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class BCNController implements Initializable {
    public TextField fieldTransaccionIDTarjeta;
    public Button btnTarjetaDelete;
    public Button btnTarjetaUpdate;
    public Button btnTarjetaRead;
    public Button btnTarjetaSave;
    public TextField fieldTransacionDesc;
    public DatePicker dtpickerTransaccionDate;
    public TextField fieldTransaccionMonto;
    public Button btnTransaccionSave;
    public Button btnTransaccionRead;
    public Button btnTransaccionUpdate;
    public Button btnTransaccionDelete;
    public TableView tableViewTarjeta;
    public TableColumn colTarjetaID;
    public TableColumn colTarjetaNumero;
    public TableColumn colTarjetaFechaExp;
    public TableColumn colTarjetaIDtipoTarjeta;
    public TableColumn colTarjetaIDtipoFacilitador;
    public TableColumn colTarjetaIDCliente;
    public TableColumn colTransaccionIDCliente;
    public TableColumn colTransaccionIDTarjeta;
    public TableColumn colTransaccionMonto;
    public TableColumn colTransaccionFecha;
    public TableColumn colTransaccionDescripcion;
    public TableColumn colTransaccionID;
    public TableView tableViewTransaccion;
    public TextField fieldTarjetaIDCliente;
    public TextField fieldTarjetaNumber;
    public DatePicker dtpickerTarjetaExpire;
    public ComboBox comboBxTarjetaFacilitador;
    public Button btnClienteDelete;
    public Button btnClienteUpdate;
    public Button btnClienteRead;
    public Button btnClienteSave;
    public TextField fieldClienteTel;
    public TextField fieldClienteID;
    public TextField fieldClienteAddress;
    public TextField fieldClienteName;
    public TableColumn colClienteTelefono;
    public TableColumn colClienteDireccion;
    public TableColumn colClienteNombre;
    public TableColumn colClienteID;
    public TableView tableViewCliente;
    @FXML
    private Label welcomeText;
//    //private ComboBox<Facilitador> facilitador;
//    @FXML
//    private DatePicker dpFechaExp;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public Button btnRefreshTable;
    @FXML
    public Label lblNameError;
    @FXML
    public TextField fieldFirstName;
    @FXML
    public TextField fieldMiddleName;
    @FXML
    public TextField fieldLastName;
    @FXML
    public TextField fieldStudentID;
    @FXML
    public Button btnNew;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnDelete;

    public Student student;
    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> columnID;

    @FXML
    private TableColumn<Student, String> colFirstName;

    @FXML
    private TableColumn<Student, String> colMiddleName;

    @FXML
    private TableColumn<Student, String> colLastName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showStudents();
    }

    @FXML
    private void showStudents()
    {
        Query query = new Query();
        ObservableList<Student> list = query.getStudentList();
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableView.setItems(list);
    }
    
//    @FXML
//    private void showClientes()
//    {
//        Query query = new Query();
//        ObservableList<Cliente> list = query.getClienteList();
//        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
//        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//        tableView.setItems(list);
//    }
    

    @FXML
    private void addStudentFunction()
    {
        Student student = new Student(Integer.parseInt(fieldStudentID.getText()),fieldFirstName.getText(), fieldMiddleName.getText(),fieldLastName.getText());
        Query query = new Query();
        query.addStudent(student);
        showStudents();

    }
    @FXML
    private void deleteStudent()
    {
        int studentId = Integer.parseInt(fieldStudentID.getText());
        Query query = new Query();
        query.deleteStudent(studentId);
        showStudents();

    }

    @FXML
    private void updateStudentFunction()
    {
        Student student = new Student(Integer.parseInt(fieldStudentID.getText()),fieldFirstName.getText(), fieldMiddleName.getText(),fieldLastName.getText());
        Query query = new Query();
        query.updateStudent(student);
        showStudents();
    }

    @FXML
    private void mouseClicked(MouseEvent e)
    {
        try {
            Student student = (Student) tableView.getSelectionModel().getSelectedItem();
            student = new Student(student.getId(), student.getFirstName(), student.getMiddleName(), student.getLastName());
            this.student = student;
            fieldFirstName.setText(student.getFirstName());
            fieldMiddleName.setText(student.getMiddleName());
            fieldLastName.setText(student.getLastName());
            fieldLastName.setText(student.getLastName());
            fieldStudentID.setText (String.valueOf (student.getId()) );

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



}
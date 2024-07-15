package group.crudgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.*;

import java.net.URL;
import java.time.LocalDate;

import java.util.ResourceBundle;

import javafx.scene.control.DatePicker;


public class BCNController implements Initializable {
    @FXML
    public TextField fieldTransaccionIDTarjeta;
    @FXML
    public Button btnTarjetaDelete;
    @FXML
    public Button btnTarjetaUpdate;
    @FXML
    public Button btnTarjetaRead;
    @FXML
    public Button btnTarjetaSave;
    @FXML
    public TextField fieldTransacionDesc;
    @FXML
    public DatePicker dtpickerTransaccionDate;
    @FXML
    public TextField fieldTransaccionMonto;
    @FXML
    public Button btnTransaccionSave;
    @FXML
    public Button btnTransaccionRead;
    @FXML
    public Button btnTransaccionUpdate;
    @FXML
    public Button btnTransaccionDelete;
    @FXML
    public TableView<Tarjeta> tableViewTarjeta;
    @FXML
    public TableColumn<Tarjeta,Integer> colTarjetaID;
    @FXML
    public TableColumn<Tarjeta,String> colTarjetaNumero;
    @FXML
    public TableColumn<Tarjeta,Date> colTarjetaFechaExp;
    @FXML
    public TableColumn<Tarjeta,Integer> colTarjetaIDtipoTarjeta;
    @FXML
    public TableColumn<Tarjeta,Integer> colTarjetaIDtipoFacilitador;
    @FXML
    public TableColumn<Tarjeta,Integer> colTarjetaIDCliente;
    @FXML
    public TableColumn<Transaccion,Integer> colTransaccionIDCliente;
    @FXML
    public TableColumn<Transaccion,Integer> colTransaccionIDTarjeta;
    @FXML
    public TableColumn<Transaccion,Double> colTransaccionMonto;
    @FXML
    public TableColumn<Transaccion, Date> colTransaccionFecha;
    @FXML
    public TableColumn<Transaccion,String> colTransaccionDescripcion;
    @FXML
    public TableColumn<Transaccion,Integer> colTransaccionID;
    @FXML
    public TableView<Transaccion> tableViewTransaccion;
    @FXML
    public TextField fieldTarjetaIDCliente;
    @FXML
    public TextField fieldTarjetaNumber;
    @FXML
    public DatePicker dtpickerTarjetaExpire;
    @FXML
    public ComboBox<Tarjeta> comboBxTarjetaFacilitador;
    @FXML
    public Button btnClienteDelete;
    @FXML
    public Button btnClienteUpdate;
    @FXML
    public Button btnClienteRead;
    @FXML
    public Button btnClienteSave;
    @FXML
    public TextField fieldClienteTel;
    @FXML
    public TextField fieldClienteID;
    @FXML
    public TextField fieldClienteAddress;
    @FXML
    public TextField fieldClienteName;
    @FXML
    public TableColumn<Cliente, String> colClienteTelefono;
    @FXML
    public TableColumn<Cliente, String> colClienteDireccion;
    @FXML
    public TableColumn<Cliente, String> colClienteNombre;
    @FXML
    public TableColumn<Cliente, Integer> colClienteID;
    @FXML
    public TableView<Cliente> tableViewCliente;
    public TextField fieldTarjetaID;
    public TextField fieldTransaccionID;
    public ToggleGroup Facilitador;
    public ToggleGroup TipoTarjeta;
    public RadioButton rdbtnDebito;
    public RadioButton rdbtnCredito;
    public RadioButton rdbtnAmericanExpress;
    public RadioButton rdbtnMasterCard;
    public RadioButton rdbtnVisa;
    public TextField fieldTransaccionIDCliente;
    public Button btnReporteA;
    public Button btnReporteB;
    public Button btnReporteC;
    public Button btnReporteD;
    public DatePicker dtPickerInicio;
    public DatePicker dtPickerFin;
    public TextField fieldReporteAIDCliente;
    public DatePicker dtPickerAnioReporteB;
    public DatePicker dtPickerMesReporteB;
    public TextField fieldReporteBID_Cliente;
    public TextField fieldReporteCIDCliente;
    public RadioButton rdbtnReporteDVisa;
    public ToggleGroup FacilitadorReporteD;
    public RadioButton rdbtnReporteDMasterCard;
    public RadioButton rdbtnReporteDAmericanExpress;
    public Button btnPageII;
    public Button btnPageI;
    public Button btnStatement;
    public TableView TableViewStatement;
    public TextField fieldStatementID;
    public TableColumn colIDTableViewStatement;
    public TableColumn colNOMBRETableViewStatement;
    public TableColumn colTARJETANOTableViewStatement;
    public TableColumn colDESCRIPTableViewStatement;
    public TableColumn colFacilitadorTableViewStatement;
    @FXML
    private Label welcomeText;
    private Tarjeta tarjeta;
    private Transaccion transaccion;
//    //private ComboBox<Facilitador> facilitador;
//    @FXML
//    private DatePicker dpFechaExp;

    private Stage stage; //Stage para generar la ventana
    private Scene scene; //Escena que carga dentro de la ventana de Stage
    private Parent root; // Almacena todos los Children de la escena



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

    public Cliente cliente;
    public Student student;


    @FXML
    private TableView<StatementRecord> tableView;

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
//      showStudents();
        showClientes();
        showTarjetas();
        showTransacciones();

        colIDTableViewStatement.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNOMBRETableViewStatement.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTarjetaNumero.setCellValueFactory(new PropertyValueFactory<>("numero_tarjeta"));
        colDESCRIPTableViewStatement.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colFacilitadorTableViewStatement.setCellValueFactory(new PropertyValueFactory<>("facilitador"));

    }


//    @FXML
//    private void showStudents()
//    {
//        Query query = new Query();
//        ObservableList<Student> list = query.getStudentList();
//        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
//        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//        tableView.setItems(list);
//    }
    
    @FXML
    private void showClientes()
    {
        Query query = new Query();
        ObservableList<Cliente> list = query.getClienteList();
        colClienteID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colClienteNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colClienteDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colClienteTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        tableViewCliente.setItems(list);
    }

    @FXML
    private void showTransacciones()
    {
        Query query = new Query();
        ObservableList<Transaccion> list = query.getTransaccionList();
        colTransaccionID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTransaccionFecha.setCellValueFactory(new PropertyValueFactory<>("fecha_compra"));
        colTransaccionMonto.setCellValueFactory(new PropertyValueFactory<>("monto_total"));
        colTransaccionDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colTransaccionIDTarjeta.setCellValueFactory(new PropertyValueFactory<>("id_tarjeta"));
        colTransaccionIDCliente.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));

        tableViewTransaccion.setItems(list);
    }

    @FXML
    private void showTarjetas()
    {
        Query query = new Query();
        ObservableList<Tarjeta> list = query.getTarjetaList();
        colTarjetaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        // Usar el CellFactory personalizado para censurar los números de tarjeta

        colTarjetaNumero.setCellFactory(new Callback<TableColumn<Tarjeta, String>, TableCell<Tarjeta, String>>() {
            @Override
            public TableCell<Tarjeta, String> call(TableColumn<Tarjeta, String> param) {
                return new CensurarNumeroTarjetaCell();
            }
        });

//        Query.censurarNumeroTarjeta(colTarjetaNumero.getCellFactory().toString());
//
//
          colTarjetaNumero.setCellValueFactory(new PropertyValueFactory<>("numero_tarjeta"));
//        Query.censurarNumeroTarjeta(colTarjetaNumero.getCellFactory().toString());
//        colTarjetaNumero.setCellValueFactory(Query.censurarNumeroTarjetaTableView(colTarjetaNumero.getCellFactory().toString()));

        colTarjetaIDtipoTarjeta.setCellValueFactory(new PropertyValueFactory<>("id_tipo_tarjeta"));
        colTarjetaFechaExp.setCellValueFactory(new PropertyValueFactory<>("fecha_expiracion"));
        colTarjetaIDtipoFacilitador.setCellValueFactory(new PropertyValueFactory<>("id_facilitador_tarjeta"));
        colTarjetaIDCliente.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));

        tableViewTarjeta.setItems(list);
    }

    public void cambiarEscena(ActionEvent event) {
    }

    public class CensurarNumeroTarjetaCell extends TableCell<Tarjeta, String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
            } else {
                // Censurar el número de tarjeta
                String censoredNumber = "XXXX XXXX XXXX " + item.substring(item.length() - 4);
                setText(censoredNumber);
            }
        }
    }
    

    @FXML
    private void addStudentFunction()
    {
//        Student student = new Student(Integer.parseInt(fieldStudentID.getText()),fieldFirstName.getText(), fieldMiddleName.getText(),fieldLastName.getText());
//        Query query = new Query();
//        query.addStudent(student);
//        showStudents();

    }
    @FXML
    private void deleteStudent()
    {
//        int studentId = Integer.parseInt(fieldStudentID.getText());
//        Query query = new Query();
//        query.deleteStudent(studentId);
//        showStudents();

    }

    @FXML
    private void updateStudentFunction()
    {
//        Student student = new Student(Integer.parseInt(fieldStudentID.getText()),fieldFirstName.getText(), fieldMiddleName.getText(),fieldLastName.getText());
//        Query query = new Query();
//        query.updateStudent(student);
//        showStudents();
    }

    @FXML
    private void mouseClicked(MouseEvent e)
    {
//        try {
//            Student student = (Student) tableView.getSelectionModel().getSelectedItem();
//            student = new Student(student.getId(), student.getFirstName(), student.getMiddleName(), student.getLastName());
//            this.student = student;
//            fieldFirstName.setText(student.getFirstName());
//            fieldMiddleName.setText(student.getMiddleName());
//            fieldLastName.setText(student.getLastName());
//            fieldLastName.setText(student.getLastName());
//            fieldStudentID.setText (String.valueOf (student.getId()) );
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    }

    @FXML
    private void addClienteFunction()
    {
        Cliente cliente = new Cliente(Integer.parseInt(fieldClienteID.getText()),fieldClienteName.getText(), fieldClienteAddress.getText(),fieldClienteTel.getText());
        Query query = new Query();
        query.addCliente(cliente);
        showClientes();

    }
    @FXML
    private void deleteCliente()
    {
        int clienteId = Integer.parseInt(fieldClienteID.getText());
        Query query = new Query();
        query.deleteCliente(clienteId);
        showClientes();

    }

    @FXML
    private void updateClienteFunction()
    {
        Cliente cliente = new Cliente(Integer.parseInt(fieldClienteID.getText()),fieldClienteName.getText(), fieldClienteAddress.getText(),fieldClienteTel.getText());
        Query query = new Query();
        query.updateCliente(cliente);
        showClientes();
    }

    @FXML
    private void mouseClickedCliente(MouseEvent e)
    {
        try {
            Cliente cliente = (Cliente) tableViewCliente.getSelectionModel().getSelectedItem();
            cliente = new Cliente(cliente.getId(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono());
            this.cliente = cliente;
            fieldClienteName.setText(cliente.getNombre());
            fieldClienteAddress.setText(cliente.getDireccion());
            fieldClienteTel.setText(cliente.getTelefono());
            fieldClienteID.setText (String.valueOf (cliente.getId()) );

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    //ps.setDate(2, java.sql.Date.valueOf(fechaExp));
    @FXML
    private void addTarjetaFunction()
    {
        if (  (rdbtnCredito.isSelected() || rdbtnDebito.isSelected() )
                && (rdbtnAmericanExpress.isSelected() || rdbtnVisa.isSelected() || rdbtnMasterCard.isSelected() ) ){

            Tarjeta tarjeta = new Tarjeta();

            LocalDate fecha_expiracion_LocalDate = dtpickerTarjetaExpire.getValue();

            Date fecha_expiracion = Date.valueOf(fecha_expiracion_LocalDate);
            tarjeta.setFecha_expiracion(fecha_expiracion);

            if (rdbtnCredito.isSelected()) {
                tarjeta.setId_tipo_tarjeta(1);

            }else{tarjeta.setId_tipo_tarjeta(2);}

            if (rdbtnVisa.isSelected()) {
                tarjeta.setId_facilitador_tarjeta(1);

            } else if (rdbtnMasterCard.isSelected()) {
                tarjeta.setId_facilitador_tarjeta(2);

            } else if (rdbtnAmericanExpress.isSelected()) {
                tarjeta.setId_facilitador_tarjeta(3);
            }

            tarjeta = new Tarjeta(Integer.parseInt(fieldTarjetaID.getText()), fieldTarjetaNumber.getText(), tarjeta.getId_tipo_tarjeta(), tarjeta.getFecha_expiracion(), tarjeta.getId_facilitador_tarjeta(), Integer.parseInt(fieldTarjetaIDCliente.getText()));
            Query query = new Query();
            query.addTarjeta(tarjeta);
            showTarjetas();

        }else{
            System.out.println("Datos tarjeta imcompletos");
        }

    }

    @FXML
    private void deleteTarjeta()
    {
        int tarjetaId = Integer.parseInt(fieldTarjetaID.getText());
        Query query = new Query();
        query.deleteTarjeta(tarjetaId);
        showTarjetas();

    }

    @FXML
    private void updateTarjetaFunction()
    {
        if (  (rdbtnCredito.isSelected() || rdbtnDebito.isSelected() )
                && (rdbtnAmericanExpress.isSelected() || rdbtnVisa.isSelected() || rdbtnMasterCard.isSelected() ) ) {

            Tarjeta tarjeta = new Tarjeta();

            LocalDate fecha_expiracion_LocalDate = dtpickerTarjetaExpire.getValue();

            Date fecha_expiracion = Date.valueOf(fecha_expiracion_LocalDate);
            tarjeta.setFecha_expiracion(fecha_expiracion);

            if (rdbtnCredito.isSelected()) {
                tarjeta.setId_tipo_tarjeta(1);

            } else {
                tarjeta.setId_tipo_tarjeta(2);
            }

            if (rdbtnVisa.isSelected()) {
                tarjeta.setId_facilitador_tarjeta(1);

            } else if (rdbtnMasterCard.isSelected()) {
                tarjeta.setId_facilitador_tarjeta(2);

            } else if (rdbtnAmericanExpress.isSelected()) {
                tarjeta.setId_facilitador_tarjeta(3);
            }

            tarjeta = new Tarjeta(Integer.parseInt(fieldTarjetaID.getText()), fieldTarjetaNumber.getText(), tarjeta.getId_tipo_tarjeta(), tarjeta.getFecha_expiracion(), tarjeta.getId_facilitador_tarjeta(), Integer.parseInt(fieldTarjetaIDCliente.getText()));

            Query query = new Query();
            query.updateTarjeta(tarjeta);
            showTarjetas();
        }else {
            System.out.println("Datos tarjeta incompletos");
        }


    }

    @FXML
    private void mouseClickedTarjeta(MouseEvent e)
    {
        try {
            Tarjeta tarjeta = (Tarjeta) tableViewTarjeta.getSelectionModel().getSelectedItem();
            tarjeta = new Tarjeta(tarjeta.getId(), tarjeta.getNumero_tarjeta(), tarjeta.getId_tipo_tarjeta(), tarjeta.getFecha_expiracion(), tarjeta.getId_facilitador_tarjeta(),tarjeta.getId_cliente());
            this.tarjeta = tarjeta;
            fieldTarjetaID.setText(String.valueOf (tarjeta.getId()));
            fieldTarjetaNumber.setText(tarjeta.getNumero_tarjeta());
            fieldTarjetaIDCliente.setText(String.valueOf (tarjeta.getId_cliente()));
            dtpickerTarjetaExpire.setValue(tarjeta.getFecha_expiracion().toLocalDate());

            if (tarjeta.getId_tipo_tarjeta() == 1)
            {
                rdbtnCredito.setSelected(true); rdbtnDebito.setSelected(false);
            }else{rdbtnDebito.setSelected(true); rdbtnCredito.setSelected(false);}

            if (tarjeta.getId_facilitador_tarjeta() == 1){
                rdbtnVisa.setSelected(true); rdbtnMasterCard.setSelected(false); rdbtnAmericanExpress.setSelected(false);
            } else if (tarjeta.getId_facilitador_tarjeta() == 2) {
                rdbtnVisa.setSelected(false); rdbtnMasterCard.setSelected(true); rdbtnAmericanExpress.setSelected(false);
            } else if (tarjeta.getId_facilitador_tarjeta() == 3) {
                rdbtnVisa.setSelected(false); rdbtnMasterCard.setSelected(false); rdbtnAmericanExpress.setSelected(true);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    @FXML
    private void addTransaccionFunction()
    {

            Transaccion transaccion = new Transaccion();

            LocalDate fecha_compra_LocalDate = dtpickerTransaccionDate.getValue();

            Date fecha_compra = Date.valueOf(fecha_compra_LocalDate);

            transaccion.setFecha_compra(fecha_compra);

            transaccion = new Transaccion(Integer.parseInt(fieldTransaccionID.getText()), transaccion.getFecha_compra(), Double.parseDouble(fieldTransaccionMonto.getText()), fieldTransacionDesc.getText(), Integer.parseInt(fieldTransaccionIDTarjeta.getText()) , Integer.parseInt(fieldTransaccionIDCliente.getText()));
            Query query = new Query();
            query.addTransaccion(transaccion);
            showTransacciones();


    }

    @FXML
    private void deleteTransaccion()
    {
        int transaccionId = Integer.parseInt(fieldTransaccionID.getText());
        Query query = new Query();
        query.deleteTransaccion(transaccionId);
        showTransacciones();

    }

    @FXML
    private void updateTransaccion()
    {
        Transaccion transaccion = new Transaccion();

        LocalDate fecha_transaccion_localdate = dtpickerTransaccionDate.getValue();

        Date fecha_transaccion = Date.valueOf(fecha_transaccion_localdate);
        transaccion.setFecha_compra(fecha_transaccion);

        transaccion = new Transaccion(Integer.parseInt(fieldTransaccionID.getText()) , transaccion.getFecha_compra(), Double.parseDouble(fieldTransaccionMonto.getText()) , fieldTransacionDesc.getText() , Integer.parseInt(fieldTransaccionIDTarjeta.getText()), Integer.parseInt(fieldTransaccionIDCliente.getText()) );

        Query query = new Query();
        query.updateTransaccion(transaccion);
        showTransacciones();

    }

    @FXML
    private void mouseClickedTransaccion(MouseEvent e)
    {
        try {
            Transaccion transaccion = (Transaccion) tableViewTransaccion.getSelectionModel().getSelectedItem();
            transaccion = new Transaccion( transaccion.getId() , transaccion.getFecha_compra(), transaccion.getMonto_total() , transaccion.getDescripcion(), transaccion.getId_tarjeta(), transaccion.getId_cliente() );
            this.transaccion = transaccion;

            fieldTransaccionID.setText(String.valueOf (transaccion.getId()));
            fieldTransaccionMonto.setText( String.valueOf(transaccion.getMonto_total()) );
            fieldTransaccionIDTarjeta.setText(String.valueOf (transaccion.getId_tarjeta()));
            fieldTransaccionMonto.setText(String.valueOf(transaccion.getMonto_total()));
            fieldTransaccionIDCliente.setText(String.valueOf(transaccion.getId_cliente()));
            fieldTransacionDesc.setText(transaccion.getDescripcion());
            dtpickerTransaccionDate.setValue(transaccion.getFecha_compra().toLocalDate());


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public void reporteA() {
    Query query = new Query();

    LocalDate fecha_inicio_LocalDate = dtPickerInicio.getValue();
    LocalDate fecha_fin_localDate = dtPickerFin.getValue();
    Date fecha_compra_inicio = Date.valueOf(fecha_inicio_LocalDate);
    Date fecha_compra_fin = Date.valueOf(fecha_fin_localDate);

    query.reporteAComprasRealizadas(Integer.parseInt(fieldReporteAIDCliente.getText()), fecha_compra_inicio, fecha_compra_fin);

    }

    public void reporteB()
    {
        Query query = new Query();

        LocalDate fecha = dtPickerMesReporteB.getValue();

        query.reporteBGastosMes(Integer.parseInt(fieldReporteBID_Cliente.getText()) , fecha );
    }

    public void reporteC() throws SQLException {
        Query query = new Query();
        query.reporteCTarjetas(Integer.parseInt(fieldReporteCIDCliente.getText()));
    }

    public void reporteD() throws SQLException
    {
        Query query = new Query();

        String facilitador = "";
        if (rdbtnReporteDVisa.isSelected())
        {
            facilitador = "Visa";
        } else if (rdbtnMasterCard.isSelected()) {
            facilitador = "MasterCard";
        } else if (rdbtnAmericanExpress.isSelected()) {
            facilitador = "American Express";
        }

        query.reporteDgenerarReporteClientesPorFacilitador(facilitador);
    }


    public void statement() throws SQLException {
        Query query = new Query();
        query.generateStatement(Integer.parseInt(fieldStatementID.getText()));

        ObservableList<StatementRecord> list = query.getList();

        colIDTableViewStatement.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNOMBRETableViewStatement.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTARJETANOTableViewStatement.setCellValueFactory(new PropertyValueFactory<>("numeroTarjeta"));
        colDESCRIPTableViewStatement.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colFacilitadorTableViewStatement.setCellValueFactory(new PropertyValueFactory<>("facilitador"));

        TableViewStatement.setItems(list);
    }

}
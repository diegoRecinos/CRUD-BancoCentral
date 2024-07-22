package group.crudgui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class SecondController {


    public TextField fieldStatementIDPageTwo;
    public Button btnPageI;
    public Button btnStatementPageTwo;
    public RadioButton rdbtnStatementAmericanExpressPageTwo;
    public RadioButton rdbtnStatementMasterCardPageTwo;
    public ToggleGroup FacilitadorReporteD1;
    public RadioButton rdbtnStatementVisaPageTwo;
    public TableColumn colFacilitadorTableViewStatementPageTwo;
    public TableColumn colDescripcionTableViewStatementPageTwo;
    public TableColumn colNumeroTableViewStatementPageTwo;
    public TableColumn colNombreTableViewStatementPageTwo;
    public TableColumn colIDTableViewStatementPageTwo;
    public TableView tableViewStatementPageTwo;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(BCNApplication.class.getResource("hello-view.fxml") ) ;
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setTitle("BCN-page-one");
        stage.setMinHeight(700);
        stage.setMinWidth(1400);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();

    }

    public void statement() throws SQLException {
        Query query = new Query();

        if (rdbtnStatementVisaPageTwo.isSelected())
        {
            fieldStatementIDPageTwo.setText("1");
        } else if (rdbtnStatementMasterCardPageTwo.isSelected()) {
            fieldStatementIDPageTwo.setText("2");
        } else if (rdbtnStatementAmericanExpressPageTwo.isSelected()) {
            fieldStatementIDPageTwo.setText("3");
        }

        query.generateStatement(Integer.parseInt(fieldStatementIDPageTwo.getText()));


        ObservableList<StatementRecord> list = query.getList();

        colIDTableViewStatementPageTwo.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreTableViewStatementPageTwo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNumeroTableViewStatementPageTwo.setCellValueFactory(new PropertyValueFactory<>("numeroTarjeta"));
        colDescripcionTableViewStatementPageTwo.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colFacilitadorTableViewStatementPageTwo.setCellValueFactory(new PropertyValueFactory<>("facilitador"));

        tableViewStatementPageTwo.setItems(list);
    }



}

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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class SecondController {

    private Parent root;
    private Stage stage;
    private Scene scene;


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

    @FXML
    protected void onReturnbtn_Click(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("BCN");
//        stage.setMinWidth(900);
//        stage.setMinHeight(700);
        stage.setMinWidth(1200);
        stage.setMinHeight(700);
        stage.setWidth(1200);
        stage.setHeight(700);

        stage.setScene(scene);
        stage.show();
    }


}

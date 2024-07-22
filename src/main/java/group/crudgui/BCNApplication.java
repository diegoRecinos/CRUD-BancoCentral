package group.crudgui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.sql.*;

public class BCNApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BCNApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("BCN");
        stage.setMinWidth(1400);
        stage.setMinHeight(700);

        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) throws SQLException {
        launch();
    }
}
package group.crudgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReportesController
{

    private Media media;
    private MediaPlayer mediaPlayer;

    String audioFilePath = getClass().getResource("/group/crudgui/Sounds/warning.mp3").toString();

    @FXML
    public void submit(ActionEvent event) {

        try
        {
        

        } catch (Exception e)
        {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            // El mensaje de contendra nuestra ventana

            alert.setContentText("Error: " + e.toString());
            // Metodo que bloquea las demas ventanas y espera hasta que el usario interactue con el cuadro de dialogo

            try {
                //String audioFilePath = getClass().getResource("/group/crudgui/Sounds/warning.mp3").toString();
                System.out.println("Audio file path: " + audioFilePath);

                Media media = new Media(audioFilePath);
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();

            } catch (NullPointerException ex) {
                System.err.println("Error: Could not find the audio file. Ensure the path is correct.");
                ex.printStackTrace();
            } catch (Exception exc) {
                System.err.println("An error occurred while trying to play the audio.");
                exc.printStackTrace();
            }

            alert.showAndWait();
        }

    }


}

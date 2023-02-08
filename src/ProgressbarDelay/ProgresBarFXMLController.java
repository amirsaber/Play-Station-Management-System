/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgressbarDelay;

import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class ProgresBarFXMLController implements Initializable {

    public  static Stage Progress = new Stage();
    @FXML
    private JFXProgressBar Pro;

    public void ProgressStart() throws IOException {
        Parent TitleRoot = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Scene TitleScene = new Scene(TitleRoot);

        Progress.setScene(TitleScene);
        Progress.setMaximized(false);
        Progress.setFullScreen(false);
        Progress.setResizable(false);
        Progress.setTitle(" ");

        Progress.getIcons().add(new Image("stopwatch.png"));

        Progress.show();

    }

    public void ProgressClose() {
        Progress.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

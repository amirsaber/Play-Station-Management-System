/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactUsPackage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class ContactUsFXMLController implements Initializable {

    @FXML
    private HBox H1;
    @FXML
    private VBox v1;
    @FXML
    private VBox v2;
    @FXML
    private VBox v3;
    @FXML
    private ToggleButton toogle;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button facebutton;
    @FXML
    private Button messangerbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/TMcompany16/").toURI());
                } catch (IOException | URISyntaxException e1) {
                }
            }
        });
        messangerbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/tec.mang.5").toURI());
                } catch (IOException | URISyntaxException e1) {
                }
            }
        });

        toogle.setOnAction(e -> {

            if (toogle.isSelected()) {
                anchor.setOpacity(1);
               // https://api.whatsapp.com/send?phone=201158860265&text= 
                 try {
                    Desktop.getDesktop().browse(new URL("https://api.whatsapp.com/send?phone=201158860265&text= ").toURI());
                } catch (IOException | URISyntaxException e1) {
                }
            } else {
                anchor.setOpacity(0);
            }

        });
        facebutton.setOnMouseEntered(e -> {
            H1.setCursor(Cursor.HAND);
            v1.setCursor(Cursor.HAND);
            v2.setCursor(Cursor.HAND);
            v3.setCursor(Cursor.HAND);

        });
        messangerbutton.setOnMouseEntered(e -> {
            H1.setCursor(Cursor.HAND);
            v1.setCursor(Cursor.HAND);
            v2.setCursor(Cursor.HAND);
            v3.setCursor(Cursor.HAND);

        });
        toogle.setOnMouseEntered(e -> {
            H1.setCursor(Cursor.HAND);
            v1.setCursor(Cursor.HAND);
            v2.setCursor(Cursor.HAND);
            v3.setCursor(Cursor.HAND);

        });
        toogle.setOnMouseExited(e -> {
            H1.setCursor(Cursor.DEFAULT);
            v1.setCursor(Cursor.DEFAULT);
            v2.setCursor(Cursor.DEFAULT);
            v3.setCursor(Cursor.DEFAULT);

        });
        facebutton.setOnMouseExited(e -> {
            H1.setCursor(Cursor.DEFAULT);
            v1.setCursor(Cursor.DEFAULT);
            v2.setCursor(Cursor.DEFAULT);
            v3.setCursor(Cursor.DEFAULT);

        });
        messangerbutton.setOnMouseExited(e -> {
            H1.setCursor(Cursor.DEFAULT);
            v1.setCursor(Cursor.DEFAULT);
            v2.setCursor(Cursor.DEFAULT);
            v3.setCursor(Cursor.DEFAULT);

        });
    }

}

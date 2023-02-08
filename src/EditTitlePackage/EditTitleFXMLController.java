/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditTitlePackage;

import AlertMaker.AlertMaker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafxapplication11.SqliteConnection;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class EditTitleFXMLController implements Initializable {

    @FXML
    private JFXTextField textf;
    AlertMaker a = new AlertMaker();
   static Stage EditTitle = new Stage();

    Connection conn = SqliteConnection.Connector();

    ResultSet rs;

    PreparedStatement ps;

    public void EditTitleStageMethod() throws IOException {
        Parent TitleRoot = FXMLLoader.load(getClass().getResource("EditTitleFXML.fxml"));

        Scene TitleScene = new Scene(TitleRoot);

        EditTitle.setScene(TitleScene);
        EditTitle.setMaximized(false);
        EditTitle.setFullScreen(false);
EditTitle.setResizable(false);
        EditTitle.setTitle("Edit title");

        EditTitle.getIcons().add(new Image("edit.png"));

        EditTitle.show();

    }

    @FXML
    private void save() throws SQLException {

        if (textf.getText().isEmpty()) {
            a.showErrorMessage("Attention", "Please Enter New Title");

        } else {
            try {
                String query = "Update neww set title=? where nember=1 ";
                ps = conn.prepareStatement(query);

                ps.setString(1, textf.getText());
                 ps.execute();

                ps.close();
             
               a.showSimpleAlert("Ok!", "Title Changed");
               textf.clear();
               EditTitle.close();
            } catch (SQLException e) {
                System.err.println(e);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                ps.close();
            }
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

}

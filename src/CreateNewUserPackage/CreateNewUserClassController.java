/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateNewUserPackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import AlertMaker.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafxapplication11.SqliteConnection;

/**
 *
 * @author Amir
 */
public class CreateNewUserClassController {

    private AlertMaker alert = new AlertMaker();

    @FXML
    TextField CreateNewUserTextField;
    @FXML
    PasswordField CreateNewUserPasswordField;
    @FXML
    private Connection conn = SqliteConnection.Connector();

    @FXML
    private ResultSet rs;
    @FXML
    private PreparedStatement ps;

    @FXML

    public void CreateNewUserAction(ActionEvent event) throws IOException, SQLException {

        //conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        if (CreateNewUserTextField.getText().isEmpty() | CreateNewUserPasswordField.getText().isEmpty()) {

            if (CreateNewUserTextField.getText().isEmpty() && CreateNewUserPasswordField.getText().isEmpty()) {

                // CreateNewUserAlertMissingParts.setContentText(null);
                alert.showSimpleAlert(null, "Please enter user name and password");
            } else if (CreateNewUserTextField.getText().isEmpty()) {
                alert.showSimpleAlert(null, "Please enter user name field");
            } else {
                alert.showSimpleAlert(null, "Please enter Password field");

            }

        } else {

            try {

                String query = "INSERT INTO Users (UserName, Password) VALUES (?,?) ";
                ps = conn.prepareStatement(query);

                ps.setString(1, CreateNewUserTextField.getText());
                ps.setString(2, CreateNewUserPasswordField.getText());
                ps.execute();
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.INFORMATION,
                        "User " + CreateNewUserTextField.getText() + " "
                        + "has been created, Now you can access to program by this account");
                CreateNewUserAlert.setTitle("Create user (" + CreateNewUserTextField.getText() + ") Success! ");
                CreateNewUserAlert.setHeaderText(null);
                CreateNewUserAlert.showAndWait();

                Parent root11 = FXMLLoader.load(getClass().getResource("/CreateNewUserPackage/CreateNewUserFXML.fxml"));

                Scene scene11 = new Scene(root11);

                Stage window11 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window11.close();
                CreateNewUserTextField.clear();
                CreateNewUserPasswordField.clear();

                ps.close();
            } catch (Exception e1) {
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                // CreateNewUserErrorAlert.setTitle("Clinic Manager ");
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText("This User name is already exist Please choose another user name");
                // CreateNewUserErrorAlert.setContentText(e1.getMessage());

                CreateNewUserErrorAlert.showAndWait();
                System.err.println(e1);
                   ps.close();
                    rs.close();

            }

        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

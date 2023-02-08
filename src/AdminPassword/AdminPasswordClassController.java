/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPassword;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import AlertMaker.AlertMaker;
import CreateNewUserPackage.*;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxapplication11.*;
import AdminPassword.AdminPasswordClass;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

/**
 *
 * @author Amir
 */
public class AdminPasswordClassController {

    private CreateNewUserClass CreateNewUserObject = new CreateNewUserClass();
    private AlertMaker alert = new AlertMaker();
    private FXMLDocumentController strings = new FXMLDocumentController();
    AdminPasswordClass SetCount = new AdminPasswordClass();

    @FXML
    PasswordField AminPasswordPasswordField;
    @FXML

    String AdminPasswordString = "a";
    @FXML
    private Label label;
    Connection conn = SqliteConnection.Connector();
    PreparedStatement ps;
    ResultSet rs;

    private void LoadPass() {
        try {

            String query = "select pass from AdminPasswordTable where number =1 ";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                AdminPasswordString = rs.getString(1);
            }

            ps.close();
            rs.close();
        } catch (SQLException e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MainSceneControllerClass.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML

    public void AdminPasswordCheck(ActionEvent event) throws IOException {

        if (AminPasswordPasswordField.getText().isEmpty()) {
            alert.showSimpleAlert("Attention", "Please enter an admin password");
            SetCount.setAdminStageCount(0);
            CreateNewUserObject.setCreateNewUserStagCount(0);
        } else {
            LoadPass();
            if (AminPasswordPasswordField.getText().equals(AdminPasswordString)) {

                System.out.println("Ok");
                System.out.println(strings.getUserNameSave());
                System.out.println(strings.getPasswordSave());

                //    CreateNewUserObject.CreateNewUserStageMethod();
                Parent root11 = FXMLLoader.load(getClass().getResource("/CreateNewUserPackage/CreateNewUserFXML.fxml"));

                Scene scene11 = new Scene(root11);

                Stage window11 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window11.setMaximized(false);
                window11.setFullScreen(false);
                window11.setMaxWidth(570);
                window11.setMaxHeight(340);
                window11.setMinWidth(570);
                window11.setMinHeight(340);

                window11.setScene(scene11);
                window11.setTitle("create new user");

                window11.getIcons().add(new Image("user_group_new.png"));
                AminPasswordPasswordField.clear();
                CreateNewUserObject.setCreateNewUserStagCount(0);

            } else {

                System.out.println("a7a");
                System.out.println(strings.getUserNameSave());
                System.out.println(strings.getPasswordSave());
                alert.showErrorMessage("Attention", "The Admin Password is incorrect");

            }
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

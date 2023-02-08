/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import AdminPassword.*;
import java.io.IOException;
import AlertMaker.*;
import ContactUsPackage.ContactUsStageClass;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Amir
 */
public class FXMLDocumentController implements Initializable {

    public final String AdminPasswordMain = "amir";

    public static String UserNameSave;
    @FXML
    private ImageView image;
    @FXML
    private ImageView AddImg;
    @FXML
    private ImageView DeleteImg;
    @FXML
    private ImageView DatabaseImg;

    @FXML
    private ProgressBar bar;
    @FXML
    private HBox HBOXX2;
    @FXML
    private HBox HBOXX1;

    public String getUserNameSave() {
        return UserNameSave;
    }

    public static String PasswordSave;

    public String getPasswordSave() {
        return PasswordSave;
    }

    private AdminPasswordClass AdminPasswordObject = new AdminPasswordClass();

    private AlertMaker alert = new AlertMaker();

    private boolean checkk = false;

    @FXML
    TextField UserNameLogin;
    @FXML
    PasswordField PasswordLogin;

    private Connection conn = SqliteConnection.Connector();
    private ResultSet rs;
    private PreparedStatement ps;
    @FXML
    private Pane Pane;
    @FXML
    private VBox VBOXX;
    @FXML
    private HBox HBOXX;

///////////////////////
    ///////////////////////
    ///////////////////////
    ///////////////////////
    ///////////////////////
    ////////////// this method for login in login scene
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
        //  SqliteConnection.Connector();
        //conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        if (UserNameLogin.getText().isEmpty() || PasswordLogin.getText().isEmpty()) {

            if (UserNameLogin.getText().isEmpty() && PasswordLogin.getText().isEmpty()) {
                alert.showSimpleAlert("Attention", "Please enter the user name and password");
            } else if (UserNameLogin.getText().isEmpty()) {
                alert.showSimpleAlert("Attention", "Please enter the user name");
            } else {
                alert.showSimpleAlert("Attention", "Please enter the password");
            }
        } else {
            try {

                Timeline task = new Timeline(
                        new KeyFrame(
                                Duration.ZERO,
                                new KeyValue(bar.progressProperty(), 0)
                        ),
                        new KeyFrame(
                                Duration.seconds(2.4),
                                new KeyValue(bar.progressProperty(), 1)
                        )
                );
                alert.showSimpleAlert("Error", "Database connection failed");
                String query = "Select * from Users where UserName=? and Password=?";
                ps = conn.prepareStatement(query);

                ps.setString(1, UserNameLogin.getText());
                ps.setString(2, PasswordLogin.getText());
                rs = ps.executeQuery();

                while (rs.next()) {

                    checkk = true;
                  
                    bar.setOpacity(1);
                    task.play();
                }
                if (checkk == true) {
                    Pane.setCursor(Cursor.WAIT);
                    VBOXX.setCursor(Cursor.WAIT);
                    HBOXX.setCursor(Cursor.WAIT);
                    HBOXX1.setCursor(Cursor.WAIT);
                    HBOXX2.setCursor(Cursor.WAIT);
                    UserNameLogin.setCursor(Cursor.WAIT);
                    PasswordLogin.setCursor(Cursor.WAIT);
                    System.out.println("OK!!");

                //    File source = new File("C:\\ProgramData\\Miicrosoft Ps_Help\\Mydatabase\\Clinic_Manager_DB.db");
                 //   File dest = new File("D:\\TMPSBup\\Psbup.db");
                    // File dest = new File("D:\\TMPSBup\\Clinic_Manager_DB.db");
                    // File dest = new File("F:\\TMPSBup\\Clinic_Manager_DB.db");
                //    try {

                        //     copyFileUsingChannel(source, dest);
               //     } catch (Exception e) {//
               //     }
                    UserNameSave = UserNameLogin.getText();
                    PasswordSave = PasswordLogin.getText();
                    System.out.println(UserNameSave);
                    System.out.println(UserNameLogin.getText());
                    UserNameLogin.clear();
                    PasswordLogin.clear();
                    UserNameLogin.setDisable(true);
                    UserNameLogin.setText("Please Wait...");

                    PauseTransition delay = new PauseTransition(Duration.seconds(2.4));
                    delay.setAutoReverse(true);

                    delay.play();
                    delay.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            try {
                                Parent root1 = FXMLLoader.load(FXMLDocumentController.this.getClass().getResource("MainSceneFXML.fxml"));
                                Scene scene1 = new Scene(root1);
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                                //set Stage boundaries to visible bounds of the main screen

                                window.setX(primaryScreenBounds.getMinX());
                                window.setY(primaryScreenBounds.getMinY());
                                window.setMinWidth(primaryScreenBounds.getWidth());
                                window.setMinHeight(primaryScreenBounds.getHeight());
                                window.setMaxWidth(primaryScreenBounds.getWidth());
                                window.setMaxHeight(primaryScreenBounds.getHeight());
                                window.setScene(scene1);
                                window.setResizable(true);
                                window.setMaximized(true);
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    });

                    //   window.setFullScreen(false);

                    /*      window.setMinWidth(1280);
                            
                            window.setMinHeight(1024);
                            window.setMaxWidth(1280);
                            window.setMaxHeight(1024);
                            window.setMinWidth(1280);*/
                    //    window.setMinWidth(1366);
                    //    window.setMinHeight(768);
                    //    window.setMaxWidth(1366);
                    //   window.setMaxHeight(768);
                    //   window.setMaximized(true);
                    //   window.setX(0);
                    //   window.setY(0);
                }
                if (checkk == false) {
                    alert.showSimpleAlert("Attention", "Username and password did not match to records");

                }
                ps.close();
                rs.close();

            } catch (Exception e1) {

                System.err.println(e1);

                ps.close();
                rs.close();
            }
        }

    }
    /////////////////////////////////
    /////////////////////////////////
    /////////////////////////////////
    ///////////////////////////////// this method for open create new user stage

    @FXML
    public void AddUserHandler() throws IOException {

        System.out.println("Added!!");
        AdminPasswordObject.AdminPasswordStageMethod();
        AdminPasswordObject.setAdminStageCount(0);
    }
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    ////////////////////////////////////// this second choise

    @FXML
    public void DeleteUserHandler() throws IOException {

        System.out.println("Deleted!!");
        File source = new File("C:\\ProgramData\\Miicrosoft Ps_Help\\Mydatabase\\Clinic_Manager_DB.db");
        File dest = new File("E:\\TMPSBup\\Psbup.db");
        //  File dest1 = new File("F:\\TMPSBup\\Clinic_Manager_DB.db");
        try {

            //copyFileUsingChannel(source, dest);
            copyFileUsingChannel(source, dest);
            alert.showSimpleAlert("Success!", "Backup of data was successfully completed");

        } catch (Exception e) {//
            alert.showSimpleAlert("Failed!", e.getMessage() + e.toString());
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    /////////////////////////////// this for contact us
    @FXML
    public void DatabaseHandler() throws IOException {

        ContactUsStageClass s = new ContactUsStageClass();
        s.DrinksDatabaseStageMethod();

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    /////////////////////////////// this for contact us
    @FXML
    public void OpenTMPage() throws IOException {
//https://www.facebook.com/TMcompany16/ page 
//https://www.facebook.com/tec.mang.5  account
        //https://api.whatsapp.com/send?phone=201158860265&text= 
        try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/TMcompany16/").toURI());
        } catch (Exception e) {
        }

    }
//////////////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    /////////////////////////////// this for contact us

    @FXML
    public void MouseEntered() throws IOException {
        Pane.setCursor(Cursor.HAND);
        VBOXX.setCursor(Cursor.HAND);
        HBOXX.setCursor(Cursor.HAND);

    }
//////////////////////////////////////
    ///////////////////////////////
    /////////////////////////////// this for contact us

    @FXML
    public void MouseExit() throws IOException {
        Pane.setCursor(Cursor.DEFAULT);
        VBOXX.setCursor(Cursor.DEFAULT);
        HBOXX.setCursor(Cursor.DEFAULT);

    }
//////////////////////////////////////
//////////////////////////////////////
//////////////////////////////////////
//////////////////////////////////////

    private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}

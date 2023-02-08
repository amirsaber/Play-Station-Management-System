/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsersDatabasePackage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import AlertMaker.AlertMaker;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafxapplication11.*;

/**
 *
 * @author Amir
 */
public class UserDatabaseClassController implements Initializable {
    //MainSceneControllerClass m = new MainSceneControllerClass();

    @FXML
    Connection conn = SqliteConnection.Connector();
    @FXML
    ResultSet rs;
    @FXML
    PreparedStatement ps;
    @FXML
    TableView<UsersClass> table;
    @FXML
    TableColumn<UsersClass, String> UserNameCol;
    @FXML
    TableColumn<UsersClass, String> PasswordCol;
    @FXML
    TableColumn<UsersClass, Float> AmountCol;
    //@FXML
    //TableColumn<UsersClass, String> DetailsCol;
    @FXML
    ListView<String> list;
    @FXML
    TextField usernametextfield;

    @FXML
    TextField passwordtextfield;
    @FXML
    TextField amounttextfield;
    @FXML
    TextArea detailstextarea;
    //////////////////////////////
    //////////////////////////////
    //////////////////////////////
    /////////////////////////////////
    //////////////////////
    final ObservableList<UsersClass> data = FXCollections.observableArrayList();
    final ObservableList<String> options = FXCollections.observableArrayList();
    AlertMaker alert = new AlertMaker();

    int count = 0;
    /////////////////////////////
    /////////////////////////////
    /////////////////////////////
    /////////////////////////////
    /////////////////////////////
    /////////////////////////////
    /////////////////////////////

    @FXML
    private void LoadTable(ActionEvent event) throws SQLException {

        FillListView();
        UserNameCol.setCellValueFactory(new PropertyValueFactory("UserNameProperty"));
        PasswordCol.setCellValueFactory(new PropertyValueFactory("PasswordProperty"));
        AmountCol.setCellValueFactory(new PropertyValueFactory("AmountProperty"));

//		DetailsCol.setCellValueFactory(new PropertyValueFactory("DetailsProperty"));
        //conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        {
            try {

                String query = "Select * from Users";
                ps = conn.prepareStatement(query);

                rs = ps.executeQuery();
                while (rs.next()) {

                    data.add(new UsersClass(rs.getString("UserName"), rs.getString("Password"), rs.getFloat("Amount"),
                            rs.getString("Details")));
                    table.setItems(data);

                }

                ps.close();
                rs.close();
                // table.getColumns().addAll(tid, tfn, tln, te, tg, tmn, tm,
                // tbd, tvd);

            } catch (Exception eViewAllPatient) {
                System.err.println(eViewAllPatient);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                ps.close();
                rs.close();
            }
            usernametextfield.clear();
            passwordtextfield.clear();
            amounttextfield.setText("0");
            detailstextarea.setText("   ");
        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    private void FillListView() throws SQLException {

        //conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        // usernametextfield.setEditable(false);
        for (int i = 0; i < table.getItems().size(); i++) { // to when i back to
            // main menu by back
            // button remove all
            // fields on table
            table.getItems().clear();
        }
        options.clear();

        try {

            String query = "Select UserName from Users";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.setItems(options);
                options.add(rs.getString("UserName"));

            }

            ps.close();
            rs.close();

        } catch (SQLException e) {

            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            ps.close();
            rs.close();
        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void FillFromListview() throws SQLException {

        //	conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            String query = "Select * from Users where UserName = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, (String) list.getSelectionModel().getSelectedItem());

            rs = ps.executeQuery();

            while (rs.next()) {
                usernametextfield.setText(rs.getString("UserName"));
                passwordtextfield.setText(rs.getString("Password"));
                amounttextfield.setText(rs.getString("Amount"));
                detailstextarea.setText(rs.getString("Details"));
                String a = rs.getString("Details");
                System.out.println(a);

            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e);
            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            ps.close();
            rs.close();
        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void AddNewUser() throws SQLException {
        //conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "INSERT INTO Users (UserName, Password, Amount, Details) VALUES (?,?,?,?) ";
            if (usernametextfield.getText().isEmpty() | passwordtextfield.getText().isEmpty()) // to
            // prevent
            // user
            // from
            // input
            // empty
            // user
            // name
            // and
            // password
            {

                if (usernametextfield.getText().isEmpty() && passwordtextfield.getText().isEmpty()) {

                    // CreateNewUserAlertMissingParts.setContentText(null);
                    alert.showSimpleAlert(null, "Please enter user name and password");
                } else if (usernametextfield.getText().isEmpty()) {
                    alert.showSimpleAlert(null, "Please enter user name field");
                } else {
                    alert.showSimpleAlert(null, "Please enter Password field");

                }
            } else {

                ps = conn.prepareStatement(query);

                ps.setString(1, usernametextfield.getText());
                ps.setString(2, passwordtextfield.getText());
                ps.setString(3, amounttextfield.getText());
                ps.setString(4, detailstextarea.getText());

                ps.execute();
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.INFORMATION, "User " + usernametextfield.getText()
                        + " " + "has been created, Now you can access to program by this account");
                CreateNewUserAlert.setTitle("Create user (" + usernametextfield.getText() + ") Success! ");
                CreateNewUserAlert.setHeaderText(null);
                CreateNewUserAlert.showAndWait();

                ps.close();

                usernametextfield.clear();
                passwordtextfield.clear();
                amounttextfield.clear();
                detailstextarea.clear();
                LoadTable(null);

            }
        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText("This User name is already exist Please choose another user name");
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setHeaderText(null);
            a1.setContentText(e1.getMessage());
            a1.showAndWait();
            System.err.println(e1);

            ps.close();

        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void UpdateUser() throws SQLException {
        //	conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Update Users set UserName=?, Password=?, Amount=?, Details=? where UserName='"
                    + usernametextfield.getText() + "'  ";
            if (usernametextfield.getText().isEmpty() | passwordtextfield.getText().isEmpty()) // to
            // password
            {

                if (usernametextfield.getText().isEmpty() && passwordtextfield.getText().isEmpty()) {

                    // CreateNewUserAlertMissingParts.setContentText(null);
                    alert.showSimpleAlert(null, "Please enter user name and password");
                } else if (usernametextfield.getText().isEmpty()) {
                    alert.showSimpleAlert(null, "Please enter user name field");
                } else {
                    alert.showSimpleAlert(null, "Please enter Password field");

                }
            } else {

                ps = conn.prepareStatement(query);

                ps.setString(1, usernametextfield.getText());
                ps.setString(2, passwordtextfield.getText());
                ps.setString(3, amounttextfield.getText());
                ps.setString(4, detailstextarea.getText());

                ps.execute();
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.INFORMATION,
                        "User " + usernametextfield.getText() + " " + "details has been updated");
                CreateNewUserAlert.setTitle("update user (" + usernametextfield.getText() + ") Success! ");
                CreateNewUserAlert.setHeaderText(null);
                CreateNewUserAlert.showAndWait();

                ps.close();
                usernametextfield.clear();
                passwordtextfield.clear();
                amounttextfield.clear();
                detailstextarea.clear();
                LoadTable(null);

            }
        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);

            ps.close();

        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void DeleteUser() throws SQLException {
        //	conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        if (usernametextfield.getText().isEmpty()) {
            alert.showSimpleAlert(null, "Please enter user name of user you want to delete");
        } else {
            Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert.setTitle("Confirmation dialog");
            CreateNewUserAlert.setContentText("Are you sure to delete");
            CreateNewUserAlert.setHeaderText(null);

            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();

            try {
                if (action.get() == ButtonType.OK) {
                    FXMLDocumentController f = new FXMLDocumentController();

                    if (usernametextfield.getText().equals(f.UserNameSave)) {
                        Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                        CreateNewUserErrorAlert.setHeaderText(null);
                        CreateNewUserErrorAlert
                                .setContentText("You can not delete this user because they are logged in");
                        CreateNewUserErrorAlert.showAndWait();

                    } else {
                        String query = "Delete from Users where UserName =?  ";

                        ps = conn.prepareStatement(query);

                        ps.setString(1, usernametextfield.getText());

                        ps.executeUpdate();

                        LoadTable(null);
                    }
                }

                ps.close();

            } catch (Exception e1) {
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e1.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                System.err.println(e1);

                ps.close();

            }

        }
        usernametextfield.clear();
        passwordtextfield.clear();
        amounttextfield.setText("0");
        detailstextarea.setText("   ");
    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void loadfromtable() {
        try {
  if (!table.getSelectionModel().isEmpty()) {
            UsersClass us = (UsersClass) table.getSelectionModel().getSelectedItem();
            String query = "Select * from Users where UserName = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, us.GetUserName());

            rs = ps.executeQuery();

            while (rs.next()) {
                usernametextfield.setText(rs.getString("UserName"));
                passwordtextfield.setText(rs.getString("Password"));
                amounttextfield.setText(rs.getString("Amount"));
                detailstextarea.setText(rs.getString("Details"));
                String a = rs.getString("Details");
                System.out.println(a);

            }}
            ps.close();
            rs.close();

        } catch (Exception e1) {
            System.err.println(e1);
            System.err.println(e1);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ActionEvent event = null;
        // Todo.
        try {
            LoadTable(event);
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setOnMouseClicked(e -> {

            try {
                if (!table.getSelectionModel().isEmpty()) {
                    UsersClass us = (UsersClass) table.getSelectionModel().getSelectedItem();
                    String query = "Select * from Users where UserName = ? ";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, us.GetUserName());

                    rs = ps.executeQuery();

                    while (rs.next()) {
                        usernametextfield.setText(rs.getString("UserName"));
                        passwordtextfield.setText(rs.getString("Password"));
                        amounttextfield.setText(rs.getString("Amount"));
                        detailstextarea.setText(rs.getString("Details"));
                        String a = rs.getString("Details");
                        System.out.println(a);

                    }
                }
                ps.close();
                rs.close();

            } catch (Exception e1) {
                System.err.println(e1);
                System.err.println(e1);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e1.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                try {
                    ps.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });


    }

}

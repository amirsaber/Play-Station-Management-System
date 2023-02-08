/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DevicesDatabasePackage;

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
import javafx.scene.control.TextField;
import AlertMaker.AlertMaker;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ButtonType;
import javafxapplication11.SqliteConnection;

/**
 *
 * @author Amir
 */
public class DevicesDatabaseClassController implements Initializable {

    private Connection conn = SqliteConnection.Connector();
    
    private ResultSet rs;
    private PreparedStatement ps;
    @FXML
    private TableView<DevicesClass> table;
    @FXML
    private TableColumn<DevicesClass, String> NameCol;
    @FXML
    private TableColumn<DevicesClass, String> NameCola;
    @FXML
    private TableColumn<DevicesClass, Float> PriceCol;
    @FXML
    private TableColumn<DevicesClass, Float> QuantityCol;
    @FXML
    private TableColumn<DevicesClass, Float> CountCol;
    @FXML
    private TableColumn<DevicesClass, Float> nCol;
    @FXML
    private ListView<String> list;
    @FXML
    private TextField drinksnametextfield;
    @FXML
    private TextField pricetextfield;
    @FXML
    private TextField quantitytextfield;
    @FXML
    private TextField counttextfield;
    @FXML
    private TextField ntextfield;
    //////////////////////////////
    //////////////////////////////
    //////////////////////////////
    /////////////////////////////////
    //////////////////////
    final ObservableList<DevicesClass> data = FXCollections.observableArrayList();
    final ObservableList<String> options = FXCollections.observableArrayList();
    private AlertMaker alert = new AlertMaker();

    int count = 0;
/////////////////////////////
/////////////////////////////
/////////////////////////////
/////////////////////////////
/////////////////////////////
/////////////////////////////
/////////////////////////////
    @FXML
    private TextField drinksnametextfield1;

    @FXML
    private void LoadTable(ActionEvent event) throws SQLException {

        FillListView();
        NameCol.setCellValueFactory(new PropertyValueFactory<>("NameProperty"));
        NameCola.setCellValueFactory(new PropertyValueFactory<>("Name1Property"));
        PriceCol.setCellValueFactory(new PropertyValueFactory("PriceProperty"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory("QuantityProperty"));
        CountCol.setCellValueFactory(new PropertyValueFactory("CountProperty"));
        nCol.setCellValueFactory(new PropertyValueFactory("MatchProperty"));
        // conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        {
            try {

                String query = "Select PlayStationType , Namee, PerHour, PerMatch, PerHourM, PerMatchM   from Devices";
                ps = conn.prepareStatement(query);

                rs = ps.executeQuery();
                while (rs.next()) {

                    data.add(new DevicesClass(
                            rs.getString("PlayStationType"),
                            rs.getString("Namee"),
                            rs.getFloat("PerHour"),
                            rs.getFloat("PerMatch"),
                            rs.getFloat("PerHourM"),
                            rs.getFloat("PerMatchM")
                    ));
                    table.setItems(data);

                }

                ps.close();
                rs.close();
                //        table.getColumns().addAll(tid, tfn, tln, te, tg, tmn, tm, tbd, tvd);

            } catch (Exception eViewAllPatient) {
                System.err.println(eViewAllPatient);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                ps.close();
                rs.close();
            }
            drinksnametextfield.clear();
            drinksnametextfield1.clear();
            pricetextfield.clear();
            quantitytextfield.clear();
            counttextfield.clear();
            ntextfield.clear();
        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    private void FillListView() throws SQLException {

        //  conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        // usernametextfield.setEditable(false);
        for (int i = 0; i < table.getItems().size(); i++) { // to when i back to main menu by back button remove all fields on table
            table.getItems().clear();
        }
        options.clear();

        try {

            String query = "Select PlayStationType from Devices";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.setItems(options);
                options.add(rs.getString("PlayStationType"));

            }

            ps.close();
            rs.close();

        } catch (SQLException e) {

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
    @FXML
    private void FillFromListview() throws SQLException {

        //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            String query = "Select PlayStationType, PerHour, PerMatch, PerHourM, PerMatchM, Namee  from Devices where PlayStationType = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, (String) list.getSelectionModel().getSelectedItem());

            rs = ps.executeQuery();

            while (rs.next()) {
                drinksnametextfield.setText(rs.getString("PlayStationType"));
                drinksnametextfield1.setText(rs.getString("Namee"));
                pricetextfield.setText(rs.getString("PerHour"));
                quantitytextfield.setText(rs.getString("PerMatch"));
                counttextfield.setText(rs.getString("PerHourM"));
                ntextfield.setText(rs.getString("PerMatchM"));
              

            }
            ps.close();
            rs.close();

        } catch (Exception e) {

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
    private void AddNewUser() throws SQLException {
        //    conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "INSERT INTO Devices (PlayStationType, PerHour, PerMatch, PerHourM , PerMatchM , Namee) VALUES (?,?,?,?,?,?) ";
            if (drinksnametextfield.getText().isEmpty() || pricetextfield.getText().isEmpty()
                    || quantitytextfield.getText().isEmpty()
                    || counttextfield.getText().isEmpty()
                    || ntextfield.getText().isEmpty() // to prevent user from input empty user name and password
                    || drinksnametextfield1.getText().isEmpty()) // to prevent user from input empty user name and password
            {

                if (drinksnametextfield.getText().isEmpty() && pricetextfield.getText().isEmpty() && quantitytextfield.getText().isEmpty()) {

                    //CreateNewUserAlertMissingParts.setContentText(null);
                    alert.showSimpleAlert(null, "Please enter type of device and it's prices");
                } else if (drinksnametextfield.getText().isEmpty()) {
                    alert.showSimpleAlert(null, "Please enter device name field");
                } else {
                    alert.showSimpleAlert(null, "Please enter prices fields");

                }
            } else {

                ps = conn.prepareStatement(query);

                ps.setString(1, drinksnametextfield.getText());
                ps.setString(2, pricetextfield.getText());
                ps.setString(3, quantitytextfield.getText());
                ps.setString(4, counttextfield.getText());
                ps.setString(5, ntextfield.getText());
                ps.setString(6, drinksnametextfield1.getText());

                ps.execute();
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.INFORMATION, "Device " + drinksnametextfield.getText() + " " + "has been added");
                CreateNewUserAlert.setTitle("device (" + drinksnametextfield.getText() + ") added ");
                CreateNewUserAlert.setHeaderText(null);
                CreateNewUserAlert.showAndWait();

                ps.close();
                drinksnametextfield.clear();
                pricetextfield.clear();
                quantitytextfield.clear();
                counttextfield.clear();
                ntextfield.clear();
                LoadTable(null);

            }
        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText("This device is already exist");
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            System.err.println(e1);
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setHeaderText(null);
            a1.setContentText(e1.getMessage());
            a1.showAndWait();
            ps.close();

        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void UpdateUser() throws SQLException {
        //    conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            /*
             rs.getString("PlayStationType"),
             rs.getInt("PerHour"),
             rs.getInt("PerMatch"),
             rs.getInt("HoursCount"),
             rs.getInt("MatchesCount")
             Devices
             */

            String query = "Update Devices set Namee=?, PerHour=?, PerMatch=?, PerHourM=?, PerMatchM=? where PlayStationType='" + drinksnametextfield.getText() + "'  ";
            if (drinksnametextfield1.getText().isEmpty() || pricetextfield.getText().isEmpty()
                    || quantitytextfield.getText().isEmpty()
                    || counttextfield.getText().isEmpty()
                    || ntextfield.getText().isEmpty()) // to prevent user from input empty user name and password // to prevent user from input empty user name and password
            {

                if (drinksnametextfield1.getText().isEmpty() && pricetextfield.getText().isEmpty() && quantitytextfield.getText().isEmpty()) {

                    //CreateNewUserAlertMissingParts.setContentText(null);
                    alert.showSimpleAlert(null, "Please enter device name and its prices");
                } else if (drinksnametextfield1.getText().isEmpty()) {
                    alert.showSimpleAlert(null, "Please enter device name field");
                } else {
                    alert.showSimpleAlert(null, "Please enter prices fields");

                }
            } else {

                ps = conn.prepareStatement(query);

                ps.setString(1, drinksnametextfield1.getText());
                ps.setString(2, pricetextfield.getText());
                ps.setString(3, quantitytextfield.getText());
                ps.setString(4, counttextfield.getText());
                ps.setString(5, ntextfield.getText());

                ps.execute();
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.INFORMATION, "Device " + drinksnametextfield1.getText() + " " + "details has been updated");
                CreateNewUserAlert.setTitle("update device (" + drinksnametextfield1.getText() + ") Success! ");
                CreateNewUserAlert.setHeaderText(null);
                CreateNewUserAlert.showAndWait();

                ps.close();
                drinksnametextfield1.clear();
                drinksnametextfield.clear();
                pricetextfield.clear();
                quantitytextfield.clear();
                counttextfield.clear();
                ntextfield.clear();
                LoadTable(null);

            }
        } catch (Exception e) {
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
    private void DeleteUser() throws SQLException {
        //  conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        if (drinksnametextfield.getText().isEmpty()) {
            alert.showSimpleAlert(null, "Please enter device name of device you want to delete");
        } else {
            Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert.setTitle("Confirmation dialog");
            CreateNewUserAlert.setContentText("Are you sure to delete");
            CreateNewUserAlert.setHeaderText(null);

            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();

            try {
                if (action.get() == ButtonType.OK) {

                    if (drinksnametextfield.getText().equals("ps3i")
                            || drinksnametextfield.getText().equals("ps3ii")
                            || drinksnametextfield.getText().equals("ps3iii")
                            || drinksnametextfield.getText().equals("ps3iv")
                            || drinksnametextfield.getText().equals("ps3v")
                            || drinksnametextfield.getText().equals("ps4i")
                            || drinksnametextfield.getText().equals("ps4i")
                            || drinksnametextfield.getText().equals("ps4ii")) {

                        Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                        CreateNewUserErrorAlert.setHeaderText(null);
                        CreateNewUserErrorAlert
                                .setContentText("You can not delete this device");
                        CreateNewUserErrorAlert.showAndWait();

                    } else {
                        String query = "Delete from Devices where PlayStationType =?  ";

                        ps = conn.prepareStatement(query);

                        ps.setString(1, drinksnametextfield.getText());

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
        drinksnametextfield.clear();
        drinksnametextfield1.clear();
        pricetextfield.clear();
        quantitytextfield.clear();
        counttextfield.clear();
        ntextfield.clear();
    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void loadfromtable(){
    
    
      try {
          
            if (!table.getSelectionModel().isEmpty()) {
          DevicesClass dv = (DevicesClass) table.getSelectionModel().getSelectedItem();
            String query = "Select PlayStationType, PerHour, PerMatch, PerHourM, PerMatchM , Namee  from Devices where PlayStationType = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, dv.GetName());

            rs = ps.executeQuery();

            while (rs.next()) {
                drinksnametextfield.setText(rs.getString("PlayStationType"));
                 drinksnametextfield1.setText(rs.getString("Namee"));
                pricetextfield.setText(rs.getString("PerHour"));
                quantitytextfield.setText(rs.getString("PerMatch"));
                counttextfield.setText(rs.getString("PerHourM"));
                ntextfield.setText(rs.getString("PerMatchM"));
               
                /*
                 rs.getString("PlayStationType"),
                 rs.getInt("PerHour"),
                 rs.getInt("PerMatch"),
                 rs.getInt("HoursCount"),
                 rs.getInt("MatchesCount")
                 */

            }}
            ps.close();
            rs.close();

        } catch (Exception e) {

            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
          try {
              ps.close();
               rs.close();
          } catch (SQLException ex) {
              Logger.getLogger(DevicesDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
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
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ActionEvent event = null;
        try {
            LoadTable(event);
        } catch (SQLException ex) {
            Logger.getLogger(DevicesDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    table.setOnMouseClicked(ee->{
    
      try {
            if (!table.getSelectionModel().isEmpty()) {
          
          DevicesClass dv = (DevicesClass) table.getSelectionModel().getSelectedItem();
            String query = "Select PlayStationType, PerHour, PerMatch, PerHourM, PerMatchM , Namee  from Devices where PlayStationType = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, dv.GetName());

            rs = ps.executeQuery();

            while (rs.next()) {
                drinksnametextfield.setText(rs.getString("PlayStationType"));
                drinksnametextfield1.setText(rs.getString("Namee"));
                pricetextfield.setText(rs.getString("PerHour"));
                quantitytextfield.setText(rs.getString("PerMatch"));
                counttextfield.setText(rs.getString("PerHourM"));
                ntextfield.setText(rs.getString("PerMatchM"));
                /*
                 rs.getString("PlayStationType"),
                 rs.getInt("PerHour"),
                 rs.getInt("PerMatch"),
                 rs.getInt("HoursCount"),
                 rs.getInt("MatchesCount")
                 */

            }
            }
            ps.close();
            rs.close();

        } catch (Exception e) {

            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
          try {
              ps.close();
               rs.close();
          } catch (SQLException ex) {
              Logger.getLogger(DevicesDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
          }
           
        }

    
    
    });
    
    
    
    
    }

}

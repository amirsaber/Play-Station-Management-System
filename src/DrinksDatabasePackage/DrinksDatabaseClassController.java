/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrinksDatabasePackage;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableRow;
import javafxapplication11.SqliteConnection;

/**
 *
 * @author Amir
 */
public class DrinksDatabaseClassController implements Initializable {

    @FXML
    Connection conn = SqliteConnection.Connector();

    @FXML
    ResultSet rs;
    @FXML
    PreparedStatement ps;
    @FXML
    TableView<DrinkesClass> table;
    @FXML
    TableColumn<DrinkesClass, String> NameCol;
    @FXML
    TableColumn<DrinkesClass, Float> PriceCol;
    @FXML
    TableColumn<DrinkesClass, Integer> QuantityCol;
    @FXML
    TableColumn<DrinkesClass, Integer> CountCol;
    @FXML
    ListView<String> list;
    @FXML
    TextField drinksnametextfield;
    @FXML
    TextField pricetextfield;
    @FXML
    TextField quantitytextfield;
    @FXML
    TextField counttextfield;
    //////////////////////////////
    //////////////////////////////
    //////////////////////////////
    /////////////////////////////////
    //////////////////////
    final ObservableList<DrinkesClass> data = FXCollections.observableArrayList();
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
    private void LoadTable(ActionEvent event) throws SQLException {

        FillListView();
        NameCol.setCellValueFactory(new PropertyValueFactory("NameProperty"));
        PriceCol.setCellValueFactory(new PropertyValueFactory("PriceProperty"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory("QuantityProperty"));
        CountCol.setCellValueFactory(new PropertyValueFactory("CountProperty"));
        //conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        {
            try {

                String query = "Select * from Drinks";
                ps = conn.prepareStatement(query);

                rs = ps.executeQuery();
                while (rs.next()) {

                    data.add(new DrinkesClass(rs.getString("Name"), rs.getFloat("Price"), rs.getInt("Quantity"),
                            rs.getInt("Count")));
                    table.setItems(data);

                }

                ps.close();
                rs.close();
                // table.getColumns().addAll(tid, tfn, tln, te, tg, tmn, tm,
                // tbd, tvd);

            } catch (Exception e) {
                System.err.println(e);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                ps.close();
                rs.close();
            }
            drinksnametextfield.clear();
            pricetextfield.clear();
            quantitytextfield.setText("0");
            counttextfield.setText("0");
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

            String query = "Select Name from Drinks";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.setItems(options);
                options.add(rs.getString("Name"));

            }

            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e);
            ps.close();
            rs.close();
        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void FillFromListview() throws SQLException {

        //conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            String query = "Select * from Drinks where Name = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, (String) list.getSelectionModel().getSelectedItem());

            rs = ps.executeQuery();

            while (rs.next()) {
                drinksnametextfield.setText(rs.getString("Name"));
                pricetextfield.setText(rs.getString("Price"));
                quantitytextfield.setText(rs.getString("Quantity"));
                counttextfield.setText(rs.getString("Count"));

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
        //	conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "INSERT INTO Drinks (Name, Price, Quantity, Count) VALUES (?,?,?,?) ";
            if (drinksnametextfield.getText().isEmpty() | pricetextfield.getText().isEmpty()) // to
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

                if (drinksnametextfield.getText().isEmpty() && pricetextfield.getText().isEmpty()) {

                    // CreateNewUserAlertMissingParts.setContentText(null);
                    alert.showSimpleAlert(null, "Please enter name of drink and it's price");
                } else if (drinksnametextfield.getText().isEmpty()) {
                    alert.showSimpleAlert(null, "Please enter drink name field");
                } else {
                    alert.showSimpleAlert(null, "Please enter price field");

                }
            } else {

                ps = conn.prepareStatement(query);

                ps.setString(1, drinksnametextfield.getText());
                ps.setString(2, pricetextfield.getText());
                ps.setString(3, quantitytextfield.getText());
                ps.setString(4, counttextfield.getText());

                ps.execute();
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.INFORMATION,
                        "Drink " + drinksnametextfield.getText() + " " + "has been created");
                CreateNewUserAlert.setTitle("drink (" + drinksnametextfield.getText() + ") added ");
                CreateNewUserAlert.setHeaderText(null);
                CreateNewUserAlert.showAndWait();

                ps.close();
                drinksnametextfield.clear();
                pricetextfield.clear();
                quantitytextfield.clear();
                counttextfield.clear();
                LoadTable(null);

            }
        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText("This drink is already exist");
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            System.err.println(e1);
            Alert aa = new Alert(Alert.AlertType.ERROR);
            aa.setHeaderText(null);
            aa.setContentText(e1.getMessage());
            aa.showAndWait();
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

            String query = "Update Drinks set Name=?, Price=?, Quantity=?, Count=? where Name='"
                    + drinksnametextfield.getText() + "'  ";
            if (drinksnametextfield.getText().isEmpty() | pricetextfield.getText().isEmpty()) // to
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

                if (drinksnametextfield.getText().isEmpty() && pricetextfield.getText().isEmpty()) {

                    // CreateNewUserAlertMissingParts.setContentText(null);
                    alert.showSimpleAlert(null, "Please enter drink name and price");
                } else if (drinksnametextfield.getText().isEmpty()) {
                    alert.showSimpleAlert(null, "Please enter drink name field");
                } else {
                    alert.showSimpleAlert(null, "Please enter price field");

                }
            } else {

                ps = conn.prepareStatement(query);

                ps.setString(1, drinksnametextfield.getText());
                ps.setString(2, pricetextfield.getText());
                ps.setString(3, quantitytextfield.getText());
                ps.setString(4, counttextfield.getText());
                ps.execute();
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.INFORMATION,
                        "Drink " + drinksnametextfield.getText() + " " + "details has been updated");
                CreateNewUserAlert.setTitle("update drink (" + drinksnametextfield.getText() + ") Success! ");
                CreateNewUserAlert.setHeaderText(null);
                CreateNewUserAlert.showAndWait();

                ps.close();
                drinksnametextfield.clear();
                pricetextfield.clear();
                quantitytextfield.clear();
                counttextfield.clear();
                LoadTable(null);

            }
        } catch (Exception e) {
            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            ps.close();

        }

    }

    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void DeleteUser() throws SQLException {
        //conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        if (drinksnametextfield.getText().isEmpty()) {
            alert.showSimpleAlert(null, "Please enter drink name of drink you want to delete");
        } else {
            Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert.setTitle("Confirmation dialog");
            CreateNewUserAlert.setContentText("Are you sure to delete");
            CreateNewUserAlert.setHeaderText(null);

            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();

            try {
                if (action.get() == ButtonType.OK) {

                    String query = "Delete from Drinks where Name =?  ";

                    ps = conn.prepareStatement(query);

                    ps.setString(1, drinksnametextfield.getText());

                    ps.executeUpdate();

                    LoadTable(null);

                }
                ps.close();
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
        drinksnametextfield.clear();
        pricetextfield.clear();
        quantitytextfield.setText("0");
        counttextfield.setText("0");
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
            DrinkesClass dr = (DrinkesClass) table.getSelectionModel().getSelectedItem();
            String query = "Select * from Drinks where Name = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, dr.GetName());

            rs = ps.executeQuery();

            while (rs.next()) {
                drinksnametextfield.setText(rs.getString("Name"));
                pricetextfield.setText(rs.getString("Price"));
                quantitytextfield.setText(rs.getString("Quantity"));
                counttextfield.setText(rs.getString("Count"));

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
                Logger.getLogger(DrinksDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            LoadTable(event);
        } catch (SQLException ex) {
            Logger.getLogger(DrinksDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setOnMouseClicked(ee
                -> {

            try {
  if (!table.getSelectionModel().isEmpty()) {
                DrinkesClass dr = (DrinkesClass) table.getSelectionModel().getSelectedItem();
                String query = "Select * from Drinks where Name = ? ";
                ps = conn.prepareStatement(query);
                ps.setString(1, dr.GetName());

                rs = ps.executeQuery();

                while (rs.next()) {
                    drinksnametextfield.setText(rs.getString("Name"));
                    pricetextfield.setText(rs.getString("Price"));
                    quantitytextfield.setText(rs.getString("Quantity"));
                    counttextfield.setText(rs.getString("Count"));

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
                    Logger.getLogger(DrinksDatabaseClassController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
  String a = "";
        List<String> columnData = new ArrayList<>();
        for (DrinkesClass item : table.getItems()) {
            columnData.add(NameCol.getCellObservableValue(item).getValue());
          
            a+=NameCol.getCellObservableValue(item).getValue()+"\n";
        }
        System.out.println(a);
      //  String row = table.getRowFactory(0).toString();
      //  System.out.println(row);
    }

}

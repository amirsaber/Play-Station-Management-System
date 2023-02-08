/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrdersPackage;

import AlertMaker.AlertMaker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafxapplication11.SqliteConnection;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class OrdersEditFXMLController implements Initializable {
    
    @FXML
    private JFXTextField OrderNumberTextField;
    @FXML
    private JFXTextField PriceTextField;
    @FXML
    private JFXTextField CashierTextField;
    @FXML
    private JFXTextField DetailsTextField;
    @FXML
    private TableColumn<OrdersEditClass, String> NumberCol;
    @FXML
    private TableColumn<OrdersEditClass, String> CashierCol;
    @FXML
    private TableColumn<OrdersEditClass, String> PriceCol;
    @FXML
    private TableColumn<OrdersEditClass, String> DetilsCol;
    @FXML
    private TableColumn<OrdersEditClass, String> StartCol;
    @FXML
    private TableColumn<OrdersEditClass, String> EndCol;
    @FXML
    private TableView<OrdersEditClass> table;
    
    Connection conn = SqliteConnection.Connector();
    ResultSet rs;
    PreparedStatement ps;
    final ObservableList<OrdersEditClass> data = FXCollections.observableArrayList();
    final ObservableList<String> options = FXCollections.observableArrayList();
    static String OrderPriceSave;
    static String CashSave;
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    @FXML
    private JFXComboBox<String> DrinksCombobox;
    @FXML
    private JFXTextField drinksquantity;
    
    private void LoadTable() {
        for (int i = 0; i < table.getItems().size(); i++) {
            table.getItems().clear();
        }
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        CashierCol.setCellValueFactory(new PropertyValueFactory<>("cashier"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        DetilsCol.setCellValueFactory(new PropertyValueFactory<>("details"));
        StartCol.setCellValueFactory(new PropertyValueFactory<>("starttime"));
        EndCol.setCellValueFactory(new PropertyValueFactory<>("endtime"));
        
        try {
            
            String query = "SELECT *  FROM Orders ";
            
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                data.add(new OrdersEditClass(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getString(6)
                ));
                
                table.setItems(data);
                
            }
            
            ps.close();
            rs.close();
            
        } catch (Exception eViewAllPatient) {
            System.err.println(eViewAllPatient);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    static Stage ReportsStage = new Stage();
    
    public void StageMethod() throws IOException {
        
        Parent ReportsRoot = FXMLLoader.load(getClass().getResource("OrdersEditFXML.fxml"));
        
        Scene ReportsScene = new Scene(ReportsRoot);
        ReportsStage.setScene(ReportsScene);
        ReportsStage.setMaximized(false);
        ReportsStage.setFullScreen(false);
        ReportsStage.setResizable(false);
        ReportsStage.setTitle("Orders");
        
        ReportsStage.getIcons().add(new Image("order.png"));
        
        ReportsStage.showAndWait();
        
    }
    ///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void loadfromtable() {
        
        try {
            if (!table.getSelectionModel().isEmpty()) {
                OrdersEditClass dr = (OrdersEditClass) table.getSelectionModel().getSelectedItem();
                String query = "Select * from Orders where Number = ? ";
                ps = conn.prepareStatement(query);
                ps.setString(1, dr.getNumber());
                
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    OrderNumberTextField.setText(rs.getString("Number"));
                    PriceTextField.setText(rs.getString("OrderPrice"));
                    OrderPriceSave = (rs.getString("OrderPrice"));
                    CashierTextField.setText(rs.getString("Cashier"));
                    DetailsTextField.setText(rs.getString("OrderAllNumber"));
                    
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
                
            }
            
        }
    }
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

    private float getcash() {
        
        float cashfloat = 0;
        String cashiername = CashierTextField.getText();
        
        try {
            
            String query = "SELECT Amount  FROM Users where UserName ='" + cashiername + "' ";
            
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                cashfloat = Float.parseFloat(rs.getString(1));
                
            }
            
            ps.close();
            rs.close();
            
        } catch (Exception eViewAllPatient) {
            System.err.println(eViewAllPatient);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return cashfloat;
    }
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

    private void UpdateOrdersAll() {
        String query = "Update OrdersAll set PriceAll=? where NumberAll='"
                + DetailsTextField.getText() + "'  ";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setString(1, PriceTextField.getText());
            ps.execute();
            
            ps.close();
            
        } catch (SQLException e) {
            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    ///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    private void updateCash() {
        
        float cashierCash = getcash();
        float lastPrice = Float.parseFloat(OrderPriceSave);
        float newPrice = Float.parseFloat(PriceTextField.getText());
        
        cashierCash = cashierCash - (lastPrice - newPrice);
        String query = "Update Users set Amount=? where UserName='"
                + CashierTextField.getText() + "'  ";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setFloat(1, cashierCash);
            ps.execute();
            
            ps.close();
            
        } catch (Exception e) {
            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void UpdateOrders() {
        
        if (OrderNumberTextField.getText().isEmpty() || PriceTextField.getText().isEmpty()) {
            AlertMaker a = new AlertMaker();
            a.showSimpleAlert("Attention", "من  فضلك املا كل الخانات المطلوبه");
            
        } else {
            String query = "Update Orders set OrderPrice=? where Number='"
                    + OrderNumberTextField.getText() + "'  ";
            
            try {
                
                ps = conn.prepareStatement(query);
                ps.setString(1, PriceTextField.getText());
                ps.execute();
                
                ps.close();
                UpdateOrdersAll();
                LoadTable();
                updateCash();
                OrderNumberTextField.clear();
                PriceTextField.clear();
                CashierTextField.clear();
                DetailsTextField.clear();
                AlertMaker a = new AlertMaker();
                a.showSimpleAlert("Success", "Order details has been successfully updated");
            } catch (Exception e) {
                System.err.println(e);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    private void DeleteOrdersAll() {
        String query = " Delete from OrdersAll where NumberAll =?  ";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setString(1, DetailsTextField.getText());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    ///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    private void deleteCash() {
        
        float cashierCash = getcash();
        
        float newPrice = Float.parseFloat(PriceTextField.getText());
        
        cashierCash = cashierCash - newPrice;
        String query = "Update Users set Amount=? where UserName='"
                + CashierTextField.getText() + "'  ";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setFloat(1, cashierCash);
            ps.execute();
            
            ps.close();
            
        } catch (Exception e) {
            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void DeleteOrders() {
        
        if (OrderNumberTextField.getText().isEmpty() || PriceTextField.getText().isEmpty()) {
            AlertMaker a = new AlertMaker();
            a.showSimpleAlert("Attention", "من  فضلك املا كل الخانات المطلوبه");
            
        } else {
            String query = "Delete from Orders where Number =? ";
            Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert.setTitle("Confirmation dialog");
            CreateNewUserAlert.setContentText("Are you sure to delete this order");
            CreateNewUserAlert.setHeaderText(null);
            
            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
            try {
                if (action.get() == ButtonType.OK) {
                    ps = conn.prepareStatement(query);
                    ps.setString(1, OrderNumberTextField.getText());
                    ps.executeUpdate();
                    
                    ps.close();
                    DeleteOrdersAll();
                    LoadTable();
                    deleteCash();
                    OrderNumberTextField.clear();
                    PriceTextField.clear();
                    CashierTextField.clear();
                    DetailsTextField.clear();
                    AlertMaker a = new AlertMaker();
                    a.showSimpleAlert("Success", "Delete Order success");
                }
            } catch (Exception e) {
                System.err.println(e);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void FillLCombobox() throws SQLException {
        
        options.clear();
        
        try {
            
            String query = "Select Name from Drinks";
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                DrinksCombobox.setItems(options);
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
            ps.close();
            rs.close();
        }
        
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////
    private int getQuantity() {
        String drink = DrinksCombobox.getValue().toString();
        
        int res = 0;
        try {
            
            String query = "Select Quantity from Drinks where Name = '" + drink + "' ";
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                res = rs.getInt(1);
                
            }
            
            ps.close();
            rs.close();
            
        } catch (SQLException e) {
            
            System.err.println(e);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                
            }
            
        }
        return res;
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    @FXML
    private void returnDrink() {
        
        AlertMaker a = new AlertMaker();
        if (DrinksCombobox.getSelectionModel().isEmpty() || drinksquantity.getText().isEmpty()) {
            
            a.showErrorMessage("Attention", "Please fill out all fields");
        } else {
            try {
                String drink = DrinksCombobox.getValue().toString();
                int exist = getQuantity();
                int added = Integer.parseInt(drinksquantity.getText());
                added += exist;
                String query = "Update Drinks set Quantity=? where Name='"
                        + drink + "'  ";
                ps = conn.prepareStatement(query);
                ps.setInt(1, added);
                ps.execute();
                
                ps.close();
                a.showSimpleAlert("Success", "The specified quantity of the drink was retrieved to the store");
                drinksquantity.clear();
                DrinksCombobox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.err.println(e);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrdersEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
    }
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadTable();
        try {
            FillLCombobox();
        } catch (SQLException ex) {
            
        }
        drinksquantity.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                drinksquantity.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        PriceTextField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                PriceTextField.setText(newValue.replaceAll("[^\\d]", "."));
            }
        });
    }
    
}

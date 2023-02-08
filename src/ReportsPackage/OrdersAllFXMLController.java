/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportsPackage;

import AlertMaker.AlertMaker;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafxapplication11.SqliteConnection;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class OrdersAllFXMLController implements Initializable {
    
    @FXML
    private DatePicker FromDatePicker;
    @FXML
    private DatePicker ToDatePicker;
    @FXML
    private ComboBox<String> UsersCombobox;
    @FXML
    private Text SumTotal;
    @FXML
    private Text CountTotal;
    @FXML
    TableView<OrdersClass> tableOrders;
    @FXML
    TableColumn<OrdersClass, String> OrderNumberCol;
    @FXML
    TableColumn<OrdersClass, String> CashierCol;
    @FXML
    TableColumn<OrdersClass, String> OrderPriceCol;
    @FXML
    TableColumn<OrdersClass, String> TableCol;
    @FXML
    TableColumn<OrdersClass, String> DateCol;
    @FXML
    TableColumn<OrdersClass, String> TimeCol;
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
    @FXML
    Connection conn = SqliteConnection.Connector();
    @FXML
    ResultSet rs;
    @FXML
    PreparedStatement ps;
    final ObservableList<OrdersClass> data = FXCollections.observableArrayList();
    final ObservableList<String> options = FXCollections.observableArrayList();
    Text CashierNameIndicator = new Text(" ");
    Text OrderIndicator = new Text(" ");
    private AlertMaker alert = new AlertMaker();
    
    float sum = 0;
    int count = 0;
    int bn = 0;
    public String query;
    String sasa = "All Users";

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void FillLCombobox() throws SQLException {
        
        options.clear();
        
        try {
            
            String query = "Select UserName from Users";
            ps = conn.prepareStatement(query);
            options.add("All Cashiers");
            
            rs = ps.executeQuery();
            while (rs.next()) {
                UsersCombobox.setItems(options);
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

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    @FXML
    private void FillFromListview() throws SQLException {
        
        CashierNameIndicator.setText((String) UsersCombobox.getSelectionModel().getSelectedItem());
        
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    @FXML
    public void CashierChoise() {
        OrderIndicator.setText("CashierAll");
        //     SumTotal.setText("CashierAll");
    }

    ///////////////////////////////////
    ///////////////////////////////////
    @FXML
    public void OrderChoise() {
        OrderIndicator.setText("PriceAll");
        //   SumTotal.setText("PriceAll");
    }

    ///////////////////////////////////
    ///////////////////////////////////
    @FXML
    public void TableChoise() {
        OrderIndicator.setText("TableAll");
        //   SumTotal.setText("TableAll");
    }

    ///////////////////////////////////
    ///////////////////////////////////
    @FXML
    public void DateChoise() {
        OrderIndicator.setText("DateAll");
        //   SumTotal.setText("DateAll");
    }

    ///////////////////////////////////
    ///////////////////////////////////
    @FXML
    public void TimeChoise() {
        OrderIndicator.setText("TimeAll");
        //  SumTotal.setText("TimeAll");
    }
    ///////////////////////////////////
    ///////////////////////////////////

    @FXML
    public void LoadTable() throws SQLException {
        
        OrderNumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        CashierCol.setCellValueFactory(new PropertyValueFactory<>("cashier"));
        OrderPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableCol.setCellValueFactory(new PropertyValueFactory<>("tablee"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        sum = 0;
        count = 0;
        
        if (((TextField) ToDatePicker.getEditor()).getText().isEmpty()
                || ((TextField) FromDatePicker.getEditor()).getText().isEmpty()
                || OrderIndicator.getText().equals(" ")
                /*|| CashierNameIndicator.getText().equals(" ")*/) {
            
            alert.showErrorMessage("Attention", "You must select all choices");
            
        } else {
            
            for (int i = 0; i < tableOrders.getItems().size(); i++) {
                tableOrders.getItems().clear();
            }
            DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String From = FromDatePicker.getValue().format(myFormat);
            String To = ToDatePicker.getValue().format(myFormat);
            
            try {
                
                int index;
                index = UsersCombobox.getSelectionModel().getSelectedIndex();
                String sdt = UsersCombobox.getValue();
                if (index == 0 ) {
                    
                    query = "SELECT *  FROM    OrdersAll where DateAll >= '" + From + "' and DateAll <= '" + To + "' "
                            + "order by " + OrderIndicator.getText() + " ";
                    
                } else {
                    
                    query = "SELECT *  FROM    OrdersAll where DateAll >= '" + From + "' and DateAll <= '" + To + "' "
                            + "and CashierAll = '" + CashierNameIndicator.getText() + "' "
                            + "order by " + OrderIndicator.getText() + " ";
                }
                
                ps = conn.prepareStatement(query);
                
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    
                    data.add(new OrdersClass(
                            rs.getString("NumberAll"),
                            rs.getString("CashierAll"),
                            rs.getString("PriceAll"),
                            rs.getString("TableAll"),
                            rs.getString("Date"),
                            rs.getString("TimeAll")
                    ));
                    
                    tableOrders.setItems(data);
                    float c = Float.parseFloat(rs.getString(3));
                    sum += c;
                    count++;
                    
                }
                
                SumTotal.setText(Float.toString(sum));
                CountTotal.setText(Integer.toString(count));
                ps.close();
                rs.close();
                
            } catch (Exception eViewAllPatient) {
                System.err.println(eViewAllPatient);
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                ps.close();
                rs.close();
                
            }
            
        }
        
    }
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FromDatePicker.setValue(LocalDate.now());
        ToDatePicker.setValue(LocalDate.now());
        //NumberAll.
        OrderIndicator.setText("NumberAll");
        try {
            FillLCombobox();
              UsersCombobox.getSelectionModel().select(0);
        } catch (SQLException ex) {
            Logger.getLogger(OrdersAllFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
}

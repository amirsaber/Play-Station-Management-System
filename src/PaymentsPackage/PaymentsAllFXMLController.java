/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentsPackage;

import AlertMaker.AlertMaker;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafxapplication11.SqliteConnection;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class PaymentsAllFXMLController implements Initializable {

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
    TableView<PaymentsClass> tableOrders;
    @FXML
    TableColumn<PaymentsClass, String> OrderNumberCol;
    @FXML
    TableColumn<PaymentsClass, String> CashierCol;
    @FXML
    TableColumn<PaymentsClass, String> OrderPriceCol;
    @FXML
    TableColumn<PaymentsClass, String> TableCol;
    @FXML
    TableColumn<PaymentsClass, String> DateCol;
    @FXML
    TableColumn<PaymentsClass, String> TimeCol;
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
    Connection conn = SqliteConnection.Connector();
    ResultSet rs;
    PreparedStatement ps;
    final ObservableList<PaymentsClass> data = FXCollections.observableArrayList();
    final ObservableList<String> options = FXCollections.observableArrayList();
    Text CashierNameIndicator = new Text(" ");
    Text OrderIndicator = new Text(" ");
    private AlertMaker alert = new AlertMaker();

    float sum = 0;
    int count = 0;
    int bn = 0;
    public String query;
    String sasa = "All Users";
    @FXML
    private ComboBox<String> TypeCombobox;
    public static String selectTypeString;

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    public void StageMethod() throws IOException {
        Stage ReportsStage = new Stage();
        Parent ReportsRoot = FXMLLoader.load(getClass().getResource("PaymentsAllFXML.fxml"));

        Scene ReportsScene = new Scene(ReportsRoot);
        ReportsStage.setScene(ReportsScene);
        ReportsStage.setMaximized(false);
        ReportsStage.setFullScreen(false);
ReportsStage.setResizable(false);
        ReportsStage.setTitle("Payments");

        ReportsStage.getIcons().add(new Image("get-money.png"));

        ReportsStage.showAndWait();

    }
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
                || OrderIndicator.getText().equals(" ") /*|| CashierNameIndicator.getText().equals(" ")*/) {

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
                if (index == 0) {
                    int index1;
                    index1 = TypeCombobox.getSelectionModel().getSelectedIndex();
                    if (index1 == 0) {
                        query = "SELECT *  FROM    Payments where date >= '" + From + "' and date <= '" + To + "' "
                                + "order by " + OrderIndicator.getText() + " ";
                    } else {
                        query = "SELECT *  FROM    Payments where date >= '" + From + "' and date <= '" + To + "' "
                                + "and type ='" + selectTypeString + "' "
                                + "order by " + OrderIndicator.getText() + " ";
                    }

                } else {
                    int index1;
                    index1 = TypeCombobox.getSelectionModel().getSelectedIndex();
                    if (index1 == 0) {
                        query = "SELECT *  FROM    Payments where date >= '" + From + "' and date <= '" + To + "' "
                                + "and cashier = '" + CashierNameIndicator.getText() + "' "
                                + "order by " + OrderIndicator.getText() + " ";
                    } else {
                        query = "SELECT *  FROM    Payments where date >= '" + From + "' and date <= '" + To + "' "
                                + "and cashier = '" + CashierNameIndicator.getText() + "' "
                                + "and type ='" + selectTypeString + "' "
                                + "order by " + OrderIndicator.getText() + " ";
                    }

                }

                ps = conn.prepareStatement(query);

                rs = ps.executeQuery();

                while (rs.next()) {

                    data.add(new PaymentsClass(
                            rs.getString("PaymentId"),
                            rs.getString("cashier"),
                            rs.getString("description"),
                            rs.getString("amount"),
                            rs.getString("date"),
                            rs.getString("time")
                    ));

                    tableOrders.setItems(data);
                    float c = Float.parseFloat(rs.getString(4));
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
        OrderIndicator.setText("PaymentId");
        try {
            FillLCombobox();
            UsersCombobox.getSelectionModel().select(0);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsAllFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TypeCombobox.getItems().addAll(
                "كل المصاريف",
                "مصاريف خاصه بالمحل",
                "مصاريف خاصه بالكاشير"
        );
           TypeCombobox.getSelectionModel().select(0);
        TypeCombobox.setOnAction(e -> {

            if (TypeCombobox.getValue().equals("مصاريف خاصه بالمحل")) {
                selectTypeString = "1";
            }

            if (TypeCombobox.getValue().equals("مصاريف خاصه بالكاشير")) {
                selectTypeString = "2";
                System.out.println(selectTypeString);
            }

        });

    }

}

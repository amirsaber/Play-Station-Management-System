/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HistoryPackage;

import AlertMaker.AlertMaker;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class HistoryFXMLController implements Initializable {
    
    @FXML
    private JFXDatePicker historydate;
    @FXML
    private JFXTimePicker from;
    @FXML
    private JFXTimePicker to;
    @FXML
    private Text SumTotal;
    @FXML
    private Text CountTotal;
    @FXML
    private TableView<HistoryClass> table;
    @FXML
    private TableColumn<HistoryClass, String> process;
    @FXML
    private TableColumn<HistoryClass, String> number;
    @FXML
    private TableColumn<HistoryClass, String> price;
    @FXML
    private TableColumn<HistoryClass, String> device;
    @FXML
    private TableColumn<HistoryClass, String> cashier;
    @FXML
    private TableColumn<HistoryClass, String> date;
    @FXML
    private TableColumn<HistoryClass, String> time;
//////////////////////////////////////////////////
//////////////////////////////////////////////////
    Connection conn = SqliteConnection.Connector();
    ResultSet rs;
    PreparedStatement ps;
    final ObservableList<HistoryClass> data = FXCollections.observableArrayList();
    
    private AlertMaker alert = new AlertMaker();
    
    float sum = 0;
    int count = 0;
    
    public String query;

    ///////////////////////////////////
    ///////////////////////////////////
    @FXML
    public void LoadTable() throws SQLException {
        
        process.setCellValueFactory(new PropertyValueFactory<>("process"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        device.setCellValueFactory(new PropertyValueFactory<>("tablee"));
        cashier.setCellValueFactory(new PropertyValueFactory<>("cashier"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        sum = 0;
        count = 0;
        
        for (int i = 0; i < table.getItems().size(); i++) {
            table.getItems().clear();
        }
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm");
        String From = from.getValue().format(myFormat);
        String To = to.getValue().format(myFormat);
        System.out.println(From);
        System.out.println(To);
        DateTimeFormatter myFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String da = historydate.getValue().format(myFormat1);
        try {
            
            query = "SELECT *  FROM    history  where time >= '" + From + "' and time <= '" + To + "' "
                    + "and date = '" + da + "' "
                    + "order by time  ";
            
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                data.add(new HistoryClass(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
                
                table.setItems(data);
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

//////////////////////////////////////////////////
//////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    public void StageMethod() throws IOException {
        Stage ReportsStage = new Stage();
        Parent ReportsRoot = FXMLLoader.load(getClass().getResource("HistoryFXML.fxml"));
        
        Scene ReportsScene = new Scene(ReportsRoot);
        ReportsStage.setScene(ReportsScene);
        ReportsStage.setMaximized(false);
        ReportsStage.setFullScreen(false);
        ReportsStage.setResizable(false);
        ReportsStage.setTitle("History");
        
        ReportsStage.getIcons().add(new Image("Replay_48px.png"));
        
        ReportsStage.showAndWait();
        
    }

    /**
     * Initializes the controller class.
     */
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        historydate.setValue(LocalDate.now());
        to.setValue(LocalTime.now());
        from.setValue(LocalTime.MIN);
        historydate.setEditable(false);
        from.setEditable(false);
        to.setEditable(false);
    }
    
}

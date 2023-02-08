/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentsPackage;

import ActionPackage.ActionClass;
import AlertMaker.AlertMaker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import static javafxapplication11.FXMLDocumentController.UserNameSave;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class PaymentsFXMLController implements Initializable {
    
    @FXML
    private JFXComboBox<String> list;
    @FXML
    private JFXTextField description;
    @FXML
    private JFXTextField amount;
    
    static Stage PaymentStage = new Stage();
    public static String cashier;
    
    public void PaymentsStageMethod() throws IOException {
        Parent PaymentsRoot = FXMLLoader.load(getClass().getResource("PaymentsFXML.fxml"));
        Scene PaymentsScene = new Scene(PaymentsRoot);
        PaymentStage.setScene(PaymentsScene);
        PaymentStage.setMaximized(false);
        PaymentStage.setFullScreen(false);
        PaymentStage.setTitle("Payments");
        PaymentStage.getIcons().add(new Image("get-money.png"));
        PaymentStage.setResizable(false);
        PaymentStage.showAndWait();
        
    }
    
    @FXML
    private void save() throws SQLException {
        
        if (list.getSelectionModel().isEmpty() || amount.getText().isEmpty()) {
            AlertMaker gt = new AlertMaker();
            gt.showErrorMessage("Error", "من فضلك املا كل الخانات");
            
        } else {
            float price = Float.parseFloat(amount.getText());
            ActionClass a = new ActionClass();
            int index;
            index = list.getSelectionModel().getSelectedIndex();
            if (index == 3 || index == 4) {
                if (!description.getText().isEmpty()) {
                    
                    if (index == 3) {
                        a.SaveToPaymentsTable(UserNameSave, price, description.getText(), "1");
                    } else {
                        a.SaveToPaymentsTable(UserNameSave, price, description.getText(), "2");
                    }
                    PaymentStage.close();
                    
                } else {
                    AlertMaker gt = new AlertMaker();
                    gt.showErrorMessage("Error", "من فضلك املا كل الخانات");
                }
                
            } else {
                a.SaveToPaymentsTable(UserNameSave, price, list.getValue(), "1");
                PaymentStage.close();
            }
            
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(UserNameSave);
        
        list.getItems().addAll("وصل ايجار",
                "وصل كهرباء",
                "وصل مياه",
                "مصاريف خاصه بالمحل",
                "مصاريف خاصه بالكاشير"
        );
        list.setOnAction(e -> {
            
            if (list.getValue().equals("مصاريف خاصه بالمحل") || list.getValue().equals("مصاريف خاصه بالكاشير")) {
                description.setDisable(false);
                description.setOpacity(1);
            } else {
                description.setOpacity(0);
                description.setDisable(true);
            }
        });
        description.setOpacity(0);
        description.setDisable(true);
        PaymentStage.setOnCloseRequest(e -> {
            e.consume();
            Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert.setTitle("Confirmation dialog");
            CreateNewUserAlert.setContentText("Are you sure ?");
            CreateNewUserAlert.setHeaderText(null);
            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
            if (action.get() == ButtonType.OK) {
                
                PaymentStage.close();
            }
        });
        amount.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                amount.setText(newValue.replaceAll("[\\D]", "."));
            }
        });
    }
    
}

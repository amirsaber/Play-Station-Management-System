/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportsPackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafxapplication11.*;

/**
 * FXML Controller class
 *
 * @author Amir
 */
public class ReportsFXMLController implements Initializable {

    public Stage ReportsStage = new Stage();

    @FXML
    public void UsersReportsButton() {

        PrintReport1 p = new PrintReport1();
        p.ShowReport1();
    }

    @FXML
    public void DevicesReportsButton() {
        PrintReport view = new PrintReport();
        view.ShowReport();

    }

    @FXML
    public void DrinksReportsButton() {

        PrintReport2 pp = new PrintReport2();
        pp.ShowReport2();

    }

    @FXML
    public void OrdersReportsButton() {

        PrintReport3 pp3 = new PrintReport3();
        pp3.ShowReport3();

    }

    public void ReportsStageMethod() throws IOException {

        Parent ReportsRoot = FXMLLoader.load(getClass().getResource("ReportsFXML.fxml"));
        //Parent ReportsRoot = FXMLLoader.load(getClass().getResource("OrdersAllFXML.fxml"));
        Scene ReportsScene = new Scene(ReportsRoot);
        ReportsStage.setScene(ReportsScene);
        ReportsStage.setMaximized(false);
        ReportsStage.setFullScreen(false);

        ReportsStage.setTitle("Reports");

        ReportsStage.getIcons().add(new Image("57-512 (1).png"));
        //  ReportsStage.initStyle(StageStyle.UTILITY);
        ReportsStage.setX(250);
        ReportsStage.setY(230);
        ReportsStage.setResizable(false);
        ReportsStage.showAndWait();

    }

    @FXML
    public void ReportsStageClose() {
        ReportsStage.close();
    }

    @FXML
    public void OpenReports(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("OrdersAllFXML.fxml"));
        ///  sssss.StageMethod();
        Scene scene1 = new Scene(root1);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        //    window.setMaximized(true);
        //   window.setFullScreen(false);

        window.setMinWidth(1155);
        window.setMinHeight(690);

        window.setX(10);
        window.setY(2);
                            //window.setMaximized(true);

      // window.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
